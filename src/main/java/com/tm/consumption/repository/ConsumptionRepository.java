package com.tm.consumption.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tm.consumption.model.Consumption;

public interface ConsumptionRepository extends MongoRepository<Consumption, String> {
    List<Consumption> findConsumptionsByUserId(Integer userId);
    List<Consumption> findConsumptionsByBeer(String beer);
    Consumption findConsumptionByUserIdAndBeer(Integer userid, String beer);
    Consumption findIdContains(String id);
}