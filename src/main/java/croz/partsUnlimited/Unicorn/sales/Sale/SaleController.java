package croz.partsUnlimited.Unicorn.sales.Sale;


import croz.partsUnlimited.Unicorn.sales.Article.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class SaleController {

    SaleRepository saleRepository;

    @Autowired
    public SaleController(SaleRepository saleRepository){
        this.saleRepository = saleRepository;
    }

    @GetMapping(path = "/sales/articles")
    public List<Article> getArticles(){
        return saleRepository.getOffer();
    }

    @GetMapping(path = "/offer")
    public List<Article> getOffer(){
        return saleRepository.getOffer();
    }

    @PostMapping(path = "/sales")
    public void addSale(@RequestBody Sale sale){
        saleRepository.addSale(sale);
    }

}
