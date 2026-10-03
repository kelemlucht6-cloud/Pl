package com.frostsecurity.extreme.mixin;

import com.frostsecurity.extreme.packets.PacketAnalyzer;
import net.minecraft.network.ClientConnection;
import net.minecraft.network.packet.Packet;
import io.netty.channel.ChannelHandlerContext;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientConnection.class)
public abstract class ClientConnectionMixin {
    @Inject(method = "send(Lnet/minecraft/network/packet/Packet;)V", at = @At("HEAD"))
    private void frost$onSend(Packet<?> packet, CallbackInfo ci) {
        PacketAnalyzer.record("OUT", packet.getClass().getName(), 0, System.nanoTime());
    }

    @Inject(method = "channelRead0", at = @At("HEAD"))
    private void frost$onReceive(ChannelHandlerContext context, Packet<?> packet, CallbackInfo ci) {
        PacketAnalyzer.record("IN", packet.getClass().getName(), 0, System.nanoTime());
    }
}
