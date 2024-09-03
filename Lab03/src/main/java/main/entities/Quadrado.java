package entities;

public class Quadrado extends Figura {
    private double lado;

    public Quadrado(double lado) {
        if(lado <= 0)
            throw new IllegalArgumentException("Lado inválido!");

        this.lado = lado;
    }

    @Override
    public double calculaArea() {
        return ( this.lado * this.lado );
    }

    @Override
    public double calculaPerimetro() {
        return ( this.lado * 4 );
    }

    @Override
    public String infoGeral() {
        return ( "O quadrado criado tem lados de tamanho: " + this.lado + " u.m" );
    }

    @Override
    public String tipo() {
        return "Quadrado";
    }

    // Getters e Setters
    public double getLado() {
        return this.lado;
    }

    public void setLado(double lado) {
        this.lado = lado;
    }

}
