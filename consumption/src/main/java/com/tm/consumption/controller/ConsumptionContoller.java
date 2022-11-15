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
    public List<Consumption> getConsumptionsByUserId(@PathVariable Integer userId) {
        return consumptionRepository.findConsumptionsByUserId(userId);
    }

    @GetMapping("/consumptions/{beer}")
    public List<Consumption> getConsumptionsByBeer(@PathVariable String beer) {
        return consumptionRepository.findConsumptionsByBeer(beer);
    }

    @GetMapping("/consumptions/user/{userId}/beer/{beer}")
    public Consumption getConsumptionByUserIdAndBeer(@PathVariable Integer userId, @PathVariable String beer) {
        return consumptionRepository.findConsumptionByUserIdAndBeer(userId, beer);
    }

    @PostMapping("/consumptions")
    public Consumption createConsumption(@RequestBody Consumption consumption) {
        return consumptionRepository.save(consumption);
    }

    @PutMapping("/consumptions")
    public Consumption updateConsumption(@RequestBody Consumption consumption) {
        Consumption retrievedConsumption = consumptionRepository.findConsumptionByUserIdAndBeer(consumption.getUserId(), consumption.getBeer());
        retrievedConsumption.setCount(consumption.getCount());
        retrievedConsumption.setScore(consumption.getScore());
        retrievedConsumption.setRemark(consumption.getRemark());
        return consumptionRepository.save(retrievedConsumption);
    }

    @DeleteMapping("/consumptions/user/{userId}/beer/{beer}")
    public ResponseEntity<?> deleteConsumption(@PathVariable Integer userId, @PathVariable String beer) {
        Consumption retrievedConsumption = consumptionRepository.findConsumptionByUserIdAndBeer(userId, beer);
        if(retrievedConsumption != null) {
            consumptionRepository.delete(retrievedConsumption);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    
    
}
