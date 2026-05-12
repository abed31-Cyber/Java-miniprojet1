package model;

public class Comptable extends Employe {

    // -------- Attribut --------

    private boolean certificationCPA;

    // -------- Constructeur --------

    public Comptable(
            String nom,
            String prenom,
            int age,
            String email,
            int id,
            String departement,
            double salaireBase,
            String dateEmbauche,
            boolean certificationCPA
    ) {

        super(
                nom,
                prenom,
                age,
                email,
                id,
                departement,
                salaireBase,
                dateEmbauche
        );

        setCertificationCPA(certificationCPA);
    }

    // -------- Getter --------

    public boolean isCertificationCPA() {
        return certificationCPA;
    }

    // -------- Setter --------

    public void setCertificationCPA(boolean certificationCPA) {
        this.certificationCPA = certificationCPA;
    }

    // -------- Méthodes --------

    @Override
    public double calculerSalaireTotal() {

        return getSalaireBase() + (certificationCPA ? 500 : 0);
    }

    @Override
    public String getPoste() {
        return "Comptable";
    }
}