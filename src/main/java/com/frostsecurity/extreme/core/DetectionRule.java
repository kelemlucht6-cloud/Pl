package com.frostsecurity.extreme.core;
import java.util.function.Predicate;
public record DetectionRule(String id, String description, Predicate<SecurityContext> predicate, RiskLevel severity) {}
