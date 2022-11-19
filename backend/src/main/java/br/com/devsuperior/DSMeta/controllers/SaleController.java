package br.com.devsuperior.DSMeta.controllers;

import br.com.devsuperior.DSMeta.entities.Sale;
import br.com.devsuperior.DSMeta.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sales")
public class SaleController {
    @Autowired
    private SaleService service;

    @GetMapping
    public ResponseEntity<Page<Sale>> findAllPaged(
            Pageable pageable,
            @RequestParam(name = "min",defaultValue = "") String minDate,
            @RequestParam(name = "max",defaultValue = "") String maxDate
    ) {
        return ResponseEntity.ok().body(service.findAllPaged(pageable, minDate, maxDate));
    }

    @GetMapping("/{id}/notification")
    public void notification(@PathVariable Long id) {
        service.sendSms(id);
    }
}
