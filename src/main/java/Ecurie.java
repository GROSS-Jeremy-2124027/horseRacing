/**
 * Classe regroupant l'ensemble des méthodes statics permettant d'instancier un objet de la fabrique souhaitée
 */
public class Ecurie {
    /**
     * Méthode static permettant de retourner un cheval très lent en passant en paramètre la factory correspondant à la
     * race de cheval souhaité.
     * @param factory Factory correspondant à la factory de la race souhaitée.
     * @return Un cheval très lent de la race souhaitée.
     */
    public static Cheval createChevalTresLent(ChevalFactory factory) {
        return factory.createChevalTresLent();
    }

    /**
     * Méthode static permettant de retourner un cheval lent en passant en paramètre la factory correspondant à la
     * race de cheval souhaité.
     * @param factory Factory correspondant à la factory de la race souhaitée.
     * @return Un cheval lent de la race souhaitée.
     */
    public static Cheval createChevalLent(ChevalFactory factory) {
        return factory.createChevalLent();
    }

    /**
     * Méthode static permettant de retourner un cheval moyennement rapide en passant en paramètre la factory correspondant à la
     * race de cheval souhaité.
     * @param factory Factory correspondant à la factory de la race souhaitée.
     * @return Un cheval moyennement rapide de la race souhaitée.
     */
    public static Cheval createChevalMoyen(ChevalFactory factory) {
        return factory.createChevalMoyen();
    }

    /**
     * Méthode static permettant de retourner un cheval rapide en passant en paramètre la factory correspondant à la
     * race de cheval souhaité.
     * @param factory Factory correspondant à la factory de la race souhaitée.
     * @return Un cheval rapide de la race souhaitée.
     */
    public static Cheval createChevalRapide(ChevalFactory factory) {
        return factory.createChevalRapide();
    }

    /**
     * Méthode static permettant de retourner un cheval très rapide en passant en paramètre la factory correspondant à la
     * race de cheval souhaité.
     * @param factory Factory correspondant à la factory de la race souhaitée.
     * @return Un cheval très rapide de la race souhaitée.
     */
    public static Cheval createChevalTresRapide(ChevalFactory factory) {
        return factory.createChevalTresRapide();
    }
}
