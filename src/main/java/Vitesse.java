public enum Vitesse {
    TRES_LENT {
        @Override
        public double getCoefficient() {
            return
        }
    }, LENT, MOYEN, RAPIDE, TRES_RAPIDE;

    abstract double getCoefficient();
}
