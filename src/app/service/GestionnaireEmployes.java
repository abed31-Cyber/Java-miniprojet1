package service;

import model.Employe;
import java.util.ArrayList; // Pour utiliser les listes dynamiques
import java.util.List;
import java.util.Optional;

public class GestionnaireEmployes {

    // On crée un attribut List qui ne peut contenir que des objets de type Employe
    private List<Employe> listeEmployes;

    // Constructeur : on prépare la liste vide
    // On utilise une ArrayList qui est une implémentation de List
    public GestionnaireEmployes() {
        this.listeEmployes = new ArrayList<>();
    }

    // Méthode pour ajouter un employé à la liste
    public void ajouterEmploye(Employe e) {
        this.listeEmployes.add(e);
        System.out.println("Employé ajouté avec succès !");
    }

    // À toi de jouer pour la suite...
    public void listerTous() {
        // Utilise une boucle for pour parcourir la listeEmployes
        for (Employe employe : listeEmployes) {
            System.out.println(employe);
        }
    }

    // Méthode pour trouver un employé par son ID
    // on fait une boucle qui parcourt la liste des employés et qui compare l'ID de chaque employé avec celui recherché

    public Optional<Employe> trouverParID(int id){
        for (Employe employe : listeEmployes) {
            if (employe.getId() == id) {
                return Optional.of(employe);
            }
        }

        return Optional.empty();
    }

    // Méthode pour calculer la masse salariale Total
   public  double calculerMasseSalariale(){
    double totalsalaire = 0;

    for (Employe e : listeEmployes) {
       totalsalaire += e.calculerSalaireTotal();
    }
    return totalsalaire;

   }
    
}