import javax.swing.*;
import java.awt.*;

class ContadorModelo {
    private int valor;

    public void incrementar() {
        valor++;
    }

    public int getValor() {
        return valor;
    }
}

class ContadorVista extends JFrame {
    public final JButton boton = new JButton("Contar");
    public final JLabel etiqueta = new JLabel("Clics: 0");

    public ContadorVista() {
        super("Contador MVC");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        add(etiqueta, BorderLayout.CENTER);
        add(boton, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
    }
}

class ContadorControlador {
    public ContadorControlador(ContadorModelo modelo, ContadorVista vista) {
        // Cuando se hace clic en el botón...
        vista.boton.addActionListener(e -> {
            modelo.incrementar(); // 1. Cambia el dato en el Modelo
            vista.etiqueta.setText("Clics: " + modelo.getValor()); // 2. Actualiza la Vista
        });
    }
}

// PUNTO DE ENTRADA (STAND-ALONE)
public class Main {
    public static void main(String[] args) {
        ContadorModelo modelo = new ContadorModelo();
        ContadorVista vista = new ContadorVista();
        new ContadorControlador(modelo, vista); // Conecta todo

        vista.setVisible(true); // Muestra la ventana
    }
}
