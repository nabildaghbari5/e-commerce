package cotonart.pfe.textil.services;


import cotonart.pfe.textil.entities.Produit;
import cotonart.pfe.textil.repositories.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitService implements IProduitService {
    @Autowired
    ProduitRepository produitRepo;


    @Override
    public List<Produit> getAllProduit() {
        return produitRepo.findAll();
    }

    @Override
    public Produit save(Produit produit) {
        return produitRepo.save(produit);
    }

    @Override
    public Produit findById(Integer id) {
        return produitRepo.findById(id).get();
    }

    @Override
    public void delete(Integer id) {
        produitRepo.deleteById(id);
    }

    @Override
    public Produit update(Integer id, Produit produit) {
        Produit prod = produitRepo.findById(id).get();
        if (prod != null) {
            prod.setNom(produit.getNom());
            prod.setPrix(produit.getPrix());
            prod.setQuantite(produit.getQuantite());
            prod.setDescription(produit.getDescription());
            return produitRepo.save(prod);


        } else {
            return null;

        }


    }
}



