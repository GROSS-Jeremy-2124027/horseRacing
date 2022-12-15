/**
 * Classe permettant aux différents utilisateurs de pouvoir parier sur la course.
 */
public class Parieur {
    /**
     * Attribut correspondant à la cagnotte du parieur.
     */
    private double cagnotte;
    /**
     * Attribut correspondant au nombre de paris gagnant du parieur.
     */
    private int nombreVictoires;
    /**
     * Attribut correspondant au nom du parieur.
     */
    private String nomParieur;
    /**
     * Attribut correspondant au numéro du cheval sur lequel le parieur va parier sa cagnotte pendant la course.
     */
    private int numeroDuChevalSurLequelParier;

    /**
     * Constructeur de la classe Parieur permettant de créer un nouveau parieur en rentrant comme paramètre le nom du nouveau
     * parieur. La cagnotte de chaque parieur est de base initialisée à 50 et son nombre de paris gagnant à 0.
     * @param nomParieur Chaine de caractères correspondant au nom du parieur.
     */
    public Parieur(String nomParieur) {
        this.cagnotte = 50;
        this.nombreVictoires = 0;
        this.nomParieur = nomParieur;
    }

    /**
     * Getter permettant d'accéder à l'attribut correspondant au nombre de paris gagnant.
     * @return Nombre de paris gagnant.
     */
    public int getNombreVictoires() {
        return nombreVictoires;
    }

    /**
     * Getter permettant d'accéder à l'attribut correspondant au nom du parieur.
     * @return Le nom du parieur.
     */
    public String getNomParieur() {
        return nomParieur;
    }

    /**
     * Setter permettant de changer le numéro du cheval sur lequel l'utilisateur parie.
     * @param numeroDuChevalSurLequelParier Entier correspondant au numéro du cheval sur lequel l'utilisateur parie.
     */
    public void setNumeroDuChevalSurLequelParier(int numeroDuChevalSurLequelParier) {
        this.numeroDuChevalSurLequelParier = numeroDuChevalSurLequelParier;
    }

    /**
     * Getter permettant d'accéder à l'attribut correspondant au numéro du cheval sur lequel l'utilisateur parie.
     * @return
     */
    public int getNumeroDuChevalSurLequelParier() {
        return numeroDuChevalSurLequelParier;
    }

    /**
     * Getter permettant d'accéder à l'attribut correspondant à la cagnotte du parieur.
     * @return La cagnotte du parieur.
     */
    public double getCagnotte() {
        return cagnotte;
    }

    /**
     * Setter permettant de changer la cagnotte du parieur.
     * @param cagnotte Double correspondant au nouveau montant de sa cagnotte.
     */
    public void setCagnotte(double cagnotte) {
        this.cagnotte = cagnotte;
    }

    /**
     * Méthode permettant d'afficher les différents attributs d'un objet Parieur.
     * @return Une chaine de caractères regroupant les attributs d'un objet Parieur.
     */
    @Override
    public String toString() {
        return "Parieur{" +
                "cagnotte=" + cagnotte +
                ", nombreVictoire=" + nombreVictoires +
                ", nomParieur='" + nomParieur + '\'' +
                ", numeroDuChevalSurLequelParier=" + numeroDuChevalSurLequelParier +
                '}';
    }

    /**
     * Setter permettant de changer le nombre de victoires d'un parieur.
     * @param nombreVictoires Entier correspondant au nouveau nombre de victoires d'un parieur.
     */
    public void setNombreVictoires(int nombreVictoires) {
        this.nombreVictoires = nombreVictoires;
    }
}
