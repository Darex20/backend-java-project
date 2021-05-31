package croz.partsUnlimited.Unicorn.warehouse.Part;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "Part")
@Table
public class Part {
    @Id
    @SequenceGenerator(
            name = "part_sequence",
            sequenceName = "part_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "part_sequence"
    )
    @Column(
            nullable = false
    )
    private long partId;

    @Column(
            nullable = true
    )
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dateOfProduction;

    public Part(long partId, LocalDate dateOfProduction) {
        this.partId = partId;
        this.dateOfProduction = dateOfProduction;
    }

    public Part(LocalDate dateOfProduction){
        this.dateOfProduction = dateOfProduction;
    }
    public Part() { }

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


}
