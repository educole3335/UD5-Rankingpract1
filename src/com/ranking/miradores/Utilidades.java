package com.ranking.miradores;
import javax.swing.*;

public class Utilidades {
    public static String pedirTexto(String msg) {
        return JOptionPane.showInputDialog(null, msg);
    }

    public static int pedirEntero(String msg) {
        while (true) {
            try {
                int valor = Integer.parseInt(pedirTexto(msg));
                if (valor < 1 || valor > 5) throw new NumberFormatException();
                return valor;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Introduce un número entre 1 y 5.");
            }
        }
    }

    public static boolean pedirSiNo(String msg) {
        int res = JOptionPane.showConfirmDialog(null, msg, "Confirmar", JOptionPane.YES_NO_OPTION);
        return res == JOptionPane.YES_OPTION;
    }
}

