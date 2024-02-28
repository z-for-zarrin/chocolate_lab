package com.bnta.chocolate.components;

import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.models.Estate;
import com.bnta.chocolate.services.ChocolateService;
import com.bnta.chocolate.services.EstateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    EstateService estateService;

    @Autowired
    ChocolateService chocolateService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Estate estate1 = new Estate("English Chocolate Co.", "England");
        Estate estate2 = new Estate("Nigerian Chocolate Co.", "Nigeria");
        Estate estate3 = new Estate("Peruvian Chocolate Co.", "Peru");

        estateService.saveEstate(estate1);
        estateService.saveEstate(estate2);
        estateService.saveEstate(estate3);

        Chocolate chocolate1 = new Chocolate("Thames Chocolate", 80, estate1);
        Chocolate chocolate2 = new Chocolate("Abuja Chocolate", 20, estate2);
        Chocolate chocolate3 = new Chocolate("Lima Chocolate", 95, estate3);
        Chocolate chocolate4 = new Chocolate("Lagos Chocolate", 100, estate2);
        Chocolate chocolate5 = new Chocolate("Mersey Chocolate", 45, estate1);

        chocolateService.saveChocolate(chocolate1);
        chocolateService.saveChocolate(chocolate2);
        chocolateService.saveChocolate(chocolate3);
        chocolateService.saveChocolate(chocolate4);
        chocolateService.saveChocolate(chocolate5);
    }
}
