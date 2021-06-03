package croz.partsUnlimited.Unicorn.warehouse.Part;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import croz.partsUnlimited.Unicorn.warehouse.Automobile.Automobile;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity(name = "Part")
@Table
public class Part {

    @Id
    @JsonIgnore
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            nullable = false,
            name = "partid"
    )
    private Long partId;

    @JsonInclude
    @Column(
            name = "serialnumber",
            unique = true
    )
    private Long serialNumber;

    @Column(name = "dateofproduction")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dateOfProduction;

    @JsonIgnore
    @ManyToMany(
            cascade = {CascadeType.MERGE,CascadeType.DETACH,CascadeType.PERSIST}
    )
    @JoinTable(
            name = "automobilepart",
            joinColumns = @JoinColumn(name = "partid"),
            inverseJoinColumns = @JoinColumn(name = "automobileid")
    )
    List<Automobile> automobiles;


    public Part(long partId, LocalDate dateOfProduction) {
        this.partId = partId;
        this.dateOfProduction = dateOfProduction;
    }

    public Part(LocalDate dateOfProduction){
        this.dateOfProduction = dateOfProduction;
    }
    public Part() { }

    public List<Automobile> getAutomobiles() {
        return automobiles;
    }

    public void setAutomobiles(List<Automobile> automobiles) {
        this.automobiles = automobiles;
    }

    public Long getPartId() {
        return partId;
    }

    public long getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(long serialNumber) {
        this.serialNumber = serialNumber;
    }

    public void setPartId(long partId) {
        this.partId = partId;
    }

    public LocalDate getDateOfProduction() {
        return dateOfProduction;
    }

    public void setDateOfProduction(LocalDate dateOfProduction) {
        this.dateOfProduction = dateOfProduction;
    }


    public void addAutomobile(Automobile automobile) {
        automobiles.add(automobile);
        automobile.getParts().add(this);
    }

    public void removeAutomobile(Automobile automobile) {
        automobiles.remove(automobile);
        automobile.getParts().remove(this);
    }
}
