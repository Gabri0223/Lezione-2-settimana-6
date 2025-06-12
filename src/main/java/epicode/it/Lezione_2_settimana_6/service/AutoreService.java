package epicode.it.Lezione_2_settimana_6.service;

import epicode.it.Lezione_2_settimana_6.exception.NotFoundException;
import epicode.it.Lezione_2_settimana_6.model.AutorePost;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class AutoreService {

    private List<AutorePost> autori=new ArrayList();

    public AutorePost saveAutore(AutorePost autore){
        autore.setId(new Random().nextInt(1,20000));
        autore.setAvatar("https://ui-avatars.com/api/?name=Mario+Rossi");
        autori.add(autore);
        return autore;
    }

    public AutorePost getAutore(int id)throws NotFoundException {
        return autori.stream().filter(autorePost -> autorePost.getId()==id).findFirst().orElseThrow(()->new NotFoundException("autore post non trovato"));
    }

    public List<AutorePost> getAllAutori(){
        return autori;
    }

    public AutorePost modificaAutore(int id,AutorePost autore)throws NotFoundException{

        AutorePost autoreDaModificare= getAutore(id);

        autoreDaModificare.setNome(autore.getNome());
        autoreDaModificare.setEmail(autore.getEmail());
        autoreDaModificare.setCognome(autore.getCognome());
        autoreDaModificare.setDataDiNascita(autore.getDataDiNascita());
        return autoreDaModificare;
    }

    public void deleteAutore(int id)throws NotFoundException{

        AutorePost autoreDaEliminare=getAutore(id);

        autori.remove(autoreDaEliminare);
    }
}
