package com.frostsecurity.extreme.recon;
import java.util.*; import java.util.concurrent.CopyOnWriteArrayList;
public final class ReconService { private static final List<ServerProfile> history=new CopyOnWriteArrayList<>(); public static ServerProfile observe(){ServerProfile p=ServerProfile.current();history.add(p);return p;} public static List<ServerProfile> history(){return List.copyOf(history);} }
