package model;


public class Developpeur extends Employe {

    // -------- Attributs --------

    private String langage;
    private String niveauExpertise;
    private double primePerformance;

    // -------- Constructeur --------

    public Developpeur(
            String nom,
            String prenom,
            int age,
            String email,
            int id,
            String departement,
            double salaireBase,
            String dateEmbauche,
            String langage,
            String niveauExpertise,
            double primePerformance
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

        setLangage(langage);
        setNiveauExpertise(niveauExpertise);
        setPrimePerformance(primePerformance);
    }

    // -------- Getters --------

    public String getLangage() {
        return langage;
    }

    public String getNiveauExpertise() {
        return niveauExpertise;
    }

    public double getPrimePerformance() {
        return primePerformance;
    }

    // -------- Setters --------

    public void setLangage(String langage) {

        if (langage == null || langage.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Le langage ne peut pas être vide"
            );
        }

        this.langage = langage;
    }

    public void setNiveauExpertise(String niveauExpertise) {

        if (
                !niveauExpertise.equalsIgnoreCase("Junior")
                && !niveauExpertise.equalsIgnoreCase("Senior")
                && !niveauExpertise.equalsIgnoreCase("Lead")
        ) {

            throw new IllegalArgumentException(
                    "Le niveau doit être : Junior, Senior ou Lead"
            );
        }

        this.niveauExpertise = niveauExpertise;
    }

    public void setPrimePerformance(double primePerformance) {

        if (primePerformance < 0) {
            throw new IllegalArgumentException(
                    "La prime de performance ne peut pas être négative"
            );
        }

        this.primePerformance = primePerformance;
    }

    // -------- Méthodes --------

    @Override
    public double calculerSalaireTotal() {

        return getSalaireBase() + primePerformance;
    }

    @Override
    public String getPoste() {
        return "Développeur";
    }
}