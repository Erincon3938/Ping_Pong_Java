package Clases;

public class Hilo extends  Thread {

    private final Tablero_Juego canvas;

    public Hilo (Tablero_Juego canvas) {

        this.canvas = canvas;

    }



    @Override
    public void run () {
        // Velocidad de Pelota
        while (!Pelota.finJuego) {

            canvas.repaint();
            try {

                //Paint Velocity
                Thread.sleep(9);

            }

            catch (Exception ex) {

                System.out.println("error in graphics engine: " + ex.getMessage());
            }

        }

    }

}
