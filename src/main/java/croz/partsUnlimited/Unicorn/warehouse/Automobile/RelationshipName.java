package croz.partsUnlimited.Unicorn.warehouse.Automobile;

import javax.persistence.IdClass;
import java.io.Serializable;



public class RelationshipName implements Serializable {
    private String automobileName;
    private String brandName;

    public String getAutomobileName() {
        return automobileName;
    }

    public void setAutomobileName(String automobileName) {
        this.automobileName = automobileName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
}
