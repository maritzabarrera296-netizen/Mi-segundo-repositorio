import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

class ContadorVista extends JFrame {
    JLabel etiqueta = new JLabel("Clics: 0");
    JButton boton = new JButton("Contar");

    public ContadorVista() {
        setTitle("MVC Sencillo");
        setSize(250, 120);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        add(etiqueta);
        add(boton);
    }
}
