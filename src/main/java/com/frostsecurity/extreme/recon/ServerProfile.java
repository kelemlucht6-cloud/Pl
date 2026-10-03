package com.frostsecurity.extreme.recon;
import net.minecraft.client.MinecraftClient; import net.minecraft.client.network.ServerInfo; import java.time.Instant;
public record ServerProfile(String name,String address,String minecraftVersion,boolean versionObserved,Instant observedAt){
 public static ServerProfile current(){ MinecraftClient c=MinecraftClient.getInstance(); ServerInfo s=c.getCurrentServerEntry(); if(s==null) return new ServerProfile("singleplayer","local","unknown",false,Instant.now()); return new ServerProfile(s.name,s.address,c.getGameVersion(),true,Instant.now()); }
}
