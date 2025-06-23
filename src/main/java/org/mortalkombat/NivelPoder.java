package org.mortalkombat;

public enum NivelPoder {
    BAJO(1),
    MEDIO(2),
    ALTO(3);

    private final int valor;

    NivelPoder(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

    public static NivelPoder fromValor(int valor) {
        for (NivelPoder nivel : values()) {
            if (nivel.valor == valor) {
                return nivel;
            }
        }
        throw new IllegalArgumentException("Valor no válido para NivelPoder: " + valor);
    }
}
