package main.models;

public enum StatusDisciplina {

    CURSANDO {
        @Override
        public String toString() {
            return "Cursando";
        }
    },
    APROVADO {
        @Override
        public String toString() {
            return "Aprovado";
        }
    },
    REPROVADO {
        @Override
        public String toString() {
            return "Reprovado";
        }
    };

    @Override
    public abstract String toString();

}
