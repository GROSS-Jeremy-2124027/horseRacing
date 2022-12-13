import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Course {
    public static void main(String[] args) throws Exception {
        int nombreCheval = 5;
        DispositifsDeLaCourse course = new DispositifsDeLaCourse(nombreCheval, 2.5);

        Map<Integer, AtomicInteger> dictionnairePositions = new HashMap<>();
        for (int i = 0; i < nombreCheval; i += 1) {
            dictionnairePositions.put(new Integer(i + 1), new AtomicInteger(0));
        }

        for (Iterator<Cheval> iterator = course.getChevauxDeCourse().iterator(); iterator.hasNext();) {
            Cheval chevalTemp = iterator.next();
            System.out.println("Cheval numéro : " + chevalTemp.getNumeroCheval());
            System.out.println("Ce cheval s\'appelle " + chevalTemp.getNomCheval() + " c\'est un " + chevalTemp.getRace() + " " + chevalTemp.getSexeCheval() + ", sa cote est de " + chevalTemp.getCoteCheval() + " car c\'est un cheval " + chevalTemp.getVitesse());
        }

        for (Thread thread : DispositifsDeLaCourse.getListeThread()) {
            thread.start();
        }


    }
}
