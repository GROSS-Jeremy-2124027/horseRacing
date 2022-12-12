public class Ecurie {
    public static Cheval createChevalTresLent(ChevalFactory factory) {
        return factory.createChevalTresLent();
    }
    public static Cheval createChevalLent(ChevalFactory factory) {
        return factory.createChevalLent();
    }
    public static Cheval createChevalMoyen(ChevalFactory factory) {
        return factory.createChevalMoyen();
    }
    public static Cheval createChevalRapide(ChevalFactory factory) {
        return factory.createChevalRapide();
    }
    public static Cheval createChevalTresRapide(ChevalFactory factory) {
        return factory.createChevalTresRapide();
    }
}
