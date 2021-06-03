package croz.partsUnlimited.Unicorn.warehouse.Part;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Qualifier("parts")
@Repository
public interface PartRepository extends JpaRepository<Part, Long>{

    // SELECT * FROM part WHERE partId = ?
    // @Query("SELECT p FROM Part p WHERE p.dateOfProduction = ?1")
    Optional<List<Part>> findPartByDateOfProduction(LocalDate date);

    // @Query("SELECT p FROM Part p WHERE p.dateOfProduction = ?1")
    Optional<Part> findPartByPartId(Long partId);

    // @Query("SELECT p FROM Part p WHERE p.serialNumber = ?1")
    Optional<Part> getPartBySerialNumber(Long serialNumber);

}
