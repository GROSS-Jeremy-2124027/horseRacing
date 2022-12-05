public enum Vitesse {
    TRES_LENT {
        @Override
        public double getCoefficient() {
            return 1.8;
        }
    }, LENT {
        @Override
        public double getCoefficient() {
            return 1.5;
        }
    }, MOYEN {
        @Override
        public double getCoefficient() {
            return 1.0;
        }
    }, RAPIDE {
        @Override
        public double getCoefficient() {
            return 0.8;
        }
    }, TRES_RAPIDE {
        @Override
        public double getCoefficient() {
            return 0.5;
        }
    };

    abstract double getCoefficient();
}
