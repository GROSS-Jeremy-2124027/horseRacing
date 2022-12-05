public class Frisson extends Cheval{

    private String nomCheval;
    private int numeroCheval;
    private int nombreVictoire;
    private double coteCheval;
    private Sexe sexeCheval;
    private Vitesse vitesseCheval;

    public Frisson(String nomCheval, int numeroCheval, int nombreVictoire, double coteCheval, Sexe sexeCheval, Vitesse vitesseCheval) {
        this.nomCheval = nomCheval;
        this.numeroCheval = numeroCheval;
        this.nombreVictoire = nombreVictoire;
        this.coteCheval = coteCheval;
        this.sexeCheval = sexeCheval;
        this.vitesseCheval = vitesseCheval;
    }

    public String getNomCheval() {
        return nomCheval;
    }

    public void setNomCheval(String nomCheval) {
        this.nomCheval = nomCheval;
    }

    public int getNumeroCheval() {
        return numeroCheval;
    }

    public void setNumeroCheval(int numeroCheval) {
        this.numeroCheval = numeroCheval;
    }

    public int getNombreVictoire() {
        return nombreVictoire;
    }

    public void setNombreVictoire(int nombreVictoire) {
        this.nombreVictoire = nombreVictoire;
    }

    public double getCoteCheval() {
        return coteCheval;
    }

    public void setCoteCheval(double coteCheval) {
        this.coteCheval = coteCheval;
    }

    public Sexe getSexeCheval() {
        return sexeCheval;
    }

    public void setSexeCheval(Sexe sexeCheval) {
        this.sexeCheval = sexeCheval;
    }

    public Vitesse getVitesseCheval() {
        return vitesseCheval;
    }

    public void setVitesseCheval(Vitesse vitesseCheval) {
        this.vitesseCheval = vitesseCheval;
    }


    public double calculNote(double coteCheval, double coefficient){
        return coteCheval * coefficient;
    }
}
