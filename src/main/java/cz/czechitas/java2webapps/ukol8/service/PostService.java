package cz.czechitas.java2webapps.ukol8.service;


import cz.czechitas.java2webapps.ukol8.entity.Post;
import cz.czechitas.java2webapps.ukol8.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class PostService {

    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Page<Post> list(Pageable page) {
        return postRepository.findAll(page);
    }

    public Post findBySlug(String slug) {
        return postRepository.findBySlug(slug);
    }

        public Page<Post> findAllAlreadyPublished (Pageable pageable){
            LocalDate datumOd = LocalDate.of(1950, 1, 1);
            LocalDate datumDo = LocalDate.now();
            Pageable rebuiltPageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by("published").descending());
            return postRepository.findByPublishedBetweenAndPublishedNotNull(datumOd, datumDo, rebuiltPageable);
        }
    }
