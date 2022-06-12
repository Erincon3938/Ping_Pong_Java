package Clases;
import javax.swing.*;

public class Ventana extends JFrame {

    private final int Ancho = 810, Alto = 510;
    Tablero_Juego canvas ;

    public Ventana() {

        // Titulo de la Pagina
        setTitle("Ping Pong");
        // Tamaño de la Ventana
        setSize(Ancho, Alto);
        // Ubicamos la Ventana en el Centro
        setLocationRelativeTo(null);
        // Impedir Modificar el Tamaño de la Ventana
        setResizable(false);
        canvas = new Tablero_Juego();
        add(canvas);
        addKeyListener(new Evento_Teclado());
        new Hilo(canvas).start();


    }

}
