package entities;

import controller.Figuras;
import entities.Quadrado;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class QuadradoTest {
    Figuras figuras = new Figuras();
    double lado = 7;

    @Before
    public void setUp() throws Exception {
        figuras.addFigura(1, new Quadrado(lado));
    }

    @Test
    public void calculaAreaTest() {
        assertEquals(49.00, figuras.searchIdFiguraById(1).getFigura().calculaArea(), 0.1);
    }

    @Test
    public void calculaPerimetroTest() {
        assertEquals(28.00, figuras.searchIdFiguraById(1).getFigura().calculaPerimetro(), 0.1);
    }

    @Test
    public void infoGeralTest() {
        assertEquals("O quadrado criado tem lados de tamanho: " + lado + " u.m", figuras.searchIdFiguraById(1).getFigura().infoGeral());
    }

    @Test
    public void tipoTest() {
        assertEquals("Quadrado", figuras.searchIdFiguraById(1).getFigura().tipo());
    }
}