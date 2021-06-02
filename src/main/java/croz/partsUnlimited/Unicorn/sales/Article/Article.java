package croz.partsUnlimited.Unicorn.sales.Article;

import croz.partsUnlimited.Unicorn.sales.Sale.Sale;

import javax.persistence.*;

//@Entity(name = "Article")
//@Table
public class Article {


    @Id
    Long partId;

    @Column
    double basePrice;

    @ManyToOne
    Sale sale;

    public Article(Long partId, double basePrice) {
        this.partId = partId;
        this.basePrice = basePrice;
    }

    public Article() {
    }
}
