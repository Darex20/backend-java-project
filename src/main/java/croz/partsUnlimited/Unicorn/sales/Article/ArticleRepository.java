package croz.partsUnlimited.Unicorn.sales.Article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class ArticleRepository {

    JdbcTemplate jdbcTemplate;

    @Autowired
    public ArticleRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Article> getArticles() {
        String sql = "SELECT * FROM article";
        List<Article> articles = jdbcTemplate.query(sql, new BeanPropertyRowMapper(Article.class));
        return articles;
    }

    public void addArticle(Article article) {
        String sql = "INSERT INTO article(basePrice, articleId, partId, saleId) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, article.getBasePrice(), article.getArticleId(), article.getPartId(), article.getSaleId());
    }

    public Article getArticleBySerialNumber(Long serialNumber) {
        String sql = "SELECT serialNumber, basePrice, dateOfProduction FROM article NATURAL JOIN part WHERE serialNumber = ?";
        return (Article) jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper(Article.class), serialNumber);
    }

    public void deleteArticle(Long articleId) {
        String sql = "DELETE FROM article WHERE articleId = ?";
        jdbcTemplate.update(sql, new Object[]{articleId});
    }

    public void updateArticleBasePrice(Long articleId, Article article) {
        String sql = "UPDATE article SET basePrice = ? WHERE articleId = ?";
        jdbcTemplate.update(sql, article.getBasePrice(), articleId);
    }
}
