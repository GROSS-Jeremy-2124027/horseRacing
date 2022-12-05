import java.util.ArrayList;
import java.util.List;

public class Course extends Thread {
    private List<Cheval> chevauxDeCourse = new ArrayList<>();

    @Override
    public void run() {
        for (int i = 0; i < 10; ++i) {
            try {
                Thread.sleep((long) (Math.random() * 200));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Bonjour et bienvenue dans ce PMU de diiiingue !!!" + "\n" +
                    "Vous aller parier sur un chevaux. Tout d'abord, entrer le nombre de chevaux");
        }

    }
}
