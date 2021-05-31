package croz.partsUnlimited.Unicorn.warehouse.Brand;

import croz.partsUnlimited.Unicorn.warehouse.Automobile.Automobile;

import javax.persistence.*;
import java.util.List;


@Entity(name = "Brand")
@Table
public class Brand {


    @Id
    @Column(
          nullable = false
    )
    String brandName;

    @ManyToMany
    List<Automobile> brandAutomobiles;

    public Brand(String brandName, List<Automobile> brandAutomobiles) {
        this.brandName = brandName;
        this.brandAutomobiles = brandAutomobiles;
    }

    public Brand(){ }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public List<Automobile> getBrandAutomobiles() {
        return brandAutomobiles;
    }

    public void setBrandAutomobiles(List<Automobile> brandAutomobiles) {
        this.brandAutomobiles = brandAutomobiles;
    }
}
