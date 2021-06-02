package croz.partsUnlimited.Unicorn.sales.Sale;


import croz.partsUnlimited.Unicorn.sales.Article.Article;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

//@Entity(name = "Sale")
//@Table
public class Sale {


    @Column(
            nullable = false
    )
    @Id
    Long saleId;

    @Column
    LocalDate startDate;

    @Column
    LocalDate endDate;

    @Column
    double percentageOff;

    @OneToMany(cascade = {CascadeType.ALL})
    List<Article> articles;


}
