package sonido;

import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class SonidoFondo extends Thread {

    Clip sonido;
    boolean estado = true;

    public void run() {
        while (estado) {
            try {
                sonido = AudioSystem.getClip();
//                File a = new File("C:\\Users\\Usuario\\Desktop\\tetris.wav");//pc casa
//                File a = new File("/home/s7orm/Escritorio/tetris.wav");//pc portatil
//                File a = new File("/home/local/DANIELCASTELAO/igonzaleziglesias/NetBeansProjects/Tetris/ProyectoProgTetris/wavs/tetris.wav");//pc clase
                File a = new File("/home/local/DANIELCASTELAO/igonzaleziglesias/NetBeansProjects/tetrisDesc/ProyectoProgTetris/wavs/Tetris 99.wav");//pc clase
                sonido.open(AudioSystem.getAudioInputStream(a));
                sonido.start();
//                Thread.sleep(25500); // (25.5segundos)
                Thread.sleep(292000); // (292 segundos)
                sonido.close();
            } catch (Exception tipoError) {
                System.out.println("" + tipoError);
            }
        }
    }

    public void cambiarEstado() {
        estado = false;
        sonido.close();
    }

}
