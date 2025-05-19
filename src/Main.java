import com.ranking.miradores.GestorMiradores;
import com.ranking.miradores.Mirador;
import com.ranking.miradores.Utilidades;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Añadir miradores iniciales
        inicializarMiradores();

        String opcion;
        do {
            opcion = JOptionPane.showInputDialog(
                "Ranking de los mejores lugares de Tenerife\n\n" +
                "1. Añadir lugar\n" +
                "2. Editar lugar\n" +
                "3. Mostrar lugares\n" +
                "4. Eliminar lugar\n" +
                "Q. Salir"
            );

            switch (opcion) {
                case "1" -> añadir();
                case "2" -> editar();
                case "3" -> mostrar();
                case "4" -> eliminar();
                case "Q", "q" -> JOptionPane.showMessageDialog(null, "¡Hasta luego!");
                default -> JOptionPane.showMessageDialog(null, "Opción no válida.");
            }
        } while (!opcion.equalsIgnoreCase("Q"));
    }

    private static void inicializarMiradores() {
        GestorMiradores.añadir(new Mirador("Mirador de Humboldt", "Orotava", true, 4, 5));
        GestorMiradores.añadir(new Mirador("Mirador de La Paz", "Puerto de la Cruz", false, 5, 4));
        GestorMiradores.añadir(new Mirador("Mirador de Chipeque", "La Orotava", true, 3, 5));
    }

    private static void añadir() {
        try {
            String nombre = Utilidades.pedirTexto("Nombre del lugar:");
            String ubicacion = Utilidades.pedirTexto("Ubicación:");
            boolean muyTransitado = Utilidades.pedirSiNo("¿Es muy transitado?");
            int limpieza = Utilidades.pedirEntero("Puntuación de limpieza (1-5):");
            int vistas = Utilidades.pedirEntero("Puntuación de vistas (1-5):");

            Mirador nuevo = new Mirador(nombre, ubicacion, muyTransitado, limpieza, vistas);
            GestorMiradores.añadir(nuevo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al añadir lugar.");
        }
    }

    private static void mostrar() {
        StringBuilder sb = new StringBuilder();
        int i = 1;
        for (Mirador lugar : GestorMiradores.getTodosOrdenados()) {
            sb.append(i++).append(". ").append(lugar.toString()).append("\n\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    private static void eliminar() {
        int index = Utilidades.pedirEntero("¿Qué número de lugar deseas eliminar?") - 1;
        if (GestorMiradores.eliminar(index)) {
            JOptionPane.showMessageDialog(null, "Lugar eliminado.");
        } else {
            JOptionPane.showMessageDialog(null, "Índice no válido.");
        }
    }

    private static void editar() {
        try {
            int index = Utilidades.pedirEntero("¿Qué número de lugar deseas editar?") - 1;
            Mirador lugar = GestorMiradores.get(index);
            String nuevoNombre = Utilidades.pedirTexto("Nuevo nombre [" + lugar.getNombre() + "]:");
            String nuevaUbicacion = Utilidades.pedirTexto("Nueva ubicación:");
            boolean nuevoTransito = Utilidades.pedirSiNo("¿Es muy transitado?");
            int nuevaLimpieza = Utilidades.pedirEntero("Nueva limpieza:");
            int nuevasVistas = Utilidades.pedirEntero("Nuevas vistas:");

            Mirador editado = new Mirador(
                nuevoNombre.isBlank() ? lugar.getNombre() : nuevoNombre,
                nuevaUbicacion.isBlank() ? lugar.getUbicacion() : nuevaUbicacion,
                nuevoTransito,
                nuevaLimpieza,
                nuevasVistas
            );
            GestorMiradores.get(index).actualizar(
                editado.getNombre(),
                editado.getUbicacion(),
                editado.isMuyTransitado(),
                editado.getLimpieza(),
                editado.getVistas()
            );
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al editar.");
        }
    }
}

