package com.frostsecurity.extreme.packets;
import java.util.*;
public final class PacketStats { public record Stats(long count,long bytes,double avgSize){} public static Map<String,Stats> aggregate(){ Map<String,long[]> m=new TreeMap<>(); for(var e:PacketAnalyzer.recent()){var a=m.computeIfAbsent(e.type(),k->new long[2]);a[0]++;a[1]+=e.size();} Map<String,Stats> out=new TreeMap<>();m.forEach((k,a)->out.put(k,new Stats(a[0],a[1],a[0]==0?0:(double)a[1]/a[0])));return out;} }
