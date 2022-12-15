import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Classe regroupant les différents attributs et méthodes nécessaires au bon fonctionnement de la course.
 */
public class DispositifsDeLaCourse {
    /**
     * Attribut correspondant à une liste comportant tous les chevaux participants à la course.
     */
    private List<Cheval> chevauxDeCourse = new ArrayList<>();
    /**
     * Attribut correspondant à une liste comportant toutes les races que les chevaux peuvent avoir.
     */
    private List<String> typesDeChevaux = new ArrayList<>(List.of("Frisson", "Mustang", "PurSangArabe", "QuarterHorse"));
    /**
     * Attribut correspondant à une liste comportant toutes les vitesses que peuvent prendre les chevaux.
     */
    private List<Vitesse> listeDeVitesses = new ArrayList<>(List.of(Vitesse.TRES_LENT, Vitesse.LENT, Vitesse.MOYEN, Vitesse.RAPIDE, Vitesse.TRES_RAPIDE));
    /**
     * Attribut correspondant à une liste comportant aux sexes que peut prendre les chevaux.
     */
    private List<Sexe> listeDesSexes = new ArrayList<>(List.of(Sexe.MALE, Sexe.FEMALE));
    /**
     * Attribut correspondant à un dictionnaire regroupant en clé le numéro du cheval faisant la course et en valeur un
     * entier atomic correspondant à sa position actuelle dans la course.
     */
    private static Map<Integer, AtomicInteger> dictionnairePosition = new HashMap<>();
    /**
     * Attribut static correspondant à une liste comportant tous les threads comportant un cheval pour la course.
     */
    private static List<Thread> listeThread = new ArrayList<>();
    /**
     * Attribut static correspondant à une valeur booléenne atomic qui permet de savoir si la course est en cours ou non (true --> en course, false --> fini).
     */
    private static AtomicBoolean enCours = new AtomicBoolean(true);
    /**
     * Attribut static correspondant à une liste comportant tous les parieurs de la course.
     */
    private static List<Parieur> parieursDeLaCourse = new ArrayList<>();

    /**
     * Constructeur de la classe permettant de créer la course en indiquant le nombre de chevaux et la cote de base pour cette dernière.
     * Chaque cheval crée est créé avec une race, une vitesse et un sexe aléatoire.
     * @param nombreChevaux Entier correspondant au nombre de chevaux participant à la course.
     * @param coteDeBase Double correspondant à la côte de base de la course.
     */
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

    /**
     * Getter permettant d'accéder au dictionnaire de positions static de la classe.
     * @return Le dictionnaire de positions
     */
    public static Map<Integer, AtomicInteger> getDictionnairePosition() {
        return dictionnairePosition;
    }

    /**
     * Méthode permettant d'afficer l'état actuel de la course à l'aide d'un StringBuilder s'adaptant en fonction de la position
     * du cheval dans la course.
     */
    public static void affichagePositions() {
        // Création du StringBuilder et on initie sa taille à 10
        StringBuilder avancement = new StringBuilder();
        // On parcourt les clés du dictionnaire
        for (Integer integer : getDictionnairePosition().keySet()) {
            // On fait une boucle partant de 0 jusqu'à la valeur de la clé
            for (int i = 0; i < getDictionnairePosition().get(integer).get(); i += 1) {
                // On insère un trait pour faire comprendre que le cheval avance
                avancement.append('-');
            }
            // On fait une boucle partant de la valeur de la clé jusqu'à la valeur maximale qui est dix
            for (int i = getDictionnairePosition().get(integer).get(); i < 10; i += 1) {
                // On insère un hashtag pour faire comprendre qu'il reste des étapes avant la fin de la course
                avancement.append('#');
            }
            // On insère un trait vertical pour simuler la ligne d'arrivée
            avancement.append('|');
            System.out.println("Cheval " + integer.toString() + " : " + avancement);
            avancement.setLength(0);
        }
    }

    /**
     * Getter permettant d'accéder à la liste static regroupant les threads de la course.
     * @return La liste comportant les threads de la course.
     */
    public static List<Thread> getListeThread() {
        return listeThread;
    }

    /**
     * Getter permettant d'accéder à l'attribut booléen atomic et static de la course.
     * @return L'attribut booléen atomic et static de la course.
     */
    public static AtomicBoolean getEnCours() {
        return enCours;
    }

    /**
     * Getter permettant d'accéder à la liste regroupant les chevaux participant à la course.
     * @return La liste comportant les chevaux de la course.
     */
    public List<Cheval> getChevauxDeCourse() {
        return chevauxDeCourse;
    }

    /**
     * Getter permettant d'accéder à la liste des parieurs participant à la course.
     * @return La liste regroupant les parieurs pariant sur la course.
     */
    public List<Parieur> getParieursDeLaCourse() {
        return parieursDeLaCourse;
    }

    /**
     * Méthode permettant de retrouver le cheval ayant remporté la course. Elle incrémente également de un le nombre de victoires de ce même cheval
     * @return Le cheval vainqueur de la course.
     */
    public Cheval trouveVainqueur() {
        // On parcourt les clés du dictionnaire
        for (Integer key : dictionnairePosition.keySet()) {
            // Si la valeur est égale à 10
            if (dictionnairePosition.get(key).get() == 10) {
                // On incrémente le nombre de victoires avant de retourner le cheval
                chevauxDeCourse.get(key - 1).setNombreVictoires(chevauxDeCourse.get(key - 1).getNombreVictoires() + 1);
                return chevauxDeCourse.get(key - 1);
            }
        }
        return null;
    }

    /**
     * Méthode permettant de remettre à zéro toutes les valeurs du dicitonnaire regroupant les positions des chevaux.
     */
    public void remettreChevalSurLigneDeDépart() {
        // On parcourt les clés du dictionnaire de positions
        for (Integer cle : dictionnairePosition.keySet()) {
            // On met à zéro chaque valeur
            dictionnairePosition.get(cle).set(0);
        }
    }

    public boolean verificationVictoireParieur() {
        if (getParieursDeLaCourse().size() == 1) {
            return true;
        }
        return false;
    }

    public void afficherResultatCourse() {
        // Algorithme de tri
        List<Integer> listeResultat = new ArrayList<>();
        List<Integer> listeNumeroChevaux = new ArrayList<>();
        for (int i = 0; i < chevauxDeCourse.size(); i += 1) {
            listeNumeroChevaux.add(i + 1);
            listeResultat.add(dictionnairePosition.get(i + 1).get());
        }
        for (int i = 0; i < listeResultat.size() - 1; i += 1) {
            for (int j = i + 1; j < listeResultat.size(); j += 1) {
                if (listeResultat.get(i) < listeResultat.get(j)) {
                    int tempResultat = listeResultat.get(i);
                    int tempNumero = listeNumeroChevaux.get(i);

                    listeResultat.set(i, listeResultat.get(j));
                    listeNumeroChevaux.set(i, listeNumeroChevaux.get(j));

                    listeResultat.set(j, tempResultat);
                    listeNumeroChevaux.set(j, tempNumero);
                }
            }
        }
        for (int i = 0; i < listeNumeroChevaux.size(); i += 1) {
            if (i == 0) {
                System.out.println("Le cheval numéro " + listeNumeroChevaux.get(i) + " finit à la " + (i + 1) + "er place.");
            } else {
                System.out.println("Le cheval numéro " + listeNumeroChevaux.get(i) + " finit à la " + (i + 1) + "ème place.");
            }
        }
    }

    /**
     * Méthode qui permet de commencer ou de reprendre la course en fonction du nombre de courses effectuées qui sera passé en
     * paramètre.
     * @param nombreDeCourse Entier correspondant au nombre de courses effectuées pour l'instant.
     */
    public void lanceLesChevaux(int nombreDeCourse) {
        // Si c'est la première course
        if (nombreDeCourse == 0) {
            for (Thread thread : listeThread) {
                // On commence les threads.
                thread.start();
            }
        } else { // Si ce n'est pas la première course
            for (Thread thread : listeThread) {
                // On redémarre les threads
                thread.resume();
            }
        }
    }
}
