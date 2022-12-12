public class PurSangArabeFactory implements ChevalFactory {
    private String nomCheval;
    private int numeroCheval;
    private int nombreVictoire;
    private double coteCheval;
    private Sexe sexeCheval;

    public PurSangArabeFactory(String nomCheval, int numeroCheval, int nombreVictoire, double coteCheval, Sexe sexeCheval) {
        this.nomCheval = nomCheval;
        this.numeroCheval = numeroCheval;
        this.nombreVictoire = nombreVictoire;
        this.coteCheval = coteCheval;
        this.sexeCheval = sexeCheval;
    }

    @Override
    public Cheval createChevalTresLent() {
        // Retourne un Pur sang très lent
        return new PurSangArabe(nomCheval, numeroCheval, nombreVictoire, coteCheval, sexeCheval, Vitesse.TRES_LENT);
    }

    @Override
    public Cheval createChevalLent() {
        // Retourne un Pur sang lent
        return new PurSangArabe(nomCheval, numeroCheval, nombreVictoire, coteCheval, sexeCheval, Vitesse.LENT);
    }

    @Override
    public Cheval createChevalMoyen() {
        // Retourne un Pur sang moyennement rapide
        return new PurSangArabe(nomCheval, numeroCheval, nombreVictoire, coteCheval, sexeCheval, Vitesse.MOYEN);
    }

    @Override
    public Cheval createChevalRapide() {
        // Retourne un Pur sang rapide
        return new PurSangArabe(nomCheval, numeroCheval, nombreVictoire, coteCheval, sexeCheval, Vitesse.RAPIDE);
    }

    @Override
    public Cheval createChevalTresRapide() {
        // Retourne un Pur sang très rapide
        return new PurSangArabe(nomCheval, numeroCheval, nombreVictoire, coteCheval, sexeCheval, Vitesse.TRES_RAPIDE);
    }
}
