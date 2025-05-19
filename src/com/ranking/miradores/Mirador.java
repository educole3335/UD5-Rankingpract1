package com.ranking.miradores;

public class Mirador {
    
    private String nombre;
    private String ubicacion;
    private boolean muyTransitado;
    private int limpieza;
    private int vistas;
    private int puntuacion;

    public Mirador(String nombre, String ubicacion, boolean muyTransitado, int limpieza, int vistas) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.muyTransitado = muyTransitado;
        this.limpieza = limpieza;
        this.vistas = vistas;
        this.puntuacion = calcularPuntuacion();
    }

    private int calcularPuntuacion() {
        int transitoPunt = muyTransitado ? 2 : 5;
        return Math.round((limpieza + vistas + transitoPunt) / 3.0f);
    }

    public String getNombre() { return nombre; }
    public String getUbicacion() { return ubicacion; }
    public boolean isMuyTransitado() { return muyTransitado; }
    public int getLimpieza() { return limpieza; }
    public int getVistas() { return vistas; }
    public int getPuntuacion() { return puntuacion; }

    public void actualizar(String nombre, String ubicacion, boolean transito, int limpieza, int vistas) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.muyTransitado = transito;
        this.limpieza = limpieza;
        this.vistas = vistas;
        this.puntuacion = calcularPuntuacion();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("----------------------------\n");
        sb.append(nombre).append(" (").append(ubicacion).append(")\n");
        sb.append("  Limpieza: ").append(limpieza).append("\n");
        sb.append("  Vistas: ").append(vistas).append("\n");
        sb.append("  Muy transitado: ").append(muyTransitado ? "Sí" : "No").append("\n");
        sb.append("  Puntuación: ").append(puntuacion).append("\n");
        sb.append("----------------------------");
        return sb.toString();
    }
    }

