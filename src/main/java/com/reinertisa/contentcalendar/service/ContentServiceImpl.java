package com.reinertisa.contentcalendar.service;

import com.reinertisa.contentcalendar.entity.Content;
import com.reinertisa.contentcalendar.repository.ContentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContentServiceImpl implements ContentService {
    private final ContentRepository contentRepository;

    @Override
    public List<Content> findAll() {
        return contentRepository.findAll();
    }

    @Override
    public Content findById(Long id) {
        return contentRepository.findById(id);
    }

    @Override
    public Content create(Content content) {
        return contentRepository.save(content);
    }

    @Override
    public Content update(Long id, Content content) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Content> search(String keyword) {
        return List.of();
    }
}
