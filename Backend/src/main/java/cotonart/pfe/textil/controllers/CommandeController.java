package cotonart.pfe.textil.controllers;

import cotonart.pfe.textil.entities.Commande;
import cotonart.pfe.textil.services.ICommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/commande")

public class CommandeController {

    @Autowired
    ICommandeService iCommandeService;

    @GetMapping("/retrieve")
    public List<Commande> getAllCommande(){
        return iCommandeService.getAllCommande();
    }

    @PostMapping("/save")
    public Commande save(@RequestBody Commande commande){
        return iCommandeService.save(commande);
    }

    @GetMapping("/findById/{id}")
    public Commande findById(@PathVariable Integer id){
        return iCommandeService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id){
        iCommandeService.delete(id);
    }

    @PutMapping("/update/{id}")
    public Commande update(@PathVariable Integer id, @RequestBody Commande commande){
        Commande comd = iCommandeService.update(id, commande);
        return comd;
    }

    @GetMapping("/getCommandeByUtilisateur/{utilisateurId}")
    public List<Commande> getCommandeByUtilisateur(@PathVariable Integer utilisateurId) {
        return iCommandeService.findByUtilisateurId(utilisateurId);
    }



}
