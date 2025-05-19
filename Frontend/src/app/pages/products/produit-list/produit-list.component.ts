import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-produit-list',
  templateUrl: './produit-list.component.html',
  styleUrls: ['./produit-list.component.scss']
})
export class ProduitListComponent implements OnInit {
  produitList: any[] = [];
  categorieList: any[] = [];
  produitForm!: FormGroup;
  isEditMode = false;
  modalRef!: NgbModalRef;
  selectedProduitId!: number | null;
  selectedFile: any;

  constructor(private fb: FormBuilder, private modalService: NgbModal) {}

  ngOnInit(): void {
    this.initForm();
    this.loadProduits();
    this.loadCategories();
  }

  initForm() {
    this.produitForm = this.fb.group({
      nom: [''],
      description: [''],
      prix: [0],
      quantite: [0],
      dateAjout: [''],
      categorieId: [null],
    });
    
  }

  loadProduits() {
    // Remplace avec appel à ton service
    this.produitList = [
      {
        id: 1,
        nom: 'Produit A',
        description: 'Super produit',
        prix: 49.99,
        quantite: 20,
        dateAjout: '2024-06-01',
        categorie: { id: 1, name: 'Électronique' }
      },
      {
        id: 2,
        nom: 'Produit A',
        description: 'Super produit',
        prix: 49.99,
        quantite: 20,
        dateAjout: '2024-06-01',
        categorie: { id: 1, name: 'Électronique' }
      },
      {
        id: 3,
        nom: 'Produit A',
        description: 'Super produit',
        prix: 49.99,
        quantite: 20,
        dateAjout: '2024-06-01',
        categorie: { id: 1, name: 'Électronique' }
      },
      {
        id: 4,
        nom: 'Produit A',
        description: 'Super produit',
        prix: 49.99,
        quantite: 20,
        dateAjout: '2024-06-01',
        categorie: { id: 1, name: 'Électronique' }
      },
      {
        id: 5,
        nom: 'Produit A',
        description: 'Super produit',
        prix: 49.99,
        quantite: 20,
        dateAjout: '2024-06-01',
        categorie: { id: 1, name: 'Électronique' }
      },
      {
        id: 6,
        nom: 'Produit A',
        description: 'Super produit',
        prix: 49.99,
        quantite: 20,
        dateAjout: '2024-06-01',
        categorie: { id: 1, name: 'Électronique' }
      }
    ];
  }

  loadCategories() {
    // Remplace avec appel à ton service
    this.categorieList = [
      { id: 1, name: 'Catégorie 1' },
      { id: 2, name: 'Catégorie 2' },
    ];
  }

  onFileSelected(event: any) {
    const file = event.target.files[0];
    if (file) {
      this.selectedFile = file;
    }
  }
  

  openModal(content: any, produit: any = null) {
    this.isEditMode = !!produit;
    this.selectedProduitId = produit?.id || null;
    if (produit) {
      this.produitForm.patchValue({
        nom: produit.nom,
        description: produit.description,
        prix: produit.prix,
        quantite: produit.quantite, 
        dateAjout: this.formatDate(produit.dateAjout),
        categorieId: produit.categorie?.id,
      });
   } else {
      this.produitForm.reset();
    }
    this.modalRef = this.modalService.open(content, { centered: true, size: 'lg' });
  }

  closeModal() {
    if (this.modalRef) {
      this.modalRef.close();
    }
    this.produitForm.reset();
  }

  saveProduit() {
    const formValue = this.produitForm.value;
    if (this.isEditMode && this.selectedProduitId != null) {
      // Update produit
      console.log('Modification du produit', formValue);
    } else {
      // Create produit
      console.log('Création du produit', formValue);
    }
    this.closeModal();
  }

  onDelete(id: number) {
    // Appel delete ici
    console.log('Suppression du produit ID:', id);
  }
  formatDate(date: string | Date): string {
    const d = new Date(date);
    return d.toISOString().split('T')[0];
  }
}
