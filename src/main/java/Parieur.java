public class Parieur {
    /**
     * Classe définissant le parieur
     */
    private double cagnotte;
    private int nombreVictoire;
    private String nomParieur;

    private int numeroDuChevalSurLequelParier;

    public Parieur(String nomParieur) {
        this.cagnotte = 100;
        this.nombreVictoire = 0;
        this.nomParieur = nomParieur;
    }

    public int getNombreVictoire() {
        return nombreVictoire;
    }

    public String getNomParieur() {
        return nomParieur;
    }

    public void setNumeroDuChevalSurLequelParier(int numeroDuChevalSurLequelParier) {
        this.numeroDuChevalSurLequelParier = numeroDuChevalSurLequelParier;
    }

    public int getNumeroDuChevalSurLequelParier() {
        return numeroDuChevalSurLequelParier;
    }

    public double getCagnotte() {
        return cagnotte;
    }

    public void setCagnotte(double cagnotte) {
        this.cagnotte = cagnotte;
    }

    public void setNombreVictoire(int nombreVictoire) {
        this.nombreVictoire = nombreVictoire;
    }

    @Override
    public String toString() {
        return "Parieur{" +
                "cagnotte=" + cagnotte +
                ", nombreVictoire=" + nombreVictoire +
                ", nomParieur='" + nomParieur + '\'' +
                ", numeroDuChevalSurLequelParier=" + numeroDuChevalSurLequelParier +
                '}';
    }
}
