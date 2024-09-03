package entities;

import controller.Figuras;
import entities.Retangulo;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RetanguloTest {
    Figuras figuras = new Figuras();
    double altura = 10;
    double largura = 5;

    @Before
    public void setUp() throws Exception {
        figuras.addFigura(1, new Retangulo(altura, largura));
    }

    @Test
    public void calculaAreaTest() {
        assertEquals(50.00, figuras.searchIdFiguraById(1).getFigura().calculaArea(), 0.1);
    }

    @Test
    public void calculaPerimetroTest() {
        assertEquals(30.00, figuras.searchIdFiguraById(1).getFigura().calculaPerimetro(), 0.1);
    }

    @Test
    public void infoGeralTest() {
        assertEquals("O retângulo criado tem altura de tamanho: " + altura + " u.m e largura de tamanho: " + largura + " u.m", figuras.searchIdFiguraById(1).getFigura().infoGeral());
    }

    @Test
    public void tipoTest() {
        assertEquals("Retângulo", figuras.searchIdFiguraById(1).getFigura().tipo());
    }
}