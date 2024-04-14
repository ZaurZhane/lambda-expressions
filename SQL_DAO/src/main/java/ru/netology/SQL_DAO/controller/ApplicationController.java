package ru.netology.SQL_DAO.controller;

import ru.netology.SQL_DAO.service.ApplicationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApplicationController {
    private final ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }
    @GetMapping("/products/fetch-product")
    public List<String> getProductName(@RequestParam(value = "name", required = false) String name) {
        return applicationService.getProductName(name);
    }

}
