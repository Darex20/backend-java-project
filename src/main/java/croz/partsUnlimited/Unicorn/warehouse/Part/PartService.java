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

    public void addNewPartById(Part part){
        Optional<Part> partById =
                partRepository.findPartByPartId(part.getPartId());
        if(partById.isPresent()){
            throw new IllegalStateException("Id taken.");
        }
        partRepository.save(part);
    }

    public Part getPartById(Long partId) {
        return partRepository.findById(partId)
                .orElseThrow(() -> new EntityNotFoundException("Part was not found."));
    }

    public List<Part> getPartByDate(String dateOfProduction) {
        LocalDate date = LocalDate.parse(dateOfProduction);
        return partRepository.findPartByDateOfProduction(date)
                .orElseThrow(() -> new EntityNotFoundException("Part was not found."));
    }

    public void delete(Long partId) {
        Part part = partRepository.getById(partId);
        /*for(Automobile auto : part.getAutomobiles()){
            if(part.getAutomobiles().size() == 1) {
                auto.setBrand(null);
                Optional<Automobile> automobile = automobileRepository.findById(auto.getAutomobileName());
                if(automobile.isPresent()){
                    List<Part> parts = automobile.get().getParts();
                    parts.remove(part);
                }
            }
        } */
        for(Automobile auto : part.getAutomobiles()){
            auto.getParts().remove(part);
        }
        //part.getAutomobiles().removeAll(part.getAutomobiles());
        partRepository.delete(part);
    }

    public Part getPartBySerialNumber(long serialNumber) {
        if(partRepository.getPartBySerialNumber(serialNumber).isPresent()){
            return partRepository.getPartBySerialNumber(serialNumber).get();
        } else {
            throw new EntityNotFoundException("Part with that id was not found.");
        }
    }
}
