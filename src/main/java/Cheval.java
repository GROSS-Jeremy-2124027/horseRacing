import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class Cheval implements Runnable{
    // Attributs de la classe Cheval
    // Protected pour raison d'héritage
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

    // Méthode abstraite pour pouvoir savoir de quelle race est le cheval
    public abstract String getRace();

    // Getters
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
