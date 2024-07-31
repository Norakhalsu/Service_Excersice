package com.example.service_excersice.Controller;


import com.example.service_excersice.ApiResponse.ApiResponse;
import com.example.service_excersice.Model.Artical;
import com.example.service_excersice.Service.ArticalService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/article")
@RequiredArgsConstructor
public class ArticalController {

    private final ArticalService articalService;


    @GetMapping("/get")// get all Articles
    public ResponseEntity getArtical() {

        ArrayList<Artical> articles =articalService.getArticle();
        return ResponseEntity.status(200).body(articles);

    }


    @PostMapping("/add")// add new article
    public ResponseEntity addArtical(@Valid @RequestBody Artical artical , Errors errors) {
        if (errors.hasErrors()) {
            String message =errors.getFieldError().getDefaultMessage();
            return  ResponseEntity.badRequest().body(message);
        }
           articalService.addArtical(artical);
        return ResponseEntity.status(200).body(new ApiResponse("article added"));
    }

    @PutMapping("/update/{id}")// update Article
    public ResponseEntity updateArtical(@PathVariable int id , @Valid @RequestBody Artical artical , Errors errors) {
        if (errors.hasErrors()) {
            String message =errors.getFieldError().getDefaultMessage();
            return  ResponseEntity.badRequest().body(message);
        }
            boolean update =articalService.updateArtical(id,artical);
          if (update) {
              return ResponseEntity.status(200).body(new ApiResponse("Article updated successfully"));
          }
          return ResponseEntity.status(200).body(new ApiResponse(" Article not Found "));
    }


    @DeleteMapping("/delete/{id}")// delete article
    public ResponseEntity deleteArtical(@PathVariable int id) {
        boolean delete =articalService.deleteArtical(id);
        if (delete) {
            return ResponseEntity.status(200).body(new ApiResponse("Article deleted successfully"));
        }
        return ResponseEntity.status(200).body(new ApiResponse(" Article not Found "));
    }



    @PutMapping("/publish/{id}")// Publish NewsArticles
    public ResponseEntity Publish(@PathVariable int id ){
        boolean insert =articalService.publishArticle(id);
        if (insert) {
            return ResponseEntity.status(200).body(new ApiResponse(" Article published successfully"));
        }
        return ResponseEntity.status(200).body(new ApiResponse(" Article not Found "));
    }


    @GetMapping("/all-publish")//Get all Published NewsArticles
    public ResponseEntity getAllPublish() {

        ArrayList<Artical> articals=articalService.getallArticles();
        if(articals==null){
            return ResponseEntity.status(400).body(new ApiResponse(" No Article Found "));
        }
        return ResponseEntity.status(200).body(articals);
    }


    @GetMapping("category/{category}")//Get NewsArticles by Category.
    public ResponseEntity getCategory(@PathVariable String category) {

        ArrayList<Artical> category_articals=articalService.getCategory(category);
        if(category_articals==null){
            return ResponseEntity.status(400).body(new ApiResponse(" No Category Found "));
        }
        return ResponseEntity.status(200).body(category_articals);
    }





}
