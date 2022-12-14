public enum Sexe {
    /**
     * Liste des deux sexes possibles (male female)
     */
    MALE {
        @Override
        public String toString() {
            return "male";
        }
    }, FEMALE {
        @Override
        public String toString() {
            return "femelle";
        }
    };

    public abstract String toString();
}
