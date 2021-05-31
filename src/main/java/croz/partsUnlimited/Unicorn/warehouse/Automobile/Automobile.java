package croz.partsUnlimited.Unicorn.warehouse.Automobile;


import croz.partsUnlimited.Unicorn.warehouse.Brand.Brand;
import croz.partsUnlimited.Unicorn.warehouse.Part.Part;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity(name = "Automobile")
@Table
public class Automobile implements Serializable {

    @Id
    @Column(
            nullable = false
    )
    String automobileName;

    @OneToMany(cascade = {CascadeType.ALL})
    List<Part> parts;

    public Automobile(String automobileName, List<Part> parts) {
        this.automobileName = automobileName;
        this.parts = parts;
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


    @Override
    public String toString() {
        return "Automobile{" +
                "automobileName='" + automobileName + '\'' +
                ", parts=" + parts +
                '}';
    }
}
