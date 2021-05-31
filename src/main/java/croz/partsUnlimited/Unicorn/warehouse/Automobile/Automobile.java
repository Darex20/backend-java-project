package croz.partsUnlimited.Unicorn.warehouse.Automobile;


import croz.partsUnlimited.Unicorn.warehouse.Brand.Brand;
import croz.partsUnlimited.Unicorn.warehouse.Part.Part;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity(name = "Automobile")
@Table
@IdClass(RelationshipName.class)
public class Automobile extends Brand implements Serializable {

    @Id
    @Column(
            nullable = false
    )
    String automobileName;

    @Transient
    List<Part> parts;


    public Automobile(String brandName, String automobileName, List<Part> parts) {
        super(brandName);
        this.automobileName = automobileName;

    }

    public Automobile(){}

    public String getAutomobileName() {
        return automobileName;
    }

    public void setAutomobileName(String automobileName) {
        this.automobileName = automobileName;
    }


    public List<Part> getParts() {
        return parts;
    }

    public void setParts(List<Part> parts) {
        this.parts = parts;
    }

    public int getPartCount(){
        if (parts == null){
            return 0;
        }
        return parts.size();
    }

    @Override
    public String toString() {
        return "Automobile{" +
                "brand_and_automobile='" + super.getBrandName() + " " + this.getAutomobileName() + '\'' +
                ", count=" + getPartCount() +
                '}';
    }
}
