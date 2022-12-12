import java.util.ArrayList;
import java.util.List;

public class Course extends Thread {
    private List<Cheval> chevauxDeCourse = new ArrayList<>();

//    @Override
//    public void run() {
//        for (int i = 0; i < 10; ++i) {
//            try {
//                Thread.sleep((long) (Math.random() * 200));
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            System.out.println("Bonjour et bienvenue dans ce PMU de diiiingue !!!" + "\n" +
//                    "Vous aller parier sur un chevaux. Tout d'abord, entrer le nombre de chevaux");
//        }
//
//    }

    public static void main(String[] args) {
        String test = GenererNomCheval.donneNomCheval();
        System.out.println(test);

        QuarterHorseFactory bob = new QuarterHorseFactory(GenererNomCheval.donneNomCheval(), 0, 0, 1.23, Sexe.MALE);
        Cheval c3 = bob.createChevalMoyen();
        Cheval cheval1 = Ecurie.createChevalMoyen(new QuarterHorseFactory(GenererNomCheval.donneNomCheval(), 0, 0, 1.23, Sexe.MALE));
        System.out.println(cheval1);
        Cheval cheval2 = Ecurie.createChevalRapide(new FrissonFactory(test, 1, 5, 1.002, Sexe.MALE));
        System.out.println(cheval2);
    }
}
