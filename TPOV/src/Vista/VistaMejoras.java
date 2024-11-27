package Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class VistaMejoras extends JFrame {
    private JButton botonMejorarAtaque;
    private JButton botonMejorarVida;
    private JButton botonMejorarDefensa;
    private JButton botonVolver;
    private JLabel experienciaLabel;// Nueva etiqueta para mostrar la experiencia
    private JButton botonInventario;

    public VistaMejoras() {
        setTitle("Mejoras");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 1000);

        // Usar un JLayeredPane para manejar el fondo y los componentes superpuestos
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(1200, 1000));
        setContentPane(layeredPane); // Establecer el JLayeredPane como contenedor principal

        // Panel con fondo de imagen
        JPanel mejorasPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon mejorasImage = new ImageIcon(getClass().getResource("/recursos/stats.png")); // Imagen de fondo
                if (mejorasImage.getImage() != null) {
                    g.drawImage(mejorasImage.getImage(), 0, 0, getWidth(), getHeight(), this);
                } else {
                    System.out.println("Error: No se pudo cargar la imagen de fondo.");
                }
            }
        };
        mejorasPanel.setBounds(0, 0, 1200, 1000); // Ocupa todo el espacio de la ventana
        layeredPane.add(mejorasPanel, Integer.valueOf(0)); // Fondo en la capa inferior

        // Título de la vista
        JLabel tituloLabel = new JLabel("Mejoras");
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 30));
        tituloLabel.setForeground(Color.WHITE);
        tituloLabel.setBounds(500, 20, 200, 50); // Centrado del texto en la parte superior
        layeredPane.add(tituloLabel, Integer.valueOf(1)); // Título sobre el fondo

        // Etiqueta de experiencia disponible
        experienciaLabel = new JLabel("Experiencia Disponible: ");
        experienciaLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        experienciaLabel.setForeground(Color.WHITE);
        experienciaLabel.setBounds(450, 100, 300, 30); // Posición debajo del título
        layeredPane.add(experienciaLabel, Integer.valueOf(1));

        // Botón para mejorar Ataque
        botonMejorarAtaque = new JButton("Mejorar Ataque");
        botonMejorarAtaque.setFont(new Font("Arial", Font.BOLD, 20));
        botonMejorarAtaque.setBounds(450, 200, 300, 50); // Centrado de botones
        botonMejorarAtaque.setFocusPainted(false);
        layeredPane.add(botonMejorarAtaque, Integer.valueOf(2));

        // Botón para mejorar Vida
        botonMejorarVida = new JButton("Mejorar Vida");
        botonMejorarVida.setFont(new Font("Arial", Font.BOLD, 20));
        botonMejorarVida.setBounds(450, 300, 300, 50); // Centrado de botones
        botonMejorarVida.setFocusPainted(false);
        layeredPane.add(botonMejorarVida, Integer.valueOf(2));

        // Botón para mejorar Defensa
        botonMejorarDefensa = new JButton("Mejorar Defensa");
        botonMejorarDefensa.setFont(new Font("Arial", Font.BOLD, 20));
        botonMejorarDefensa.setBounds(450, 400, 300, 50); // Centrado de botones
        botonMejorarDefensa.setFocusPainted(false);
        layeredPane.add(botonMejorarDefensa, Integer.valueOf(2));

        // Botón para Inventario
        botonInventario = new JButton("Ver Inventario");
        botonInventario.setFont(new Font("Arial", Font.BOLD, 20));
        botonInventario.setBounds(450, 500, 300, 50); // Centrado de botones
        botonInventario.setFocusPainted(false);
        layeredPane.add(botonInventario, Integer.valueOf(2));

        // Botón para Volver
        botonVolver = new JButton("Volver");
        botonVolver.setFont(new Font("Arial", Font.BOLD, 20));
        botonVolver.setBounds(450, 600, 300, 50); // Centrado de botones
        botonVolver.setFocusPainted(false);
        layeredPane.add(botonVolver, Integer.valueOf(2)); // Añadir el botón en una capa superior

        // Centrar la ventana
        setLocationRelativeTo(null);
    }

    // Método para mostrar la experiencia disponible
    public void setExperienciaDisponible(double experiencia) {
        experienciaLabel.setText("Experiencia Disponible: " + experiencia);
    }

    public void mostrarVista() {
        setVisible(true);
    }

    public void setBotonMejorarAtaqueListener(ActionListener listener) {
        botonMejorarAtaque.addActionListener(listener);
    }

    public void setBotonMejorarVidaListener(ActionListener listener) {
        botonMejorarVida.addActionListener(listener);
    }

    public void setBotonMejorarDefensaListener(ActionListener listener) {
        botonMejorarDefensa.addActionListener(listener);
    }

    public void setBotonInventario(ActionListener listener) {
        botonInventario.addActionListener(listener);
    }

    public void setBotonVolverListener(ActionListener listener) {
        botonVolver.addActionListener(listener);
    }

}



