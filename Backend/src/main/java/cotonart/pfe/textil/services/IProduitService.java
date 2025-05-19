package cotonart.pfe.textil.services;

import cotonart.pfe.textil.entities.Produit;

import java.util.List;

public interface IProduitService {
    public List<Produit> getAllProduit() ;
    public Produit save(Produit produit);
    public Produit findById(Integer id);
    public void delete(Integer id);
    public Produit update(Integer id , Produit produit );
}
