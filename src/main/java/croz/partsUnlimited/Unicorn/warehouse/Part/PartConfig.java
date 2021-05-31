package croz.partsUnlimited.Unicorn.warehouse.Part;

import croz.partsUnlimited.Unicorn.warehouse.Automobile.Automobile;
import croz.partsUnlimited.Unicorn.warehouse.Automobile.AutomobileRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class PartConfig {


    @Bean
    CommandLineRunner commandLineRunner(PartRepository partRepository
                                    , AutomobileRepository automobileRepository){
        return args -> {
            Part p1 = new Part(
                    LocalDate.of(2021, Month.JANUARY, 5)
            );

            Part p2 = new Part(
                    LocalDate.of(2020, Month.OCTOBER, 2)
            );

            Automobile p3 = new Automobile(
                    "Ford",
                    "Coupe",
                    List.of(new Part(
                                    LocalDate.of(2021, Month.JANUARY, 5)),
                            new Part(
                                    LocalDate.of(2020, Month.OCTOBER, 2)))
            );

            Automobile p4 = new Automobile(
                    "DeLorean",
                    "DMC-1",
                    List.of(new Part(
                                    LocalDate.of(2021, Month.JANUARY, 5)),
                            new Part(
                                    LocalDate.of(2019, Month.JUNE, 20)))
            );

            automobileRepository.saveAll(List.of(p3,p4));
            partRepository.saveAll(List.of(p1,p2));
        };
    }
}
