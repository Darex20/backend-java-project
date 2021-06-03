package croz.partsUnlimited.Unicorn.sales.Article;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/sales/articles")
public class ArticleController {

    ArticleRepository articleRepository;
    @Autowired
    public ArticleController(ArticleRepository articleRepository){
        this.articleRepository = articleRepository;
    }


    @GetMapping("/{serialNumber}")
    public Article getArticleById(@PathVariable Long serialNumber){
        return articleRepository.getArticleBySerialNumber(serialNumber);
    }

    @PostMapping
    public void addNewArticle(@RequestBody HelpClass value){
        Article article = new Article(value.getPartId(), value.getBasePrice(), value.getSaleId(), value.getArticleId());
        articleRepository.addArticle(article);
    }

    @PutMapping("/{articleId}")
    public void updateArticleBasePrice(@PathVariable Long articleId, @RequestBody Article article){
        articleRepository.updateArticleBasePrice(articleId, article);
    }

    @DeleteMapping("/{articleId}")
    public void deleteArticle(@PathVariable Long articleId){
        articleRepository.deleteArticle(articleId);
    }

    @DeleteMapping
    public void deleteArticle(@RequestBody Article article){
        articleRepository.deleteArticle(article.getArticleId());
    }

}
