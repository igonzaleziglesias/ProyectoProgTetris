package baseDatos;

public class Jugador implements Comparable {
    private int id;
    private String name;
    private String puntos;

    public Jugador(int id, String name, String puntos) {
        this.id = id;
        this.name = name;
        this.puntos = puntos;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPuntos() {
        return puntos;
    }
    
        @Override
    public int compareTo(Object t) {
        Jugador o = (Jugador) t;
        if (Integer.parseInt(this.puntos) < Integer.parseInt(o.puntos)) {
            return 1;
        }
        if (Integer.parseInt(this.puntos) > Integer.parseInt(o.puntos)) {
            return -1;
        }
        return 0;
    }
}
