import java.util.Iterator;

public class Course {
    public static void main(String[] args) throws Exception {


        DispositifsDeLaCourse course = new DispositifsDeLaCourse(5, 2.5);

        for (Iterator<Cheval> iterator = course.getChevauxDeCourse().iterator(); iterator.hasNext();) {
            Cheval chevalTemp = iterator.next();
            System.out.println("Cheval numéro : " + chevalTemp.getNumeroCheval());
            System.out.println("Ce cheval s\'appelle " + chevalTemp.getNomCheval() + " c\'est un " + chevalTemp.getRace() + " " + chevalTemp.getSexeCheval() + ", sa cote est de " + chevalTemp.getCoteCheval() + " car c\'est un cheval " + chevalTemp.getVitesse());
        }
    }
}
