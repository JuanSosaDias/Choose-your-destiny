import java.util.*;

public class Juego {

    public static void main(String[] args) {
        new Juego().iniciar();
    }

    private void iniciar() {
        Scanner scanner = new Scanner(System.in);

        // Crear escenas
        Escena inicio = new Escena("Despertás en una habitación oscura y cerrada.");
        Escena ventana = new Escena("Mirá por la ventana: un bosque oscuro. Algo se mueve.");
        Escena puerta = new Escena("Abrís la puerta. El pasillo está iluminado con luces rojas.");
        Escena saltar = new Escena("Saltás y caés en un arbusto. Estás en el bosque, libre pero herido.");
        Escena esperar = new Escena("Esperás... Una figura sombría aparece. No hay escapatoria.");
        Escena izquierda = new Escena("Girá a la izquierda. Hay una sala con pantallas que muestran tu cara.");
        Escena derecha = new Escena("Girá a la derecha. Encontrás una salida secreta.");
        Escena finBueno = new Escena("Lográs escapar. Respirás aire puro por primera vez en días.");
        Escena finMalo = new Escena("La figura te alcanza. Todo se vuelve oscuro.");
        Escena finalEnigma = new Escena("Un mensaje aparece: '¿Y si nunca despertaste?'");

        // Configurar opciones
        inicio.agregarOpcion("Mirar por la ventana", ventana);
        inicio.agregarOpcion("Abrir la puerta", puerta);

        ventana.agregarOpcion("Saltar por la ventana", saltar);
        ventana.agregarOpcion("Esperar un rato", esperar);

        puerta.agregarOpcion("Girar a la izquierda", izquierda);
        puerta.agregarOpcion("Girar a la derecha", derecha);

        saltar.agregarOpcion("Buscar ayuda en el bosque", finBueno);
        saltar.agregarOpcion("Sentarte a descansar", finalEnigma);

        esperar.agregarOpcion("Gritar", finMalo);
        esperar.agregarOpcion("Cerrar los ojos", finalEnigma);

        izquierda.agregarOpcion("Desconectar las pantallas", finalEnigma);
        izquierda.agregarOpcion("Huir de la sala", finMalo);

        derecha.agregarOpcion("Correr por la salida", finBueno);
        derecha.agregarOpcion("Explorar más", finalEnigma);

        // Juego en sí
        Escena escenaActual = inicio;

        while (true) {
            System.out.println("\n" + escenaActual.getDescripcion());
            List<Opcion> opciones = escenaActual.getOpciones();

            if (opciones.isEmpty()) {
                System.out.println("\n=== Fin de la historia ===");
                break;
            }

            for (int i = 0; i < opciones.size(); i++) {
                System.out.println((i + 1) + ". " + opciones.get(i).getTexto());
            }

            System.out.print("Elegí una opción: ");
            int eleccion = scanner.nextInt();

            if (eleccion < 1 || eleccion > opciones.size()) {
                System.out.println("Opción inválida.");
            } else {
                escenaActual = opciones.get(eleccion - 1).getSiguiente();
            }
        }
    }
}
