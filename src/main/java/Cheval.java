public abstract class Cheval {
    protected String nomCheval;
    protected int numeroCheval, nombreVictoire;
    protected double coteCheval;
    protected Sexe sexeCheval;
    protected Vitesse vitesse;



    @Override
    public String toString() {
        return "Cheval{" +
                "nomCheval='" + nomCheval + '\'' +
                ", numeroCheval=" + numeroCheval +
                ", nombreVictoire=" + nombreVictoire +
                ", coteCheval=" + coteCheval +
                ", sexeCheval=" + sexeCheval +
                ", vitesse=" + vitesse +
                '}';
    }

    public abstract String getRace();

    public String getNomCheval() {
        return nomCheval;
    }

    public int getNumeroCheval() {
        return numeroCheval;
    }

    public int getNombreVictoire() {
        return nombreVictoire;
    }

    public double getCoteCheval() {
        return coteCheval;
    }

    public Sexe getSexeCheval() {
        return sexeCheval;
    }

    public Vitesse getVitesse() {
        return vitesse;
    }
}
