package croz.partsUnlimited.Unicorn.warehouse.Brand;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Qualifier("brands")
@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {

}
