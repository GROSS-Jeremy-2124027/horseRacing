public class FrissonFactory implements ChevalFactory{
    private String nomCheval;
    private int numeroCheval;
    private int nombreVictoire;
    private double coteCheval;
    private Sexe sexeCheval;

    public FrissonFactory(String nomCheval, int numeroCheval, int nombreVictoire, double coteCheval, Sexe sexeCheval) {
        this.nomCheval = nomCheval;
        this.numeroCheval = numeroCheval;
        this.nombreVictoire = nombreVictoire;
        this.coteCheval = coteCheval;
        this.sexeCheval = sexeCheval;
    }

    @Override
    public Cheval createChevalTresLent() {
        // Retourne un Frisson très lent
        return new Frisson(nomCheval, numeroCheval, nombreVictoire, coteCheval, sexeCheval, Vitesse.TRES_LENT);
    }

    @Override
    public Cheval createChevalLent() {
        // Retourne un Frisson lent
        return new Frisson(nomCheval, numeroCheval, nombreVictoire, coteCheval, sexeCheval, Vitesse.LENT);
    }

    @Override
    public Cheval createChevalMoyen() {
        // Retourne un Frisson moyennement rapide
        return new Frisson(nomCheval, numeroCheval, nombreVictoire, coteCheval, sexeCheval, Vitesse.MOYEN);
    }

    @Override
    public Cheval createChevalRapide() {
        // Retourne un Frisson rapide
        return new Frisson(nomCheval, numeroCheval, nombreVictoire, coteCheval, sexeCheval, Vitesse.RAPIDE);
    }

    @Override
    public Cheval createChevalTresRapide() {
        // Retourne un Frisson très rapide
        return new Frisson(nomCheval, numeroCheval, nombreVictoire, coteCheval, sexeCheval, Vitesse.TRES_RAPIDE);
    }
}
