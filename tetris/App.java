package tetris;

import excepciones.ExcepcionSql;
import static tetris.Menu.crearMenu;

public class App {

    static int INDEX;

    public App() {
        try {
            crearMenu();
        } catch (ExcepcionSql ex) {
            ex.getMessage();
        }
    }

}
