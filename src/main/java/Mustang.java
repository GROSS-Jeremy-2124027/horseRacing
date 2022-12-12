public class Mustang extends Cheval{
    public Mustang(String nomCheval, int numeroCheval, int nombreVictoire, double coteCheval, Sexe sexeCheval, Vitesse vitesseCheval) {
        this.nomCheval = nomCheval;
        this.numeroCheval = numeroCheval;
        this.nombreVictoire = nombreVictoire;
        this.coteCheval = calculCote(coteCheval, vitesseCheval.getCoefficient());
        this.sexeCheval = sexeCheval;
        this.vitesse = vitesseCheval;
    }

    @Override
    public String getRace() {
        return "Mustang";
    }

    // Permet de calculer la vraie côte du cheval en fonction de sa vitesse et de la côte de base
    public double calculCote(double coteCheval, double coefficient){
        return coteCheval * coefficient;
    }
}
