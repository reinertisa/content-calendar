package com.reinertisa.contentcalendar.controller;

import com.reinertisa.contentcalendar.entity.Content;
import com.reinertisa.contentcalendar.exception.ResourceNotFound;
import com.reinertisa.contentcalendar.service.ContentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/content")
@RequiredArgsConstructor
public class ContentController {

    private final ContentService contentService;

    @GetMapping("")
    ResponseEntity<List<Content>> findAll() {
        try {
            return ResponseEntity.ok(contentService.findAll());
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }

    @GetMapping("/{id}")
    ResponseEntity<Content> findById(@PathVariable Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(contentService.findById(id));
        } catch (ResponseStatusException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }

    @PostMapping("")
    ResponseEntity<Content> create(@RequestBody Content content) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(contentService.create(content));
        } catch (ResourceNotFound ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }
}
