package com.tm.consumption.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tm.consumption.model.Consumption;
import com.tm.consumption.repository.ConsumptionRepository;

import java.util.List;

@RestController
public class ConsumptionContoller {

    @Autowired
    private ConsumptionRepository consumptionRepository;

    @GetMapping("/consumptions")
    public List<Consumption> getAllConsumptions() {
        return consumptionRepository.findAll();
    }

    @GetMapping("/consumptions/user/{userId}")
    public List<Consumption> getConsumptionsByUserId(@PathVariable String userId) {
        return consumptionRepository.findConsumptionsByUserId(userId);
    }

    @GetMapping("/consumptions/beer/{beerId}")
    public List<Consumption> getConsumptionsByBeer(@PathVariable String beerId) {
        return consumptionRepository.findConsumptionsByBeerId(beerId);
    }

    @GetMapping("/consumptions/user/{userId}/beer/{beerId}")
    public Consumption getConsumptionByUserIdAndBeer(@PathVariable String userId, @PathVariable String beerId) {
        return consumptionRepository.findConsumptionByUserIdAndBeerId(userId, beerId);
    }

    @GetMapping("/consumptions/{id}")
    public Consumption getConsumptionById(@PathVariable String id) {
        return consumptionRepository.findConsumptionById(id);
    }

    @PostMapping("/consumptions")
    public Consumption createConsumption(@RequestBody Consumption consumption) {
        return consumptionRepository.save(consumption);
    }

    @PutMapping("/consumptions")
    public Consumption updateConsumption(@RequestBody Consumption consumption) {
        Consumption retrievedConsumption = consumptionRepository.findConsumptionByUserIdAndBeerId(consumption.getUserId(), consumption.getBeerId());
        retrievedConsumption.setCount(consumption.getCount());
        retrievedConsumption.setScore(consumption.getScore());
        retrievedConsumption.setRemark(consumption.getRemark());
        return consumptionRepository.save(retrievedConsumption);
    }

    @DeleteMapping("/consumptions/user/{userId}/beer/{beer}")
    public ResponseEntity<?> deleteConsumption(@PathVariable String userId, @PathVariable String beerId) {
        Consumption retrievedConsumption = consumptionRepository.findConsumptionByUserIdAndBeerId(userId, beerId);
        if(retrievedConsumption != null) {
            consumptionRepository.delete(retrievedConsumption);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    
    
}
