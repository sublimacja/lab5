package com.example.lab5.controller;


import com.example.lab5.service.ApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ppkwu")
@RequiredArgsConstructor
public class ApiController {
    private final ApiService apiService;

    @GetMapping("/lab5/{searchTerm}")
    public String getVCard(@PathVariable("searchTerm") String searchTerm) {
        return apiService.getVCard(searchTerm);
    }
}
