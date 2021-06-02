package croz.partsUnlimited.Unicorn.warehouse.Brand;

import croz.partsUnlimited.Unicorn.warehouse.Part.Part;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Qualifier("brands")
@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {


}
