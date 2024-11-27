package Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class VistaNoTesoro extends JFrame {
    private JButton botonVolver;

    public VistaNoTesoro() {
        setTitle("No Tesoro");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        // Usar un JLayeredPane para manejar el fondo y los componentes superpuestos
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(800, 600));
        setContentPane(layeredPane);

        // Panel con fondo de imagen
        JPanel noTesoroPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon noTesoroImage = new ImageIcon(getClass().getResource("/recursos/tesoroVacio.jpg")); // Imagen de fondo
                if (noTesoroImage.getImage() != null) {
                    g.drawImage(noTesoroImage.getImage(), 0, 0, getWidth(), getHeight(), this);
                } else {
                    System.out.println("Error: No se pudo cargar la imagen de fondo.");
                }
            }
        };
        noTesoroPanel.setBounds(0, 0, 800, 600); // Ocupa todo el espacio de la ventana
        layeredPane.add(noTesoroPanel, Integer.valueOf(0)); // Fondo en la capa inferior

        // Cuadro de texto en el centro de la vista
        JLabel mensajeLabel = new JLabel("Mala suerte. El tesoro no está en esta ubicación");
        mensajeLabel.setFont(new Font("Arial", Font.BOLD, 24));
        mensajeLabel.setForeground(Color.WHITE);
        mensajeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mensajeLabel.setBounds(0, 20, 800, 50); // Centrado horizontal y en la parte superior
        layeredPane.add(mensajeLabel, Integer.valueOf(1)); // Añadir sobre el fondo

        // Botón para Volver
        botonVolver = new JButton("Volver");
        botonVolver.setFont(new Font("Arial", Font.BOLD, 20));
        botonVolver.setBounds(250, 400, 300, 50); // Centrado del botón
        botonVolver.setFocusPainted(false);
        layeredPane.add(botonVolver, Integer.valueOf(2)); // Añadir el botón en una capa superior

        // Centrar la ventana
        setLocationRelativeTo(null);
    }

    public void setBotonVolverListener(ActionListener listener) {
        botonVolver.addActionListener(listener);
    }

    public void mostrarVista() {
        setVisible(true);
    }

    public void cerrarVista() {
        dispose();
    }
}

