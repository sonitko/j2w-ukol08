package cz.czechitas.java2webapps.ukol8.repository;

import cz.czechitas.java2webapps.ukol8.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    Pageable postPage = PageRequest.of(0, 20, Sort.by("published").descending());

    Post findBySlug(String slug);

    Page<Post> findByPublishedBetweenAndPublishedNotNull(LocalDate datumOd, LocalDate datumDo, Pageable postPage);

}