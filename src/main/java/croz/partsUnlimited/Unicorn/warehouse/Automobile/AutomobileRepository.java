package croz.partsUnlimited.Unicorn.warehouse.Automobile;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Qualifier("automobiles")
@Repository
public interface AutomobileRepository extends JpaRepository<Automobile, Long> {

}
