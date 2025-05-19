package com.ranking.miradores;
import java.util.*;

public class GestorMiradores {
    private static final List<Mirador> lista = new ArrayList<>();

    public static void añadir(Mirador m) {
        lista.add(m);
    }

    public static List<Mirador> getTodosOrdenados() {
        lista.sort(Comparator.comparingInt(Mirador::getPuntuacion).reversed());
        return lista;
    }

    public static boolean eliminar(int index) {
        if (index >= 0 && index < lista.size()) {
            lista.remove(index);
            return true;
        }
        return false;
    }

    public static Mirador get(int index) {
        return lista.get(index);
    }

    public static int total() {
        return lista.size();
    }
}

