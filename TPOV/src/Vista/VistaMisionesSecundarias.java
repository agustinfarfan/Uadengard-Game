package Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class VistaMisionesSecundarias extends JFrame {
    private JButton botonVolver;
    private JPanel panelMisiones;

    public VistaMisionesSecundarias() {
        setTitle("Misiones Secundarias");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 1000);

        // Usar un JLayeredPane para manejar el fondo y componentes superpuestos
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(1200, 1000));
        setContentPane(layeredPane);

        // Panel con fondo
        JPanel misionesSecundariasPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon misionesImage = new ImageIcon(getClass().getResource("/recursos/background.jpg"));
                g.drawImage(misionesImage.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        misionesSecundariasPanel.setBounds(0, 0, 1200, 1000);
        layeredPane.add(misionesSecundariasPanel, Integer.valueOf(0));

        // Contenedor para las misiones
        panelMisiones = new JPanel();
        panelMisiones.setLayout(new GridLayout(0, 2, 20, 10)); // Dos columnas, espacio entre filas
        panelMisiones.setOpaque(false); // Transparente para mostrar el fondo
        JScrollPane scrollPane = new JScrollPane(panelMisiones);
        scrollPane.setBounds(100, 100, 1000, 700);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        layeredPane.add(scrollPane, Integer.valueOf(1));

        // Botón "Volver"
        botonVolver = new JButton("Volver");
        botonVolver.setFont(new Font("Arial", Font.BOLD, 20));
        botonVolver.setBounds(500, 850, 200, 50);
        layeredPane.add(botonVolver, Integer.valueOf(2));

        setLocationRelativeTo(null);
    }

    public void mostrarVista() {
        setVisible(true);
    }

    public void setBotonVolverListener(ActionListener listener) {
        botonVolver.addActionListener(listener);
    }

    public void mostrarMisiones(List<String> nombres, List<String> objetivos, List<String> estados, List<ActionListener> listeners) {
        panelMisiones.removeAll(); // Limpiar contenido anterior

        for (int i = 0; i < nombres.size(); i++) {
            JLabel labelMision = new JLabel("<html><b>" + nombres.get(i) + "</b><br>" + objetivos.get(i) + "</html>");
            labelMision.setFont(new Font("Arial", Font.PLAIN, 16));
            labelMision.setForeground(Color.WHITE);

            JButton botonEstado = new JButton(estados.get(i));
            botonEstado.setFont(new Font("Arial", Font.BOLD, 16));
            botonEstado.addActionListener(listeners.get(i)); // Asigna el listener
            botonEstado.setEnabled(!"Disponible".equals(estados.get(i)) && !"Reclamada".equals(estados.get(i)));

            panelMisiones.add(labelMision); // Columna izquierda
            panelMisiones.add(botonEstado); // Columna derecha
        }

        panelMisiones.revalidate();
        panelMisiones.repaint();
    }
}

