package main.entities;

public class Circulo extends Figura {
    private double raio;

    public Circulo(double raio) {
        if(raio <= 0)
            throw new IllegalArgumentException("Raio inválido!");

        this.raio = raio;
    }

    @Override
    public double calculaArea() {
        return ( Math.PI * Math.pow(this.raio, 2) );
    }

    @Override
    public double calculaPerimetro() {
        return ( 2 * Math.PI * this.raio );
    }

    @Override
    public String infoGeral() {
        return ( "O círculo criado tem raio de tamanho: " + this.raio + " u.m");
    }

    @Override
    public String tipo() {
        return "Círculo";
    }

    // Getters e Setters
    public double getRaio() {
        return this.raio;
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }

}
