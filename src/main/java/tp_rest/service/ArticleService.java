package tp_rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tp_rest.bo.Article;
import tp_rest.bo.ResponseDTO;
import tp_rest.dao.ArticleDAO;

import java.util.List;

@Service
public class ArticleService {

    @Autowired
    private ArticleDAO articleDAO;


    public ResponseDTO<List<Article>> getAll(){
        return new ResponseDTO<>("202", articleDAO.getAllArticles());
    }

    public ResponseDTO<Article> getId(int id) {

        Article article = articleDAO.getArticle(id);

        if(article != null) {
            return new ResponseDTO<>("202", articleDAO.getArticle(id));
        }

        return new ResponseDTO<>("703", null);
    }

    public ResponseDTO<Article> saveOrUpdate(Article article) {

        Article returnedArticle = articleDAO.createOrUpdateArticle(article);
        if (returnedArticle != article) {
            return new ResponseDTO<>("202", returnedArticle);
        }

        return new ResponseDTO<>("203", returnedArticle);

    }


    public ResponseDTO<Article> delete(int id) {

        boolean removeSucces = articleDAO.deleteArticle(id);

        if(removeSucces) {
            return new ResponseDTO<>("202", null);
        }

        return new ResponseDTO<>("703", null);
    }

}
