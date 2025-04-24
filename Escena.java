import java.util.ArrayList;
import java.util.List;

public class Escena {
    private String descripcion;
    private List<Opcion> opciones;

    public Escena(String descripcion) {
        this.descripcion = descripcion;
        this.opciones = new ArrayList<>();
    }

    public void agregarOpcion(String texto, Escena siguiente) {
        opciones.add(new Opcion(texto, siguiente));
    }

    public String getDescripcion() {
        return descripcion;
    }

    public List<Opcion> getOpciones() {
        return opciones;
    }
}
