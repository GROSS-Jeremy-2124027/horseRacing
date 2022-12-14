import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class DispositifsDeLaCourse {
    /**
     * Classe définissant les dispositifs de la course (nombre de chevaux, cote de base, parieurs)
     */
    // Attributs de la classe DispositifsDeLaCourse

    // Liste qui va comporter les chevaux de la course
    private List<Cheval> chevauxDeCourse = new ArrayList<>();
    // Liste qui permet de répertorier les différentes races de chevaux
    private List<String> typesDeChevaux = new ArrayList<>(List.of("Frisson", "Mustang", "PurSangArabe", "QuarterHorse"));
    // Liste qui permet de répertorier les différents types de vitesses
    private List<Vitesse> listeDeVitesses = new ArrayList<>(List.of(Vitesse.TRES_LENT, Vitesse.LENT, Vitesse.MOYEN, Vitesse.RAPIDE, Vitesse.TRES_RAPIDE));
    // Liste qui permet de savoir si le cheval est un male ou une femelle
    private List<Sexe> listeDesSexes = new ArrayList<>(List.of(Sexe.MALE, Sexe.FEMALE));
    // Map d'entiers et d'entiers atomics qui va permettre de déterminer la position de chaque cheval lors de la course
    private static Map<Integer, AtomicInteger> dictionnairePosition = new HashMap<>();

    private static List<Thread> listeThread = new ArrayList<>();

    private static AtomicBoolean enCours = new AtomicBoolean(true);

    private static List<Parieur> parieursDeLaCourse = new ArrayList<>();

    public DispositifsDeLaCourse(int nombreChevaux, double coteDeBase) {
        // Permet de numéroter chaque cheval
        int compteurCheval = 1;
        for (int i = 0; i < nombreChevaux; i += 1) {
            // On ajoute un entier atomic pour chaque cheval
            dictionnairePosition.put(new Integer(i + 1), new AtomicInteger(0));
            // On prend une race de cheval aléatoirement dans la liste des types de chevaux
            String typeCheval = typesDeChevaux.get(new Random().nextInt(typesDeChevaux.size()));
            switch (typeCheval) {
                case "Frisson": // Si le cheval est un Frisson
                    // On prend une vitesse aléatoirement pour le cheval
                    Vitesse vitesse = listeDeVitesses.get(new Random().nextInt(listeDeVitesses.size()));
                    switch (vitesse) {
                        case LENT: // Si le Frisson est lent
                            // On prend aléatoirement un sexe pour le cheval
                            Sexe sexe = listeDesSexes.get(new Random().nextInt(listeDesSexes.size()));
                            switch (sexe) {
                                case MALE: // Si le Frisson est un mâle
                                    // On ajoute un Frisson mâle et lent dans notre liste
                                    chevauxDeCourse.add(Ecurie.createChevalLent(new FrissonFactory(GenererNomCheval.donneNomCheval(), compteurCheval, 0, coteDeBase, Sexe.MALE)));
                                    // On ajoute dans notre liste de thread le nouveau cheval
                                    listeThread.add(new Thread(chevauxDeCourse.get(i)));
                                    break;
                                case FEMALE: // Si le Frisson est une femelle
                                    // On ajoute un Frisson femelle et lent dans notre liste
                                    chevauxDeCourse.add(Ecurie.createChevalLent(new FrissonFactory(GenererNomCheval.donneNomCheval(), compteurCheval, 0, coteDeBase, Sexe.FEMALE)));
                                    // On ajoute dans notre liste de thread le nouveau cheval
                                    listeThread.add(new Thread(chevauxDeCourse.get(i)));
                                    break;
                            }
                            break;
                        case TRES_LENT: // Si le Frisson est très lent
                            // On prend aléatoirement un sexe pour le cheval
                            sexe = listeDesSexes.get(new Random().nextInt(listeDesSexes.size()));
                            switch (sexe) {
                                case MALE: // Si le Frisson est un mâle
                                    // On ajoute un Frisson mâle et très lent dans notre liste
                                    chevauxDeCourse.add(Ecurie.createChevalTresLent(new FrissonFactory(GenererNomCheval.donneNomCheval(), compteurCheval, 0, coteDeBase, Sexe.MALE)));
                                    // On ajoute dans notre liste de thread le nouveau cheval
                                    listeThread.add(new Thread(chevauxDeCourse.get(i)));
                                    break;
                                case FEMALE: /// Si le Frisson est une femelle
                                    // On ajoute un Frisson femelle et très lent dans notre liste
                                    chevauxDeCourse.add(Ecurie.createChevalTresLent(new FrissonFactory(GenererNomCheval.donneNomCheval(), compteurCheval, 0, coteDeBase, Sexe.FEMALE)));
                                    // On ajoute dans notre liste de thread le nouveau cheval
                                    listeThread.add(new Thread(chevauxDeCourse.get(i)));
                                    break;
                            }
                            break;
                        case MOYEN: // Si le Frisson est moyennement rapide
                            // On prend aléatoirement un sexe pour le cheval
                            sexe = listeDesSexes.get(new Random().nextInt(listeDesSexes.size()));
                            switch (sexe) {
                                case MALE: // Si le Frisson est un male
                                    // On ajoute un Frisson mâle et moyennement rapide dans notre liste
                                    chevauxDeCourse.add(Ecurie.createChevalMoyen(new FrissonFactory(GenererNomCheval.donneNomCheval(), compteurCheval, 0, coteDeBase, Sexe.MALE)));
                                    // On ajoute dans notre liste de thread le nouveau cheval
                                    listeThread.add(new Thread(chevauxDeCourse.get(i)));
                                    break;
                                case FEMALE: // Si le Frisson est une femelle
                                    // On ajoute un Frisson femelle et moyennement rapide dans notre liste
                                    chevauxDeCourse.add(Ecurie.createChevalMoyen(new FrissonFactory(GenererNomCheval.donneNomCheval(), compteurCheval, 0, coteDeBase, Sexe.FEMALE)));
                                    // On ajoute dans notre liste de thread le nouveau cheval
                                    listeThread.add(new Thread(chevauxDeCourse.get(i)));
                                    break;
                            }
                            break;
                        case RAPIDE: // Si le Frisson est rapide
                            // On prend aléatoirement un sexe pour le cheval
                            sexe = listeDesSexes.get(new Random().nextInt(listeDesSexes.size()));
                            switch (sexe) {
                                case MALE: // Si le Frisson est un mâle
                                    // On ajoute un Frisson mâle et rapide dans notre liste
                                    chevauxDeCourse.add(Ecurie.createChevalRapide(new FrissonFactory(GenererNomCheval.donneNomCheval(), compteurCheval, 0, coteDeBase, Sexe.MALE)));
                                    // On ajoute dans notre liste de thread le nouveau cheval
                                    listeThread.add(new Thread(chevauxDeCourse.get(i)));
                                    break;
                                case FEMALE: // Si le Frisson est une femelle
                                    // On ajoute un Frisson femelle et rapide dans notre liste
                                    chevauxDeCourse.add(Ecurie.createChevalRapide(new FrissonFactory(GenererNomCheval.donneNomCheval(), compteurCheval, 0, coteDeBase, Sexe.FEMALE)));
                                    // On ajoute dans notre liste de thread le nouveau cheval
                                    listeThread.add(new Thread(chevauxDeCourse.get(i)));
                                    break;
                            }
                            break;
                        case TRES_RAPIDE: // Si le Frisson est très rapide
                            // On prend aléatoirement un sexe pour le cheval
                            sexe = listeDesSexes.get(new Random().nextInt(listeDesSexes.size()));
                            switch (sexe) {
                                case MALE: // Si le cheval est un mâle
                                    // On ajoute un Frisson mâle et très rapide dans notre liste
                                    chevauxDeCourse.add(Ecurie.createChevalTresRapide(new FrissonFactory(GenererNomCheval.donneNomCheval(), compteurCheval, 0, coteDeBase, Sexe.MALE)));
                                    // On ajoute dans notre liste de thread le nouveau cheval
                                    listeThread.add(new Thread(chevauxDeCourse.get(i)));
                                    break;
                                case FEMALE: // Si le cheval est une femelle
                                    // On ajoute un Frisson femelle et très rapide dans notre liste
                                    chevauxDeCourse.add(Ecurie.createChevalTresRapide(new FrissonFactory(GenererNomCheval.donneNomCheval(), compteurCheval, 0, coteDeBase, Sexe.FEMALE)));
                                    // On ajoute dans notre liste de thread le nouveau cheval
                                    listeThread.add(new Thread(chevauxDeCourse.get(i)));
                                    break;
                            }
                            break;
                    }
                    break;
                case "Mustang": // Si le cheval est un Mustang
                    // On prend une vitesse aléatoirement pour le cheval
                    vitesse = listeDeVitesses.get(new Random().nextInt(listeDeVitesses.size()));
                    switch (vitesse) {
                        case LENT: // Si le mustang est lent
                            // On prend aléatoirement un sexe pour le cheval
                            Sexe sexe = listeDesSexes.get(new Random().nextInt(listeDesSexes.size()));
                            switch (sexe) {
                                case MALE: // Si le mustang est un mâle
                                    // On ajoute un Mustang mâle et lent dans notre liste
                                    chevauxDeCourse.add(Ecurie.createChevalLent(new MustangFactory(GenererNomCheval.donneNomCheval(), compteurCheval, 0, coteDeBase, Sexe.MALE)));
                                    // On ajoute dans notre liste de thread le nouveau cheval
                                    listeThread.add(new Thread(chevauxDeCourse.get(i)));
                                    break;
                                case FEMALE: // Si le mustang est une femelle
                                    // On ajoute un Mustang femelle et lent dans notre liste
                                    chevauxDeCourse.add(Ecurie.createChevalLent(new MustangFactory(GenererNomCheval.donneNomCheval(), compteurCheval, 0, coteDeBase, Sexe.FEMALE)));
                                    // On ajoute dans notre liste de thread le nouveau cheval
                                    listeThread.add(new Thread(chevauxDeCourse.get(i)));
                                    break;
                            }
                            break;
                        case TRES_LENT: // Si le mustang est très lent
                            // On prend aléatoirement un sexe pour le cheval
                            sexe = listeDesSexes.get(new Random().nextInt(listeDesSexes.size()));
                            switch (sexe) {
                                case MALE: // Si le mustang est un mâle
                                    // On ajoute un Mustang mâle et très lent dans notre liste
                                    chevauxDeCourse.add(Ecurie.createChevalTresLent(new MustangFactory(GenererNomCheval.donneNomCheval(), compteurCheval, 0, coteDeBase, Sexe.MALE)));
                                    // On ajoute dans notre liste de thread le nouveau cheval
                                    listeThread.add(new Thread(chevauxDeCourse.get(i)));
                                    break;
                                case FEMALE: // Si le mustang est une femelle
                                    // On ajoute un Mustang femelle et très lent dans notre liste
                                    chevauxDeCourse.add(Ecurie.createChevalTresLent(new MustangFactory(GenererNomCheval.donneNomCheval(), compteurCheval, 0, coteDeBase, Sexe.FEMALE)));
                                    // On ajoute dans notre liste de thread le nouveau cheval
                                    listeThread.add(new Thread(chevauxDeCourse.get(i)));
                                    break;
                            }
                            break;
                        case MOYEN: // Si le mustang est moyennement rapide
                            // On prend aléatoirement un sexe pour le cheval
                            sexe = listeDesSexes.get(new Random().nextInt(listeDesSexes.size()));
                            switch (sexe) {
                                case MALE: // Si le mustang est un mâle
                                    // On ajoute un Mustang mâle et moyennement rapide dans notre liste
                                    chevauxDeCourse.add(Ecurie.createChevalMoyen(new MustangFactory(GenererNomCheval.donneNomCheval(), compteurCheval, 0, coteDeBase, Sexe.MALE)));
                                    // On ajoute dans notre liste de thread le nouveau cheval
                                    listeThread.add(new Thread(chevauxDeCourse.get(i)));
                                    break;
                                case FEMALE: // Si le mustang est une femelle
                                    // On ajoute un Mustang femelle et moyennement rapide dans notre liste
                                    chevauxDeCourse.add(Ecurie.createChevalMoyen(new MustangFactory(GenererNomCheval.donneNomCheval(), compteurCheval, 0, coteDeBase, Sexe.FEMALE)));
                                    // On ajoute dans notre liste de thread le nouveau cheval
                                    listeThread.add(new Thread(chevauxDeCourse.get(i)));
                                    break;
                            }
                            break;
                        case RAPIDE: // Si le mustang est rapide
                            // On prend aléatoirement un sexe pour le cheval
                            sexe = listeDesSexes.get(new Random().nextInt(listeDesSexes.size()));
                            switch (sexe) {
                                case MALE: // Si le mustang est un mâle
                                    // On ajoute un Mustang mâle et rapide dans notre liste
                                    chevauxDeCourse.add(Ecurie.createChevalRapide(new MustangFactory(GenererNomCheval.donneNomCheval(), compteurCheval, 0, coteDeBase, Sexe.MALE)));
                                    // On ajoute dans notre liste de thread le nouveau cheval
                                    listeThread.add(new Thread(chevauxDeCourse.get(i)));
                                    break;
                                case FEMALE: // Si le mustang est une femelle
                                    // On ajoute un Mustang femelle et rapide dans notre liste
                                    chevauxDeCourse.add(Ecurie.createChevalRapide(new MustangFactory(GenererNomCheval.donneNomCheval(), compteurCheval, 0, coteDeBase, Sexe.FEMALE)));
                                    // On ajoute dans notre liste de thread le nouveau cheval
                                    listeThread.add(new Thread(chevauxDeCourse.get(i)));
                                    break;
                            }
                            break;
                        case TRES_RAPIDE: // Si le mustang est très rapide
                            // On prend aléatoirement un sexe pour le cheval
                            sexe = listeDesSexes.get(new Random().nextInt(listeDesSexes.size()));
                            switch (sexe) {
                                case MALE: // Si le mustang est un mâle
                                    // On ajoute un Mustang mâle et très rapide dans notre liste
                                    chevauxDeCourse.add(Ecurie.createChevalTresRapide(new MustangFactory(GenererNomCheval.donneNomCheval(), compteurCheval, 0, coteDeBase, Sexe.MALE)));
                                    // On ajoute dans notre liste de thread le nouveau cheval
                                    listeThread.add(new Thread(chevauxDeCourse.get(i)));
                                    break;
                                case FEMALE: // Si le mustang est une femelle
                                    // On ajoute un Mustang femelle et très rapide dans notre liste
                                    chevauxDeCourse.add(Ecurie.createChevalTresRapide(new MustangFactory(GenererNomCheval.donneNomCheval(), compteurCheval, 0, coteDeBase, Sexe.FEMALE)));
                                    // On ajoute dans notre liste de thread le nouveau cheval
                                    listeThread.add(new Thread(chevauxDeCourse.get(i)));
                                    break;
                            }
                            break;
                    }
                    break;
                case "PurSangArabe": // Si le cheval est un Pur sang arabe
                    // On prend une vitesse aléatoirement pour le cheval
                    vitesse = listeDeVitesses.get(new Random().nextInt(listeDeVitesses.size()));
                    switch (vitesse) {
                        case LENT: // Si le pur sang est lent
                            // On prend aléatoirement un sexe pour le cheval
                            Sexe sexe = listeDesSexes.get(new Random().nextInt(listeDesSexes.size()));
                            switch (sexe) {
                                case MALE: // Si le pur sang est un mâle
                                    // On ajoute un Pur sang mâle et lent dans notre liste
                                    chevauxDeCourse.add(Ecurie.createChevalLent(new PurSangArabeFactory(GenererNomCheval.donneNomCheval(), compteurCheval, 0, coteDeBase, Sexe.MALE)));
                                    // On ajoute dans notre liste de thread le nouveau cheval
                                    listeThread.add(new Thread(chevauxDeCourse.get(i)));
                                    break;
                                case FEMALE: // Si le pur sang est une femelle
                                    // On ajoute un Pur sang femelle et lent dans notre liste
                                    chevauxDeCourse.add(Ecurie.createChevalLent(new PurSangArabeFactory(GenererNomCheval.donneNomCheval(), compteurCheval, 0, coteDeBase, Sexe.FEMALE)));
                                    // On ajoute dans notre liste de thread le nouveau cheval
                                    listeThread.add(new Thread(chevauxDeCourse.get(i)));
                                    break;
                            }
                            break;
                        case TRES_LENT: // Si le pur sang est très lent
                            // On prend aléatoirement un sexe pour le cheval
                            sexe = listeDesSexes.get(new Random().nextInt(listeDesSexes.size()));
                            switch (sexe) {
                                case MALE: // Si le pur sang est un mâle
                                    // On ajoute un Pur sang mâle et très lent dans notre liste
                                    chevauxDeCourse.add(Ecurie.createChevalTresLent(new PurSangArabeFactory(GenererNomCheval.donneNomCheval(), compteurCheval, 0, coteDeBase, Sexe.MALE)));
                                    // On ajoute dans notre liste de thread le nouveau cheval
                                    listeThread.add(new Thread(chevauxDeCourse.get(i)));
                                    break;
                                case FEMALE: // Si le pur sang est une femelle
                                    // On ajoute un Pur sang femelle et très lent dans notre liste
                                    chevauxDeCourse.add(Ecurie.createChevalTresLent(new PurSangArabeFactory(GenererNomCheval.donneNomCheval(), compteurCheval, 0, coteDeBase, Sexe.FEMALE)));
                                    // On ajoute dans notre liste de thread le nouveau cheval
                                    listeThread.add(new Thread(chevauxDeCourse.get(i)));
                                    break;
                            }
                            break;
                        case MOYEN: // Si le pur sang est moyennement rapide
                            // On prend aléatoirement un sexe pour le cheval
                            sexe = listeDesSexes.get(new Random().nextInt(listeDesSexes.size()));
                            switch (sexe) {
                                case MALE: // Si le pur sang est un mâle
                                    // On ajoute un Pur sang mâle et moyennement rapide dans notre liste
                                    chevauxDeCourse.add(Ecurie.createChevalMoyen(new PurSangArabeFactory(GenererNomCheval.donneNomCheval(), compteurCheval, 0, coteDeBase, Sexe.MALE)));
                                    // On ajoute dans notre liste de thread le nouveau cheval
                                    listeThread.add(new Thread(chevauxDeCourse.get(i)));
                                    break;
                                case FEMALE: // Si le pur sang est une femelle
                                    // On ajoute un Pur sang femelle et moyennement rapide dans notre liste
                                    chevauxDeCourse.add(Ecurie.createChevalMoyen(new PurSangArabeFactory(GenererNomCheval.donneNomCheval(), compteurCheval, 0, coteDeBase, Sexe.FEMALE)));
                                    // On ajoute dans notre liste de thread le nouveau cheval
                                    listeThread.add(new Thread(chevauxDeCourse.get(i)));
                                    break;
                            }
                            break;
                        case RAPIDE: // Si le pur sang est rapide
                            // On prend aléatoirement un sexe pour le cheval
                            sexe = listeDesSexes.get(new Random().nextInt(listeDesSexes.size()));
                            switch (sexe) {
                                case MALE: // Si le pur sang est un mâle
                                    // On ajoute un Pur sang mâle et rapide dans notre liste
                                    chevauxDeCourse.add(Ecurie.createChevalRapide(new PurSangArabeFactory(GenererNomCheval.donneNomCheval(), compteurCheval, 0, coteDeBase, Sexe.MALE)));
                                    // On ajoute dans notre liste de thread le nouveau cheval
                                    listeThread.add(new Thread(chevauxDeCourse.get(i)));
                                    break;
                                case FEMALE: // Si le pur sang est une femelle
                                    // On ajoute un Pur sang femelle et rapide dans notre liste
                                    chevauxDeCourse.add(Ecurie.createChevalRapide(new PurSangArabeFactory(GenererNomCheval.donneNomCheval(), compteurCheval, 0, coteDeBase, Sexe.FEMALE)));
                                    // On ajoute dans notre liste de thread le nouveau cheval
                                    listeThread.add(new Thread(chevauxDeCourse.get(i)));
                                    break;
                            }
                            break;
                        case TRES_RAPIDE: // Si le pur sang est très rapide
                            // On prend aléatoirement un sexe pour le cheval
                            sexe = listeDesSexes.get(new Random().nextInt(listeDesSexes.size()));
                            switch (sexe) {
                                case MALE: // Si le pur sang est un mâle
                                    // On ajoute un Pur sang mâle et très rapide dans notre liste
                                    chevauxDeCourse.add(Ecurie.createChevalTresRapide(new PurSangArabeFactory(GenererNomCheval.donneNomCheval(), compteurCheval, 0, coteDeBase, Sexe.MALE)));
                                    // On ajoute dans notre liste de thread le nouveau cheval
                                    listeThread.add(new Thread(chevauxDeCourse.get(i)));
                                    break;
                                case FEMALE: // Si le pur sang est une femelle
                                    // On ajoute un Pur sang femelle et très rapide dans notre liste
                                    chevauxDeCourse.add(Ecurie.createChevalTresRapide(new PurSangArabeFactory(GenererNomCheval.donneNomCheval(), compteurCheval, 0, coteDeBase, Sexe.FEMALE)));
                                    // On ajoute dans notre liste de thread le nouveau cheval
                                    listeThread.add(new Thread(chevauxDeCourse.get(i)));
                                    break;
                            }
                            break;
                    }
                    break;
                case "QuarterHorse": // Si le cheval est un Quarter horse
                    // On prend une vitesse aléatoirement pour le cheval
                    vitesse = listeDeVitesses.get(new Random().nextInt(listeDeVitesses.size()));
                    switch (vitesse) {
                        case LENT: // Si le quarter horse est lent
                            // On prend aléatoirement un sexe pour le cheval
                            Sexe sexe = listeDesSexes.get(new Random().nextInt(listeDesSexes.size()));
                            switch (sexe) {
                                case MALE: // Si le quarter horse est un mâle
                                    // On ajoute un Quarter horse mâle et lent dans notre liste
                                    chevauxDeCourse.add(Ecurie.createChevalLent(new QuarterHorseFactory(GenererNomCheval.donneNomCheval(), compteurCheval, 0, coteDeBase, Sexe.MALE)));
                                    // On ajoute dans notre liste de thread le nouveau cheval
                                    listeThread.add(new Thread(chevauxDeCourse.get(i)));
                                    break;
                                case FEMALE: // Si le quarter horse est une femelle
                                    // On ajoute un Quarter horse femelle et lent dans notre liste
                                    chevauxDeCourse.add(Ecurie.createChevalLent(new QuarterHorseFactory(GenererNomCheval.donneNomCheval(), compteurCheval, 0, coteDeBase, Sexe.FEMALE)));
                                    // On ajoute dans notre liste de thread le nouveau cheval
                                    listeThread.add(new Thread(chevauxDeCourse.get(i)));
                                    break;
                            }
                            break;
                        case TRES_LENT: // Si le quarter horse est très lent
                            // On prend aléatoirement un sexe pour le cheval
                            sexe = listeDesSexes.get(new Random().nextInt(listeDesSexes.size()));
                            switch (sexe) {
                                case MALE: // Si le quarter horse est un mâle
                                    // On ajoute un Quarter horse mâle et très lent dans notre liste
                                    chevauxDeCourse.add(Ecurie.createChevalTresLent(new QuarterHorseFactory(GenererNomCheval.donneNomCheval(), compteurCheval, 0, coteDeBase, Sexe.MALE)));
                                    // On ajoute dans notre liste de thread le nouveau cheval
                                    listeThread.add(new Thread(chevauxDeCourse.get(i)));
                                    break;
                                case FEMALE: // Si le quarter horse est un mâle
                                    // On ajoute un Quarter horse femelle et très lent dans notre liste
                                    chevauxDeCourse.add(Ecurie.createChevalTresLent(new QuarterHorseFactory(GenererNomCheval.donneNomCheval(), compteurCheval, 0, coteDeBase, Sexe.FEMALE)));
                                    // On ajoute dans notre liste de thread le nouveau cheval
                                    listeThread.add(new Thread(chevauxDeCourse.get(i)));
                                    break;
                            }
                            break;
                        case MOYEN: // Si le quarter horse est moyennement rapide
                            // On prend aléatoirement un sexe pour le cheval
                            sexe = listeDesSexes.get(new Random().nextInt(listeDesSexes.size()));
                            switch (sexe) {
                                case MALE: // Si le quarter horse est un mâle
                                    // On ajoute un Quarter horse mâle et moyennement rapide dans notre liste
                                    chevauxDeCourse.add(Ecurie.createChevalMoyen(new QuarterHorseFactory(GenererNomCheval.donneNomCheval(), compteurCheval, 0, coteDeBase, Sexe.MALE)));
                                    // On ajoute dans notre liste de thread le nouveau cheval
                                    listeThread.add(new Thread(chevauxDeCourse.get(i)));
                                    break;
                                case FEMALE: // Si le quarter horse est une femelle
                                    // On ajoute un Quarter horse femelle et moyennement rapide dans notre liste
                                    chevauxDeCourse.add(Ecurie.createChevalMoyen(new QuarterHorseFactory(GenererNomCheval.donneNomCheval(), compteurCheval, 0, coteDeBase, Sexe.FEMALE)));
                                    // On ajoute dans notre liste de thread le nouveau cheval
                                    listeThread.add(new Thread(chevauxDeCourse.get(i)));
                                    break;
                            }
                            break;
                        case RAPIDE: // Si le quarter horse est rapide
                            // On prend aléatoirement un sexe pour le cheval
                            sexe = listeDesSexes.get(new Random().nextInt(listeDesSexes.size()));
                            switch (sexe) {
                                case MALE: // Si le quarter horse est un mâle
                                    // On ajoute un Quarter horse mâle et rapide dans notre liste
                                    chevauxDeCourse.add(Ecurie.createChevalRapide(new QuarterHorseFactory(GenererNomCheval.donneNomCheval(), compteurCheval, 0, coteDeBase, Sexe.MALE)));
                                    // On ajoute dans notre liste de thread le nouveau cheval
                                    listeThread.add(new Thread(chevauxDeCourse.get(i)));
                                    break;
                                case FEMALE: // Si le quarter horse est une femelle
                                    // On ajoute un Quarter horse femelle et rapide dans notre liste
                                    chevauxDeCourse.add(Ecurie.createChevalRapide(new QuarterHorseFactory(GenererNomCheval.donneNomCheval(), compteurCheval, 0, coteDeBase, Sexe.FEMALE)));
                                    // On ajoute dans notre liste de thread le nouveau cheval
                                    listeThread.add(new Thread(chevauxDeCourse.get(i)));
                                    break;
                            }
                            break;
                        case TRES_RAPIDE: // Si le quarter horse est très rapide
                            // On prend aléatoirement un sexe pour le cheval
                            sexe = listeDesSexes.get(new Random().nextInt(listeDesSexes.size()));
                            switch (sexe) {
                                case MALE: // Si le quarter horse est un mâle
                                    // On ajoute un Quarter horse mâle et très rapide dans notre liste
                                    chevauxDeCourse.add(Ecurie.createChevalTresRapide(new QuarterHorseFactory(GenererNomCheval.donneNomCheval(), compteurCheval, 0, coteDeBase, Sexe.MALE)));
                                    // On ajoute dans notre liste de thread le nouveau cheval
                                    listeThread.add(new Thread(chevauxDeCourse.get(i)));
                                    break;
                                case FEMALE: // Si le quarter horse est une femelle
                                    // On ajoute un Quarter horse femelle et très rapide dans notre liste
                                    chevauxDeCourse.add(Ecurie.createChevalTresRapide(new QuarterHorseFactory(GenererNomCheval.donneNomCheval(), compteurCheval, 0, coteDeBase, Sexe.FEMALE)));
                                    // On ajoute dans notre liste de thread le nouveau cheval
                                    listeThread.add(new Thread(chevauxDeCourse.get(i)));
                                    break;
                            }
                            break;
                    }
                    break;
            }
            // On incrémente le nombre de chevaux
            compteurCheval += 1;
        }

    }

    public static Map<Integer, AtomicInteger> getDictionnairePosition() {
        return dictionnairePosition;
    }

    public static void affichagePositions() {
        StringBuilder avancement = new StringBuilder();
        avancement.setLength(10);
        for (Integer integer : getDictionnairePosition().keySet()) {
            for (int i = 0; i < getDictionnairePosition().get(integer).get(); i += 1) {
                avancement.insert(i, '-');
            }
            for (int i = getDictionnairePosition().get(integer).get(); i < 10; i += 1) {
                avancement.insert(i, '#');
            }
            avancement.insert(10, '|');
            System.out.println("Cheval " + integer.toString() + " : " + avancement);
            avancement.setLength(0);
        }
    }

    public static List<Thread> getListeThread() {
        return listeThread;
    }

    public static AtomicBoolean getEnCours() {
        return enCours;
    }

    public List<Cheval> getChevauxDeCourse() {
        return chevauxDeCourse;
    }

    public List<Parieur> getParieursDeLaCourse() {
        return parieursDeLaCourse;
    }

    public Cheval trouveVainqueur() {
        for (Integer key : dictionnairePosition.keySet()) {
            if (dictionnairePosition.get(key).get() == 10){
                chevauxDeCourse.get(key - 1).setNombreVictoire(chevauxDeCourse.get(key - 1).getNombreVictoire() + 1);
                return chevauxDeCourse.get(key - 1);
            }
        }
        return null;
    }

    public void remettreChevalSurLigneDeDépart() {
        for (Integer cle : dictionnairePosition.keySet()) {
            dictionnairePosition.get(cle).set(0);
        }
    }

    public void lanceLesChevaux(int nombreDeCourse) {
        if (nombreDeCourse == 0) {
            for (Thread thread : listeThread) {
                thread.start();
            }
        } else {
            for (Thread thread : listeThread) {
                thread.resume();
            }
        }
    }
}
