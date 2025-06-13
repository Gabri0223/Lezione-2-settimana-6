package epicode.it.Lezione_2_settimana_6.controller;

import epicode.it.Lezione_2_settimana_6.dto.BlogDto;
import epicode.it.Lezione_2_settimana_6.exception.NotFoundException;
import epicode.it.Lezione_2_settimana_6.model.BlogPost;
import epicode.it.Lezione_2_settimana_6.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/blogPosts")
public class BlogController {
    @Autowired
    private BlogService blogService;

    @GetMapping("")
    public Page<BlogPost> getAllBlog(@RequestParam(defaultValue = "0") int page,
                                     @RequestParam(defaultValue = "10") int size,
                                     @RequestParam(defaultValue = "id") String sortBy){
        return blogService.getAllBlogPost( page, size, sortBy );
    }

    @GetMapping("/{id}")
    public BlogPost getBlog(@PathVariable int id) throws NotFoundException {
        return blogService.getBlogPost(id);
    }

    @PostMapping("")
    public BlogPost creaPost(@RequestBody BlogDto postDto) throws NotFoundException {
        return blogService.saveBlogPost(postDto);
    }

    @PutMapping("/{id}")
    public BlogPost modificaPost(@PathVariable int id,@RequestBody BlogDto postDto) throws NotFoundException {
        return blogService.modificaBlogPost(id,postDto);
    }

    @DeleteMapping("/{id}")
    public void eliminaPost(@PathVariable int id)throws NotFoundException{
        blogService.deleteBlogPost(id);
    }
}
