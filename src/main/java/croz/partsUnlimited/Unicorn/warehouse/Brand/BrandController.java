package croz.partsUnlimited.Unicorn.warehouse.Brand;

import croz.partsUnlimited.Unicorn.warehouse.Automobile.Automobile;
import croz.partsUnlimited.Unicorn.warehouse.Part.Part;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(path = "warehouse/")
public class BrandController {

    private final BrandService brandService;

    @Autowired
    public BrandController(BrandService brandService){
        this.brandService = brandService;
    }

    @GetMapping(path = "/automobiles/{brandAndAuto}")
    public List<Part> getBrandAndAutoPart(@PathVariable String brandAndAuto){
        List<Part> partList = new ArrayList<>();
        for(Brand brand : brandService.getBrands()){
            for(Automobile auto : brand.getBrandAutomobiles()){
                for(Part part : auto.getParts()){
                    String name = brand.getBrandName() + auto.getAutomobileName();
                    if(name.equals(brandAndAuto)){
                        partList.add(part);
                    }
                }
            }
        }
        if(!partList.isEmpty()){
            return partList;
        } else {
            throw new EntityNotFoundException("There are no parts.");
        }
    }

    @GetMapping(path = "/automobiles")
    public List<String> getAutomobiles() throws JSONException {
        List<String> list = new ArrayList<>();
        for (Brand brand : brandService.getBrands()){
            for(Automobile auto : brand.getBrandAutomobiles()){
                list.add(auto.toString());
            }
        }
        return list;
    }
}
