package Vista;

import Modelo.Mapa.Ubicacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class VistaUbicacionHostil extends JFrame {
    private JButton botonVolver;
    private JButton botonPelear;
    private JButton botonBuscarTesoro;
    private JLabel ubicacionActual;

    public VistaUbicacionHostil() {
        setTitle("Ubicacion Hostil");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 1000);

        // Usar un JLayeredPane para manejar el fondo y los componentes superpuestos
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(1200, 1000));

        // Panel con fondo de imagen
        JPanel ubicacionesPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon ubiImage = new ImageIcon(getClass().getResource("/recursos/background.jpg")); // Imagen de fondo
                if (ubiImage.getImage() != null) {
                    g.drawImage(ubiImage.getImage(), 0, 0, getWidth(), getHeight(), this);
                } else {
                    System.out.println("Error: No se pudo cargar la imagen de fondo.");
                }
            }
        };
        ubicacionesPanel.setBounds(0, 0, 1200, 1000); // Ocupa todo el espacio de la ventana
        layeredPane.add(ubicacionesPanel, Integer.valueOf(0)); // Fondo en la capa inferior

        JLabel tituloLabel = new JLabel("Ubicacion Hostil");
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 40));
        tituloLabel.setForeground(Color.WHITE);
        tituloLabel.setBounds(450, 20, 350, 50);
        layeredPane.add(tituloLabel, Integer.valueOf(1));

        // Etiqueta para mostrar la ubicación actual
        ubicacionActual = new JLabel("Te encuentras en: ");
        ubicacionActual.setFont(new Font("Arial", Font.PLAIN, 24));
        ubicacionActual.setForeground(Color.WHITE);
        ubicacionActual.setHorizontalAlignment(SwingConstants.CENTER);
        ubicacionActual.setBounds(0, 80, 1200, 30); // Justo debajo del título
        layeredPane.add(ubicacionActual, Integer.valueOf(1));

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridBagLayout());  // Layout para centrar y ajustar botones
        panelBotones.setOpaque(false);  // Hacerlo transparente para que se vea el fondo

        // Configuración de GridBagConstraints para centrar los botones
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);  // Espaciado entre botones
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Botón para descansar
        botonPelear = new JButton("Pelear");
        botonPelear.setFont(new Font("Arial", Font.BOLD, 20));
        botonPelear.setFocusPainted(false);
        botonPelear.setPreferredSize(new Dimension(400, 50));  // Aumenta el tamaño del botón
        panelBotones.add(botonPelear, gbc);

        // Botón para mejorar personaje
        gbc.gridy++;
        botonBuscarTesoro = new JButton("Buscar Tesoro");
        botonBuscarTesoro.setFont(new Font("Arial", Font.BOLD, 20));
        botonBuscarTesoro.setFocusPainted(false);
        botonBuscarTesoro.setPreferredSize(new Dimension(400, 50));  // Aumenta el tamaño del botón
        panelBotones.add(botonBuscarTesoro, gbc);

        // Botón para volver
        gbc.gridy++;
        botonVolver = new JButton("Volver");
        botonVolver.setFont(new Font("Arial", Font.BOLD, 20));
        botonVolver.setFocusPainted(false);
        botonVolver.setPreferredSize(new Dimension(400, 50));  // Aumenta el tamaño del botón
        panelBotones.add(botonVolver, gbc);

        // Añadir el panel de botones al JLayeredPane
        panelBotones.setBounds(300, 400, 600, 300);  // Ajuste del tamaño y posición
        layeredPane.add(panelBotones, Integer.valueOf(2));  // Añadir los botones en una capa superior

        // Centrar la ventana
        setContentPane(layeredPane);
        setLocationRelativeTo(null);

    }

    public void mostrarVista() {
        setVisible(true);
    }

    public void setBotonVolverListener(ActionListener listener) {
        botonVolver.addActionListener(listener);
    }

    public void setBotonPelearListener(ActionListener listener) {
        botonPelear.addActionListener(listener);
    }

    public void setBotonBuscarTesoroListener(ActionListener listener) {
        botonBuscarTesoro.addActionListener(listener);
    }

    public void mostrarMensajeNoPeleaste(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Advertencia", JOptionPane.ERROR_MESSAGE);
    }

    public void mostrarMensajeResultado(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Advertencia", JOptionPane.ERROR_MESSAGE);
    }

    public void setUbicacionActual(Ubicacion ubicacion) {
        ubicacionActual.setText("Te encuentras en: " + ubicacion.getNombre()); // Actualiza el texto dinámicamente
    }

}



