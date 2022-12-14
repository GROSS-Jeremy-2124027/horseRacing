public class FrissonFactory implements ChevalFactory{
    /**
     * Fabrique de Frisson
     */
    private String nomCheval;
    private int numeroCheval;
    private int nombreVictoire;
    private double coteCheval;
    private Sexe sexeCheval;

    /**
     * Constructeur de Frisson
     * @param nomCheval
     * @param numeroCheval
     * @param nombreVictoire
     * @param coteCheval
     * @param sexeCheval
     */
    public FrissonFactory(String nomCheval, int numeroCheval, int nombreVictoire, double coteCheval, Sexe sexeCheval) {
        this.nomCheval = nomCheval;
        this.numeroCheval = numeroCheval;
        this.nombreVictoire = nombreVictoire;
        this.coteCheval = coteCheval;
        this.sexeCheval = sexeCheval;
    }

    /**
     * Fonctions permettant de créer un frisson très lent
     * @return un cheval de race frisson très lent
     */
    @Override
    public Cheval createChevalTresLent() {
        // Retourne un Frisson très lent
        return new Frisson(nomCheval, numeroCheval, nombreVictoire, coteCheval, sexeCheval, Vitesse.TRES_LENT);
    }

    /**
     * Fonctions permettant de créer un frisson lent
     * @return un cheval de race frisson lent
     */
    @Override
    public Cheval createChevalLent() {
        return new Frisson(nomCheval, numeroCheval, nombreVictoire, coteCheval, sexeCheval, Vitesse.LENT);
    }

    /**
     * Fonctions permettant de créer un frisson de vitesse moyenne
     * @return un cheval de race frisson de vitresse moyen
     */
    @Override
    public Cheval createChevalMoyen() {
        return new Frisson(nomCheval, numeroCheval, nombreVictoire, coteCheval, sexeCheval, Vitesse.MOYEN);
    }

    /**
     * Fonctions permettant de créer un frisson rapide
     * @return un cheval de race frisson rapide
     */
    @Override
    public Cheval createChevalRapide() {
        return new Frisson(nomCheval, numeroCheval, nombreVictoire, coteCheval, sexeCheval, Vitesse.RAPIDE);
    }

    /**
     * Fonctions permettant de créer un frisson très rapide
     * @return un cheval de race frisson très rapide
     */
    @Override
    public Cheval createChevalTresRapide() {
        return new Frisson(nomCheval, numeroCheval, nombreVictoire, coteCheval, sexeCheval, Vitesse.TRES_RAPIDE);
    }
}
