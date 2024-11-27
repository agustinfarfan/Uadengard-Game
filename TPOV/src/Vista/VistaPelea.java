package Vista;

import Modelo.Unidades.Criatura;
import Modelo.Unidades.Dragon;
import Modelo.Unidades.Espectro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class VistaPelea extends JFrame {
    private JButton botonPelear;
    private JLabel imagenHeroe;
    private JPanel panelCriaturas;

    public VistaPelea() {
        // Configuración de la ventana principal
        setTitle("Combate");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 1000);

        // Crear un JLayeredPane para gestionar los componentes
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(1200, 1000));
        setContentPane(layeredPane);

        // Panel de fondo
        JPanel fondoPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Cargar la imagen de fondo
                ImageIcon backgroundImage = new ImageIcon(getClass().getResource("/recursos/backgroundPelea.jpg"));
                g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        fondoPanel.setBounds(0, 0, 1200, 1000);
        layeredPane.add(fondoPanel, Integer.valueOf(0));

        // Etiqueta del título "Combate"
        JLabel tituloLabel = new JLabel("Combate");
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 40));
        tituloLabel.setForeground(Color.WHITE);
        tituloLabel.setHorizontalAlignment(SwingConstants.CENTER);
        tituloLabel.setBounds(0, 20, 1200, 50);
        layeredPane.add(tituloLabel, Integer.valueOf(1));

        // Imagen del héroe
        imagenHeroe = new JLabel();
        imagenHeroe.setHorizontalAlignment(SwingConstants.CENTER);
        imagenHeroe.setBounds(450, 100, 300, 300);
        layeredPane.add(imagenHeroe, Integer.valueOf(1));

        // Botón "Pelear"
        botonPelear = new JButton("Pelear");
        botonPelear.setFont(new Font("Arial", Font.BOLD, 20));
        botonPelear.setBounds(500, 450, 200, 50);
        layeredPane.add(botonPelear, Integer.valueOf(1));

        // Panel para mostrar las imágenes de las criaturas
        panelCriaturas = new JPanel();
        panelCriaturas.setLayout(new FlowLayout());
        panelCriaturas.setOpaque(false); // Fondo transparente
        panelCriaturas.setBounds(100, 550, 1000, 300);
        layeredPane.add(panelCriaturas, Integer.valueOf(1));

        // Centrar la ventana
        setLocationRelativeTo(null);
    }

    // Método para mostrar la imagen del héroe
    public void setImagenHeroe(String rutaImagen) {
        ImageIcon heroeImage = new ImageIcon(getClass().getResource(rutaImagen));
        Image img = heroeImage.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH);
        imagenHeroe.setIcon(new ImageIcon(img));
    }

    // Método para agregar imágenes de criaturas según su tipo
    public void setImagenesCriaturas(List<Criatura> criaturas) {
        panelCriaturas.removeAll(); // Limpiar el panel primero
        for (Criatura criatura : criaturas) {
            String rutaImagen = "/recursos/";
            if (criatura instanceof Dragon) {
                rutaImagen += "dragon.png";
            } else if (criatura instanceof Espectro) {
                rutaImagen += "espectro.png";
            } else {
                rutaImagen += "troll.png";
            }
            // Cargar la imagen y ajustarla
            ImageIcon criaturaImage = new ImageIcon(getClass().getResource(rutaImagen));
            Image img = criaturaImage.getImage().getScaledInstance(175, 175, Image.SCALE_SMOOTH);
            JLabel criaturaLabel = new JLabel(new ImageIcon(img));

            // Agregar al panel
            panelCriaturas.add(criaturaLabel);
        }

        panelCriaturas.revalidate();
        panelCriaturas.repaint();
    }


    // Método para agregar un listener al botón "Pelear"
    public void setBotonPelearListener(ActionListener listener) {
        botonPelear.addActionListener(listener);
    }

    // Método para mostrar mensajes de victoria o derrota
    public void mostrarMensajeResultado(String mensaje, boolean victoria) {
        JOptionPane.showMessageDialog(this, mensaje,
                victoria ? "Victoria" : "Derrota",
                victoria ? JOptionPane.INFORMATION_MESSAGE : JOptionPane.ERROR_MESSAGE);
    }

    // Método para mostrar la vista
    public void mostrarVista() {
        setVisible(true);
    }

    // Método para cerrar la vista
    public void cerrarVista() {
        setVisible(false);
    }
}


