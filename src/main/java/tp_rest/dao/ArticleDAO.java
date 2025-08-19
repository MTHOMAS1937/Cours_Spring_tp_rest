package tp_rest.dao;

import org.springframework.stereotype.Component;
import tp_rest.bo.Article;

import java.util.ArrayList;
import java.util.List;

@Component
public class ArticleDAO {


    List<Article> articles = new ArrayList<>() {{
        add(new Article(1, "Chaise"));
        add(new Article(2, "Table"));
        add(new Article(3, "Micro"));
        add(new Article(4, "Pc"));
        add(new Article(5, "Clavier"));
        add(new Article(6, "Souris"));
        add(new Article(7, "Pantalon"));
        add(new Article(8, "T-Shirt"));
        add(new Article(9, "Chaussures"));
        add(new Article(10, "Montre"));
    }};



    public List<Article> getAllArticles() {
        return articles;
    }

    public Article getArticle(int id) {
        return articles.stream().filter(article ->  article.getId() == id).findFirst().orElse(null);
    }

    public Article createOrUpdateArticle(Article article) {

        Article articleFound = articles.stream().filter(a -> a.getId()  == article.getId()).findFirst().orElse(null);

        if (articleFound != null) {
            articleFound.setTitle(article.getTitle());
            return articleFound;
        }
        article.setId(articles.size()+1);
        articles.add(article);
        return article;
    }

    public boolean deleteArticle(int id) {
        return articles.removeIf(article -> article.getId() == id);
    }
}
