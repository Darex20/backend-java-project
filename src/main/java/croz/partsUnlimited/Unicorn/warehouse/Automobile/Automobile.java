package croz.partsUnlimited.Unicorn.warehouse.Automobile;


import com.fasterxml.jackson.annotation.JsonIgnore;
import croz.partsUnlimited.Unicorn.warehouse.Brand.Brand;
import croz.partsUnlimited.Unicorn.warehouse.Part.Part;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity(name = "Automobile")
@Table
public class Automobile {

    @Id
    @Column(
            nullable = false,
            name = "automobileid"
    )
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long automobileId;

    @JoinColumn
    String automobileName;

    @JsonIgnore
    @ManyToMany(
            cascade = CascadeType.ALL,
            mappedBy = "automobiles"
    )
    List<Part> parts;

    @JsonIgnore
    @ManyToOne(
            cascade = {CascadeType.MERGE}
    )
    Brand brand;

    public Automobile(String automobileName, List<Part> parts) {
        this.automobileName = automobileName;
        this.parts = parts;
    }

    public Automobile(String automobileName, Brand brand, List<Part> parts) {
        this.automobileName = automobileName;
        this.parts = parts;
        this.brand = brand;
    }

    public Automobile(){}

    public String getAutomobileName() {
        return automobileName;
    }

    public void setAutomobileName(String automobileName) {
        this.automobileName = automobileName;
    }

    public Brand getBrand() {
        return brand;
    }

    public List<Part> getParts() {
        return parts;
    }

    public void setParts(List<Part> parts) {
        this.parts = parts;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public void addPart(Part part) {
        parts.add(part);
        part.getAutomobiles().add(this);
    }

    public void removePart(Part part) {
        parts.remove(part);
        part.getAutomobiles().remove(this);
    }


    @Override
    public String toString() {
        return "{" +
                "brand_and_automobile='" + brand.getBrandName() + automobileName + '\'' +
                ", count=" + parts.size() +
                '}';
    }
}
