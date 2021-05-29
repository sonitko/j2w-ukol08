package cz.czechitas.java2webapps.ukol8.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String slug;
    private String author;
    private String title;
    private String perex;
    private String body;
    private LocalDate published;

    public Post() {
    }

    public Post(Long id, String slug, String author, String title, String perex, String body, LocalDate published) {
        this.id = id;
        this.slug = slug;
        this.author = author;
        this.title = title;
        this.perex = perex;
        this.body = body;
        this.published = published;
    }

    public Long getId() {
        return id;
    }

    public String getSlug() {
        return slug;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getPerex() {
        return perex;
    }

    public String getBody() {
        return body;
    }

    public LocalDate getPublished() {
        return published;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public void setAuthor(String autor) {
        this.author = autor;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPerex(String perex) {
        this.perex = perex;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setPublished(LocalDate published) {
        this.published = published;
    }
}
