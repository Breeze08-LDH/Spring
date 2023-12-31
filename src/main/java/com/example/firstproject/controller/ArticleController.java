package com.example.firstproject.controller;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class ArticleController {

    @Autowired  // 스프링 부트가 미리 생성해놓은 객체를 가져다가 자동연결
    private ArticleRepository articleRepository;

    @GetMapping("/articles/new")
    public String newArticleForm(){
        return "articles/new";
    }

    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form){
        log.info("DTO : " + form.toString());
        // --System.out.println("DTO : " + form.toString());  로깅기능으로 대체

        // 1. DTO를 Entity로 변환
        Article article = form.toEntity();
        log.info("Entity : " + article.toString());
        //System.out.println("Entity : " + article.toString());
        
        // 2. Repository에게  Entity를 DB안에 저장하게 함
        Article saved = articleRepository.save(article);
        log.info("Repository : " + saved.toString());
        //System.out.println("Repository : " + saved.toString());
        
        return null;
    }


}


