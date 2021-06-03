package croz.partsUnlimited.Unicorn.warehouse.Automobile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AutomobileService {

    private final AutomobileRepository automobileRepository;

    @Autowired
    public AutomobileService(@Qualifier("automobiles")AutomobileRepository automobileRepository) {
        this.automobileRepository = automobileRepository;
    }

    public List<Automobile> getAutomobiles(){
        return automobileRepository.findAll();
    }

}
