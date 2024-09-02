package main.entities;

public class Retangulo extends Figura {
    private double altura;
    private double largura;

    public Retangulo(double altura, double largura) {
        if(altura <= 0 || largura <= 0)
            throw new IllegalArgumentException("Altura e/ou largura inválida!");

        this.altura = altura;
        this.largura = largura;
    }

    @Override
    public double calculaArea() {
        return ( this.altura * this.largura );
    }

    @Override
    public double calculaPerimetro() {
        return ( this.altura * 2 + this.largura * 2 );
    }

    @Override
    public String infoGeral() {
        return ( "O retângulo criado tem altura de tamanho: " + this.altura + " u.m e largura de tamanho: " + this.largura + " u.m" );
    }

    @Override
    public String tipo() {
        return "Retângulo";
    }

    // Getters e Setters
    public double getAltura() {
        return this.altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getLargura() {
        return this.largura;
    }

    public void setLargura(double largura) {
        this.largura = largura;
    }

}
