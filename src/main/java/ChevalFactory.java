public interface ChevalFactory {
    // Méthode pour créer un cheval très lent
    Cheval createChevalTresLent();
    // Méthode pour créer un cheval lent
    Cheval createChevalLent();
    // Méthode pour créer un cheval moyennement rapide
    Cheval createChevalMoyen();
    // Méthode pour créer un cheval rapide
    Cheval createChevalRapide();
    // Méthode pour créer un cheval très rapide
    Cheval createChevalTresRapide();
}
