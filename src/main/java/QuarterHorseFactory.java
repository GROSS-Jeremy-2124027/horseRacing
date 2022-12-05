public class QuarterHorseFactory implements ChevalFactory {
    private String nomCheval;
    private int numeroCheval;
    private int nombreVictoire;
    private double coteCheval;
    private Sexe sexeCheval;
    private Vitesse vitesseCheval;

    public QuarterHorseFactory(String nomCheval, int numeroCheval, int nombreVictoire, double coteCheval, Sexe sexeCheval, Vitesse vitesseCheval) {
        this.nomCheval = nomCheval;
        this.numeroCheval = numeroCheval;
        this.nombreVictoire = nombreVictoire;
        this.coteCheval = coteCheval;
        this.sexeCheval = sexeCheval;
        this.vitesseCheval = vitesseCheval;
    }

    @Override
    public Cheval createCheval() {
        return new QuarterHorse(nomCheval, numeroCheval, nombreVictoire, coteCheval, sexeCheval, vitesseCheval);
    }
}
