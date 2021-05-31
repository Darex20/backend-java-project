package croz.partsUnlimited.Unicorn.warehouse.Automobile;

import croz.partsUnlimited.Unicorn.warehouse.Part.Part;
import croz.partsUnlimited.Unicorn.warehouse.Part.PartRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;


public class AutomobileConfig {

    /*
    @Bean
    CommandLineRunner commandLineRunner(AutomobileRepository automobileRepository){
        return args -> {
            Automobile p1 = new Automobile(
                    "Ford",
                    "Coupe",
                    List.of(new Part(
                                LocalDate.of(2021, Month.JANUARY, 5)),
                            new Part(
                                LocalDate.of(2020, Month.OCTOBER, 2)))
            );

            Automobile p2 = new Automobile(
                    "DeLorean",
                    "DMC-1",
                    List.of(new Part(
                                    LocalDate.of(2021, Month.JANUARY, 5)))
            );

            automobileRepository.saveAll(List.of(p1,p2));
        };
    } */
}
