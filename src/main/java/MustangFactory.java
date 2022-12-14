public class MustangFactory implements ChevalFactory{
    /**
     * Fabrique de Mustang
     */
    private String nomCheval;
    private int numeroCheval;
    private int nombreVictoire;
    private double coteCheval;
    private Sexe sexeCheval;

    /**
     * Constructeur de Mustang
     * @param nomCheval
     * @param numeroCheval
     * @param nombreVictoire
     * @param coteCheval
     * @param sexeCheval
     */
    public MustangFactory(String nomCheval, int numeroCheval, int nombreVictoire, double coteCheval, Sexe sexeCheval) {
        this.nomCheval = nomCheval;
        this.numeroCheval = numeroCheval;
        this.nombreVictoire = nombreVictoire;
        this.coteCheval = coteCheval;
        this.sexeCheval = sexeCheval;
    }

    /**
     * Fonctions permettant de créer un Mustang très lent
     * @return un cheval de race Mustang très lent
     */
    @Override
    public Cheval createChevalTresLent() {
        return new Mustang(nomCheval, numeroCheval, nombreVictoire, coteCheval, sexeCheval, Vitesse.TRES_LENT);
    }

    /**
     * Fonctions permettant de créer un Mustang lent
     * @return un cheval de race Mustang lent
     */
    @Override
    public Cheval createChevalLent() {
        return new Mustang(nomCheval, numeroCheval, nombreVictoire, coteCheval, sexeCheval, Vitesse.LENT);
    }

    /**
     * Fonctions permettant de créer un Mustang de vitesse moyen
     * @return un cheval de race Mustang de vitesse moyen
     */
    @Override
    public Cheval createChevalMoyen() {
        return new Mustang(nomCheval, numeroCheval, nombreVictoire, coteCheval, sexeCheval, Vitesse.MOYEN);
    }

    /**
     * Fonctions permettant de créer un Mustang rapide
     * @return un cheval de race Mustang rapide
     */
    @Override
    public Cheval createChevalRapide() {
        return new Mustang(nomCheval, numeroCheval, nombreVictoire, coteCheval, sexeCheval, Vitesse.RAPIDE);
    }

    /**
     * Fonctions permettant de créer un Mustang très rapide
     * @return un cheval de race Mustang très rapide
     */
    @Override
    public Cheval createChevalTresRapide() {
        return new Mustang(nomCheval, numeroCheval, nombreVictoire, coteCheval, sexeCheval, Vitesse.TRES_RAPIDE);
    }
}
