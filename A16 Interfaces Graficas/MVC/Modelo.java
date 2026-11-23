import javax.swing.*;
import java.awt.FlowLayout;

// 1. MODELO: Solo maneja los datos y las reglas
class ContadorModelo {
    private int valor = 0;

    public void incrementar() {
        valor++;
    }

    public int getValor() {
        return valor;
    }
}