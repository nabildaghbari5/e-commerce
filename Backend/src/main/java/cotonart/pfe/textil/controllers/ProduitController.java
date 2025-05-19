package cotonart.pfe.textil.controllers;

import cotonart.pfe.textil.entities.Produit;
import cotonart.pfe.textil.services.IProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/produit")
public class ProduitController {
    @Autowired
    IProduitService iProduitService;
    @GetMapping("/retrieve")
    public List<Produit> getAllProduit() {
        return iProduitService.getAllProduit();
}
@PostMapping("/save")
    public Produit save(@RequestBody Produit produit){
        return iProduitService.save(produit);
}
@GetMapping("/findById/{id}")
    public Produit findById(@PathVariable Integer id){
        return iProduitService.findById(id);
}
@DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id){
        iProduitService.delete(id);
}
@PutMapping("/update/{id}")
    public Produit update(@PathVariable Integer id, @RequestBody Produit produit ){
        Produit prod = iProduitService.update(id, produit);
        return prod;
}
}
