package epicode.it.Lezione_2_settimana_6.repository;

import epicode.it.Lezione_2_settimana_6.model.AutorePost;
import epicode.it.Lezione_2_settimana_6.service.AutoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface AutoreRepository extends JpaRepository<AutorePost,Integer>, PagingAndSortingRepository<AutorePost,Integer> {

}
