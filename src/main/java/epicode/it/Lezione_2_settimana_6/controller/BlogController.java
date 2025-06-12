package epicode.it.Lezione_2_settimana_6.controller;

import epicode.it.Lezione_2_settimana_6.exception.NotFoundException;
import epicode.it.Lezione_2_settimana_6.model.BlogPost;
import epicode.it.Lezione_2_settimana_6.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogController {
    @Autowired
    private BlogService blogService;

    @GetMapping("/blogPosts")
    public List<BlogPost> getAllStudent(){
        return blogService.getAllBlogPost();
    }

    @GetMapping("/blogPosts/{id}")
    public BlogPost getBlog(@PathVariable int id) throws NotFoundException {
        return blogService.getBlogPost(id);
    }

    @PostMapping("/blogPosts")
    public BlogPost creaPost(@RequestBody BlogPost post) {
        return blogService.saveBlogPost(post);
    }

    @PutMapping("/blogPosts/{id}")
    public BlogPost modificaPost(@PathVariable int id,@RequestBody BlogPost post) throws NotFoundException {
        return blogService.modificaBlogPost(id,post);
    }

    @DeleteMapping("/blogPosts/{id}")
    public void eliminaPost(@PathVariable int id)throws NotFoundException{
        blogService.deleteBlogPost(id);
    }
}
