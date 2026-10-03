package com.frostsecurity.extreme.permissions;
public final class ConfigSanitizer { public static String redactSecrets(String s){return s.replaceAll("(?i)(password|token|secret)(\\s*[=:]\\s*)[^\\s#]+", "$1$2<REDACTED>");} }
