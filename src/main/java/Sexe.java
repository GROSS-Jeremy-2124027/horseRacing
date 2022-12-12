public enum Sexe {
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
