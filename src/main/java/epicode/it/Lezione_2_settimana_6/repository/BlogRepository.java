package epicode.it.Lezione_2_settimana_6.repository;

import epicode.it.Lezione_2_settimana_6.model.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BlogRepository extends JpaRepository <BlogPost,Integer>, PagingAndSortingRepository<BlogPost,Integer> {
}
