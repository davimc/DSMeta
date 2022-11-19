package br.com.devsuperior.DSMeta.services;

import br.com.devsuperior.DSMeta.entities.Sale;
import br.com.devsuperior.DSMeta.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SaleService {

    @Autowired
    private SaleRepository repository;

    public Page<Sale> findAllPaged(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
