package com.tm.consumption.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tm.consumption.model.Consumption;

public interface ConsumptionRepository extends MongoRepository<Consumption, String> {
    List<Consumption> findConsumptionsByUserId(String userId);
    List<Consumption> findConsumptionsByBeerId(String beerId);
    Consumption findConsumptionById(String id);
    Consumption findConsumptionByUserIdAndBeerId(String userId, String beerId);
}