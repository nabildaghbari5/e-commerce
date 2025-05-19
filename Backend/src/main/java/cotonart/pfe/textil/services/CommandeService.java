package cotonart.pfe.textil.services;

import cotonart.pfe.textil.entities.Commande;
import cotonart.pfe.textil.repositories.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommandeService implements ICommandeService {

    @Autowired
    CommandeRepository commandeRepo;

    @Override
    public List<Commande> getAllCommande() {
        return commandeRepo.findAll();
    }

    @Override
    public Commande save(Commande commande){
        return commandeRepo.save(commande);
    }

    @Override
    public Commande findById(Integer id){
        return commandeRepo.findById(id).get();
    }

    @Override
    public void delete(Integer id){
        commandeRepo.deleteById(id);
    }

    @Override
    public Commande update(Integer id, Commande commande){
        Commande comd = commandeRepo.findById(id).get();
        if(comd != null){
            comd.setDate(commande.getDate());
            comd.setTotal(commande.getTotal());
            comd.setDescription(commande.getDescription());
            comd.setEtat(commande.getEtat());
            return commandeRepo.save(comd);
        }
        else {
            return null;
        }
    }

    @Override
    public List<Commande> findByUtilisateurId(Integer utilisateurId) {
        return commandeRepo.findByUtilisateurId(utilisateurId);
    }
}
