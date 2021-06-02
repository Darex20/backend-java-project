package croz.partsUnlimited.Unicorn.warehouse.Brand;

import croz.partsUnlimited.Unicorn.warehouse.Automobile.Automobile;
import croz.partsUnlimited.Unicorn.warehouse.Part.Part;
import croz.partsUnlimited.Unicorn.warehouse.Part.PartService;
import org.json.JSONException;
import org.json.JSONObject;
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
    private final PartService partService;

    @Autowired
    public BrandController(BrandService brandService, PartService partService){
        this.brandService = brandService;
        this.partService = partService;
    }

    @GetMapping(path = "/automobiles/parts/{brandAndAuto}")
    public List<Part> getBrandAndAutoPart(@PathVariable String brandAndAuto){
        List<Part> partList = new ArrayList<>();
        for(Brand brand : brandService.getBrands()){
            for(Automobile auto : brand.getBrandAutomobiles()){
                for(Part part : auto.getParts()){
                    String name = brand.getBrandName() + auto.getAutomobileName();
                    if(name.equals(brandAndAuto) && partService.getParts().contains(part)){
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
        JSONObject jsonString = new JSONObject();
        String brandAndAutoName;
        List<String> autos = new ArrayList<>();
        List<String> list = new ArrayList<String>();
        int counter = 0;
        for (Brand brand : brandService.getBrands()){
            for(Automobile auto : brand.getBrandAutomobiles()){
                autos.add(auto.toString());
                /*counter = 0;
                brandAndAutoName = brand.getBrandName() + " " +  auto.getAutomobileName();
                List<Part> parts = partService.getParts();
                for(Part part : parts){
                    System.err.println("AAAAAAAAAAAAAAAAAAAAAAAAAAA");
                    System.out.println(part.getAutomobiles());
                    if(part.getAutomobiles().contains(auto)){
                        counter++;
                    }
                }
                jsonString.put("brand_and_automobile", brandAndAutoName);
                jsonString.put("count", counter);
                list.add(jsonString.toString());*/
            }
        }
        return autos;
    }
}
