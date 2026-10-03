package com.frostsecurity.extreme.packets;
import java.time.Instant; import java.util.*; import java.util.concurrent.ConcurrentLinkedDeque;
public final class PacketAnalyzer {
 public record PacketEvent(String direction,String type,int size,long nanos,Instant time){}
 private static final Deque<PacketEvent> EVENTS=new ConcurrentLinkedDeque<>(); private static int limit=3000;
 public static void record(String direction,String type,int size,long nanos){ EVENTS.addLast(new PacketEvent(direction,type,Math.max(0,size),nanos,Instant.now())); while(EVENTS.size()>limit) EVENTS.pollFirst(); }
 public static List<PacketEvent> recent(){ return List.copyOf(EVENTS); }
 public static void clear(){ EVENTS.clear(); }
}
