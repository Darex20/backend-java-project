package croz.partsUnlimited.Unicorn.warehouse.Automobile;


import croz.partsUnlimited.Unicorn.warehouse.Part.Part;
import croz.partsUnlimited.Unicorn.warehouse.Part.PartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class AutomobileService {

    private final AutomobileRepository automobileRepository;
    private final PartRepository partRepository;

    @Autowired
    public AutomobileService(@Qualifier("parts") PartRepository partRepository,
                             @Qualifier("automobiles")AutomobileRepository automobileRepository) {
        this.partRepository = partRepository;
        this.automobileRepository = automobileRepository;
    }

    public List<Automobile> getAutomobiles(){
        return automobileRepository.findAll();
    }

    /*public Automobile getAutomobileByName(String brandAndName) {
        String brandName = brandAndName.split("_")[0];
        String automobileName = brandAndName.split("_")[1];
        return automobileRepository.findByBrandNameAndAutomobileName(brandName, automobileName)
                .orElseThrow(() -> new EntityNotFoundException("Automobile not found"));
    }*/


}
