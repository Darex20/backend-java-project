package croz.partsUnlimited.Unicorn.warehouse.Brand;

import croz.partsUnlimited.Unicorn.warehouse.Automobile.Automobile;
import croz.partsUnlimited.Unicorn.warehouse.Part.Part;
import croz.partsUnlimited.Unicorn.warehouse.Part.PartService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

    @GetMapping(path = "/automobiles")
    public List<String> getAutomobiles() throws JSONException {
        List<Brand> brands = brandService.getBrands();
        JSONObject jsonString = new JSONObject();
        String brandAndAutoName;
        List<String> list = new ArrayList<String>();
        int counter = 0;
        for (Brand brand : brands){
            for(Automobile auto : brand.getBrandAutomobiles()){
                brandAndAutoName = brand.getBrandName() + " " +  auto.getAutomobileName();
                for(Part part : auto.getParts()){
                    if(partService.getParts().contains(part)){
                        counter++;
                    }
                }
                jsonString.put("brand_and_automobile", brandAndAutoName);
                jsonString.put("count", counter);
                list.add(jsonString.toString());
            }
        }
        return list;
    }
}
