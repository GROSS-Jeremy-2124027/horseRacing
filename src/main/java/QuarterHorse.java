public class QuarterHorse extends Cheval{
    private String nomCheval;
    private int numeroCheval, nombreVictoire;
    private double coteCheval;
    private Sexe sexeCheval;
    private Vitesse vitesse;


    public QuarterHorse(String nomCheval, int numeroCheval, int nombreVictoire, double coteCheval, Sexe sexeCheval, Vitesse vitesse) {
        this.nomCheval = nomCheval;
        this.numeroCheval = numeroCheval;
        this.nombreVictoire = nombreVictoire;
        this.coteCheval = coteCheval;
        this.sexeCheval = sexeCheval;
        this.vitesse = vitesse;
    }


    public double calculCote(double coteCheval, double coefficient){
        return coteCheval * coefficient;
    }
}
