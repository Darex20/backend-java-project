package croz.partsUnlimited.Unicorn.sales.Sale;

import croz.partsUnlimited.Unicorn.sales.Article.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class SaleRepository {

    JdbcTemplate jdbcTemplate;

    @Autowired
    public SaleRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Article> getOffer() {
        String sql1 = "SELECT baseprice, articleId, partId, dateOfProduction, serialNumber FROM article NATURAL JOIN part";
        String sql2 = "SELECT articleId, percentageOff FROM sale JOIN article USING(saleid) WHERE CURRENT_DATE BETWEEN startdate AND enddate";
        List<Article> articles = jdbcTemplate.query(sql1, new BeanPropertyRowMapper(Article.class));
        Map<Long,Double> map = jdbcTemplate.query(sql2, (ResultSet rs) -> {
            HashMap<Long,Double> results = new HashMap<>();
            while (rs.next()) {
                results.put(rs.getLong("articleId"), rs.getDouble("percentageOff"));
            }
            return results;
        });
        for(Map.Entry<Long, Double> entry : map.entrySet()){
            for(Article article: articles){
                if(article.getArticleId().equals(entry.getKey())){
                    article.setBasePrice(article.getBasePrice() - article.getBasePrice()*(entry.getValue()/100));
                }
            }
        }
        return articles;
    }

    public void addSale(Sale sale) {
        String sql = "INSERT INTO sale(startDate, endDate, percentageOff, saleId) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, sale.getStartDate(), sale.getEndDate(), sale.getPercentageOff(), sale.getSaleId());
    }
}
