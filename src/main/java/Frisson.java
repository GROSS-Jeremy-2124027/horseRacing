public class Frisson extends Cheval{
    public Frisson(String nomCheval, int numeroCheval, int nombreVictoire, double coteCheval, Sexe sexeCheval, Vitesse vitesseCheval) {
        this.nomCheval = nomCheval;
        this.numeroCheval = numeroCheval;
        this.nombreVictoire = nombreVictoire;
        this.coteCheval = calculCote(coteCheval, vitesseCheval.getCoefficient());
        this.sexeCheval = sexeCheval;
        this.vitesse = vitesseCheval;
    }
    @Override
    public String getRace() {
        return "Frisson";
    }

    public double calculCote(double coteCheval, double coefficient){
        return coteCheval * coefficient;
    }
}
