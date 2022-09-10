package com.devsuperior.dsmeta.controllers;

import com.devsuperior.dsmeta.services.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/sales")
public class SalesController {

    @Autowired
    private SalesService service;

    @GetMapping
    public ResponseEntity<?> findSales() {
        return ResponseEntity.ok().body(service.findSales());
    }
}
