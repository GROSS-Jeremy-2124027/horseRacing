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

}
