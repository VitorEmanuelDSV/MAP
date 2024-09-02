package main.main;

import main.controller.Figuras;
import main.entities.Circulo;
import main.entities.Quadrado;
import main.entities.Retangulo;
import main.relationships.IdFigura;

import java.util.Locale;

public class BrincandoComAsFigurasGeometricas {

    public static void main(String[] args) {

        Figuras figuras = new Figuras();

        /*
            Considerar usar switch case para criação de figura por input do usuário
            ~ A verificar
         */

        figuras.addFigura(1, figuras.createRetangulo(10, 5));
        figuras.addFigura(2, figuras.createQuadrado(7));
        figuras.addFigura(3, figuras.createCirculo(25));

        for(IdFigura figura : figuras.getFiguras()) {
            System.out.println("- Informações da figura de ID: " + figura.getId());

            System.out.println(
                "O perímetro deste " + figura.getFigura().tipo() + " é: " +
                String.format(Locale.US, "%.2f",figura.getFigura().calculaPerimetro()) + " u.m"
            );

            System.out.println(
                "A área deste " + figura.getFigura().tipo() + " é: " +
                String.format(Locale.US, "%.2f", figura.getFigura().calculaArea()) + " u.m²"
            );

            System.out.println(
                figura.getFigura().infoGeral() + "\n"
            );
        }

        System.out.println("- Informações das figuras:");
        System.out.println(
                figuras.infoFiguras()
        );

        System.out.println("- Todas as áreas são:");
        System.out.println(
                figuras.infoAreas()
        );

        System.out.println("- Todas os perímetros são:");
        System.out.println(
                figuras.infoPerimetros()
        );



    }

}
