package controller;

import controller.Figuras;
import entities.Circulo;
import entities.Quadrado;
import entities.Retangulo;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class FigurasTest {
    Figuras figuras = new Figuras();

    @Test
    public void addFiguraTest() {
        assertNotNull(figuras.addFigura(1, new Circulo(10.0)));
    }

    @Test
    public void tryAddFiguraExistenteTest() {
        figuras.addFigura(1, new Circulo(10.0));
        assertThrows(IllegalArgumentException.class, () -> {figuras.addFigura(1, new Circulo(10.0));});
    }

    @Test
    public void removeFiguraTest() {
        figuras.addFigura(1, new Circulo(10.0));
        assertNotNull(figuras.removeFigura(1));
    }

    @Test
    public void tryRemoveFiguraInexistenteTest() {
        assertThrows(NoSuchElementException.class, () -> {figuras.removeFigura(999);});
    }

    @Test
    public void searchIdFiguraByIdTest() {
        figuras.addFigura(1, new Circulo(10.0));
        assertNotNull(figuras.searchIdFiguraById(1));
    }

    @Test
    public void trySearchIdFiguraByIdInexistenteTest() {
        assertThrows(NoSuchElementException.class, () -> {figuras.searchIdFiguraById(999);});
    }

    @Test
    public void infoFigurasTest() {
        double altura = 10;
        double largura = 5;
        double lado = 7;

        figuras.addFigura(1, new Retangulo(altura, largura));
        figuras.addFigura(2, new Quadrado(lado));

        assertEquals("O retângulo criado tem altura de tamanho: " + altura + " u.m e largura de tamanho: " + largura + " u.m\n" +
                "O quadrado criado tem lados de tamanho: " + lado + " u.m\n", figuras.infoFiguras());
    }

    @Test
    public void infoAreasTest() {
        double altura = 10.0;
        double largura = 5.0;
        double lado = 7.0;

        figuras.addFigura(1, new Retangulo(altura, largura));
        figuras.addFigura(2, new Quadrado(lado));

        assertEquals("ID: 1 (Retângulo) - 50.00 u.m²\n" +
                "ID: 2 (Quadrado) - 49.00 u.m²\n", figuras.infoAreas());

        //assertEquals("ID: 1 (Retângulo) - " + String.format("%.2f", figuras.searchIdFiguraById(1).getFigura().calculaArea()) + " u.m²\n" +
        //        "ID: 2 (Quadrado) - " + String.format("%.2f", figuras.searchIdFiguraById(2).getFigura().calculaArea()) + " u.m²\n", figuras.infoAreas());
    }

    @Test
    public void infoPerimetrosTest() {
        double altura = 10.0;
        double largura = 5.0;
        double lado = 7.0;

        figuras.addFigura(1, new Retangulo(altura, largura));
        figuras.addFigura(2, new Quadrado(lado));

        assertEquals("ID: 1 (Retângulo) - 30.00 u.m\n" +
                "ID: 2 (Quadrado) - 28.00 u.m\n", figuras.infoPerimetros());

        //assertEquals("ID: 1 (Retângulo) - " + String.format("%.2f", figuras.searchIdFiguraById(1).getFigura().calculaPerimetro()) + " u.m\n" +
        //        "ID: 2 (Quadrado) - " + String.format("%.2f", figuras.searchIdFiguraById(2).getFigura().calculaPerimetro()) + " u.m\n", figuras.infoPerimetros());
    }
}