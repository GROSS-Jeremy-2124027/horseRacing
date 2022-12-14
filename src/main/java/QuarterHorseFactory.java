public class QuarterHorseFactory implements ChevalFactory {
    /**
     * Fabrique de Quarter horse
     */
    private String nomCheval;
    private int numeroCheval;
    private int nombreVictoire;
    private double coteCheval;
    private Sexe sexeCheval;
    private Vitesse vitesseCheval;

    /**
     * Constructeur de Quarter horse
     * @param nomCheval
     * @param numeroCheval
     * @param nombreVictoire
     * @param coteCheval
     * @param sexeCheval
     */
    public QuarterHorseFactory(String nomCheval, int numeroCheval, int nombreVictoire, double coteCheval, Sexe sexeCheval ) {
        this.nomCheval = nomCheval;
        this.numeroCheval = numeroCheval;
        this.nombreVictoire = nombreVictoire;
        this.coteCheval = coteCheval;
        this.sexeCheval = sexeCheval;
    }

    /**
     * Fonctions permettant de créer un Quarter horse très lent
     * @return un cheval de race Quarter horse très lent
     */
    @Override
    public Cheval createChevalTresLent() {
        return new QuarterHorse(nomCheval, numeroCheval, nombreVictoire, coteCheval, sexeCheval, Vitesse.TRES_LENT);
    }

    /**
     * Fonctions permettant de créer un Quarter horse lent
     * @return un cheval de race Quarter horse lent
     */
    @Override
    public Cheval createChevalLent() {
        return new QuarterHorse(nomCheval, numeroCheval, nombreVictoire, coteCheval, sexeCheval, Vitesse.LENT);
    }

    /**
     * Fonctions permettant de créer un Quarter horse de vitesse moyen
     * @return un cheval de race Quarter horse de vitesse moyen
     */
    @Override
    public Cheval createChevalMoyen() {
        return new QuarterHorse(nomCheval, numeroCheval, nombreVictoire, coteCheval, sexeCheval, Vitesse.MOYEN);
    }

    /**
     * Fonctions permettant de créer un Quarter horse rapide
     * @return un cheval de race Quarter horse rapide
     */
    @Override
    public Cheval createChevalRapide() {
        return new QuarterHorse(nomCheval, numeroCheval, nombreVictoire, coteCheval, sexeCheval, Vitesse.RAPIDE);
    }

    /**
     * Fonctions permettant de créer un Quarter horse très rapide
     * @return un cheval de race Quarter horse très rapide
     */
    @Override
    public Cheval createChevalTresRapide() {
        return new QuarterHorse(nomCheval, numeroCheval, nombreVictoire, coteCheval, sexeCheval, Vitesse.TRES_RAPIDE);
    }
}
