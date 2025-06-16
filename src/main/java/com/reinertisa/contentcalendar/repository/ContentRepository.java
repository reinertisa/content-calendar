package com.reinertisa.contentcalendar.repository;

import com.reinertisa.contentcalendar.entity.Content;
import com.reinertisa.contentcalendar.enumarations.Status;
import com.reinertisa.contentcalendar.enumarations.Type;
import com.reinertisa.contentcalendar.exception.ResourceNotFound;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ContentRepository {

    private List<Content> contentList = new ArrayList<>();

    public ContentRepository() {
    }

    public List<Content> findAll() {
        return contentList;
    }

    public Content findById(Long id) {
        return contentList.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFound("This ID did not found", id.intValue()));
    }

    public Content save(Content content) {
        contentList.add(content);
        return content;
    }

    public Content update(Long id, Content content) {

    }

    @PostConstruct
    private void init() {
        Content c1 = new Content(
                1L,
                "My First Blog",
                "My first blog post",
                Status.IDEA,
                Type.ARTICLE,
                LocalDateTime.now(),
                null,
                "https://www.fuzzyscore.com"
                );
        contentList.add(c1);
    }
}
