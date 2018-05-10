package com.netsneakers.sneakers.service;

import com.netsneakers.sneakers.domain.Sneaker;
import com.netsneakers.sneakers.domain.exception.NotFoundException;
import com.netsneakers.sneakers.domain.repository.SneakerRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import static org.springframework.context.i18n.LocaleContextHolder.getLocale;

@Service
@AllArgsConstructor
public class SneakerServiceImpl implements SneakerService {

    private final SneakerRepository sneakerRepository;
    private final MessageSource messageSource;

    @Override
    public Sneaker getBySku(String sku) throws NotFoundException {
        Sneaker sneaker = sneakerRepository.findById(sku)
                .orElseThrow(() -> new NotFoundException(
                        messageSource.getMessage("resource.not.found", null, getLocale())));
        return sneaker;
    }

    @Override
    public Sneaker save(Sneaker sneaker) {
        return sneakerRepository.save(sneaker);
    }
}
