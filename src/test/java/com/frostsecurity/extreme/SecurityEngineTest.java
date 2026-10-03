package com.frostsecurity.extreme;
import com.frostsecurity.extreme.core.*; import com.frostsecurity.extreme.detection.AnomalyDetector; import org.junit.jupiter.api.Test; import java.util.*; import static org.junit.jupiter.api.Assertions.*;
public class SecurityEngineTest { @Test void anomalyNeedsEnoughSamples(){assertTrue(AnomalyDetector.detect(List.of(10L,10L,10L)).isEmpty());} @Test void riskLevelsAreOrderedByExplicitEnum(){assertEquals(RiskLevel.INFORMATIONAL, RiskLevel.values()[0]);assertEquals(RiskLevel.CRITICAL,RiskLevel.values()[4]);} }
