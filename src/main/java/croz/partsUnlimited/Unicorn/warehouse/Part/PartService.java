package croz.partsUnlimited.Unicorn.warehouse.Part;

import croz.partsUnlimited.Unicorn.warehouse.Automobile.Automobile;
import croz.partsUnlimited.Unicorn.warehouse.Automobile.AutomobileRepository;
import croz.partsUnlimited.Unicorn.warehouse.Part.Part;
import croz.partsUnlimited.Unicorn.warehouse.Part.PartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service // same as @Component
public class PartService {

    private final PartRepository partRepository;
    private final AutomobileRepository automobileRepository;

    @Autowired
    public PartService(@Qualifier("parts")PartRepository partRepository, @Qualifier("automobiles")AutomobileRepository automobileRepository) {
        this.partRepository = partRepository;
        this.automobileRepository = automobileRepository;
    }

    public List<Part> getParts(){
        return partRepository.findAll();
    }

    public void addNewPartByDate(Part part) {
        partRepository.save(part);
    }


    public List<Part> getPartByDate(String dateOfProduction) {
        LocalDate date = LocalDate.parse(dateOfProduction);
        return partRepository.findPartByDateOfProduction(date)
                .orElseThrow(() -> new EntityNotFoundException("Part was not found."));
    }

    public void deleteBySerialNumber(Long serialNumber) {
        if(partRepository.getPartBySerialNumber(serialNumber).isEmpty()){
            throw new EntityNotFoundException("Part could not have been found.");
        }
        Part part = partRepository.getPartBySerialNumber(serialNumber).get();
        System.out.println("Part je " + part);
        part.getAutomobiles().removeAll(part.getAutomobiles());
        partRepository.delete(part);
    }

    public Part getPartBySerialNumber(Long serialNumber) {
        if(partRepository.getPartBySerialNumber(serialNumber).isPresent()){
            return partRepository.getPartBySerialNumber(serialNumber).get();
        } else {
            throw new EntityNotFoundException("Part with that serial Number was not found.");
        }
    }
}
