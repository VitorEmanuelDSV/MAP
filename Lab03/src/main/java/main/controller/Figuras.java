package main.controller;

import main.entities.Circulo;
import main.entities.Figura;
import main.entities.Quadrado;
import main.entities.Retangulo;
import main.relationships.IdFigura;

import java.util.ArrayList;
import java.util.Locale;
import java.util.NoSuchElementException;

public class Figuras {

    private final ArrayList<IdFigura> figuras = new ArrayList<IdFigura>();

    public Figuras() {}

    public Figura addFigura(int id, Figura figura) throws IllegalArgumentException {
        for (IdFigura idFigura : this.figuras) {
            if(id == idFigura.getId())
                throw new IllegalArgumentException("ID já existente!");
        }

        this.figuras.add(new IdFigura(id, figura));
        return figura;
    }

    public Figura removeFigura(int id) {
        for (IdFigura idFigura : this.figuras) {
            if(id == idFigura.getId()) {
                this.figuras.removeIf(
                    figura -> figura.getId() == searchIdFiguraById(id).getId()
                );
                return idFigura.getFigura();
            }
        }

        throw new NoSuchElementException("ID [" + id + "] não existente!");
    }

    public IdFigura searchIdFiguraById(int id) {
        for (IdFigura figura : this.figuras) {
            if(id == figura.getId()) return figura;
        }
        throw new NoSuchElementException("Figura de ID [" + id + "] não encontrada.");
    }

    // Creator
    public Circulo createCirculo(int raio) {
        return new Circulo(raio);
    }

    public Quadrado createQuadrado(int lado) {
        return new Quadrado(lado);
    }

    public Retangulo createRetangulo(int altura, int largura) {
        return new Retangulo(altura, largura);
    }

    // Informações -> Métodos que não precisam de TESTE
    public String infoFiguras() {
        StringBuilder info = new StringBuilder();

        for (IdFigura idFigura : this.figuras) {
            info.append(idFigura.getFigura().infoGeral()).append("\n");
        }

        return info.toString();
    }

    public String infoAreas() {
        StringBuilder info = new StringBuilder();

        for (IdFigura figura : this.figuras) {
            info.append("ID: ")
                .append(figura.getId())
                .append(" (")
                .append(figura.getFigura().tipo())
                .append(") - ").append(
                    String.format(Locale.US, "%.2f", figura.getFigura().calculaArea())
                )
                .append(" u.m²\n");
        }

        return info.toString();
    }

    public String infoPerimetros() {
        StringBuilder info = new StringBuilder();

        for (IdFigura figura : this.figuras) {
            info.append("ID: ")
                    .append(figura.getId())
                    .append(" (")
                    .append(figura.getFigura().tipo())
                    .append(") - ").append(
                        String.format(Locale.US, "%.2f", figura.getFigura().calculaPerimetro())
                    )
                    .append(" u.m\n");
        }

        return info.toString();
    }

    // Getters e Setters
    public ArrayList<IdFigura> getFiguras() {
        return this.figuras;
    }

}
