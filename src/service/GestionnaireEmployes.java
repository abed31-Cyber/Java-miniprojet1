package service;

import model.Employe;
import java.util.ArrayList; // Pour utiliser les listes dynamiques
import java.util.List;
import java.util.Optional;
/**
 * Classe de gestion des employés
 * @author
 * @version 1.0
 * @ List<Employe> : une liste qui peut contenir des objets de type Employe
 * @ ArrayList : une implémentation de List qui permet de stocker les employés de manière dynamique (on peut ajouter/supprimer sans se soucier de la taille)
 * @ Optional : une classe qui peut contenir un objet ou être vide, utilisée pour éviter les nulls et gérer les cas où un employé n'est pas trouvé lors de la recherche par ID  
 * 
 */


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

   // Méthode pour trouver le salarié le mieux paye

public Employe trouverLeMieuxPaye() {
    // On vérifie si la liste n'est pas vide pour éviter un crash
    if (listeEmployes.isEmpty()) {
        return null; 
    }

    // On initialise avec le premier employé
    Employe mieuxPaye = listeEmployes.get(0);

    //  On parcourt la liste
    for (Employe e : listeEmployes) {
        //  On compare le SALAIRE TOTAL (avec bonus/primes)
        if (e.calculerSalaireTotal() > mieuxPaye.calculerSalaireTotal()) {
            mieuxPaye = e;
        }
    }

    return mieuxPaye; // Retourne l'objet complet
}

   // Méthode pour lister par departement
// On parcourt la liste des employés et on affiche ceux dont le département correspond à celui recherché
public void listerParDepartement(String dept) {

    for (Employe e : listeEmployes) {
        if (e.getDepartement().equalsIgnoreCase(dept)) {
            System.out.println(e.getNom());
        }
    }
}
    
}