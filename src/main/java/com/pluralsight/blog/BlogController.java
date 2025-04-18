package com.pluralsight.blog;

import com.pluralsight.blog.data.PostRepository;
import com.pluralsight.blog.model.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class BlogController {

    private PostRepository postRepository;

    public BlogController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @RequestMapping("/")
    public String listPosts(ModelMap model) {
        List<Post> allPosts = postRepository.getAllPosts();
        model.put("posts", allPosts);
        return "home";
    }

    @RequestMapping("/post/{id}")
    public String postDetails(@PathVariable("id") Long id, ModelMap model) {
        Post post = postRepository.findById(id);
        model.put("post", post);
        return "post-details";
    }

}
