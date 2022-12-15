import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Course {
    public static void main(String[] args) throws Exception {
        /**
         * Fonction principale, lancant le jeu (demande nombre de chevaux, de parieurs ainsi que les chevaux sur
         * lesquels les joueurs misent)
         */
        boolean continueCourse = true;
        // Saisie au clavier du nombre de chevaux dans la course par l'utilisateur
        System.out.println("Entrer le nombre de cheval pour la course : (entre 5 et 9)");
        Scanner entreeClavier = new Scanner(System.in);
        int nombreCheval = entreeClavier.nextInt();
        // Si sa saisie n'est pas entre 5 et 9
        while (!(nombreCheval >= 5 && nombreCheval <= 9)) {
            // On redemande une saisie au clavier
            entreeClavier = new Scanner(System.in);
            nombreCheval = entreeClavier.nextInt();
        }

        // On crée une nouvelle course avec une cote de base
        DispositifsDeLaCourse course = new DispositifsDeLaCourse(nombreCheval, 2.5);

        Map<Integer, AtomicInteger> dictionnairePositions = new HashMap<>();
        for (int i = 0; i < nombreCheval; i += 1) {
            // Clé --> Numéro du cheval, Valeur --> entier atomic correspondant à la position du cheval dans la course
            dictionnairePositions.put(new Integer(i + 1), new AtomicInteger(0));
        }
        System.out.println("Entrer le nombre de joueur : (entre 2 et 9)");
        entreeClavier = new Scanner(System.in);
        int nombreJoueur = entreeClavier.nextInt();
        while (!(nombreJoueur >= 2 && nombreJoueur <= 9)) {
            entreeClavier = new Scanner(System.in);
            nombreJoueur = entreeClavier.nextInt();
        }

        for (int i = 0; i < nombreJoueur; i += 1) {
            System.out.println("Rentrer nom parieur : ");
            entreeClavier = new Scanner(System.in);
            String nomParieur = entreeClavier.nextLine();
            course.getParieursDeLaCourse().add(new Parieur(nomParieur));
        }


        // On affiche les différents chevaux
        for (Iterator<Cheval> iterator = course.getChevauxDeCourse().iterator(); iterator.hasNext(); /* On "incrémente" l'itérateur dans la boucle */) {
            // "Incrémentation" de l'itérateur
            Cheval chevalTemp = iterator.next();
            // Affichage
            System.out.println("Cheval numéro : " + chevalTemp.getNumeroCheval());
            System.out.println("Ce cheval s\'appelle " + chevalTemp.getNomCheval() + " c\'est un " + chevalTemp.getRace() + " " + chevalTemp.getSexeCheval() + ", sa cote est de " + chevalTemp.getCoteCheval() + " car c\'est un cheval " + chevalTemp.getVitesse());
        }
        for(int nombreDeCourse = 0 ; continueCourse == true ; nombreDeCourse += 1) {
            for (Parieur parieur : course.getParieursDeLaCourse()) {
                System.out.println(parieur.getNomParieur() + " pour qui voulez-vous parier ? (rentrer le numéro du cheval)");
                entreeClavier = new Scanner(System.in);
                int numeroDuChevalSurLequelParier = entreeClavier.nextInt();
                while (numeroDuChevalSurLequelParier < 0 && numeroDuChevalSurLequelParier > nombreCheval) {
                    entreeClavier = new Scanner(System.in);
                    numeroDuChevalSurLequelParier = entreeClavier.nextInt();
                }
                parieur.setNumeroDuChevalSurLequelParier(numeroDuChevalSurLequelParier);

            }

            /* TODO:
                - Classement de chaque cheval
                - Modifier la cote de chaque cheval en fonction de son nombre de victoire (rajouter un attribut nombreCourse pour chaque cheval et faire sa cote en fonction de ça ?)
                - Javadoc
             */
            // On lance les threads qui correspondent aux chevaux
            course.lanceLesChevaux(nombreDeCourse);
            while (true) {
                if (DispositifsDeLaCourse.getEnCours().get() == false) {
                    for (Thread thread : DispositifsDeLaCourse.getListeThread()) {
                        thread.suspend();
                    }
                    DispositifsDeLaCourse.getEnCours().set(true);
                    break;
                }
            }
            System.out.println("FINI");
            Cheval vainqueur = course.trouveVainqueur();
            course.afficherResultatCourse();

            for (Parieur parieur : course.getParieursDeLaCourse()) {
                if (!(parieur.getNumeroDuChevalSurLequelParier() == vainqueur.getNumeroCheval())) {
                    parieur.setCagnotte(parieur.getCagnotte() + (parieur.getCagnotte() / vainqueur.getCoteCheval()));
                    parieur.setNombreVictoires(parieur.getNombreVictoires() + 1);

                    parieur.setCagnotte(parieur.getCagnotte() - (parieur.getCagnotte() / vainqueur.getCoteCheval()));
                    if (parieur.getCagnotte() < 1) {
                        System.out.println(parieur.getNomParieur() + " est éliminé !");
                        course.getParieursDeLaCourse().remove(parieur);
                        parieur = null;
                    }
                } else {
                    parieur.setCagnotte(parieur.getCagnotte() + (parieur.getCagnotte() / vainqueur.getCoteCheval()));
                    parieur.setNombreVictoires(parieur.getNombreVictoires() + 1);
                }
                if (course.verificationVictoireParieur()) {
                    System.out.println(course.getParieursDeLaCourse().get(0).getNomParieur() + " remporte la victoire ! ");
                    System.out.println(course.getParieursDeLaCourse().get(0).getNomParieur() + " aura remporté un total de " + course.getParieursDeLaCourse().get(0).getNombreVictoires() + " paris.");
                    continueCourse = false;
                    break;
                }
                System.out.println(parieur.getNomParieur() + " il te reste : " + parieur.getCagnotte() + " €.");
            }
            course.remettreChevalSurLigneDeDépart();
        }
    }
}