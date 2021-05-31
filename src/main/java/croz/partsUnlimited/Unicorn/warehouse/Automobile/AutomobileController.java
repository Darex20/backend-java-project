package croz.partsUnlimited.Unicorn.warehouse.Automobile;


import croz.partsUnlimited.Unicorn.warehouse.Part.Part;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class AutomobileController {

        private final AutomobileService automobileService;

        @Autowired
        public AutomobileController(AutomobileService automobileService){
            this.automobileService = automobileService;
        }

        @GetMapping
        public List<Automobile> getAutomobiles() { return automobileService.getAutomobiles(); }

        //@GetMapping("/{brandAndName}")
        //public Automobile getAutomobileByName(@PathVariable String brandAndName) {
           // return automobileService.getAutomobileByName(brandAndName);
        //}
}
