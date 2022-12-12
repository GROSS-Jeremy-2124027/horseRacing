import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class DispositifsDeLaCourse {
    private List<Cheval> chevauxDeCourse = new ArrayList<>();
    private List<String> typesDeChevaux = new ArrayList<>(List.of("Frisson", "Mustang", "PurSangArabe", "QuarterHorse"));
    private List<Vitesse> listeDeVitesses = new ArrayList<>(List.of(Vitesse.TRES_LENT, Vitesse.LENT, Vitesse.MOYEN, Vitesse.RAPIDE, Vitesse.TRES_RAPIDE));
    private List<Sexe> listeDesSexes = new ArrayList<>(List.of(Sexe.MALE, Sexe.FEMALE));

    private List<AtomicInteger> placesDesChevaux = new ArrayList<>();

    public DispositifsDeLaCourse(int nombreChevaux, double coteDeBase) {
        int compteurCheval = 1;
        for (int i = 0; i < nombreChevaux; i += 1) {
            placesDesChevaux.add(new AtomicInteger(0));
            String typeCheval = typesDeChevaux.get(new Random().nextInt(typesDeChevaux.size()));
            switch (typeCheval) {
                case "Frisson":
                    Vitesse vitesse = listeDeVitesses.get(new Random().nextInt(listeDeVitesses.size()));
                    switch (vitesse) {
                        case LENT:
                            Sexe sexe = listeDesSexes.get(new Random().nextInt(listeDesSexes.size()));
                            switch (sexe) {
                                case MALE:
                                    chevauxDeCourse.add(Ecurie.createChevalLent(new FrissonFactory(GenererNomCheval.donneNomCheval(), compteurCheval, 0, coteDeBase, Sexe.MALE)));
                                    break;
                                case FEMALE:
                                    chevauxDeCourse.add(Ecurie.createChevalLent(new FrissonFactory(GenererNomCheval.donneNomCheval(), compteurCheval, 0, coteDeBase, Sexe.FEMALE)));
                                    break;
                            }
                            break;
                        case TRES_LENT:
                            sexe = listeDesSexes.get(new Random().nextInt(listeDesSexes.size()));
                            switch (sexe) {
                                case MALE:
                                    chevauxDeCourse.add(Ecurie.createChevalTresLent(new FrissonFactory(GenererNomCheval.donneNomCheval(), compteurCheval, 0, coteDeBase, Sexe.MALE)));
                                    break;
                                case FEMALE:
                                    chevauxDeCourse.add(Ecurie.createChevalTresLent(new FrissonFactory(GenererNomCheval.donneNomCheval(), compteurCheval, 0, coteDeBase, Sexe.FEMALE)));
                                    break;
                            }
                            break;
                        case MOYEN:
                            sexe = listeDesSexes.get(new Random().nextInt(listeDesSexes.size()));
                            switch (sexe) {
                                case MALE:
                                    chevauxDeCourse.add(Ecurie.createChevalMoyen(new FrissonFactory(GenererNomCheval.donneNomCheval(), compteurCheval, 0, coteDeBase, Sexe.MALE)));
                                    break;
                                case FEMALE:
                                    chevauxDeCourse.add(Ecurie.createChevalMoyen(new FrissonFactory(GenererNomCheval.donneNomCheval(), compteurCheval, 0, coteDeBase, Sexe.FEMALE)));
                                    break;
                            }
                            break;
                        case RAPIDE:
                            sexe = listeDesSexes.get(new Random().nextInt(listeDesSexes.size()));
                            switch (sexe) {
                                case MALE:
                                    chevauxDeCourse.add(Ecurie.createChevalRapide(new FrissonFactory(GenererNomCheval.donneNomCheval(), compteurCheval, 0, coteDeBase, Sexe.MALE)));
                                    break;
                                case FEMALE:
                                    chevauxDeCourse.add(Ecurie.createChevalRapide(new FrissonFactory(GenererNomCheval.donneNomCheval(), compteurCheval, 0, coteDeBase, Sexe.FEMALE)));
                                    break;
                            }
                            break;
                        case TRES_RAPIDE:
                            sexe = listeDesSexes.get(new Random().nextInt(listeDesSexes.size()));
                            switch (sexe) {
                                case MALE:
                                    chevauxDeCourse.add(Ecurie.createChevalTresRapide(new FrissonFactory(GenererNomCheval.donneNomCheval(), compteurCheval, 0, coteDeBase, Sexe.MALE)));
                                    break;
                                case FEMALE:
                                    chevauxDeCourse.add(Ecurie.createChevalTresRapide(new FrissonFactory(GenererNomCheval.donneNomCheval(), compteurCheval, 0, coteDeBase, Sexe.FEMALE)));
                                    break;
                            }
                            break;
                    }
                    break;
                case "Mustang":
                    vitesse = listeDeVitesses.get(new Random().nextInt(listeDeVitesses.size()));
                    switch (vitesse) {
                        case LENT:
                            Sexe sexe = listeDesSexes.get(new Random().nextInt(listeDesSexes.size()));
                            switch (sexe) {
                                case MALE:
                                    chevauxDeCourse.add(Ecurie.createChevalLent(new MustangFactory(GenererNomCheval.donneNomCheval(), compteurCheval, 0, coteDeBase, Sexe.MALE)));
                                    break;
                                case FEMALE:
                                    chevauxDeCourse.add(Ecurie.createChevalLent(new MustangFactory(GenererNomCheval.donneNomCheval(), compteurCheval, 0, coteDeBase, Sexe.FEMALE)));
                                    break;
                            }
                            break;
                        case TRES_LENT:
                            sexe = listeDesSexes.get(new Random().nextInt(listeDesSexes.size()));
                            switch (sexe) {
                                case MALE:
                                    chevauxDeCourse.add(Ecurie.createChevalTresLent(new MustangFactory(GenererNomCheval.donneNomCheval(), compteurCheval, 0, coteDeBase, Sexe.MALE)));
                                    break;
                                case FEMALE:
                                    chevauxDeCourse.add(Ecurie.createChevalTresLent(new MustangFactory(GenererNomCheval.donneNomCheval(), compteurCheval, 0, coteDeBase, Sexe.FEMALE)));
                                    break;
                            }
                            break;
                        case MOYEN:
                            sexe = listeDesSexes.get(new Random().nextInt(listeDesSexes.size()));
                            switch (sexe) {
                                case MALE:
                                    chevauxDeCourse.add(Ecurie.createChevalMoyen(new MustangFactory(GenererNomCheval.donneNomCheval(), compteurCheval, 0, coteDeBase, Sexe.MALE)));
                                    break;
                                case FEMALE:
                                    chevauxDeCourse.add(Ecurie.createChevalMoyen(new MustangFactory(GenererNomCheval.donneNomCheval(), compteurCheval, 0, coteDeBase, Sexe.FEMALE)));
                                    break;
                            }
                            break;
                        case RAPIDE:
                            sexe = listeDesSexes.get(new Random().nextInt(listeDesSexes.size()));
                            switch (sexe) {
                                case MALE:
                                    chevauxDeCourse.add(Ecurie.createChevalRapide(new MustangFactory(GenererNomCheval.donneNomCheval(), compteurCheval, 0, coteDeBase, Sexe.MALE)));
                                    break;
                                case FEMALE:
                                    chevauxDeCourse.add(Ecurie.createChevalRapide(new MustangFactory(GenererNomCheval.donneNomCheval(), compteurCheval, 0, coteDeBase, Sexe.FEMALE)));
                                    break;
                            }
                            break;
                        case TRES_RAPIDE:
                            sexe = listeDesSexes.get(new Random().nextInt(listeDesSexes.size()));
                            switch (sexe) {
                                case MALE:
                                    chevauxDeCourse.add(Ecurie.createChevalTresRapide(new MustangFactory(GenererNomCheval.donneNomCheval(), compteurCheval, 0, coteDeBase, Sexe.MALE)));
                                    break;
                                case FEMALE:
                                    chevauxDeCourse.add(Ecurie.createChevalTresRapide(new MustangFactory(GenererNomCheval.donneNomCheval(), compteurCheval, 0, coteDeBase, Sexe.FEMALE)));
                                    break;
                            }
                            break;
                    }
                    break;
                case "PurSangArabe":
                    vitesse = listeDeVitesses.get(new Random().nextInt(listeDeVitesses.size()));
                    switch (vitesse) {
                        case LENT:
                            Sexe sexe = listeDesSexes.get(new Random().nextInt(listeDesSexes.size()));
                            switch (sexe) {
                                case MALE:
                                    chevauxDeCourse.add(Ecurie.createChevalLent(new PurSangArabeFactory(GenererNomCheval.donneNomCheval(), compteurCheval, 0, coteDeBase, Sexe.MALE)));
                                    break;
                                case FEMALE:
                                    chevauxDeCourse.add(Ecurie.createChevalLent(new PurSangArabeFactory(GenererNomCheval.donneNomCheval(), compteurCheval, 0, coteDeBase, Sexe.FEMALE)));
                                    break;
                            }
                            break;
                        case TRES_LENT:
                            sexe = listeDesSexes.get(new Random().nextInt(listeDesSexes.size()));
                            switch (sexe) {
                                case MALE:
                                    chevauxDeCourse.add(Ecurie.createChevalTresLent(new PurSangArabeFactory(GenererNomCheval.donneNomCheval(), compteurCheval, 0, coteDeBase, Sexe.MALE)));
                                    break;
                                case FEMALE:
                                    chevauxDeCourse.add(Ecurie.createChevalTresLent(new PurSangArabeFactory(GenererNomCheval.donneNomCheval(), compteurCheval, 0, coteDeBase, Sexe.FEMALE)));
                                    break;
                            }
                            break;
                        case MOYEN:
                            sexe = listeDesSexes.get(new Random().nextInt(listeDesSexes.size()));
                            switch (sexe) {
                                case MALE:
                                    chevauxDeCourse.add(Ecurie.createChevalMoyen(new PurSangArabeFactory(GenererNomCheval.donneNomCheval(), compteurCheval, 0, coteDeBase, Sexe.MALE)));
                                    break;
                                case FEMALE:
                                    chevauxDeCourse.add(Ecurie.createChevalMoyen(new PurSangArabeFactory(GenererNomCheval.donneNomCheval(), compteurCheval, 0, coteDeBase, Sexe.FEMALE)));
                                    break;
                            }
                            break;
                        case RAPIDE:
                            sexe = listeDesSexes.get(new Random().nextInt(listeDesSexes.size()));
                            switch (sexe) {
                                case MALE:
                                    chevauxDeCourse.add(Ecurie.createChevalRapide(new PurSangArabeFactory(GenererNomCheval.donneNomCheval(), compteurCheval, 0, coteDeBase, Sexe.MALE)));
                                    break;
                                case FEMALE:
                                    chevauxDeCourse.add(Ecurie.createChevalRapide(new PurSangArabeFactory(GenererNomCheval.donneNomCheval(), compteurCheval, 0, coteDeBase, Sexe.FEMALE)));
                                    break;
                            }
                            break;
                        case TRES_RAPIDE:
                            sexe = listeDesSexes.get(new Random().nextInt(listeDesSexes.size()));
                            switch (sexe) {
                                case MALE:
                                    chevauxDeCourse.add(Ecurie.createChevalTresRapide(new PurSangArabeFactory(GenererNomCheval.donneNomCheval(), compteurCheval, 0, coteDeBase, Sexe.MALE)));
                                    break;
                                case FEMALE:
                                    chevauxDeCourse.add(Ecurie.createChevalTresRapide(new PurSangArabeFactory(GenererNomCheval.donneNomCheval(), compteurCheval, 0, coteDeBase, Sexe.FEMALE)));
                                    break;
                            }
                            break;
                    }
                    break;
                case "QuarterHorse"   :
                    vitesse = listeDeVitesses.get(new Random().nextInt(listeDeVitesses.size()));
                    switch (vitesse) {
                        case LENT:
                            Sexe sexe = listeDesSexes.get(new Random().nextInt(listeDesSexes.size()));
                            switch (sexe) {
                                case MALE:
                                    chevauxDeCourse.add(Ecurie.createChevalLent(new QuarterHorseFactory(GenererNomCheval.donneNomCheval(), compteurCheval, 0, coteDeBase, Sexe.MALE)));
                                    break;
                                case FEMALE:
                                    chevauxDeCourse.add(Ecurie.createChevalLent(new QuarterHorseFactory(GenererNomCheval.donneNomCheval(), compteurCheval, 0, coteDeBase, Sexe.FEMALE)));
                                    break;
                            }
                            break;
                        case TRES_LENT:
                            sexe = listeDesSexes.get(new Random().nextInt(listeDesSexes.size()));
                            switch (sexe) {
                                case MALE:
                                    chevauxDeCourse.add(Ecurie.createChevalTresLent(new QuarterHorseFactory(GenererNomCheval.donneNomCheval(), compteurCheval, 0, coteDeBase, Sexe.MALE)));
                                    break;
                                case FEMALE:
                                    chevauxDeCourse.add(Ecurie.createChevalTresLent(new QuarterHorseFactory(GenererNomCheval.donneNomCheval(), compteurCheval, 0, coteDeBase, Sexe.FEMALE)));
                                    break;
                            }
                            break;
                        case MOYEN:
                            sexe = listeDesSexes.get(new Random().nextInt(listeDesSexes.size()));
                            switch (sexe) {
                                case MALE:
                                    chevauxDeCourse.add(Ecurie.createChevalMoyen(new QuarterHorseFactory(GenererNomCheval.donneNomCheval(), compteurCheval, 0, coteDeBase, Sexe.MALE)));
                                    break;
                                case FEMALE:
                                    chevauxDeCourse.add(Ecurie.createChevalMoyen(new QuarterHorseFactory(GenererNomCheval.donneNomCheval(), compteurCheval, 0, coteDeBase, Sexe.FEMALE)));
                                    break;
                            }
                            break;
                        case RAPIDE:
                            sexe = listeDesSexes.get(new Random().nextInt(listeDesSexes.size()));
                            switch (sexe) {
                                case MALE:
                                    chevauxDeCourse.add(Ecurie.createChevalRapide(new QuarterHorseFactory(GenererNomCheval.donneNomCheval(), compteurCheval, 0, coteDeBase, Sexe.MALE)));
                                    break;
                                case FEMALE:
                                    chevauxDeCourse.add(Ecurie.createChevalRapide(new QuarterHorseFactory(GenererNomCheval.donneNomCheval(), compteurCheval, 0, coteDeBase, Sexe.FEMALE)));
                                    break;
                            }
                            break;
                        case TRES_RAPIDE:
                            sexe = listeDesSexes.get(new Random().nextInt(listeDesSexes.size()));
                            switch (sexe) {
                                case MALE:
                                    chevauxDeCourse.add(Ecurie.createChevalTresRapide(new QuarterHorseFactory(GenererNomCheval.donneNomCheval(), compteurCheval, 0, coteDeBase, Sexe.MALE)));
                                    break;
                                case FEMALE:
                                    chevauxDeCourse.add(Ecurie.createChevalTresRapide(new QuarterHorseFactory(GenererNomCheval.donneNomCheval(), compteurCheval, 0, coteDeBase, Sexe.FEMALE)));
                                    break;
                            }
                            break;
                    }
                    break;
            }
            compteurCheval += 1;
        }

    }

    public List<Cheval> getChevauxDeCourse() {
        return chevauxDeCourse;
    }
}
