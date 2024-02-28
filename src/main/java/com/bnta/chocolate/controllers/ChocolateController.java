package com.bnta.chocolate.controllers;

import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.models.ChocolateDTO;
import com.bnta.chocolate.services.ChocolateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/chocolates")
public class ChocolateController {

    @Autowired
    ChocolateService chocolateService;

    @GetMapping
    public ResponseEntity<List<Chocolate>> getAllChocolates(
            @RequestParam Optional<Integer> cocoaPercentage
    ) {
        List<Chocolate> chocolates;
        if(cocoaPercentage.isPresent()){
            chocolates = chocolateService.getChocolateByCocoaPercentage(cocoaPercentage.get());
            return new ResponseEntity<>(chocolates, HttpStatus.OK);
        }
        chocolates = chocolateService.getAllChocolates();
        return new ResponseEntity<>(chocolates, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Chocolate> getChocolateById(@PathVariable long id){
        Optional<Chocolate> chocolate = chocolateService.getById(id);

        if (chocolate.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(chocolate.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Chocolate> addChocolate(@RequestBody ChocolateDTO chocolateDTO){
        Chocolate newChocolate = chocolateService.addChocolateDTO(chocolateDTO);
        return new ResponseEntity<>(newChocolate, HttpStatus.CREATED);
    }

}
