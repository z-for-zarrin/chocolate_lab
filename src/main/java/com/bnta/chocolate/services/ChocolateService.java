package com.bnta.chocolate.services;

import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.models.ChocolateDTO;
import com.bnta.chocolate.repositories.ChocolateRepository;
import com.bnta.chocolate.repositories.EstateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChocolateService {

    @Autowired
    ChocolateRepository chocolateRepository;

    @Autowired
    EstateService estateService;

    public Chocolate saveChocolate(Chocolate chocolate) {
        chocolateRepository.save(chocolate);
        return chocolate;
    }

    public List<Chocolate> getAllChocolates() {
        return chocolateRepository.findAll();
    }

    public Optional<Chocolate> getById(long id) {
        return chocolateRepository.findById(id);
    }

    public List<Chocolate> getChocolateByCocoaPercentage(int cocoaPercentage) {
        return chocolateRepository.findByCocoaPercentage(cocoaPercentage);
    }

    public Chocolate addChocolateDTO(ChocolateDTO chocolateDTO) {
        Chocolate chocolate = new Chocolate(chocolateDTO.getName(),
                                            chocolateDTO.getCocoaPercentage(),
                                            estateService.getById(chocolateDTO.getEstateId()).get()
        );
        chocolateRepository.save(chocolate);
        return chocolate;
    }

}
