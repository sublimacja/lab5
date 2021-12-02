package com.example.lab5.controller;


import com.example.lab5.service.ApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/ppkwu")
@RequiredArgsConstructor
public class ApiController {
    private final ApiService apiService;

    @GetMapping("/lab5/{searchTerm}")
    public StringBuilder getVCard(@PathVariable("searchTerm") String searchTerm) throws IOException {
       return apiService.getVCard(searchTerm);
    }
}
