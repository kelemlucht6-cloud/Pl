package com.frostsecurity.extreme;

import com.frostsecurity.extreme.commands.FrostCommands;
import com.frostsecurity.extreme.config.FrostConfig;
import com.frostsecurity.extreme.core.SecurityEngine;
import com.frostsecurity.extreme.dashboard.DashboardScreen;
import com.frostsecurity.extreme.network.NetworkMonitor;
import com.frostsecurity.extreme.storage.FrostStorage;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientPlayConnectionEvents;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public final class FrostScanClient implements ClientModInitializer {
    public static final String MOD_ID = "frostscan";
    private static KeyBinding openKey;

    @Override public void onInitializeClient() {
        FrostConfig.load();
        FrostStorage.init();
        SecurityEngine.init();
        NetworkMonitor.init();
        FrostCommands.register();
        openKey = KeyBindingHelper.registerKeyBinding(new KeyBinding("key.frostscan.open", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_F8, "category.frostscan"));
        ClientPlayConnectionEvents.JOIN.register((handler, sender, client) -> NetworkMonitor.onJoin(handler));
        ClientPlayConnectionEvents.DISCONNECT.register((handler, client) -> NetworkMonitor.onDisconnect());
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            NetworkMonitor.tick(client);
            SecurityEngine.tick(client);
            while (openKey.wasPressed()) client.setScreen(new DashboardScreen());
        });
    }
}
