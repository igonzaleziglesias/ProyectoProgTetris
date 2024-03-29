package tetris;

import baseDatos.Jugador;
import excepciones.ExcepcionSql;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import static tetris.App.INDEX;

public class Menu {

    public static void crearMenu() throws ExcepcionSql {
        int eleccion;

        String[] elecciones = {"Jugar", "Salir"};//mensaje final de partida
        //implementar aqui insercion en base de datos
        eleccion = JOptionPane.showOptionDialog(
                null,
                "Bienvenido a Tetris! ヽ(^o^)ノ ",
                null,
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                elecciones,
                null
        );

        switch (eleccion) {

            case 0:
                baseDatos.Connect.connect();
                try {
                    baseDatos.Create.createTable();
                } catch (ExcepcionSql e) {

                }

                baseDatos.Quest quest = new baseDatos.Quest();
                ArrayList<Jugador> datos = new ArrayList<Jugador>();

                baseDatos.Delete delete = new baseDatos.Delete();
//     delete.deleteAll(); //USAR PARA BORRAR LA BASE DE DATOS ENTERA
                try {
                    datos = quest.selectAll();
                } catch (ExcepcionSql e) {

                }
//        System.out.println(datos.size());
                INDEX = datos.size() + 1;

                CrearEntorno game = new CrearEntorno();
                game.setLocationRelativeTo(null);//Para posicionar la ventana en el centro de la pantalla(automatico al ser null)
                game.setVisible(true);

                break;
            case 1:
                System.exit(0);
                break;

        }

    }
}
