package tp_rest.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tp_rest.bo.Article;
import tp_rest.bo.ResponseDTO;
import tp_rest.service.ArticleService;


import java.util.List;

@RestController()
@RequestMapping("/api/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;
    

    @GetMapping("/get-all-articles")
    ResponseDTO<List<Article>> getAllArticles(){
        return articleService.getAll();
    }

    @GetMapping("/{id}")
    ResponseDTO<Article> getArticle(@PathVariable int id){
        return articleService.getId(id);
    }

    @PostMapping("/save")
    ResponseDTO<Article> saveOrUpdateArticle(@RequestBody Article article) {
        return articleService.saveOrUpdate(article);
    }

    @DeleteMapping("/{id}")
    ResponseDTO<Article> deleteArticle(@PathVariable int id) {
        return articleService.delete(id);
    }

}
