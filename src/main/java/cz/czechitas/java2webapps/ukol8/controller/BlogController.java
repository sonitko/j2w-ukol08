package cz.czechitas.java2webapps.ukol8.controller;

import cz.czechitas.java2webapps.ukol8.service.PostService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.web.util.UrlPathHelper;

import javax.servlet.http.HttpServletRequest;

@Controller
public class BlogController {

    private final PostService postService;

    public BlogController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/")
    public ModelAndView zakladniSeznam(Pageable pageable) {
        return new ModelAndView("index")
                .addObject("posts", postService.findAllAlreadyPublished(pageable));
    }

    @GetMapping(path = "/post/{slug}")
    public ModelAndView showPost(@PathVariable String slug) {
        return new ModelAndView("onePost")
                .addObject("onePost", postService.findBySlug(slug));
    }

    /**
     * Získání aktuální URL s query parametry bez parametrů {@code size} a {@code page}.
     */
    @ModelAttribute("currentURL")
    public String currentURL(HttpServletRequest request) {
        UrlPathHelper helper = new UrlPathHelper();
        return UriComponentsBuilder
                .newInstance()
                .path(helper.getOriginatingRequestUri(request))
                .query(helper.getOriginatingQueryString(request))
                .replaceQueryParam("size")
                .replaceQueryParam("page")
                .build()
                .toString();
    }

}

