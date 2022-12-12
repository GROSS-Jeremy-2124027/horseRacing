public class Ecurie {
    // Méthode static pour créer un cheval très lent
    public static Cheval createChevalTresLent(ChevalFactory factory) {
        return factory.createChevalTresLent();
    }

    // Méthode static pour créer un cheval lent
    public static Cheval createChevalLent(ChevalFactory factory) {
        return factory.createChevalLent();
    }

    // Méthode static pour créer un cheval moyennement rapide
    public static Cheval createChevalMoyen(ChevalFactory factory) {
        return factory.createChevalMoyen();
    }

    // Méthode static pour créer un cheval rapide
    public static Cheval createChevalRapide(ChevalFactory factory) {
        return factory.createChevalRapide();
    }

    // Méthode static pour créer un cheval très rapide
    public static Cheval createChevalTresRapide(ChevalFactory factory) {
        return factory.createChevalTresRapide();
    }
}
