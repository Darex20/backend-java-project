package croz.partsUnlimited.Unicorn.warehouse.Automobile;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Qualifier("automobiles")
@Repository
public interface AutomobileRepository extends JpaRepository<Automobile, Long> {

    // @Query("SELECT a FROM Automobile WHERE brandName = :brandName AND automobileName = :automobileName")
    /* Optional<Automobile> findByBrandNameAndAutomobileName(
            @Param("brandName") String brandName, @Param("automobileName") String automobileName
    );*/

}
