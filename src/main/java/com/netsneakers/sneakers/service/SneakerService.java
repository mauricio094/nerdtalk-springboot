package com.netsneakers.sneakers.service;

import com.netsneakers.sneakers.domain.Sneaker;
import com.netsneakers.sneakers.domain.exception.NotFoundException;

public interface SneakerService {

    Sneaker getBySku(String sku) throws NotFoundException;

    Sneaker save(Sneaker sneaker);
}
