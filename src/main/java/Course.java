import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Classe contenant la méthode static main pour pouvoir lancer la course.
 */
public class Course {
    public static void main(String[] args) throws Exception {
        boolean continueCourse = true;

        // Saisie au clavier du nombre de chevaux dans la course par l'utilisateur
        System.out.println("Entrer le nombre de cheval pour la course : (entre 5 et 9)");
        Scanner entreeClavier = new Scanner(System.in);
        int nombreCheval = entreeClavier.nextInt();
        // Si sa saisie n'est pas entre 5 et 9
        while (!(nombreCheval >= 5 && nombreCheval <= 9)) {
            // On redemande une saisie au clavier
            System.out.println("Entrer le nombre de cheval pour la course : (entre 5 et 9)");
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
            System.out.println("Entrer le nombre de joueur : (entre 2 et 9)");
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
        for(int nombreDeCourse = 0; continueCourse; nombreDeCourse += 1) {
            /* COURSE */

            for (Parieur parieur : course.getParieursDeLaCourse()) {
                // Demande d'entrée clavier pour savoir sur quel cheval parier
                System.out.println(parieur.getNomParieur() + " pour qui voulez-vous parier ? (rentrer le numéro du cheval)");
                entreeClavier = new Scanner(System.in);
                int numeroDuChevalSurLequelParier = entreeClavier.nextInt();
                // Tant que l'entrée clavier n'est pas entre 1 et le nombre de chevaux dans la course
                while (numeroDuChevalSurLequelParier < 1 || numeroDuChevalSurLequelParier > nombreCheval) {
                    System.out.println(parieur.getNomParieur() + " pour qui voulez-vous parier ? (rentrer le numéro du cheval)");
                    entreeClavier = new Scanner(System.in);
                    numeroDuChevalSurLequelParier = entreeClavier.nextInt();
                }
                parieur.setNumeroDuChevalSurLequelParier(numeroDuChevalSurLequelParier);

            }
            // On lance les threads qui correspondent aux chevaux
            course.lanceLesChevaux(nombreDeCourse);
            while (true) {
                // Pendant l'exécution des threads, on regarde si la variable booléenne atomic correpons à faux (donc la course s'est arrêtée)
                if (DispositifsDeLaCourse.getEnCours().get() == false) {
                    for (Thread thread : DispositifsDeLaCourse.getListeThread()) {
                        // On suspend les threads
                        thread.suspend();
                    }
                    // On réinitialise la variable à true pour les prochaines courses
                    DispositifsDeLaCourse.getEnCours().set(true);
                    break;
                }
            }

            // On retrouve le cheval victorieux et on affiche les résultats de la course
            Cheval vainqueur = course.trouveVainqueur();
            course.afficherResultatCourse();

            for (Parieur parieur : course.getParieursDeLaCourse()) {
                // Si le parieur n'a pas parié sur le cheval victorieux
                if (!(parieur.getNumeroDuChevalSurLequelParier() == vainqueur.getNumeroCheval())) {
                    // On modifie la cagnotte du parieur
                    parieur.setCagnotte(parieur.getCagnotte() - (parieur.getCagnotte() / vainqueur.getCoteCheval()));
                    if (parieur.getCagnotte() < 1) {
                        // Si sa cagnotte est inférieure à 1
                        System.out.println(parieur.getNomParieur() + " est éliminé !");
                        course.getParieursDeLaCourse().remove(parieur);
                        parieur = null;
                    }
                } else {
                    // Si le parieur a parié sur le cheval victorieux
                    parieur.setCagnotte(parieur.getCagnotte() + (parieur.getCagnotte() / vainqueur.getCoteCheval()));
                    parieur.setNombreVictoires(parieur.getNombreVictoires() + 1);
                }
                // Si il ne reste plus aucun parieur dans la liste (le dernier vient d'être supprimé dans la boucle
                if (course.defaiteGenerale()) {
                    System.out.println("Personne ne remporte la victoire. Ce sont des choses qui arrivent.");
                    continueCourse = false;
                    course.arretDeLaCourse();
                    break;
                }
                // Si il ne reste plus qu'un parieur
                if (course.verificationVictoireParieur()) {
                    // Affichage du vainqueur
                    System.out.println(course.getParieursDeLaCourse().get(0).getNomParieur() + " remporte la victoire ! ");
                    System.out.println(course.getParieursDeLaCourse().get(0).getNomParieur() + " aura remporté un total de " + course.getParieursDeLaCourse().get(0).getNombreVictoires() + " paris.");
                    continueCourse = false;
                    course.arretDeLaCourse();
                    break;
                }
                System.out.println(parieur.getNomParieur() + " il te reste : " + parieur.getCagnotte() + " €.");
            }
            // Entrée clavier pour savoir si on arrête la course
            System.out.println("Voulez-vous continuez ? (Oui ou Non)");
            entreeClavier = new Scanner(System.in);
            String continuerLaCourseOuPas = entreeClavier.nextLine();
            // Tant que l'utilisateur ne rentre pas une des deux options
            while (!(continuerLaCourseOuPas.equals("Oui")) && !(continuerLaCourseOuPas.equals("Non"))) {
                System.out.println("Voulez-vous continuez ? (Oui ou Non)");
                entreeClavier = new Scanner(System.in);
                continuerLaCourseOuPas = entreeClavier.nextLine();
            }
            // Si il souhaite arrêter
            if (continuerLaCourseOuPas.equals("Non")) {
                continueCourse = false;
                course.arretDeLaCourse();
                course.affichageResultatsParieurs();
                break;
            } else { // Sinon
                // On remet à zéro les valeurs du dictionnaire de positions
                course.remettreChevalSurLigneDeDépart();
            }
        }
    }
}