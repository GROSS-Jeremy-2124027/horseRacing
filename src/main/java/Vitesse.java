/**
 * Classe Enum qui contient les différentes vitesses qui peuvent être attribuées à un cheval.
 */
public enum Vitesse {
    /**
     * Token qui correspond à un cheval très lent.
     */
    TRES_LENT {
        @Override
        public double getCoefficient() {
            return 1.8;
        }
        @Override
        public String toString() {
            return "très lent";
        }
    },
    /**
     * Token qui correspond à un cheval lent
     */
    LENT {
        @Override
        public double getCoefficient() {
            return 1.5;
        }
        @Override
        public String toString() {
            return "lent";
        }
    },
    /**
     * Token qui correspond à un cheval moyennement rapide
     */
    MOYEN {
        @Override
        public double getCoefficient() {
            return 1.0;
        }
        @Override
        public String toString() {
            return "moyennement rapide";
        }
    },
    /**
     * Token qui correspond à un cheval rapide
     */
    RAPIDE {
        @Override
        public double getCoefficient() {
            return 0.8;
        }
        @Override
        public String toString() {
            return "rapide";
        }
    },
    /**
     * Token qui correspond à un cheval très rapide
     */
    TRES_RAPIDE {
        @Override
        public double getCoefficient() {
            return 0.5;
        }
        @Override
        public String toString() {
            return "très rapide";
        }
    };

    /**
     * Méthode abstraite qui retourne pour chaque vitesse un coefficient correspondant à cette dernière.
     * @return Le coefficient de la vitesse.
     */
    public abstract double getCoefficient();

    /**
     * Méthode abstraite qui retourne pour chaque vitesse une chaine de caractères correspondant au token qui l'utilise.
     * @return La chaine de caractère pour la vitesse.
     */
    public abstract String toString();
}
