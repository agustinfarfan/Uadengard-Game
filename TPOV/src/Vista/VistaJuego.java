package Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class VistaJuego extends JFrame {
    private JTextField nombreHeroeField;
    private String tipoHeroeSeleccionado = "";
    private JButton confirmarButton;
    private JButton guerreroButton, magoButton, arqueroButton;

    public VistaJuego() {
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
                    g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };

        backgroundPanel.setLayout(new BoxLayout(backgroundPanel, BoxLayout.Y_AXIS));  // Usamos BoxLayout en dirección vertical

        JPanel titlePanel = new JPanel();
        titlePanel.setOpaque(false); // Hacer transparente el panel
        ImageIcon titleIcon = new ImageIcon(getClass().getResource("/recursos/nombreJuego.png"));// Imagen con el nombre del juego
        titleIcon = new ImageIcon(scaleImage(titleIcon.getImage(), 500, 400));
        if (titleIcon.getImage() == null) {
            System.out.println("Error: No se pudo cargar la imagen del título.");
        }
        JLabel titleLabel = new JLabel(titleIcon);
        titlePanel.add(titleLabel);

        backgroundPanel.add(titlePanel); // Agregar el panel del título al fondo

        // Espaciado entre el título y los botones de héroes
        backgroundPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Ajustar el espacio entre el título y los botones

        // Panel para los campos de entrada y el nombre del héroe
        JPanel inputPanel = new JPanel();
        inputPanel.setOpaque(false);  // Hacer el panel transparente para que se vea el fondo
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        inputPanel.setAlignmentY(Component.CENTER_ALIGNMENT);

// Nombre del héroe
        JLabel nombreLabel = new JLabel("Nombre del Héroe:");
        nombreLabel.setFont(new Font("Arial", Font.BOLD, 16));
        nombreLabel.setForeground(Color.WHITE);  // Hacer la etiqueta blanca
        nombreLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Centrar el nombre
        inputPanel.add(nombreLabel);

        nombreHeroeField = new JTextField();
        nombreHeroeField.setFont(new Font("Arial", Font.PLAIN, 14));
        nombreHeroeField.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2)); // Bordear el campo de texto
        nombreHeroeField.setBackground(new Color(0, 0, 0, 150)); // Fondo semitransparente para el campo
        nombreHeroeField.setForeground(Color.WHITE);  // Texto en blanco
        nombreHeroeField.setMaximumSize(new Dimension(300, 30)); // Establecer un tamaño máximo para que se ajuste bien
        nombreHeroeField.setAlignmentX(Component.CENTER_ALIGNMENT); // Centrar el campo
        inputPanel.add(Box.createRigidArea(new Dimension(0, 5))); // Reducir el espacio entre el label y el campo de texto
        inputPanel.add(nombreHeroeField);

// Agregar el panel de entrada al fondo sin agregar un gran espaciado extra
        backgroundPanel.add(inputPanel);

        // Espaciado entre el campo de texto y los botones de héroes
        backgroundPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Ajustamos el espacio entre el campo de texto y los botones

        // Texto "Selecciona tu héroe" encima de los botones de héroes
        JLabel seleccionHeroeLabel = new JLabel("Selecciona tu héroe: ");
        seleccionHeroeLabel.setFont(new Font("Arial", Font.BOLD, 18));
        seleccionHeroeLabel.setForeground(Color.WHITE);  // Hacer el texto blanco
        seleccionHeroeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        backgroundPanel.add(seleccionHeroeLabel);

        // Espaciado entre el texto y los botones de héroes
        backgroundPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Ajustamos el espacio entre el texto y los botones

        // Panel para los botones de héroes (usando un FlowLayout para que se acomoden horizontalmente)
        JPanel heroSelectionPanel = new JPanel();
        heroSelectionPanel.setOpaque(false); // Transparente
        heroSelectionPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 10));  // Centrar los botones y añadir espacio entre ellos

        // Cargar las imágenes y redimensionarlas manteniendo la transparencia
        ImageIcon guerreroIcon = new ImageIcon(getClass().getResource("/recursos/guerrero.png"));
        ImageIcon magoIcon = new ImageIcon(getClass().getResource("/recursos/mago.png"));
        ImageIcon arqueroIcon = new ImageIcon(getClass().getResource("/recursos/arquero.png"));

        guerreroIcon = new ImageIcon(scaleImage(guerreroIcon.getImage(), 200, 200));
        magoIcon = new ImageIcon(scaleImage(magoIcon.getImage(), 200, 200));
        arqueroIcon = new ImageIcon(scaleImage(arqueroIcon.getImage(), 200, 200));

        // Botones para seleccionar el héroe con imágenes (ajustadas de tamaño)
        guerreroButton = new JButton(guerreroIcon);
        magoButton = new JButton(magoIcon);
        arqueroButton = new JButton(arqueroIcon);

        guerreroButton.setContentAreaFilled(false);
        guerreroButton.setBorderPainted(false);
        magoButton.setContentAreaFilled(false);
        magoButton.setBorderPainted(false);
        arqueroButton.setContentAreaFilled(false);
        arqueroButton.setBorderPainted(false);

        // Agregar los botones al panel
        heroSelectionPanel.add(guerreroButton);
        heroSelectionPanel.add(magoButton);
        heroSelectionPanel.add(arqueroButton);

        // Acción de los botones para seleccionar el héroe
        guerreroButton.addActionListener(e -> tipoHeroeSeleccionado = "Guerrero");
        magoButton.addActionListener(e -> tipoHeroeSeleccionado = "Mago");
        arqueroButton.addActionListener(e -> tipoHeroeSeleccionado = "Arquero");

        // Agregar el panel de selección de héroes al fondo
        backgroundPanel.add(heroSelectionPanel);

        // Espaciado entre los botones de héroes y el botón de confirmación
        backgroundPanel.add(Box.createRigidArea(new Dimension(0, 50))); // Ajustamos el espacio entre los botones y el botón de confirmar

        // Botón de confirmación
        confirmarButton = new JButton("Confirmar");
        confirmarButton.setFont(new Font("Arial", Font.BOLD, 16));
        confirmarButton.setBackground(new Color(50, 150, 50));
        confirmarButton.setForeground(Color.WHITE);
        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false);
        buttonPanel.add(confirmarButton);

        // Agregar el botón de confirmar al fondo
        backgroundPanel.add(buttonPanel);

        // Agregar el fondo a la ventana
        add(backgroundPanel);

        // Centrar ventana en pantalla
        setLocationRelativeTo(null);
    }

    // Método para redimensionar imágenes y mantener la transparencia
    private Image scaleImage(Image srcImg, int w, int h) {
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TRANSLUCENT);
        Graphics2D g = resizedImg.createGraphics();
        g.drawImage(srcImg, 0, 0, w, h, null);
        g.dispose();
        return resizedImg;
    }

    // Métodos para obtener los datos ingresados
    public String getNombreHeroe() {
        return nombreHeroeField.getText();
    }

    public String getTipoHeroe() {
        return tipoHeroeSeleccionado;
    }

    // Validar si el nombre está vacío
    public boolean validarNombre() {
        if (nombreHeroeField.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, ingresa el nombre del héroe.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    // Método para validar si se ha seleccionado un héroe
    public boolean validarSeleccionHeroe() {
        if (tipoHeroeSeleccionado.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona un héroe.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    // Método para asociar un listener al botón de confirmar
    public void setConfirmarListener(ActionListener listener) {
        confirmarButton.addActionListener(e -> {
            // Validar nombre y tipo de héroe
            if (validarNombre() && validarSeleccionHeroe()) {
                // Si ambas validaciones son correctas, mostramos el mensaje de éxito
                JOptionPane.showMessageDialog(this, "¡Héroe configurado exitosamente!");
                // Luego, puedes llamar al listener para realizar otras acciones si es necesario
                listener.actionPerformed(e);
            }
        });
    }

    // Mostrar la ventana
    public void mostrarVista() {
        setVisible(true);
    }
}



















