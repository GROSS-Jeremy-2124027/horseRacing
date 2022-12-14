import java.util.Random;

public class QuarterHorse extends Cheval{
    public QuarterHorse(String nomCheval, int numeroCheval, int nombreVictoire, double coteCheval, Sexe sexeCheval, Vitesse vitesseCheval) {
        this.nomCheval = nomCheval;
        this.numeroCheval = numeroCheval;
        this.nombreVictoire = nombreVictoire;
        this.coteCheval = calculCote(coteCheval, vitesseCheval.getCoefficient());
        this.sexeCheval = sexeCheval;
        this.vitesse = vitesseCheval;
    }

    @Override
    public String getRace() {
        return "QuarterHorse";
    }

    // Permet de calculer la vraie côte du cheval en fonction de sa vitesse et de la côte de base

    public double calculCote(double coteCheval, double coefficient){
        return coteCheval * coefficient;
    }

    @Override
    public void run() {
        try {
            while (true) {
                if (DispositifsDeLaCourse.getEnCours().get()) {
                    Thread.sleep((long) Math.abs(1000 + (new Random().nextInt(500) * getVitesse().getCoefficient())));
                    if (DispositifsDeLaCourse.getEnCours().get()) {
                        DispositifsDeLaCourse.getDictionnairePosition().get(numeroCheval).incrementAndGet();
                    } else {
                        break;
                    }
                    DispositifsDeLaCourse.affichagePositions();
                    System.out.println();
                } else {
                    break;
                }
                if (DispositifsDeLaCourse.getDictionnairePosition().get(numeroCheval).get() == 10) {
                    DispositifsDeLaCourse.getEnCours().set(false);
                    System.out.println("Cheval " + numeroCheval + " l\'emporte ! ");
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
