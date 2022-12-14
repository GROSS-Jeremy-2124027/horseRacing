import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Course {
    public static void main(String[] args) throws Exception {
        boolean continueCourse = true;
        while (continueCourse) {
            // Saisie au clavier du nombre de chevaux dans la course par l'utilisateur
            Scanner entreeClavier = new Scanner(System.in);
            System.out.println("Entrer le nombre de cheval pour la course : (entre 5 et 9)");
            // Si sa saisie n'est pas entre 5 et 9
            while (entreeClavier.nextInt() <= 5 && entreeClavier.nextInt() >= 9) {
                // On redemande une saisie au clavier
                entreeClavier = new Scanner(System.in);
            }
            // On met la saisie dans une variable
            int nombreCheval = entreeClavier.nextInt();

            // On crée une nouvelle course avec une cote de base
            DispositifsDeLaCourse course = new DispositifsDeLaCourse(nombreCheval, 2.5);

            Map<Integer, AtomicInteger> dictionnairePositions = new HashMap<>();
            for (int i = 0; i < nombreCheval; i += 1) {
                // Clé --> Numéro du cheval, Valeur --> entier atomic correspondant à la position du cheval dans la course
                dictionnairePositions.put(new Integer(i + 1), new AtomicInteger(0));
            }

            // On affiche les différents chevaux
            for (Iterator<Cheval> iterator = course.getChevauxDeCourse().iterator(); iterator.hasNext(); /* On "incrémente" l'itérateur dans la boucle */ ) {
                // "Incrémentation" de l'itérateur
                Cheval chevalTemp = iterator.next();
                // Affichage
                System.out.println("Cheval numéro : " + chevalTemp.getNumeroCheval());
                System.out.println("Ce cheval s\'appelle " + chevalTemp.getNomCheval() + " c\'est un " + chevalTemp.getRace() + " " + chevalTemp.getSexeCheval() + ", sa cote est de " + chevalTemp.getCoteCheval() + " car c\'est un cheval " + chevalTemp.getVitesse());
            }

            /* TODO:
                - Classe joueur où on initialise une cagnotte pour chaque joueur
                - On rentre le nombre de joueur (5 - 12)
                - Chaque joueur rentre le numéro du cheval sur lequel il souhaite parier
                - La course se fait
                - Classement de chaque cheval
                - Mise à jour des cagnottes pour chaque joueur (Si un joueur à une cagnotte négative il a perdu)
                - Modifier la cote de chaque cheval en fonction de son nombre de victoire (rajouter un attribut nombreCourse pour chaque cheval et faire sa cote en fonction de ça ?)
                - Refaire une course en misant
                - Docstring
                - Javadoc
             */
            // On lance les threads qui correspondent aux chevaux
            for (Thread thread : DispositifsDeLaCourse.getListeThread()) {
                thread.start();
            }
            while (true) {
                if (DispositifsDeLaCourse.getEnCours().get() == false) {
                    for (Thread thread : DispositifsDeLaCourse.getListeThread()) {
                        thread.stop();
                    }
                    break;
                }
            }
            System.out.println("FINI");
            break;
        }
    }
}