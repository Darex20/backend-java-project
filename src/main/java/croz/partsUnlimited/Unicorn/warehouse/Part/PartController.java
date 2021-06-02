package croz.partsUnlimited.Unicorn.warehouse.Part;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
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

    @GetMapping("/serialNumber/{serialNumber}")
    public Part getPartById(@PathVariable long serialNumber) {
        return partService.getPartBySerialNumber(serialNumber);
    }

    @GetMapping("/date/{dateOfProduction}")
    public List<Part> getPartByDate(@PathVariable String dateOfProduction){
        return partService.getPartByDate(dateOfProduction);
    }

    @PostMapping
    public void addPartByDate(@RequestBody Part part){
        partService.addNewPartByDate(part);
    }

    @DeleteMapping("/serialNumber/{serialNumber}")
    public ResponseEntity<String> delPartById(@PathVariable long serialNumber) {
        partService.delete(serialNumber);
        return new ResponseEntity<String>("Successfully deleted part with id: " + serialNumber, HttpStatus.OK);
    }


}
