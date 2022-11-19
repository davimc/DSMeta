package br.com.devsuperior.DSMeta.controllers;

import br.com.devsuperior.DSMeta.entities.Sale;
import br.com.devsuperior.DSMeta.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sales")
public class SaleController {
    @Autowired
    private SaleService service;

    @GetMapping
    public ResponseEntity<Page<Sale>> findAllPaged(Pageable pageable) {
        return ResponseEntity.ok().body(service.findAllPaged(pageable));
    }
}
