package croz.partsUnlimited.Unicorn.Part;

import org.apache.tomcat.jni.Local;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class PartConfig {


    @Bean
    CommandLineRunner commandLineRunner(PartRepository partRepository){
        return args -> {
            Part p1 = new Part(
                    LocalDate.of(2021, Month.JANUARY, 5)
            );

            Part p2 = new Part(
                    LocalDate.of(2020, Month.OCTOBER, 2)
            );

            partRepository.saveAll(List.of(p1,p2));
        };
    }
}
