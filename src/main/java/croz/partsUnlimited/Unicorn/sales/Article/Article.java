package croz.partsUnlimited.Unicorn.sales.Article;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDate;

public class Article {

    Long partId;

    private Long serialNumber;

    Long articleId;

    Long saleId;

    private double basePrice;

    private LocalDate dateOfProduction;

    public Article(Long partId, double basePrice, Long saleId, Long articleId) {
        this.partId = partId;
        this.basePrice = basePrice;
        this.saleId = saleId;
        this.articleId = articleId;
    }

    @JsonIgnore
    public Long getSaleId() {
        return saleId;
    }

    public void setSaleId(Long saleId) {
        this.saleId = saleId;
    }

    public Article() {
    }

    public Long getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(Long serialNumber) {
        this.serialNumber = serialNumber;
    }

    @JsonIgnore
    public Long getPartId() {
        return partId;
    }

    public LocalDate getDateOfProduction() {
        return dateOfProduction;
    }

    public void setDateOfProduction(LocalDate dateOfProduction) {
        this.dateOfProduction = dateOfProduction;
    }

    public void setPartId(Long partId) {
        this.partId = partId;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    @JsonIgnore
    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }
}
