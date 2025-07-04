package com.marketview.Spring.MV.service;

import com.marketview.Spring.MV.model.News;
import com.marketview.Spring.MV.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService {

    @Autowired
    private NewsRepository newsRepository;

    public List<News> getAllNews() {
        return newsRepository.findAll();
    }

    public News getNewsById(String id) {
        return newsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("News not found"));
    }

    public News createNews(News news) {
        return newsRepository.save(news);
    }

    public News updateNews(String id, News newsDetails) {
        News news = getNewsById(id);
        news.setTitle(newsDetails.getTitle());
        news.setContent(newsDetails.getContent());
        // update other fields
        return newsRepository.save(news);
    }

    public void deleteNews(String id) {
        News news = getNewsById(id);
        newsRepository.delete(news);
    }
}
