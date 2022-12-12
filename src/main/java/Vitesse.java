public enum Vitesse {
    TRES_LENT {
        @Override
        public double getCoefficient() {
            return 1.8;
        }
        @Override
        public String toString() {
            return "très lent";
        }
    }, LENT {
        @Override
        public double getCoefficient() {
            return 1.5;
        }
        @Override
        public String toString() {
            return "lent";
        }
    }, MOYEN {
        @Override
        public double getCoefficient() {
            return 1.0;
        }
        @Override
        public String toString() {
            return "moyennement rapide";
        }
    }, RAPIDE {
        @Override
        public double getCoefficient() {
            return 0.8;
        }
        @Override
        public String toString() {
            return "rapide";
        }
    }, TRES_RAPIDE {
        @Override
        public double getCoefficient() {
            return 0.5;
        }
        @Override
        public String toString() {
            return "très rapide";
        }
    };

    public abstract double getCoefficient();
    public abstract String toString();
}
