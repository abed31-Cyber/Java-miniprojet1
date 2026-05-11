package service.model;



public abstract class Employe extends Personne {

    private final int id;
    private String departement;
    private double salaireBase;
    private String dateEmbauche;
    double SMIC = 1747;

    public Employe(int id, String departement, double salaireBase, String dateEmbauche) {
        super(dateEmbauche, departement, id, dateEmbauche);

        this.id = id;
        this.departement = departement;
        this.salaireBase = salaireBase;
        this.dateEmbauche = dateEmbauche;
        setDepartement(departement);
        setSalaireBase(salaireBase);
        setDateEmbauche(dateEmbauche);

    }
    // --------Getters------------------

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

    // ----Setters------

    public void setDepartement(String departement) {

        if (departement == null || departement.isEmpty()) {

            throw new IllegalArgumentException("Le departmeent ne peux etre vide");
        }
        this.departement = departement;
    }

    public void setSalaireBase(double salaireBase) {

        if (salaireBase >= SMIC) {
            throw new IllegalArgumentException("Le salaire de base doit etre superieur ou egal au SMIC");
        }
        this.salaireBase = salaireBase;
    }

    public void setDateEmbauche(String dateEmbauche) {

        if (!dateEmbauche.matches("\\d{4}-\\d{2}-\\d{2}")) {
            throw new IllegalArgumentException(
                    "La date d'embauche doit être au format YYYY-MM-DD");
        }

        this.dateEmbauche = dateEmbauche;
    }


    //-------Methode-------------


    public abstract double calculerSalaireTotal();
}
