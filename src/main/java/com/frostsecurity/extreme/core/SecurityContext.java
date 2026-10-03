package com.frostsecurity.extreme.core;
import com.frostsecurity.extreme.network.NetworkSnapshot;
import com.frostsecurity.extreme.recon.ServerProfile;
import java.util.*;
public record SecurityContext(ServerProfile server, NetworkSnapshot network, List<SecurityFinding> history) {}
