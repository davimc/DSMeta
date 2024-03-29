package br.com.devsuperior.DSMeta.services;

import br.com.devsuperior.DSMeta.entities.Sale;
import br.com.devsuperior.DSMeta.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class SaleService {

    @Autowired
    private SaleRepository repository;

    @Autowired
    private SmsService smsService;

    public Page<Sale> findAllPaged(Pageable pageable, String minDate, String maxDate) {
        LocalDate today = LocalDate.now();
        LocalDate min = minDate.equals("") ? today.minusYears(1) : LocalDate.parse(minDate);
        LocalDate max = maxDate.equals("") ? today : LocalDate.parse(maxDate);
        return repository.findSales(pageable, min, max);
    }

    public void sendSms(Long id) {
        Sale sale = repository.findById(id).get();
        String msg = "O vendedor " + sale.getSellerName() + " foi destaque em " + sale.getDate()
                + " com um total de R$ " + String.format("%.0f", sale.getAmount());
        smsService.sendSms(msg);
    }
}
