package com.frostsecurity.extreme.network;
public record NetworkSnapshot(long sent, long received, long bytesSent, long bytesReceived, long disconnects, int latencyMs, long sessionSeconds) { public String summary(){ return "sent="+sent+", recv="+received+", bytes="+bytesSent+"/"+bytesReceived+", latency="+latencyMs+"ms, disconnects="+disconnects; } }
