public class Opcion {
    private String texto;
    private Escena siguiente;

    public Opcion(String texto, Escena siguiente) {
        this.texto = texto;
        this.siguiente = siguiente;
    }

    public String getTexto() {
        return texto;
    }

    public Escena getSiguiente() {
        return siguiente;
    }
}
