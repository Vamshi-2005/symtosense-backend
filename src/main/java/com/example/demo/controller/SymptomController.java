package com.example.demo.controller;

import com.example.demo.model.PredictionResult;
import com.example.demo.service.DiseaseService;
import com.example.demo.service.PredictionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class SymptomController {

    @Autowired
    private PredictionService predictionService;

    @Autowired
    private DiseaseService diseaseService;

    // ── Home page ─────────────────────────────────────────────────────────
    @GetMapping("/")
    public String home(Model model) {
        try {
            List<String> symptoms = predictionService.getSupportedSymptoms();
            model.addAttribute("symptoms", symptoms);
        } catch (Exception e) {
            model.addAttribute("symptoms", new ArrayList<>());
        }
        return "index";
    }

    // ── Predict endpoint ──────────────────────────────────────────────────
    @PostMapping("/predict")
    public String predict(@RequestParam String symptoms, Model model) {

        if (symptoms == null || symptoms.trim().isEmpty()) {
            model.addAttribute("error", "Please enter at least one symptom.");
            return "index";
        }

        PredictionResult result = predictionService.predict(symptoms);

        if (result.hasError()) {
            model.addAttribute("error", result.getError());
            model.addAttribute("symptoms", new ArrayList<>());
            return "index";
        }

        // Get rich disease information
        Map<String, String> diseaseInfo = diseaseService.getDiseaseDetails(result.getDisease());
        Map<String, String> specialist = diseaseService.getSpecialist(result.getDisease());

        model.addAttribute("disease", result.getDisease());
        model.addAttribute("confidence", result.getConfidence());
        model.addAttribute("topPredictions", result.getTopPredictions());
        model.addAttribute("matchedSymptoms", result.getMatchedSymptoms());
        model.addAttribute("diseaseInfo", diseaseInfo);
        model.addAttribute("specialist", specialist);
        model.addAttribute("inputSymptoms", symptoms);

        return "result";
    }

    // ── Details page ──────────────────────────────────────────────────────
    @GetMapping("/details")
    public String details(@RequestParam String disease, Model model) {
        Map<String, String> diseaseInfo = diseaseService.getDiseaseDetails(disease);
        model.addAttribute("disease", disease);
        model.addAttribute("diseaseInfo", diseaseInfo);
        return "details";
    }

    // ── REST API endpoint (for JS fetch / testing) ─────────────────────
    @PostMapping("/api/predict")
    @ResponseBody
    public Map<String, Object> apiPredict(@RequestParam String symptoms) {
        PredictionResult result = predictionService.predict(symptoms);
        Map<String, Object> response = new LinkedHashMap<>();

        if (result.hasError()) {
            response.put("error", result.getError());
        } else {
            response.put("disease", result.getDisease());
            response.put("confidence", result.getConfidence());
            response.put("topPredictions", result.getTopPredictions());
            response.put("matchedSymptoms", result.getMatchedSymptoms());

            Map<String, String> info = diseaseService.getDiseaseDetails(result.getDisease());
            response.put("diseaseInfo", info);
        }
        return response;
    }
}