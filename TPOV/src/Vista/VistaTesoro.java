package Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class VistaTesoro extends JFrame {
    private JButton cerrarJuego;

    public VistaTesoro() {
        setTitle("Tesoro");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        // Usar un JLayeredPane para manejar el fondo y los componentes superpuestos
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(800, 600));
        setContentPane(layeredPane);

        // Panel con fondo de imagen
        JPanel tesoroPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon tesoroImage = new ImageIcon(getClass().getResource("/recursos/tesoro.jpg")); // Imagen de fondo
                if (tesoroImage.getImage() != null) {
                    g.drawImage(tesoroImage.getImage(), 0, 0, getWidth(), getHeight(), this);
                } else {
                    System.out.println("Error: No se pudo cargar la imagen de fondo.");
                }
            }
        };
        tesoroPanel.setBounds(0, 0, 800, 600); // Ocupa todo el espacio de la ventana
        layeredPane.add(tesoroPanel, Integer.valueOf(0)); // Fondo en la capa inferior

        // Cuadro de texto centrado en la parte superior
        JLabel mensajeLabel = new JLabel("¡Enhorabuena! ¡Has ganado!");
        mensajeLabel.setFont(new Font("Arial", Font.BOLD, 24));
        mensajeLabel.setForeground(Color.WHITE);
        mensajeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mensajeLabel.setBounds(0, 20, 800, 50); // Centrado horizontal y en la parte superior
        layeredPane.add(mensajeLabel, Integer.valueOf(1)); // Añadir sobre el fondo

        // Botón para Volver
        cerrarJuego = new JButton("Cerrar Juego");
        cerrarJuego.setFont(new Font("Arial", Font.BOLD, 20));
        cerrarJuego.setBounds(250, 400, 300, 50); // Centrado del botón
        cerrarJuego.setFocusPainted(false);
        layeredPane.add(cerrarJuego, Integer.valueOf(2)); // Añadir el botón en una capa superior

        // Centrar la ventana
        setLocationRelativeTo(null);

    }

    public void setBotonCerrarListener(ActionListener listener) {
        cerrarJuego.addActionListener(listener);
    }

    public void mostrarVista() {
        setVisible(true);
    }

    public void cerrarVista() {
        dispose();
    }
}
