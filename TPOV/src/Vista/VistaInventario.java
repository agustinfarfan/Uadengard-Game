package Vista;

import Modelo.Misiones.*;
import Modelo.Unidades.Criatura;
import Modelo.Unidades.Dragon;
import Modelo.Unidades.Espectro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class VistaInventario extends JFrame {
    private JButton botonVolver;
    private JPanel panelInventario;

    public VistaInventario() {
        setTitle("Inventario");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 1000);

        // Usar un JLayeredPane para manejar el fondo y los componentes superpuestos
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(1200, 1000));
        setContentPane(layeredPane); // Establecer el JLayeredPane como contenedor principal

        // Panel con fondo de imagen
        JPanel inventarioPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon inventarioImage = new ImageIcon(getClass().getResource("/recursos/stats.png")); // Imagen de fondo
                if (inventarioImage.getImage() != null) {
                    g.drawImage(inventarioImage.getImage(), 0, 0, getWidth(), getHeight(), this);
                } else {
                    System.out.println("Error: No se pudo cargar la imagen de fondo.");
                }
            }
        };
        inventarioPanel.setBounds(0, 0, 1200, 1000); // Ocupa todo el espacio de la ventana
        layeredPane.add(inventarioPanel, Integer.valueOf(0)); // Fondo en la capa inferior

        // Título de la vista
        JLabel tituloLabel = new JLabel("Inventario");
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 30));
        tituloLabel.setForeground(Color.WHITE);
        tituloLabel.setBounds(500, 20, 200, 50); // Centrado del texto en la parte superior
        layeredPane.add(tituloLabel, Integer.valueOf(1)); // Título sobre el fondo


        botonVolver = new JButton("Volver");
        botonVolver.setFont(new Font("Arial", Font.BOLD, 20));
        botonVolver.setBounds(450, 600, 300, 50); // Centrado de botones
        botonVolver.setFocusPainted(false);
        layeredPane.add(botonVolver, Integer.valueOf(2)); // Añadir el botón en una capa superior

        panelInventario = new JPanel();
        panelInventario.setLayout(new FlowLayout());
        panelInventario.setOpaque(false); // Fondo transparente
        panelInventario.setBounds(100, 300, 1000, 300);
        layeredPane.add(panelInventario, Integer.valueOf(1));

        // Centrar la ventana
        setLocationRelativeTo(null);
    }

    public void setInventario(List<MisionSecundaria> misionSecundarias) {
        panelInventario.removeAll(); // Limpiar el panel primero
        for (MisionSecundaria misionSecundaria : misionSecundarias) {
            String rutaImagen = "/recursos/";
            if (misionSecundaria.getEstado().equals("Reclamada")) {
                switch (misionSecundaria) {
                    case MisionAldeaDeLosTrolls misionAldeaDeLosTrolls -> rutaImagen += "escudoTitanio.png";
                    case MisionDerrotarDragon misionDerrotarDragon -> rutaImagen += "espadaFuego.png";
                    case MisionPantanoOscuro misionPantanoOscuro -> rutaImagen += "arcoLuz.png";
                    case MisionRecuperarAmuleto misionRecuperarAmuleto -> rutaImagen += "amuleto.png";
                    default -> throw new IllegalStateException("Unexpected value: " + misionSecundaria);
                }
                // Cargar la imagen y ajustarla
                ImageIcon inventarioImage = new ImageIcon(getClass().getResource(rutaImagen));
                Image img = inventarioImage.getImage().getScaledInstance(175, 175, Image.SCALE_SMOOTH);
                JLabel inventarioLabel = new JLabel(new ImageIcon(img));

                // Agregar al panel
                panelInventario.add(inventarioLabel);
            }
        }
        panelInventario.revalidate();
        panelInventario.repaint();
    }

    // Método que se llama para mostrar la vista
    public void mostrarVista() {
        setVisible(true);
    }

    public void setBotonVolverListener(ActionListener listener) {
        botonVolver.addActionListener(listener);
    }

}
