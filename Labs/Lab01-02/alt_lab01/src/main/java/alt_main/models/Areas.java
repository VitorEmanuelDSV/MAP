package alt_main.models;

public enum Areas {

    MATEMATICA {
        @Override
        public String toString() {
            return "Matemática";
        }
    },
    COMPUTACAO {
        @Override
        public String toString() {
            return "Computação";
        }
    },
    LETRAS {
        @Override
        public String toString() {
            return "Letras";
        }
    },
    FISICA {
        @Override
        public String toString() {
            return "Física";
        }
    };

    @Override
    public abstract String toString();

}
