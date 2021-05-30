package croz.partsUnlimited.Unicorn.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service // same as @Component
public class PartService {

    private final PartRepository partRepository;

    @Autowired
    public PartService(PartRepository partRepository) {
        this.partRepository = partRepository;
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
}
