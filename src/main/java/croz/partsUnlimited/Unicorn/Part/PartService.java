package croz.partsUnlimited.Unicorn.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
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
}
