package com.piiwarden.order;

import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @GetMapping("/{id}")
    public Map<String, Object> getOrder(@PathVariable String id) {
        return Map.of(
                "orderId",    id,
                "userId",     "1",
                "amount",     1499.00,
                "panCard",    "ABCDE1234F",
                "upiId",      "rahul.sharma@okaxis",
                "status",     "DELIVERED"
        );
    }
}