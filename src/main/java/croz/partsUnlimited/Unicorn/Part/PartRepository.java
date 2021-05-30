package croz.partsUnlimited.Unicorn.Part;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface PartRepository extends JpaRepository<Part, Long>{

    // SELECT * FROM part WHERE partId = ?
    // @Query("SELECT p FROM Part p WHERE p.dateOfProduction = ?1")
    Optional<List<Part>> findPartByDateOfProduction(LocalDate date);

    // @Query("SELECT p FROM Part p WHERE p.dateOfProduction = ?1")
    Optional<Part> findPartByPartId(Long partId);
}
