public class QuarterHorse extends Cheval{
    private String nomCheval;
    private int numeroCheval, nombreVictoire;
    private double coteCheval;
    private Sexe sexeCheval;
    private Vitesse vitesseCheval;


    public QuarterHorse(String nomCheval, int numeroCheval, int nombreVictoire, double coteCheval, Sexe sexeCheval, Vitesse vitesseCheval) {
        this.nomCheval = nomCheval;
        this.numeroCheval = numeroCheval;
        this.nombreVictoire = nombreVictoire;
        this.coteCheval = calculCote(coteCheval, vitesseCheval.getCoefficient());
        this.sexeCheval = sexeCheval;
        this.vitesseCheval = vitesseCheval;
    }


    public double calculCote(double coteCheval, double coefficient){
        return coteCheval * coefficient;
    }
}
