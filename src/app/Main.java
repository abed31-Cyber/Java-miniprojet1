package app;

import java.util.Optional;
import java.util.Scanner;
import model.Developpeur;
import model.Employe;
import service.GestionnaireEmployes;

public class Main {

    public static void main(String[] args) {

        // ouverture de scannner
        Scanner scanner = new Scanner(System.in);

        GestionnaireEmployes newGestionnaire = new GestionnaireEmployes();

        int choix = -1; // j'initiale a -1 pour ne pas quitter de suite.

        // tant que le choix et sifférent de zéro on affiche
        while (choix != 0) {

            System.out.println("Le Menu:");
            System.out.println("1. Lister tous les employés");
            System.out.println("2. Ajouter un employé");
            System.out.println("3. Rechercher par id");
            System.out.println("4. Afficher la masse salariale");
            System.out.println("5. Trouver le mieux payé");
            System.out.println("6. Lister par département");
            System.out.println("0. Quitter");

            choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1:// Lister tous les employe
                    newGestionnaire.listerTous();
                    break;
                case 2:// ajouter un employe
                    System.out.print("Entrez le nom de l'employé : ");
                    String nom = scanner.nextLine();
                    System.out.print("Entrez le prénom de l'employé : ");
                    String prenom = scanner.nextLine();
                    System.out.println("Entrez l'age de l'employé");
                    int age = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Entrer l'email de l'employé");
                    String email = scanner.nextLine();
                    System.out.print("Entrez l'ID de l'employé : ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Entrez le departement");
                    String departement = scanner.nextLine();
                    System.out.print("Entrez le salaire de base de l'employé : ");
                    double salaireBase = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println("Entrez la date d'embauche");
                    String dateEmbauche = scanner.nextLine();
                    System.out.println("Entrez le langage");
                    String langage = scanner.nextLine();
                    System.out.println("Veuillez entrez le niveau d'expertise: junior, intermediaire, senior");
                    String niveauExpertise = scanner.nextLine();
                    System.out.println("Veuillez entrez le prime de performance");
                    double primePerformance = scanner.nextDouble();

                    Employe nouvelEmploye = new Developpeur(nom, prenom, age, email, id, departement, salaireBase,
                            dateEmbauche, langage, niveauExpertise, primePerformance);
                    newGestionnaire.ajouterEmploye(nouvelEmploye);
                    break;
                case 3:// rechercher par id
                    System.out.print("Entrez l'ID de l'employé à rechercher : ");
                    int idRecherche = scanner.nextInt();
                    scanner.nextLine();
                    Optional<Employe> employeTrouve = newGestionnaire.trouverParID(idRecherche);
                    if (employeTrouve != null) {
                        System.out.println("Employé trouvé : " + employeTrouve);
                    } else {
                        System.out.println("Aucun employé trouvé avec cet ID.");
                    }
                    break;
                case 4: // affciheez la masse salariale
                    double masseSalariale = newGestionnaire.calculerMasseSalariale();
                    System.out.println("Masse salariale totale : " + masseSalariale);
                    break;
                case 5: // Trouver le salarié le mieux payer
                    Employe mieuxPaye = newGestionnaire.trouverLeMieuxPaye();
                    if (mieuxPaye != null) {
                        System.out.println("L'employé le mieux payé est : " + mieuxPaye);
                    } else {
                        System.out.println("Aucun employé dans la liste.");
                    }
                    break;
                case 6: // lister par département
                    String dept = scanner.nextLine();
                    newGestionnaire.listerParDepartement(dept);
                    System.out.println("Entrz le nom du département");

                case 0:
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Bonjour reassayer");

            }

        }
        // fermeture du scanner
        scanner.close();
    }
}