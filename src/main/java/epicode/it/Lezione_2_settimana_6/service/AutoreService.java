package epicode.it.Lezione_2_settimana_6.service;

import epicode.it.Lezione_2_settimana_6.exception.NotFoundException;
import epicode.it.Lezione_2_settimana_6.model.AutorePost;
import epicode.it.Lezione_2_settimana_6.repository.AutoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class AutoreService {
    @Autowired
    private AutoreRepository autoreRepository;

    public AutorePost saveAutore(AutorePost autore){
        autore.setAvatar("https://ui-avatars.com/api/?name=Mario+Rossi");
        return autoreRepository.save(autore);
    }

    public AutorePost getAutore(int id)throws NotFoundException {
        return autoreRepository.findById(id).orElseThrow(()->new NotFoundException("autore non trovato"));
    }

    public List<AutorePost> getAllAutori(){
        return autoreRepository.findAll();
    }

    public AutorePost modificaAutore(int id,AutorePost autore)throws NotFoundException{

        AutorePost autoreDaModificare= getAutore(id);

        autoreDaModificare.setNome(autore.getNome());
        autoreDaModificare.setEmail(autore.getEmail());
        autoreDaModificare.setCognome(autore.getCognome());
        autoreDaModificare.setDataDiNascita(autore.getDataDiNascita());
        return autoreRepository.save(autoreDaModificare);
    }

    public void deleteAutore(int id)throws NotFoundException{

        AutorePost autoreDaEliminare=getAutore(id);

        autoreRepository.delete(autoreDaEliminare);
    }
}
