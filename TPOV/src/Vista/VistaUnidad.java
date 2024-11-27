package Vista;

import javax.swing.*;
import java.awt.*;

public class VistaUnidad extends JFrame {

    private JLabel statsLabel; // Para actualizar las estadísticas sin recrear el panel
    private JLayeredPane layeredPane;

    public VistaUnidad() {
        // Configuración básica de la ventana
        setTitle("Estadísticas del Héroe");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 600);
        setLayout(new BorderLayout());

        // Crear el JLayeredPane
        layeredPane = new JLayeredPane();
        layeredPane.setLayout(null);

        // Panel con fondo de imagen
        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon backgroundImage = new ImageIcon(getClass().getResource("/recursos/stats.png")); // Imagen de fondo
                if (backgroundImage.getImage() != null) {
                    g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), this);
                } else {
                    System.out.println("Error: No se pudo cargar la imagen de fondo.");
                }
            }
        };
        backgroundPanel.setBounds(0, 0, 800, 600); // Ocupa todo el espacio de la ventana
        layeredPane.add(backgroundPanel, Integer.valueOf(0)); // Fondo en la capa inferior

        // Panel para las estadísticas
        JPanel statsPanel = new JPanel();
        statsPanel.setOpaque(false); // Hacer transparente el fondo del panel
        statsPanel.setLayout(new BoxLayout(statsPanel, BoxLayout.Y_AXIS));
        statsPanel.setBounds(250, 150, 300, 300); // Posición centrada en la ventana

        // Etiqueta para las estadísticas
        statsLabel = new JLabel();
        statsLabel.setFont(new Font("Arial", Font.BOLD, 22));
        statsLabel.setForeground(Color.WHITE); // Texto blanco
        statsPanel.add(statsLabel);

        layeredPane.add(statsPanel, Integer.valueOf(1)); // Colocar el panel en la capa superior

        add(layeredPane); // Agregar el JLayeredPane al JFrame

        // Centrar la ventana
        setLocationRelativeTo(null);
    }

    // Método para mostrar las estadísticas del héroe
    public void mostrarEstadisticas(String estadisticas) {
        // Actualizar el texto de las estadísticas en la etiqueta
        statsLabel.setText("<html><pre>" + estadisticas + "</pre></html>");

        // Refrescar la vista
        layeredPane.revalidate();
        layeredPane.repaint();
    }

    // Método que se llama para mostrar la vista
    public void mostrarVista() {
        setVisible(true);
    }
}


