package relationships;

import entities.Figura;

public class IdFigura {
    private int id;
    private Figura figura;

    public IdFigura(int id, Figura figura) {
        this.id = id;
        this.figura = figura;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Figura getFigura() {
        return figura;
    }

    public void setFigura(Figura figura) {
        this.figura = figura;
    }

}
