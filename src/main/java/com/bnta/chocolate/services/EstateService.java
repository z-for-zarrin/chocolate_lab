package com.bnta.chocolate.services;

import com.bnta.chocolate.models.Estate;
import com.bnta.chocolate.repositories.EstateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstateService {

    @Autowired
    EstateRepository estateRepository;

    public Estate saveEstate(Estate estate){
        estateRepository.save(estate);
        return estate;
    }
}
