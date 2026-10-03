package com.frostsecurity.extreme.core;
import java.time.Instant;
public record Evidence(String source, String observation, String detail, Instant timestamp) {}
