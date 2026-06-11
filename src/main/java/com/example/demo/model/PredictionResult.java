package com.example.demo.model;

import java.util.List;
import java.util.Map;

public class PredictionResult {
    private String disease;
    private double confidence;
    private List<Map<String, Object>> topPredictions;
    private List<String> matchedSymptoms;
    private List<String> unmatchedSymptoms;
    private String error;

    // Constructors
    public PredictionResult() {}

    public PredictionResult(String error) {
        this.error = error;
    }

    // Getters and setters
    public String getDisease() { return disease; }
    public void setDisease(String disease) { this.disease = disease; }

    public double getConfidence() { return confidence; }
    public void setConfidence(double confidence) { this.confidence = confidence; }

    public List<Map<String, Object>> getTopPredictions() { return topPredictions; }
    public void setTopPredictions(List<Map<String, Object>> topPredictions) {
        this.topPredictions = topPredictions;
    }

    public List<String> getMatchedSymptoms() { return matchedSymptoms; }
    public void setMatchedSymptoms(List<String> matchedSymptoms) {
        this.matchedSymptoms = matchedSymptoms;
    }

    public List<String> getUnmatchedSymptoms() { return unmatchedSymptoms; }
    public void setUnmatchedSymptoms(List<String> unmatchedSymptoms) {
        this.unmatchedSymptoms = unmatchedSymptoms;
    }

    public String getError() { return error; }
    public void setError(String error) { this.error = error; }

    public boolean hasError() { return error != null && !error.isEmpty(); }
}