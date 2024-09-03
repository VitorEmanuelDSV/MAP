package entities;

import controller.Figuras;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CirculoTest{
    Figuras figuras = new Figuras();
    double raio = 25;

    @Before
    public void setUp() throws Exception {
        figuras.addFigura(1, new Circulo(raio));
    }

    @Test
    public void calculaAreaTest() {
        assertEquals(1963.50, figuras.searchIdFiguraById(1).getFigura().calculaArea(), 0.1);
    }

    @Test
    public void calculaPerimetroTest() {
        assertEquals(157.08, figuras.searchIdFiguraById(1).getFigura().calculaPerimetro(), 0.1);
    }

    @Test
    public void infoGeralTest() {
        assertEquals("O círculo criado tem raio de tamanho: " + raio + " u.m", figuras.searchIdFiguraById(1).getFigura().infoGeral());
    }

    @Test
    public void tipoTest() {
        assertEquals("Círculo", figuras.searchIdFiguraById(1).getFigura().tipo());
    }
}