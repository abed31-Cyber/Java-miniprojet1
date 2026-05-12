package model;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
/**
 
    @ class : Employe
    @ salaireBase : double
    @ dateEmbauche : String
    @ id : int
    @ departement : String    
 */

public abstract class Employe extends Personne {

    // -------- Attributs --------

    private final int id;
    private String departement;
    private double salaireBase;
    private String dateEmbauche;

    private static final double SMIC = 1747;

    // -------- Constructeur --------

    public Employe(String nom, String prenom, int age, String email, int id, String departement, double salaireBase,
            String dateEmbauche) {

        super(nom, prenom, age, email);

        this.id = id;

        setDepartement(departement);
        setSalaireBase(salaireBase);
        setDateEmbauche(dateEmbauche);
    }

    // -------- Getters --------

    public int getId() {
        return id;
    }

    public String getDepartement() {
        return departement;
    }

    public double getSalaireBase() {
        return salaireBase;
    }

    public String getDateEmbauche() {
        return dateEmbauche;
    }

    // -------- Setters --------

    public void setDepartement(String departement) {

        if (departement == null || departement.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Le département ne peut pas être vide");
        }

        this.departement = departement;
    }

    public void setSalaireBase(double salaireBase) {

        if (salaireBase < SMIC) {
            throw new IllegalArgumentException(
                    "Le salaire de base doit être supérieur ou égal au SMIC");
        }

        this.salaireBase = salaireBase;
    }

    public void setDateEmbauche(String dateEmbauche) {

        try {
            LocalDate.parse(dateEmbauche);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException(
                    "La date d'embauche doit être au format YYYY-MM-DD");
        }

        this.dateEmbauche = dateEmbauche;
    }

    // -------- Méthodes --------

    public abstract double calculerSalaireTotal();

    public String getPoste() {
        return departement;
    }
}