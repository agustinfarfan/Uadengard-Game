package Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class VistaMapa extends JFrame {
    private JButton botonVolver;
    private JPanel ubicacionesPanel;
    private JButton botonMapaCompleto;
    private JLayeredPane layeredPane;

    public VistaMapa() {
        setTitle("Mapa");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 1000);

        // Usar un JLayeredPane para manejar el fondo y los componentes superpuestos
        layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(1200, 1000));
        layeredPane.setLayout(null);

        // Panel con fondo de imagen
        JPanel mapaPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon mapaImage = new ImageIcon(getClass().getResource("/recursos/mapaBackground.jpg")); // Imagen de fondo
                if (mapaImage.getImage() != null) {
                    g.drawImage(mapaImage.getImage(), 0, 0, getWidth(), getHeight(), this);
                } else {
                    System.out.println("Error: No se pudo cargar la imagen de fondo.");
                }
            }
        };
        mapaPanel.setBounds(0, 0, 1200, 1000); // Ocupa todo el espacio de la ventana
        layeredPane.add(mapaPanel, Integer.valueOf(0)); // Fondo en la capa inferior

        // Título "Mapa"
        JLabel tituloLabel = new JLabel("Mapa");
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 40));
        tituloLabel.setForeground(Color.WHITE);
        tituloLabel.setBounds(500, 20, 200, 50);
        layeredPane.add(tituloLabel, Integer.valueOf(1));

        // Subtítulo "¿A dónde quieres viajar?"
        JLabel subtituloLabel = new JLabel("¿A dónde quieres viajar?");
        subtituloLabel.setFont(new Font("Arial", Font.BOLD, 25));
        subtituloLabel.setForeground(Color.WHITE);
        subtituloLabel.setBounds(450, 100, 300, 30);
        layeredPane.add(subtituloLabel, Integer.valueOf(1));

        // Panel para los botones de ubicaciones
        ubicacionesPanel = new JPanel();
        ubicacionesPanel.setOpaque(false); // Fondo transparente
        ubicacionesPanel.setLayout(new GridLayout(0, 3, 20, 20)); // Botones en una cuadrícula
        ubicacionesPanel.setBounds(200, 150, 800, 600); // Posición y tamaño del panel
        layeredPane.add(ubicacionesPanel, Integer.valueOf(1));

        // Botón para volver
        botonVolver = new JButton("Volver");
        botonVolver.setFont(new Font("Arial", Font.BOLD, 20));
        botonVolver.setFocusPainted(false);
        botonVolver.setBounds(50, 50, 125, 40); // Posición y tamaño del botón
        layeredPane.add(botonVolver, Integer.valueOf(1)); // En una capa superior

        // Botón para ver el mapa completo
        botonMapaCompleto = new JButton("Mapa Completo");
        botonMapaCompleto.setFont(new Font("Arial", Font.BOLD, 20));
        botonMapaCompleto.setFocusPainted(false);
        botonMapaCompleto.setBounds(50, 900, 200, 40); // Posición en la esquina inferior izquierda
        layeredPane.add(botonMapaCompleto, Integer.valueOf(1));

        // Agregar el layeredPane al marco
        add(layeredPane);

        // Centrar la ventana
        setLocationRelativeTo(null);
    }

    public void mostrarVista() {
        setVisible(true);
    }

    public void setBotonVolverListener(ActionListener listener) {
        botonVolver.addActionListener(listener);
    }

    public void setBotonMapaCompletoListener(ActionListener listener) {
        botonMapaCompleto.addActionListener(listener);
    }

    public void setUbicaciones(List<String> nombresUbicaciones, List<ActionListener> acciones) {
        // Limpiar el panel antes de agregar los botones
        ubicacionesPanel.removeAll();

        for (int i = 0; i < nombresUbicaciones.size(); i++) {
            JButton botonUbicacion = new JButton(nombresUbicaciones.get(i));
            botonUbicacion.setFont(new Font("Arial", Font.BOLD, 20));
            botonUbicacion.addActionListener(acciones.get(i)); // Asignar la acción correspondiente
            ubicacionesPanel.add(botonUbicacion);
        }

        // Actualizar el panel después de agregar los botones
        ubicacionesPanel.revalidate();
        ubicacionesPanel.repaint();
    }

    public void mostrarMapaCompleto() {
        JFrame ventanaMapaCompleto = new JFrame("Mapa Completo");
        ventanaMapaCompleto.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventanaMapaCompleto.setSize(1280, 720); // Tamaño ajustado al mapa

        // Cargar la imagen desde recursos
        ImageIcon imagenMapa = new ImageIcon(getClass().getResource("/recursos/mapaCompleto.jpeg"));
        JLabel etiquetaImagen = new JLabel(imagenMapa);
        ventanaMapaCompleto.add(etiquetaImagen);

        // Centrar la ventana y mostrarla
        ventanaMapaCompleto.setLocationRelativeTo(null);
        ventanaMapaCompleto.setVisible(true);
    }
}






