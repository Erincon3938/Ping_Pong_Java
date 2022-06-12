package Clases;

import java.applet.AudioClip;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Pelota {

    // Posición
    private static double x, y;
    private static final int TamX = 15 , TamY = 15 ;
    private int dx = 1, dy = 1;
    // Tamaño (final por que son constantes)
    private final int Ancho = 15, Altura = 15;
    private Integer score1 = 0, score2 = 0;
    public static boolean finJuego = false;

    Audio audio = new Audio();
    AudioClip rebote_01 =audio.getAudio("/Audios_y_Imagen/Rebote_Pelota_01.wav");
    AudioClip rebote_02 =audio.getAudio("/Audios_y_Imagen/Rebote_Pelota_02.wav");
    AudioClip pausa =audio.getAudio("/Audios_y_Imagen/Pausa.wav");

    public Pelota(int x, int y) {

        // Inicializando Valores de la Posicion de la Pelota
        this.x = x;
        this.y = y;

    }

    // Dibujando Pelota
    public Rectangle2D getPelota() {

        return new Rectangle2D.Double(x, y, Ancho, Altura);

    }

    // Retorna la pelota (Rectangle2D implementa la interface Shape)
    public Rectangle2D getShape() {

        return new Rectangle2D.Double(x, y, TamX, TamY);

    }

    public void Mover(Rectangle limites , boolean colisionR1 , boolean colisionR2) {

        x += dx;
        y += dy;

        if (colisionR1) {

            dx =-dx ;
            x = 20 ;
            rebote_01.play();

        }

        if (colisionR2) {

            dx =-dx ;
            x = 755 ;
            rebote_01.play();

        }

        // Para Rebotar la Pelota

        if (x < limites.getMinX()) {

            // El puntaje del jugador2 aumenta en uno
            score2++ ;
            x = limites.getCenterX();
            y = limites.getCenterY();
            dx = -dx;
            pausa.play();

        }

        if (x + TamX >= limites.getMaxX()) {
            // El puntaje del jugador1 aumenta en uno
            score1++;
            x = limites.getCenterX();
            y = limites.getCenterY();
            dx = -dx;
            pausa.play();

        }

        if (y < limites.getMinY()) {

            y = limites.getMinY();
            dy = -dy;
            rebote_02.play();

        }

        if (y + TamY >= limites.getMaxY()) {

            y = limites.getMaxY() - TamY;
            dy = -dy;
            rebote_02.play();

        }

    }




    public int getScore1 () {

        return score1 ;

    }

    public int getScore2 () {

        return score2 ;

    }



}
