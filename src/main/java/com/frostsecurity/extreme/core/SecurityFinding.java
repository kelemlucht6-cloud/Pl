package com.frostsecurity.extreme.core;
import java.time.Instant; import java.util.List;
public record SecurityFinding(String id, RiskLevel severity, double confidence, String title, String explanation, List<Evidence> evidence, List<String> recommendations, Instant createdAt) {}
