package croz.partsUnlimited.Unicorn.sales.Sale;


import croz.partsUnlimited.Unicorn.sales.Article.Article;
import java.time.LocalDate;
import java.util.List;


public class Sale {

    Long saleId;

    LocalDate startDate;

    LocalDate endDate;

    double percentageOff;

    List<Article> articles;

    public Long getSaleId() {
        return saleId;
    }

    public void setSaleId(Long saleId) {
        this.saleId = saleId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public double getPercentageOff() {
        return percentageOff;
    }

    public void setPercentageOff(double percentageOff) {
        this.percentageOff = percentageOff;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}
