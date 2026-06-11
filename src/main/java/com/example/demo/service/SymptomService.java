package com.example.demo.service;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SymptomService {

    private final List<String> symptoms = Arrays.asList(
            "fever", "cough", "headache", "vomiting", "diarrhea",
            "chest pain", "fatigue", "body pain", "cold", "chills", "nausea"
    );

    public List<String> searchSymptoms(String query) {
        return symptoms.stream()
                .filter(s -> s.toLowerCase().contains(query.toLowerCase()))
                .collect(Collectors.toList());
    }
}