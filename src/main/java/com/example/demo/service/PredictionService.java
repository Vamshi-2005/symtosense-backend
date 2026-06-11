package com.example.demo.service;

import com.example.demo.model.PredictionResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.http.*;

import java.util.*;

@Service
public class PredictionService {

    @Value("${ml.service.url}")
    private String mlServiceUrl;

    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @SuppressWarnings("unchecked")
    public PredictionResult predict(String symptoms) {
        try {
            // Clean input: trim + lowercase + remove extra spaces
            String cleanedSymptoms = symptoms.trim().toLowerCase().replaceAll("\\s+", "_");

            String url = mlServiceUrl + "/predict?symptoms=" + cleanedSymptoms;

            ResponseEntity<Map> response = restTemplate.getForEntity(url, Map.class);
            Map<String, Object> body = response.getBody();

            if (body == null) {
                return new PredictionResult("No response from ML service");
            }

            if (body.containsKey("error")) {
                return new PredictionResult((String) body.get("error"));
            }

            PredictionResult result = new PredictionResult();
            result.setDisease((String) body.get("disease"));

            Object conf = body.get("confidence");
            if (conf instanceof Number) {
                result.setConfidence(((Number) conf).doubleValue());
            }

            if (body.containsKey("top_predictions")) {
                result.setTopPredictions((List<Map<String, Object>>) body.get("top_predictions"));
            }

            if (body.containsKey("matched_symptoms")) {
                result.setMatchedSymptoms((List<String>) body.get("matched_symptoms"));
            }

            if (body.containsKey("unmatched_symptoms")) {
                result.setUnmatchedSymptoms((List<String>) body.get("unmatched_symptoms"));
            }

            return result;

        } catch (ResourceAccessException e) {
            return new PredictionResult("ML service is unreachable. Please try again later.");
        } catch (Exception e) {
            return new PredictionResult("Prediction failed: " + e.getMessage());
        }
    }

    public List<String> getSupportedSymptoms() {
        try {
            String url = mlServiceUrl + "/symptoms";
            ResponseEntity<Map> response = restTemplate.getForEntity(url, Map.class);
            Map<String, Object> body = response.getBody();
            if (body != null && body.containsKey("symptoms")) {
                return (List<String>) body.get("symptoms");
            }
        } catch (Exception e) {
            // Return defaults if ML service is down
        }
        return Arrays.asList(
            "fever", "cough", "headache", "vomiting", "diarrhea",
            "fatigue", "sore_throat", "runny_nose", "body_ache", "chills",
            "rash", "shortness_of_breath", "chest_pain", "nausea",
            "loss_of_appetite", "joint_pain", "back_pain", "dizziness",
            "sweating", "swollen_lymph_nodes"
        );
    }
}