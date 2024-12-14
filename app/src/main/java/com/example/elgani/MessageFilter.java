package com.example.elgani;
import java.util.regex.Pattern;

public class MessageFilter {
    public static boolean isSensitive(String message) {
        String[] patterns = {
                "\\b\\d{10,15}\\b",  // Phone numbers
                "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}",  // Emails
                "http[s]?://(?:[a-zA-Z]|[0-9]|[$-_@.&+]|[!*\\\\(\\\\),])+"  // Links
        };

        for (String pattern : patterns) {
            if (Pattern.compile(pattern).matcher(message).find()) {
                return true;
            }
        }
        return false;
    }
}
