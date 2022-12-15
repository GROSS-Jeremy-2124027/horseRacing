/**
 * Classe abstraite implémentant l'interface Runnable pour faire en sorte que chaque cheval crée soit exécutable sur un thread.
 */
public abstract class Cheval implements Runnable{
    /**
     * Attribut correspondant au nom attribué au cheval.
     */
    protected String nomCheval;
    /**
     * Attribut correspondant au numéro du cheval.
     */
    protected int numeroCheval;
    /**
     * Attribut correspondant au nombre de victoires du cheval.
     */
    protected int nombreVictoires;
    /**
     * Attribut correspondant à la côte attribuée au cheval.
     */
    protected double coteCheval;
    /**
     * Attribut correspondant au sexe attribué au cheval.
     */
    protected Sexe sexeCheval;
    /**
     * Attribut correspondant à la vitesse attribuée au cheval.
     */
    protected Vitesse vitesse;


    /**
     * Méthode permettant d'afficher les attributs correspondants au cheval qui appelle cette méthode.
     * @return Une chaine de caractères contenant les attributs d'un cheval.
     */
    @Override
    public String toString() {
        return "Cheval{" +
                "nomCheval='" + nomCheval + '\'' +
                ", numeroCheval=" + numeroCheval +
                ", nombreVictoire=" + nombreVictoires +
                ", coteCheval=" + coteCheval +
                ", sexeCheval=" + sexeCheval +
                ", vitesse=" + vitesse +
                '}';
    }

    /**
     * Méthode abstraite permettant d'obtenir la race du cheval appelant cette méthode.
     * @return La race du cheval.
     */
    public abstract String getRace();

    /**
     * Getter permettant d'accéder à l'attribut nomCheval du cheval.
     * @return Le nom du cheval.
     */
    public String getNomCheval() {
        return nomCheval;
    }

    /**
     * Getter permettant d'accéder à l'attribut numeroCheval du cheval.
     * @return Le numéro du cheval.
     */
    public int getNumeroCheval() {
        return numeroCheval;
    }

    /**
     * Getter permettant d'accéder à l'attribut nombreVictoires du cheval.
     * @return Le nombre de victoires du cheval.
     */
    public int getNombreVictoires() {
        return nombreVictoires;
    }

    /**
     * Getter permettant d'accéder à l'attribut coteCheval du cheval.
     * @return La cote du cheval.
     */
    public double getCoteCheval() {
        return coteCheval;
    }

    /**
     * Getter permettant d'accéder à l'attribut sexeCheval du cheval.
     * @return Le sexe du cheval.
     */
    public Sexe getSexeCheval() {
        return sexeCheval;
    }

    /**
     * Getter permettant d'accéder à l'attribut vitesse du cheval.
     * @return La vitesse du cheval.
     */
    public Vitesse getVitesse() {
        return vitesse;
    }

    /**
     * Setter permettant de changer le nombre de victoires d'un cheval.
     * @param nombreVictoires Le nouveau nombre de victoires du cheval.
     */
    public void setNombreVictoires(int nombreVictoires) {
        this.nombreVictoires = nombreVictoires;
    }

}
