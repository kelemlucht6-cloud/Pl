package com.frostsecurity.extreme.core;

import com.frostsecurity.extreme.network.NetworkMonitor;
import com.frostsecurity.extreme.recon.ServerProfile;
import com.frostsecurity.extreme.storage.FrostStorage;
import net.minecraft.client.MinecraftClient;
import java.time.Instant; import java.util.*; import java.util.concurrent.CopyOnWriteArrayList;

public final class SecurityEngine {
    private static final List<DetectionRule> RULES = new CopyOnWriteArrayList<>();
    private static final List<SecurityFinding> FINDINGS = new CopyOnWriteArrayList<>();
    public static void init() {
        RULES.add(new DetectionRule("NET-001", "Latência persistentemente alta", c -> c.network().latencyMs() > 500, RiskLevel.LOW));
        RULES.add(new DetectionRule("NET-002", "Taxa de desconexão elevada", c -> c.network().disconnects() >= 3, RiskLevel.MEDIUM));
    }
    public static void tick(MinecraftClient client) { if (client.player == null) return; if (client.getTickCount() % 100 != 0) return; evaluate(); }
    public static void evaluate() {
        ServerProfile server = ServerProfile.current();
        SecurityContext ctx = new SecurityContext(server, NetworkMonitor.snapshot(), List.copyOf(FINDINGS));
        for (DetectionRule rule : RULES) if (safe(rule.predicate(), ctx)) add(new SecurityFinding(rule.id(), rule.severity(), 0.75, rule.description(), explanation(rule, ctx), List.of(new Evidence("network", "observed", ctx.network().summary(), Instant.now())), List.of("Investigue a causa e compare com sessões anteriores."), Instant.now()));
    }
    private static boolean safe(java.util.function.Predicate<SecurityContext> p, SecurityContext c) { try { return p.test(c); } catch (Exception e) { return false; } }
    private static String explanation(DetectionRule r, SecurityContext c) { return "Regra " + r.id() + " disparou com dados observados; isso é um indicador, não confirmação de vulnerabilidade."; }
    public static void add(SecurityFinding f) { FINDINGS.add(f); FrostStorage.appendFinding(f); }
    public static List<SecurityFinding> findings() { return List.copyOf(FINDINGS); }
    public static void registerRule(DetectionRule rule) { RULES.add(rule); }
    public static void clear() { FINDINGS.clear(); }
}
