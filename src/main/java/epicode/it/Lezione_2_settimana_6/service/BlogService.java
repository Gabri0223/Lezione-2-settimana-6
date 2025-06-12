package epicode.it.Lezione_2_settimana_6.service;

import epicode.it.Lezione_2_settimana_6.exception.NotFoundException;
import epicode.it.Lezione_2_settimana_6.model.BlogPost;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class BlogService {
    private List<BlogPost>blogPosts=new ArrayList<>();


    public BlogPost saveBlogPost(BlogPost blogPost){
        blogPost.setId(new Random().nextInt(1,20000));
        blogPost.setCover("https://picsum.photos/200/300");
        blogPosts.add(blogPost);
        return blogPost;
    }

    public BlogPost getBlogPost(int id)throws NotFoundException {
        return blogPosts.stream().filter(blogPost -> blogPost.getId()==id).findFirst().orElseThrow(()->new NotFoundException("blog post non trovato"));

    }

    public List<BlogPost> getAllBlogPost(){
        return blogPosts;
    }

    public BlogPost modificaBlogPost(int id,BlogPost blogPost)throws NotFoundException{

        BlogPost postDaModificare= getBlogPost(id);

        postDaModificare.setCategoria(blogPost.getCategoria());
        postDaModificare.setTitolo(blogPost.getTitolo());
        postDaModificare.setContenuto(blogPost.getContenuto());
        postDaModificare.setTempoLettura(blogPost.getTempoLettura());
        return postDaModificare;
    }

    public void deleteBlogPost(int id)throws NotFoundException{

        BlogPost postDaEliminare=getBlogPost(id);

        blogPosts.remove(postDaEliminare);
    }
}

