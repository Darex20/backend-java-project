package croz.partsUnlimited.Unicorn.warehouse.Brand;

import croz.partsUnlimited.Unicorn.warehouse.Automobile.Automobile;
import croz.partsUnlimited.Unicorn.warehouse.Part.Part;
import croz.partsUnlimited.Unicorn.warehouse.Part.PartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {

    private final BrandRepository brandRepository;

    @Autowired
    public BrandService(@Qualifier("brands")BrandRepository brandRepository){
        this.brandRepository = brandRepository;
    }

    public List<Brand> getBrands() {
        return brandRepository.findAll();
    }

}
