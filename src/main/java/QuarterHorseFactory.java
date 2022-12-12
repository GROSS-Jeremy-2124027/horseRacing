public class QuarterHorseFactory implements ChevalFactory {
    private String nomCheval;
    private int numeroCheval;
    private int nombreVictoire;
    private double coteCheval;
    private Sexe sexeCheval;
    private Vitesse vitesseCheval;

    public QuarterHorseFactory(String nomCheval, int numeroCheval, int nombreVictoire, double coteCheval, Sexe sexeCheval ) {
        this.nomCheval = nomCheval;
        this.numeroCheval = numeroCheval;
        this.nombreVictoire = nombreVictoire;
        this.coteCheval = coteCheval;
        this.sexeCheval = sexeCheval;
    }


    @Override
    public Cheval createChevalTresLent() {
        // Retourne un Quarter horse très lent
        return new QuarterHorse(nomCheval, numeroCheval, nombreVictoire, coteCheval, sexeCheval, Vitesse.TRES_LENT);
    }

    @Override
    public Cheval createChevalLent() {
        // Retourne un Quarter horse lent
        return new QuarterHorse(nomCheval, numeroCheval, nombreVictoire, coteCheval, sexeCheval, Vitesse.LENT);
    }

    @Override
    public Cheval createChevalMoyen() {
        // Retourne un Quarter horse moyennement rapide
        return new QuarterHorse(nomCheval, numeroCheval, nombreVictoire, coteCheval, sexeCheval, Vitesse.MOYEN);
    }

    @Override
    public Cheval createChevalRapide() {
        // Retourne un Quarter horse rapide
        return new QuarterHorse(nomCheval, numeroCheval, nombreVictoire, coteCheval, sexeCheval, Vitesse.RAPIDE);
    }

    @Override
    public Cheval createChevalTresRapide() {
        // Retourne un Quarter horse très rapide
        return new QuarterHorse(nomCheval, numeroCheval, nombreVictoire, coteCheval, sexeCheval, Vitesse.TRES_RAPIDE);
    }
}
