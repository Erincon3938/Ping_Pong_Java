package Clases;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public class Tablero_Juego extends JPanel {

    // Posicion de las raquetas y pelotas
    Pelota pelota = new Pelota (0,0) ;
    Raqueta r1 = new Raqueta(10 , 200) ;
    Raqueta r2 = new Raqueta((794-10-Raqueta.Ancho) , 200) ;

    public Tablero_Juego() {

        Color myColor_01 = new Color(69, 69, 69);
        setBackground(myColor_01);

    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        Color myColor_02 = new Color(174, 186, 255    ) ;
        g2.setPaint(myColor_02);
        Dibujar_Puntuaje(g2);
        Dibujar(g2) ;
        Actualizar();
    }

    public void Dibujar (Graphics2D g) {

        // Creando la linea que separa la cancha
        Line2D.Double linea = new Line2D.Double(getBounds().getCenterX(), 0, getBounds().getCenterX(), getBounds().getMaxY());
        Color myColor_03 = new Color(255, 255, 255);
        g.setPaint(myColor_03);
        // Dibujando la linea que separa la cancha
        g.draw(linea);

        // Dibujando la pelota
        Color myColor_04 = new Color(255, 255, 150);
        g.setPaint(myColor_04);
        g.fill (pelota.getShape()) ;
        Actualizar();

        // Dibujando las raquetas
        Color myColor_05 = new Color(255, 126, 153) ;
        g.setPaint(myColor_05);
        g.fill(r1.getRaqueta());
        Actualizar();

        Color myColor_06 = new Color(163, 255, 126 ) ;
        g.setPaint(myColor_06);
        g.fill(r2.getRaqueta());
        Actualizar();

    }

    //Actualiza el estado (posicion) de las raquetas y pelota

    public void Actualizar () {

        pelota.Mover(getBounds() , Colision(r1.getRaqueta()) , Colision(r2.getRaqueta()));
        r1.MoverR1(getBounds());
        r2.MoverR2(getBounds());

    }

    //Detecta si existe una colision entre la raqueta y la pelota

    private boolean Colision(Rectangle2D r)  {

        return pelota.getShape().intersects(r);

    }

    private void Dibujar_Puntuaje (Graphics2D g) {

        Graphics2D g1 = g , g2 = g ;
        Font score = new Font("Times New Roman", Font.BOLD, 30);
        g.setFont(score);

        g1.drawString(Integer.toString(pelota.getScore1()), (float) getBounds().getCenterX() - 50, 30);
        g2.drawString(Integer.toString(pelota.getScore2()), (float) getBounds().getCenterX() + 25, 30);


        if (pelota.getScore1() == 8) {

            g.drawString("  GANÓ El JUGADOR 1", (float) getBounds().getCenterX() - 180, (float) getBounds().getCenterY() - 50);
            Pelota.finJuego = true;

        }

        if (pelota.getScore2() == 8) {

            g.drawString("  GANÓ EL JUGADOR 2", (float) getBounds().getCenterX() - 180, (float) getBounds().getCenterY() - 50);
            Pelota.finJuego = true;

        }

    }

}
