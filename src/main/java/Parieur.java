public class Parieur {
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
}
