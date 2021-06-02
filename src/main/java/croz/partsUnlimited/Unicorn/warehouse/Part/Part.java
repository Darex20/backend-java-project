package croz.partsUnlimited.Unicorn.warehouse.Part;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import croz.partsUnlimited.Unicorn.warehouse.Automobile.Automobile;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity(name = "Part")
@Table
public class Part {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            nullable = false,
            name = "partid"
    )
    private Long partId;

    @Column(
            name = "serialnumber",
            unique = true
    )
    private long serialNumber;

    @Column(name = "dateofproduction")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dateOfProduction;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "automobileParts",
            joinColumns = @JoinColumn(name = "automobileName"),
            inverseJoinColumns = @JoinColumn(name = "partId")
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

    public long getPartId() {
        return partId;
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
