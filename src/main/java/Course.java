import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Course extends Thread {
    private List<Cheval> chevauxDeCourse = new ArrayList<>();
    private List<String> typesDeChevaux = new ArrayList<>(List.of("Frisson", "Mustang", "PurSangArabe", "QuarterHorse"));
    private List<Vitesse> listeDeVitesses = new ArrayList<>(List.of(Vitesse.TRES_LENT, Vitesse.LENT, Vitesse.MOYEN, Vitesse.RAPIDE, Vitesse.TRES_RAPIDE));
    private List<Sexe> listeDesSexes = new ArrayList<>(List.of(Sexe.MALE, Sexe.FEMALE));

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


    public Course(int nombreChevaux, double coteDeBase) {
        int compteurCheval = 1;
        for (int i = 0; i < nombreChevaux; i += 1) {
            String typeCheval = typesDeChevaux.get(new Random().nextInt(typesDeChevaux.size() - 1));
            switch (typeCheval) {
                case "Frisson":
                    Vitesse vitesse = listeDeVitesses.get(new Random().nextInt(listeDeVitesses.size() - 1));
                    switch (vitesse) {
                        case LENT:
                            Sexe sexe = listeDesSexes.get(new Random().nextInt(listeDesSexes.size() - 1));
                            switch (sexe) {
                                case MALE:
                                    chevauxDeCourse.add(Ecurie.createChevalLent(new FrissonFactory(GenererNomCheval.donneNomCheval(), compteurCheval, 0, coteDeBase, Sexe.MALE)));
                                case FEMALE:
                                    chevauxDeCourse.add(Ecurie.createChevalLent(new FrissonFactory(GenererNomCheval.donneNomCheval(), compteurCheval, 0, coteDeBase, Sexe.FEMALE)));
                            }
                        case TRES_LENT:
                            sexe = listeDesSexes.get(new Random().nextInt(listeDesSexes.size() - 1));
                            switch (sexe) {
                                case MALE:
                                    chevauxDeCourse.add(Ecurie.createChevalTresLent(new FrissonFactory(GenererNomCheval.donneNomCheval(), compteurCheval, 0, coteDeBase, Sexe.MALE)));
                                case FEMALE:
                                    chevauxDeCourse.add(Ecurie.createChevalTresLent(new FrissonFactory(GenererNomCheval.donneNomCheval(), compteurCheval, 0, coteDeBase, Sexe.FEMALE)));
                            }
                        case MOYEN:
                            sexe = listeDesSexes.get(new Random().nextInt(listeDesSexes.size() - 1));
                            switch (sexe) {
                                case MALE:
                                    chevauxDeCourse.add(Ecurie.createChevalMoyen(new FrissonFactory(GenererNomCheval.donneNomCheval(), compteurCheval, 0, coteDeBase, Sexe.MALE)));
                                case FEMALE:
                                    chevauxDeCourse.add(Ecurie.createChevalMoyen(new FrissonFactory(GenererNomCheval.donneNomCheval(), compteurCheval, 0, coteDeBase, Sexe.FEMALE)));
                            }
                        case RAPIDE:
                            sexe = listeDesSexes.get(new Random().nextInt(listeDesSexes.size() - 1));
                            switch (sexe) {
                                case MALE:
                                    chevauxDeCourse.add(Ecurie.createChevalRapide(new FrissonFactory(GenererNomCheval.donneNomCheval(), compteurCheval, 0, coteDeBase, Sexe.MALE)));
                                case FEMALE:
                                    chevauxDeCourse.add(Ecurie.createChevalRapide(new FrissonFactory(GenererNomCheval.donneNomCheval(), compteurCheval, 0, coteDeBase, Sexe.FEMALE)));
                            }
                        case TRES_RAPIDE:
                            sexe = listeDesSexes.get(new Random().nextInt(listeDesSexes.size() - 1));
                            switch (sexe) {
                                case MALE:
                                    chevauxDeCourse.add(Ecurie.createChevalTresRapide(new FrissonFactory(GenererNomCheval.donneNomCheval(), compteurCheval, 0, coteDeBase, Sexe.MALE)));
                                case FEMALE:
                                    chevauxDeCourse.add(Ecurie.createChevalTresRapide(new FrissonFactory(GenererNomCheval.donneNomCheval(), compteurCheval, 0, coteDeBase, Sexe.FEMALE)));
                            }
                    }
            }
        }
    }

    public List<Cheval> getChevauxDeCourse() {
        return chevauxDeCourse;
    }

    public List<String> getTypesDeChevaux() {
        return typesDeChevaux;
    }

    public static void main(String[] args) {
        System.out.println("Combien voulez-vous de cheval dans la course (Entre 5 et 10 chevaux) : ");
        Scanner input = new Scanner(System.in);
        int nombreDeChevaux = input.nextInt();
        while (nombreDeChevaux < 5 || nombreDeChevaux > 10) {
            System.out.println("Combien voulez-vous de cheval dans la course (Entre 5 et 10 chevaux) : ");
            input = new Scanner(System.in);
            nombreDeChevaux = input.nextInt();
        }
        for (int i = 0; i < nombreDeChevaux; i += 1) {
            String prochainType = this.getTypesDeChevaux().get(new Random().nextInt(getTypesDeChevaux().size()));
        }
    }
}
