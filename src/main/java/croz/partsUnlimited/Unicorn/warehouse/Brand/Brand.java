package croz.partsUnlimited.Unicorn.warehouse.Brand;

import javax.persistence.*;


@MappedSuperclass
@Table
public class Brand {


    @Id
    @Column(
          nullable = false
    )
    String brandName;

    public Brand(String brandName) {
        this.brandName = brandName;
    }

    public Brand(){ }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

}
