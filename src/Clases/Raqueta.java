package Clases;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Raqueta {

    private int x, y;
    static final int Ancho = 10, Altura = 40;

    public Raqueta(int x, int y) {

        // Inicializando Valores de Raqueta
        this.x = x;
        this.y = y;

    }

    // Crenado las raquetas

    public Rectangle2D getRaqueta() {

        return new Rectangle2D.Double(x, y, Ancho, Altura);

    }

    // Movimiento a las raquetas

    public void MoverR1 (Rectangle limites) {

        if (Evento_Teclado.w && y > limites.getMinY()) {

            y -- ;

        }

        if (Evento_Teclado.s && y < limites.getMaxY() - Altura) {

            y ++ ;

        }

    }

    public void MoverR2 (Rectangle limites) {

        if (Evento_Teclado.up && y > limites.getMinY()) {

            y -- ;

        }

        if (Evento_Teclado.down && y < limites.getMaxY() - Altura) {

            y ++ ;

        }

    }

}


