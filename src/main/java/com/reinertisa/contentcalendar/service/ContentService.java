package com.reinertisa.contentcalendar.service;

import com.reinertisa.contentcalendar.entity.Content;

import java.util.List;

public interface ContentService {

    List<Content> findAll();

    Content findById(Long id);

    Content create(Content content);

    Content update(Long id, Content content);

    void delete(Long id);

    List<Content> search(String keyword);
}
