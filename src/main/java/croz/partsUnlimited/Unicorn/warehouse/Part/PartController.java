package croz.partsUnlimited.Unicorn.warehouse.Part;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "warehouse/parts")
public class PartController {

    private final PartService partService;

    @Autowired
    public PartController(PartService partService) {
        this.partService = partService;
    }

    @GetMapping
    public List<Part> getParts() {
        return partService.getParts();
    }

    @GetMapping("/id/{partId}")
    public Part getPartById(@PathVariable Long partId) {
        return partService.getPartById(partId);
    }

    @GetMapping("/date/{dateOfProduction}")
    public List<Part> getPartByDate(@PathVariable String dateOfProduction){
        return partService.getPartByDate(dateOfProduction);
    }

    @PostMapping
    public void addPartByDate(@RequestBody Part part){
        partService.addNewPartByDate(part);
    }


}
