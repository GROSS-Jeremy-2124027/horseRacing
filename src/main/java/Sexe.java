/**
 * Classe Enum qui contient les différents sexes qui peuvent être attribués à un cheval.
 */
public enum Sexe {
    /**
     * Jeton correspond au sexe du cheval comme étant de sexe masculin.
     */
    MALE {
        @Override
        public String toString() {
            return "male";
        }
    },
    /**
     * Jeton correspond au sexe du cheval comme étant de sexe féminin.
     */
    FEMALE {
        @Override
        public String toString() {
            return "femelle";
        }
    };

    /**
     * Méthode abstraite qui renvoie une chaine de caractères correspond au token qui l'utilise.
     * @return La chaine de caractère pour le sexe.
     */
    public abstract String toString();
}
