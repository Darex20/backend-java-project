package croz.partsUnlimited.Unicorn.warehouse.Part;

import croz.partsUnlimited.Unicorn.warehouse.Automobile.Automobile;
import croz.partsUnlimited.Unicorn.warehouse.Automobile.AutomobileRepository;
import croz.partsUnlimited.Unicorn.warehouse.Brand.Brand;
import croz.partsUnlimited.Unicorn.warehouse.Brand.BrandRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

//@Configuration
public class PartConfig {

    /*
    @Bean
    CommandLineRunner commandLineRunner(PartRepository partRepository
                                    , AutomobileRepository automobileRepository, BrandRepository brandRepository){
        return args -> {
            Part p1 = new Part(
                    LocalDate.of(2021, Month.JANUARY, 5)
            );

            Part p2 = new Part(
                    LocalDate.of(2006, Month.JULY, 15)
            );

            Part p3 = new Part(
                    LocalDate.of(2021, Month.AUGUST, 10)
            );

            Part p4 = new Part(
                    LocalDate.of(2018, Month.MARCH, 22)
            );

            Part p5 = new Part(
                    LocalDate.of(2019, Month.MAY, 28)
            );

            Part p6 = new Part(
                    LocalDate.of(2020, Month.DECEMBER, 3)
            );

            Automobile a1 = new Automobile(
                    "Coupe",
                    List.of(new Part(
                                    LocalDate.of(2021, Month.JANUARY, 5)),
                            new Part(
                                    LocalDate.of(2020, Month.OCTOBER, 2)),
                            new Part(
                                    LocalDate.of(2018, Month.MARCH, 22))
                    )
            );

            Automobile a2 = new Automobile(
                    "Fiesta",
                    List.of(new Part(
                                    LocalDate.of(2018, Month.MARCH, 22)),
                            new Part(
                                    LocalDate.of(2006, Month.JULY, 15)),
                            new Part(
                                    LocalDate.of(2020, Month.DECEMBER, 3))
                    )
            );

            Automobile a3 = new Automobile(
                    "DMC-1",
                    List.of(new Part(
                                    LocalDate.of(2021, Month.JANUARY, 5)),
                            new Part(
                                    LocalDate.of(2019, Month.JUNE, 20)),
                            new Part(
                                    LocalDate.of(2020, Month.DECEMBER, 3))
                    )
            );

            Brand b1 = new Brand(
                    "Ford",
                    List.of(a1,a2)
            );
            Brand b2 = new Brand(
                    "DeLorean",
                    List.of(a3)
            );

            automobileRepository.saveAll(List.of(a1,a2,a3));
            // partRepository.saveAll(List.of(p1,p2,p3,p4,p5,p6));
            brandRepository.saveAll(List.of(b1,b2));
        }
    }*/
}
