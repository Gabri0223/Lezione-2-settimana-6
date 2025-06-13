package epicode.it.Lezione_2_settimana_6.service;

import epicode.it.Lezione_2_settimana_6.dto.BlogDto;
import epicode.it.Lezione_2_settimana_6.exception.NotFoundException;
import epicode.it.Lezione_2_settimana_6.model.AutorePost;
import epicode.it.Lezione_2_settimana_6.model.BlogPost;
import epicode.it.Lezione_2_settimana_6.repository.AutoreRepository;
import epicode.it.Lezione_2_settimana_6.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {
    @Autowired
    private BlogRepository blogRepository;
    @Autowired
    private AutoreService autoreService;

    public BlogPost saveBlogPost(BlogDto blogDto) throws NotFoundException {

        AutorePost autore= autoreService.getAutore(blogDto.getAutoreId());

        BlogPost blogPost=new BlogPost();

        blogPost.setAutore(autore);
        blogPost.setCategoria(blogDto.getCategoria());
        blogPost.setCover("https://picsum.photos/200/300");
        blogPost.setTitolo(blogDto.getTitolo());
        blogPost.setContenuto(blogDto.getContenuto());
        blogPost.setTempoLettura(blogDto.getTempoLettura());
        return blogRepository.save(blogPost);
    }

    public BlogPost getBlogPost(int id)throws NotFoundException {
        return blogRepository.findById(id).orElseThrow(()->new NotFoundException("blog non trovato"));
    }

    public Page<BlogPost> getAllBlogPost(int page,int size,String sortBy){

        Pageable pageable= PageRequest.of(page,size, Sort.by(sortBy));
        return this.blogRepository.findAll(pageable);
    }

    public BlogPost modificaBlogPost(int id, BlogDto blogDto)throws NotFoundException{

        BlogPost postDaModificare= getBlogPost(id);

        postDaModificare.setCategoria(blogDto.getCategoria());
        postDaModificare.setTitolo(blogDto.getTitolo());
        postDaModificare.setContenuto(blogDto.getContenuto());
        postDaModificare.setTempoLettura(blogDto.getTempoLettura());
        if(postDaModificare.getAutore().getId()!=blogDto.getAutoreId()){
            postDaModificare.setAutore(autoreService.getAutore(blogDto.getAutoreId()));
        }
        return blogRepository.save(postDaModificare);
    }

    public void deleteBlogPost(int id)throws NotFoundException{

        BlogPost postDaEliminare=getBlogPost(id);

        blogRepository.delete(postDaEliminare);
    }
}

