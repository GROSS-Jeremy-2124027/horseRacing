public class MustangFactory implements ChevalFactory{
    private String nomCheval;
    private int numeroCheval;
    private int nombreVictoire;
    private double coteCheval;
    private Sexe sexeCheval;

    public MustangFactory(String nomCheval, int numeroCheval, int nombreVictoire, double coteCheval, Sexe sexeCheval) {
        this.nomCheval = nomCheval;
        this.numeroCheval = numeroCheval;
        this.nombreVictoire = nombreVictoire;
        this.coteCheval = coteCheval;
        this.sexeCheval = sexeCheval;
    }

    @Override
    public Cheval createChevalTresLent() {
        // Retourne un Mustang très lent
        return new Mustang(nomCheval, numeroCheval, nombreVictoire, coteCheval, sexeCheval, Vitesse.TRES_LENT);
    }

    @Override
    public Cheval createChevalLent() {
        // Retourne un Mustang lent
        return new Mustang(nomCheval, numeroCheval, nombreVictoire, coteCheval, sexeCheval, Vitesse.LENT);
    }

    @Override
    public Cheval createChevalMoyen() {
        // Retourne un Mustang moyennement rapide
        return new Mustang(nomCheval, numeroCheval, nombreVictoire, coteCheval, sexeCheval, Vitesse.MOYEN);
    }

    @Override
    public Cheval createChevalRapide() {
        // Retourne un Mustang rapide
        return new Mustang(nomCheval, numeroCheval, nombreVictoire, coteCheval, sexeCheval, Vitesse.RAPIDE);
    }

    @Override
    public Cheval createChevalTresRapide() {
        // Retourne un Mustang très rapide
        return new Mustang(nomCheval, numeroCheval, nombreVictoire, coteCheval, sexeCheval, Vitesse.TRES_RAPIDE);
    }
}
