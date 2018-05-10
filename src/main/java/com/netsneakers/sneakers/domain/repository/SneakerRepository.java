package com.netsneakers.sneakers.domain.repository;

import com.netsneakers.sneakers.domain.Sneaker;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SneakerRepository extends MongoRepository<Sneaker, String> {
}
