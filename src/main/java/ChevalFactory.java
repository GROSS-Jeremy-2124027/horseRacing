/**
 * Interface regroupant les différentes méthodes qui vont être utilisées dans les fabriques.
 */
public interface ChevalFactory {
    /**
     * Méthode permettant de créer un cheval très lent d'une race qui sera spécifiée par la suite.
     * @return Un cheval très lent.
     */
    Cheval createChevalTresLent();
    /**
     * Méthode permettant de créer un cheval lent d'une race qui sera spécifiée par la suite.
     * @return Un cheval lent.
     */
    Cheval createChevalLent();
    /**
     * Méthode permettant de créer un cheval moyennement rapide d'une race qui sera spécifiée par la suite.
     * @return Un cheval moyennement rapide.
     */
    Cheval createChevalMoyen();
    /**
     * Méthode permettant de créer un cheval rapide d'une race qui sera spécifiée par la suite.
     * @return Un cheval rapide.
     */
    Cheval createChevalRapide();
    /**
     * Méthode permettant de créer un cheval très rapide d'une race qui sera spécifiée par la suite.
     * @return Un cheval très rapide.
     */
    Cheval createChevalTresRapide();
}
