public class PurSangArabeFactory implements ChevalFactory {
    /**
     * Fabrique de Pur sang arabe
     */
    private String nomCheval;
    private int numeroCheval;
    private int nombreVictoire;
    private double coteCheval;
    private Sexe sexeCheval;

    /**
     * Constructeur de Pur sang arabe
     * @param nomCheval
     * @param numeroCheval
     * @param nombreVictoire
     * @param coteCheval
     * @param sexeCheval
     */
    public PurSangArabeFactory(String nomCheval, int numeroCheval, int nombreVictoire, double coteCheval, Sexe sexeCheval) {
        this.nomCheval = nomCheval;
        this.numeroCheval = numeroCheval;
        this.nombreVictoire = nombreVictoire;
        this.coteCheval = coteCheval;
        this.sexeCheval = sexeCheval;
    }

    /**
     * Fonctions permettant de créer un Pur sang arabe très lent
     * @return un cheval de race Pur sang arabe très lent
     */
    @Override
    public Cheval createChevalTresLent() {
        return new PurSangArabe(nomCheval, numeroCheval, nombreVictoire, coteCheval, sexeCheval, Vitesse.TRES_LENT);
    }

    /**
     * Fonctions permettant de créer un Pur sang arabe lent
     * @return un cheval de race Pur sang arabe lent
     */
    @Override
    public Cheval createChevalLent() {
        return new PurSangArabe(nomCheval, numeroCheval, nombreVictoire, coteCheval, sexeCheval, Vitesse.LENT);
    }

    /**
     * Fonctions permettant de créer un Pur sang arabe de vitesse moyen
     * @return un cheval de race Pur sang arabe de vitesse moyen
     */
    @Override
    public Cheval createChevalMoyen() {
        return new PurSangArabe(nomCheval, numeroCheval, nombreVictoire, coteCheval, sexeCheval, Vitesse.MOYEN);
    }

    /**
     * Fonctions permettant de créer un Pur sang arabe rapide
     * @return un cheval de race Pur sang arabe rapide
     */
    @Override
    public Cheval createChevalRapide() {
        return new PurSangArabe(nomCheval, numeroCheval, nombreVictoire, coteCheval, sexeCheval, Vitesse.RAPIDE);
    }

    /**
     * Fonctions permettant de créer un Pur sang arabe très rapide
     * @return un cheval de race Pur sang arabe très rapide
     */
    @Override
    public Cheval createChevalTresRapide() {
        return new PurSangArabe(nomCheval, numeroCheval, nombreVictoire, coteCheval, sexeCheval, Vitesse.TRES_RAPIDE);
    }
}
