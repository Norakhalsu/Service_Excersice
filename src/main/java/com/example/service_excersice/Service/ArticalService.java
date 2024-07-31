package com.example.service_excersice.Service;

import com.example.service_excersice.Model.Artical;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;

@Service
public class ArticalService {

    ArrayList<Artical> articles = new ArrayList<>();

    public ArrayList<Artical> getArticle() {
        return articles;
    }

    public void addArtical(Artical artical) {
        articles.add(artical);
    }



     public boolean updateArtical(int id ,Artical artical) {
        for (int i = 0; i < articles.size(); i++) {
            if (articles.get(i).getId() == id) {
                articles.set(i, artical);
                return true;
            }
        }
        return false;

     }


     public boolean deleteArtical(int id) {
        for (int i = 0; i < articles.size(); i++) {
            if (articles.get(i).getId() == id) {
                articles.remove(i);
                return true;
            }
        }
        return false;
     }

    // Publish NewsArticles
     public boolean publishArticle(int id ) {
         for (Artical article : articles) {
             if (article.getId() == id && article.getIsPublished().equals(false)) {
                 article.setIsPublished(true);
                 article.setPublishDate(LocalDate.now());
                 return true;
             }
         }
         return false;
     }


//        for (int i = 0; i < articles.size(); i++) {
//            Artical article = articles.get(i);
//            if (article.getId()==id &&artical.isPublished()){
//                artical.setPublished(true);
//                return true;
//            }
//        }
//        return false;
//     }


    //Get all Published NewsArticles
    public ArrayList<Artical> getallArticles() {
        ArrayList<Artical> all_articals = new ArrayList<>();

        for (Artical article : articles) {
                if(article.getIsPublished().equals(true)) {
                    all_articals.add(article);
                }
             }
        if(all_articals.isEmpty()){
            return null;
        }
        return all_articals;
    }


   //Get NewsArticles by Category.
    public ArrayList<Artical> getCategory(String category) {
        ArrayList<Artical> category_articals = new ArrayList<>();

        for (Artical article : articles) {
            if(article.getCategory().equals(category)) {
                category_articals.add(article);
            }
        }
        return category_articals;
    }


}
