package com.example.lab5.controller;


import com.example.lab5.service.ApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/ppkwu")
@RequiredArgsConstructor
public class ApiController {
    private final ApiService apiService;

    @GetMapping("/lab5/{searchTerm}")
    public StringBuilder getList(@PathVariable("searchTerm") String searchTerm) throws IOException {
        return apiService.getList(searchTerm);
    }

    @GetMapping(value = "/vcard/", produces = {"text/vcard"})
    public String getVcard(@RequestParam String name
    ) {
        return apiService.getVCard(name);
    }
}
