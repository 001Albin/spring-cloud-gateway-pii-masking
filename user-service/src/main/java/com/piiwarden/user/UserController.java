package com.piiwarden.user;

import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @GetMapping("/{id}")
    public Map<String, Object> getUser(@PathVariable String id) {
        return Map.of(
                "userId",        id,
                "name",          "Rahul Sharma",
                "email",         "rahul.sharma@example.com",
                "aadhaarNumber", "234107399834",   // valid Verhoeff number
                "phone",         "+919876543210",
                "panCard",       "ABCDE1234F"
        );
    }

    @GetMapping("/debug/all")
    public Map<String, Object> getAllUsers() {
        // This is the "Shadow API" — undocumented, returns raw PII
        // The Warden will catch this even though it's not documented
        return Map.of(
                "users", java.util.List.of(
                        Map.of("userId", "1", "aadhaarNumber", "234107399834", "name", "Rahul Sharma"),
                        Map.of("userId", "2", "aadhaarNumber", "743223476019", "name", "Priya Nair")
                )
        );
    }
}