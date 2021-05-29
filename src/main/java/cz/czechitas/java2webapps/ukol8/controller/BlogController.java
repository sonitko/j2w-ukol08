package cz.czechitas.java2webapps.ukol8.controller;

import cz.czechitas.java2webapps.ukol8.service.PostService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BlogController {

    private final PostService postService;

    public BlogController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/")
    public ModelAndView zakladniSeznam() {
        return new ModelAndView("index")
                .addObject("posts", postService.findAllAlreadyPublished());
    }

    @GetMapping(path = "/post", params = "slug")
    public ModelAndView showPost(String slug) {
        return new ModelAndView("onePost")
                .addObject("onePost", postService.findBySlug(slug, Pageable.unpaged()));
    }

}

