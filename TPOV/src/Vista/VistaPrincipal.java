package Vista;

import Modelo.Unidades.Heroe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class VistaPrincipal extends JFrame {
    private JButton botonHeroe;
    private JButton botonUbicacion;
    private JButton botonMapa;

    public VistaPrincipal() {
        // Configuración básica de la ventana
        setTitle("Uadengard");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1850, 1000);
        setLayout(new BorderLayout());

        // Panel con fondo de imagen
        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon backgroundImage = new ImageIcon(getClass().getResource("/recursos/background.jpg")); // Imagen de fondo
                if (backgroundImage.getImage() != null) {
                    g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), this);
                } else {
                    System.out.println("Error: No se pudo cargar la imagen de fondo.");
                }
            }
        };
        backgroundPanel.setLayout(new BorderLayout());

        // Panel del título
        JPanel titlePanel = new JPanel();
        titlePanel.setOpaque(false);
        ImageIcon titleIcon = new ImageIcon(getClass().getResource("/recursos/nombreJuego.png"));
        titleIcon = new ImageIcon(scaleImage(titleIcon.getImage(), 400, 300));
        JLabel titleLabel = new JLabel(titleIcon);
        titlePanel.add(titleLabel);

        backgroundPanel.add(titlePanel, BorderLayout.NORTH);

        // Panel para héroe, ubicación y mapa (horizontalmente alineados)
        JPanel centralPanel = new JPanel();
        centralPanel.setOpaque(false);
        centralPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 0)); // Centrado horizontalmente con espacio entre componentes

        // Panel del héroe
        JPanel heroePanel = new JPanel();
        heroePanel.setOpaque(false);
        heroePanel.setLayout(new BoxLayout(heroePanel, BoxLayout.Y_AXIS)); // Botón y nombre en vertical

        botonHeroe = new JButton();
        botonHeroe.setOpaque(false);
        botonHeroe.setContentAreaFilled(false);
        botonHeroe.setBorderPainted(false);
        botonHeroe.setAlignmentX(Component.CENTER_ALIGNMENT);
        heroePanel.add(botonHeroe);

        centralPanel.add(heroePanel); // Agregar héroe al panel central

        // Panel de la ubicación
        JPanel ubicacionPanel = new JPanel();
        ubicacionPanel.setOpaque(false);
        ubicacionPanel.setLayout(new BoxLayout(ubicacionPanel, BoxLayout.Y_AXIS)); // Botón y nombre en vertical

        botonUbicacion = new JButton();
        botonUbicacion.setOpaque(false);
        botonUbicacion.setContentAreaFilled(false);
        botonUbicacion.setBorderPainted(false);
        botonUbicacion.setAlignmentX(Component.CENTER_ALIGNMENT);
        ubicacionPanel.add(botonUbicacion);

        centralPanel.add(ubicacionPanel); // Agregar ubicación al panel central

        // Panel del mapa (a la derecha de la ubicación)
        JPanel mapaPanel = new JPanel();
        mapaPanel.setOpaque(false);
        mapaPanel.setLayout(new BoxLayout(mapaPanel, BoxLayout.Y_AXIS));// Botón y nombre en vertical

        botonMapa = new JButton();
        botonMapa.setOpaque(false);
        botonMapa.setContentAreaFilled(false);
        botonMapa.setBorderPainted(false);
        botonMapa.setAlignmentX(Component.CENTER_ALIGNMENT);
        mapaPanel.add(botonMapa);

        // Etiqueta "Mapa" debajo de la imagen del mapa
        JLabel mapaLabel = new JLabel("Mapa");
        mapaLabel.setFont(new Font("Arial", Font.BOLD, 30));
        mapaLabel.setForeground(Color.WHITE);
        mapaLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mapaPanel.add(mapaLabel);

        centralPanel.add(mapaPanel); // Agregar mapa al panel central

        backgroundPanel.add(centralPanel, BorderLayout.CENTER);

        // Agregar el panel de fondo a la ventana principal
        add(backgroundPanel);

        // Centrar la ventana
        setLocationRelativeTo(null);
    }

    public void mostrarVista() {
        setVisible(true);
    }

    public void setImagenHeroe(ImageIcon imagenHeroe, Heroe heroe) {
        // Configurar la imagen del héroe
        Image scaledImage = scaleImage(imagenHeroe.getImage(), 300, 300);
        botonHeroe.setIcon(new ImageIcon(scaledImage));

        // Agregar el nombre del héroe
        JLabel nombreLabel = new JLabel(heroe.getNombre());
        nombreLabel.setFont(new Font("Arial", Font.BOLD, 30));
        nombreLabel.setForeground(Color.WHITE);
        nombreLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Asegurar que solo haya un nombre en el panel
        JPanel heroePanel = (JPanel) botonHeroe.getParent();
        if (heroePanel.getComponentCount() > 1) {
            heroePanel.remove(1);
        }
        heroePanel.add(nombreLabel);
        heroePanel.revalidate();
        heroePanel.repaint();
    }

    public void setImagenUbicacion(ImageIcon imagenUbicacion, String nombreUbicacion) {
        // Configurar la imagen de la ubicación
        Image scaledImage = scaleImage(imagenUbicacion.getImage(), 300, 300);
        botonUbicacion.setIcon(new ImageIcon(scaledImage));

        // Agregar el nombre de la ubicación
        JLabel nombreLabel = new JLabel(nombreUbicacion);
        nombreLabel.setFont(new Font("Arial", Font.BOLD, 30));
        nombreLabel.setForeground(Color.WHITE);
        nombreLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Asegurar que solo haya un nombre en el panel
        JPanel ubicacionPanel = (JPanel) botonUbicacion.getParent();
        if (ubicacionPanel.getComponentCount() > 1) {
            ubicacionPanel.remove(1);
        }
        ubicacionPanel.add(nombreLabel);
        ubicacionPanel.revalidate();
        ubicacionPanel.repaint();
    }

    public void setImagenMapa(ImageIcon imagenMapa) {
        // Configurar la imagen del mapa
        Image scaledImage = scaleImage(imagenMapa.getImage(), 300, 300);
        botonMapa.setIcon(new ImageIcon(scaledImage));
    }

    public void setBotonHeroeListener(ActionListener listener) {
        botonHeroe.addActionListener(listener);
    }

    public void setBotonUbicacionListener(ActionListener listener) {
        botonUbicacion.addActionListener(listener);
    }

    public void setBotonMapaListener(ActionListener listener) {
        botonMapa.addActionListener(listener);
    }

    // Método para redimensionar imágenes
    private Image scaleImage(Image srcImg, int w, int h) {
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TRANSLUCENT);
        Graphics2D g = resizedImg.createGraphics();
        g.drawImage(srcImg, 0, 0, w, h, null);
        g.dispose();
        return resizedImg;
    }
}






