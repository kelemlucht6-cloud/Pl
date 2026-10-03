package com.frostsecurity.extreme.reports;
import com.frostsecurity.extreme.core.SecurityFinding; import com.frostsecurity.extreme.recon.ServerProfile; import java.time.Instant; import java.util.List;
public record ReportData(String id,Instant generatedAt,String scope,String methodology,ServerProfile server,List<SecurityFinding> findings,List<String> limitations) {}
