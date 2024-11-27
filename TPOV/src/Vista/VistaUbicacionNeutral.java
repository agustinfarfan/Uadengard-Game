package Vista;

import Modelo.Mapa.Ubicacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class VistaUbicacionNeutral extends JFrame {
    private JButton botonVolver;
    private JButton botonDescansar;
    private JButton botonMejorar;
    private JButton botonMisiones;
    private JLabel ubicacionActual;

    public VistaUbicacionNeutral() {
        setTitle("Ubicación Neutral");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 1000);

        // Usar un JLayeredPane para manejar el fondo y los componentes superpuestos
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(1200, 1000));
        setContentPane(layeredPane); // Establece el JLayeredPane como el contenedor principal

        // Panel con fondo de imagen
        JPanel ubicacionesPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon ubiImage = new ImageIcon(getClass().getResource("/recursos/ubicacionNeutral.jpeg")); // Imagen de fondo
                if (ubiImage.getImage() != null) {
                    g.drawImage(ubiImage.getImage(), 0, 0, getWidth(), getHeight(), this);
                } else {
                    System.out.println("Error: No se pudo cargar la imagen de fondo.");
                }
            }
        };
        ubicacionesPanel.setBounds(0, 0, 1200, 1000); // Ocupa todo el espacio de la ventana
        layeredPane.add(ubicacionesPanel, Integer.valueOf(0)); // Fondo en la capa inferior

        // Título de la vista
        JLabel tituloLabel = new JLabel("Ubicación Neutral");
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 30));
        tituloLabel.setForeground(Color.WHITE);
        tituloLabel.setBounds(450, 20, 300, 50); // Ajuste de las coordenadas
        layeredPane.add(tituloLabel, Integer.valueOf(1));

        // Etiqueta para mostrar la ubicación actual
        ubicacionActual = new JLabel("Te encuentras en: ");
        ubicacionActual.setFont(new Font("Arial", Font.PLAIN, 24));
        ubicacionActual.setForeground(Color.WHITE);
        ubicacionActual.setHorizontalAlignment(SwingConstants.CENTER);
        ubicacionActual.setBounds(0, 80, 1200, 30); // Justo debajo del título
        layeredPane.add(ubicacionActual, Integer.valueOf(1));

        // Crear un panel para alinear los botones y hacerlos más grandes
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
        botonDescansar = new JButton("Descansar");
        botonDescansar.setFont(new Font("Arial", Font.BOLD, 20));
        botonDescansar.setFocusPainted(false);
        botonDescansar.setPreferredSize(new Dimension(400, 50));  // Aumenta el tamaño del botón
        panelBotones.add(botonDescansar, gbc);

        // Botón para mejorar personaje
        gbc.gridy++;
        botonMejorar = new JButton("Mejorar Personaje");
        botonMejorar.setFont(new Font("Arial", Font.BOLD, 20));
        botonMejorar.setFocusPainted(false);
        botonMejorar.setPreferredSize(new Dimension(400, 50));  // Aumenta el tamaño del botón
        panelBotones.add(botonMejorar, gbc);

        // Botón para misiones secundarias
        gbc.gridy++;
        botonMisiones = new JButton("Misiones Secundarias");
        botonMisiones.setFont(new Font("Arial", Font.BOLD, 20));
        botonMisiones.setFocusPainted(false);
        botonMisiones.setPreferredSize(new Dimension(400, 50));  // Aumenta el tamaño del botón
        panelBotones.add(botonMisiones, gbc);

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
        setLocationRelativeTo(null);
    }

    public void mostrarVista() {
        setVisible(true);
    }

    public void setBotonVolverListener(ActionListener listener) {
        botonVolver.addActionListener(listener);
    }

    public void setBotonDescansarListener(ActionListener listener) {
        botonDescansar.addActionListener(listener);
    }

    public void setBotonMejorarListener(ActionListener listener) {
        botonMejorar.addActionListener(listener);
    }

    public void setBotonMisionesListener(ActionListener listener) {
        botonMisiones.addActionListener(listener);
    }

    public void setUbicacionActual(Ubicacion ubicacion) {
        ubicacionActual.setText("Te encuentras en: " + ubicacion.getNombre()); // Actualiza el texto dinámicamente
    }
}



