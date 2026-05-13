package model;

public class Manager extends Employe {

    // -------- Attributs --------

    private double bonusMensuel;
    private int nbPersonnesManagees;

    // -------- Constructeur --------

    public Manager(
            double bonusMensuel,
            int nbPersonnesManagees,
            String nom,
            String prenom,
            int age,
            String email,
            int id,
            String departement,
            double salaireBase,
            String dateEmbauche
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

        setBonusMensuel(bonusMensuel);
        setNbPersonnesManagees(nbPersonnesManagees);
    }

    // -------- Getters --------

    public double getBonusMensuel() {
        return bonusMensuel;
    }

    public int getNbPersonnesManagees() {
        return nbPersonnesManagees;
    }

    // -------- Setters --------

    public void setBonusMensuel(double bonusMensuel) {

        if (bonusMensuel < 0) {
            throw new IllegalArgumentException(
                    "Le bonus mensuel ne peut pas être négatif"
            );
        }

        this.bonusMensuel = bonusMensuel;
    }

    public void setNbPersonnesManagees(int nbPersonnesManagees) {

        if (nbPersonnesManagees < 0) {
            throw new IllegalArgumentException(
                    "Le nombre de personnes managées ne peut pas être négatif"
            );
        }

        this.nbPersonnesManagees = nbPersonnesManagees;
    }

    // -------- Méthodes --------

    @Override
    public double calculerSalaireTotal() {

        return getSalaireBase() + bonusMensuel;
    }

    @Override
    public String getPoste() {
        return "Manager";
    }
}