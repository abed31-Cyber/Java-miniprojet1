package model;

public abstract class Personne {

    private String nom;
    private String prenom;
    private int age;
    private String email;

    public Personne(String nom, String prenom, int age, String email) {
        // On utilise les setters pour valider les données dès la construction !
        setNom(nom);
        setPrenom(prenom);
        setAge(age);
        setEmail(email);
    }

    // ----- Getters --------
    public String getNom() { return nom; }
    public String getPrenom() { return prenom; }
    public int getAge() { return age; }
    public String getEmail() { return email; }

    // ---- Setters avec validations ----
    public void setNom(String nom) {
        if (nom == null || nom.trim().isEmpty()) {
            throw new IllegalArgumentException("Le nom ne peut pas être vide");
        }
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        if (prenom == null || prenom.trim().isEmpty()) {
            throw new IllegalArgumentException("Le prénom ne peut pas être vide");
        }
        this.prenom = prenom;
    }

    public void setAge(int age) {
        // Correction de la logique : on bloque si l'âge est < 18 OU > 65
        if (age < 18 || age > 65) {
            throw new IllegalArgumentException("L'âge doit être compris entre 18 et 65 ans");
        }
        this.age = age;
    }

    public void setEmail(String email) {
        if (email == null || !email.contains("@")) { // Petite validation bonus
            throw new IllegalArgumentException("L'email est invalide");
        }
        this.email = email;
    }

    @Override
    public String toString() {
        return nom + " " + prenom + " (" + age + " ans) - " + email;
    }
}