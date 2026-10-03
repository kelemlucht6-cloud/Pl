package com.frostsecurity.extreme.network;

import net.minecraft.client.MinecraftClient; import net.minecraft.client.network.ClientPlayNetworkHandler; import net.minecraft.client.network.PlayerListEntry;
import java.util.concurrent.atomic.AtomicLong;

public final class NetworkMonitor {
 private static final AtomicLong ticks=new AtomicLong(), disconnects=new AtomicLong(); private static volatile long joinedAt; private static volatile ClientPlayNetworkHandler handler;
 public static void init() { joinedAt=0; }
 public static void onJoin(ClientPlayNetworkHandler h){ handler=h; joinedAt=System.currentTimeMillis(); ticks.set(0); }
 public static void onDisconnect(){ if(handler!=null) disconnects.incrementAndGet(); handler=null; }
 public static void tick(MinecraftClient c){ if(handler!=null) ticks.incrementAndGet(); }
 public static NetworkSnapshot snapshot(){ int latency=-1; long s=0; if(handler!=null){ for(PlayerListEntry e:handler.getPlayerList()){ if(e.getLatency()>=0){ latency=e.getLatency(); break; } } s=Math.max(0,(System.currentTimeMillis()-joinedAt)/1000); } return new NetworkSnapshot(ticks.get(),ticks.get(),0,0,disconnects.get(),latency,s); }
 public static boolean connected(){ return handler!=null; }
}
