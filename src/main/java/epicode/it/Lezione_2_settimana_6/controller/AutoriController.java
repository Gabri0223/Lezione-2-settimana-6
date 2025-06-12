package epicode.it.Lezione_2_settimana_6.controller;

import epicode.it.Lezione_2_settimana_6.exception.NotFoundException;
import epicode.it.Lezione_2_settimana_6.model.AutorePost;
import epicode.it.Lezione_2_settimana_6.service.AutoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AutoriController {

    @Autowired
    private AutoreService autoreService;

    @GetMapping("/autori")
    public List<AutorePost> getAllAutori(){
        return autoreService.getAllAutori();
    }

    @GetMapping("/autori/{id}")
    public AutorePost getAutore(@PathVariable int id) throws NotFoundException {
        return autoreService.getAutore(id);
    }

    @PostMapping("/autori")
    public AutorePost saveAutore(@RequestBody AutorePost autore){
        return autoreService.saveAutore(autore);
    }

    @PutMapping("/autori/{id}")
    public AutorePost modificaAutore(@PathVariable int id,@RequestBody AutorePost autore) throws NotFoundException {
        return autoreService.modificaAutore(id,autore);
    }

    @DeleteMapping("/autori/{id}")
    public void deleteAutore(@PathVariable int id) throws NotFoundException {
         autoreService.deleteAutore(id);
    }
}
