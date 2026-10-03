package com.frostsecurity.extreme.config;

import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.nio.file.*;
import java.util.*;

public final class FrostConfig {
    public boolean telemetryEnabled = true;
    public int maxEvents = 5000;
    public int maxPacketEvents = 3000;
    public boolean allowActiveChecks = false;
    public Set<String> allowedScopes = new LinkedHashSet<>();
    private static FrostConfig INSTANCE = new FrostConfig();
    private static Path path;
    public static void load() {
        path = Paths.get(System.getProperty("user.dir"), "config", "frostscan.json");
        try { Files.createDirectories(path.getParent()); if (Files.exists(path)) INSTANCE = new com.google.gson.Gson().fromJson(Files.readString(path), FrostConfig.class); else save(); }
        catch (Exception ignored) { INSTANCE = new FrostConfig(); }
    }
    public static void save() { try { Files.createDirectories(path.getParent()); Files.writeString(path, new GsonBuilder().setPrettyPrinting().create().toJson(INSTANCE), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING); } catch (IOException ignored) {} }
    public static FrostConfig get() { return INSTANCE; }
    public static boolean inScope(String target) { return INSTANCE.allowedScopes.stream().anyMatch(target::equalsIgnoreCase); }
}
