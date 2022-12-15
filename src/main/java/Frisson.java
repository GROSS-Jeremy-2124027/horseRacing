import java.util.Random;

/**
 * Classe héritant de la classe abstraite Cheval permettant de créer un cheval état un Frisson
 */
public class Frisson extends Cheval {
    /**
     * Constructeur de la classe permettant de créer un nouveau Cheval catégorisé comme étant un Frisson.
     * @param nomCheval Chaine de caractères correspondante au nom attribué au cheval.
     * @param numeroCheval Entier correspondant au numéro attribué au cheval.
     * @param nombreVictoire Entier correspondant au nombre de victoires du cheval.
     * @param coteCheval Double correspondant à la côte de base. Elle sera modifiée pour s'adapter en fonction de la vitesse
     *                   du cheval.
     * @param sexeCheval Enum correspondant au sexe attribué au cheval.
     * @param vitesseCheval Enum correspondant à la vitesse attribué au cheval.
     */
    public Frisson(String nomCheval, int numeroCheval, int nombreVictoire, double coteCheval, Sexe sexeCheval, Vitesse vitesseCheval) {
        this.nomCheval = nomCheval;
        this.numeroCheval = numeroCheval;
        this.nombreVictoires = nombreVictoire;
        this.coteCheval = calculCote(coteCheval, vitesseCheval.getCoefficient());
        this.sexeCheval = sexeCheval;
        this.vitesse = vitesseCheval;
    }

    /**
     * Getter permettant de récupérer la race du cheval.
     * @return La race du cheval sous forme d'une chaine de caractères.
     */
    @Override
    public String getRace() {
        return "Frisson";
    }

    /**
     * Méthode permettant de modifier la cote en fonction de sa vitesse du cheval lors de sa création.
     * @param coteCheval Double correspondant à la côte de base.
     * @param coefficient Double correspondant au coefficient de la vitesse du cheval.
     * @return La nouvelle côte du cheval.
     */
    public double calculCote(double coteCheval, double coefficient){
        return coteCheval * coefficient;
    }

    /**
     * Méthode implémentée de l'interface Runnable permettant de faire la course une fois le cheval mit sur son propre thread.
     * Le thread va s'endormir pour une durée indéterminée et influencée par le coefficient de la vitesse du cheval avant
     * d'incrémenter l'entier atomic dans le dictionnaire à la clé correspondante au numéro du cheval faisant la course.
     */
    @Override
    public void run() {
        try {
            while (true) {
                // On endort le thread pour une durée indéterminée
                Thread.sleep((long) Math.abs(1000 + (new Random().nextInt(1000) * getVitesse().getCoefficient())));
                // On incrémente l'entier atomic dans le dictionnaire des positions avant d'afficher la totalité de la course
                DispositifsDeLaCourse.getDictionnairePosition().get(numeroCheval).incrementAndGet();
                DispositifsDeLaCourse.affichagePositions();
                System.out.println();
                // Si l'entier atomic est égale à dix
                if (DispositifsDeLaCourse.getDictionnairePosition().get(numeroCheval).get() == 10) {
                    // On passe le boolean atomic à faux pour arrêter tous les threads dans le main.
                    DispositifsDeLaCourse.getEnCours().set(false);
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
