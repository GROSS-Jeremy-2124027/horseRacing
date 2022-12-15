/**
 * Classe implémentant l'interface ChevalFactory permettant de créer des objets Mustang en fonction de la vitesse souhaitée.
 */
public class MustangFactory implements ChevalFactory{
    /**
     * Attribut correspondant au nom attribué au cheval.
     */
    private String nomCheval;
    /**
     * Attribut correspondant au numéro du cheval.
     */
    private int numeroCheval;
    /**
     * Attribut correspondant au nombre de victoires du cheval.
     */
    private int nombreVictoires;
    /**
     * Attribut correspondant à la côte attribuée au cheval.
     */
    private double coteCheval;
    /**
     * Attribut correspondant au sexe attribué au cheval.
     */
    private Sexe sexeCheval;

    /**
     * Constructeur de la classe MustangFactory qui permet de créer une instance de cette classe. Elle ne prend pas
     * en paramètre l'attribut vitesseCheval, ce dernier sera attribué lors de l'appel d'une méthode de notre factory.
     * @param nomCheval Chaine de caractères correspondante au nom attribué au cheval.
     * @param numeroCheval Entier correspondant au numéro attribué au cheval.
     * @param nombreVictoires Entier correspondant au nombre de victoires du cheval.
     * @param coteCheval Double correspondant à la côte de base.
     * @param sexeCheval Enum correspondant au sexe attribué au cheval.
     */
    public MustangFactory(String nomCheval, int numeroCheval, int nombreVictoires, double coteCheval, Sexe sexeCheval) {
        this.nomCheval = nomCheval;
        this.numeroCheval = numeroCheval;
        this.nombreVictoires = nombreVictoires;
        this.coteCheval = coteCheval;
        this.sexeCheval = sexeCheval;
    }

    /**
     * Méthode de l'interface ChevalFactory qui permet d'instancier un objet de la classe Mustang avec une vitesse
     * catégorisée comme étant très lente.
     * @return Un cheval Mustang très lent.
     */
    @Override
    public Cheval createChevalTresLent() {
        return new Mustang(nomCheval, numeroCheval, nombreVictoires, coteCheval, sexeCheval, Vitesse.TRES_LENT);
    }

    /**
     * Méthode de l'interface ChevalFactory qui permet d'instancier un objet de la classe Mustang avec une vitesse
     * catégorisée comme étant très lente.
     * @return Un cheval Mustang lent.
     */
    @Override
    public Cheval createChevalLent() {
        return new Mustang(nomCheval, numeroCheval, nombreVictoires, coteCheval, sexeCheval, Vitesse.LENT);
    }

    /**
     * Méthode de l'interface ChevalFactory qui permet d'instancier un objet de la classe Mustang avec une vitesse
     * catégorisée comme étant moyennement rapide.
     * @return Un cheval Mustang moyennement rapide.
     */
    @Override
    public Cheval createChevalMoyen() {
        return new Mustang(nomCheval, numeroCheval, nombreVictoires, coteCheval, sexeCheval, Vitesse.MOYEN);
    }

    /**
     * Méthode de l'interface ChevalFactory qui permet d'instancier un objet de la classe Mustang avec une vitesse
     * catégorisée comme étant très lente.
     * @return Un cheval Mustang rapide.
     */
    @Override
    public Cheval createChevalRapide() {
        return new Mustang(nomCheval, numeroCheval, nombreVictoires, coteCheval, sexeCheval, Vitesse.RAPIDE);
    }

    /**
     * Méthode de l'interface ChevalFactory qui permet d'instancier un objet de la classe Mustang avec une vitesse
     * catégorisée comme étant très lente.
     * @return Un cheval Mustang très rapide.
     */
    @Override
    public Cheval createChevalTresRapide() {
        return new Mustang(nomCheval, numeroCheval, nombreVictoires, coteCheval, sexeCheval, Vitesse.TRES_RAPIDE);
    }
}
