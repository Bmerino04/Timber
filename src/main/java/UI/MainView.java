package UI;

import javax.swing.*;
import java.awt.*;

/**
 * MainView representa la vista principal de la aplicación.
 * Simula una interfaz vertical similar a la de un teléfono.
 */
public class MainView extends JFrame {

    /**
     * Constructor de la clase MainView.
     * Configura los elementos principales de la interfaz gráfica, incluyendo una barra superior, contenido central, y una barra inferior.
     */
    public MainView() {
        // Configuración básica de la ventana
        setTitle("Vista Principal");
        setSize(400, 700); // Tamaño vertical simulando un teléfono
        setLocationRelativeTo(null); // Centrar ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Barra superior
        JPanel topBar = new JPanel(new BorderLayout());
        topBar.setPreferredSize(new Dimension(400, 50));
        topBar.setBackground(Color.LIGHT_GRAY);

        // Elementos de la barra superior
        JLabel logoPlaceholder = new JLabel("LOGO", SwingConstants.LEFT);
        logoPlaceholder.setPreferredSize(new Dimension(100, 50));
        logoPlaceholder.setHorizontalAlignment(SwingConstants.CENTER);
        topBar.add(logoPlaceholder, BorderLayout.WEST);

        JButton profileButton = new JButton("Perfil");
        profileButton.setPreferredSize(new Dimension(50, 50));
        topBar.add(profileButton, BorderLayout.EAST);

        add(topBar, BorderLayout.NORTH);

        // Contenido principal
        JPanel mainContent = new JPanel();
        mainContent.setLayout(new BoxLayout(mainContent, BoxLayout.Y_AXIS));
        mainContent.setBackground(Color.WHITE);

        // Elementos del contenido principal
        JLabel profilePicPlaceholder = new JLabel("Foto de Perfil", SwingConstants.CENTER);
        profilePicPlaceholder.setPreferredSize(new Dimension(100, 100));
        profilePicPlaceholder.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        profilePicPlaceholder.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel usernameLabel = new JLabel("Nombre de Usuario");
        usernameLabel.setFont(new Font("Arial", Font.BOLD, 16));
        usernameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextArea userBio = new JTextArea("Biografía del usuario...");
        userBio.setWrapStyleWord(true);
        userBio.setLineWrap(true);
        userBio.setEditable(false);
        userBio.setMaximumSize(new Dimension(350, 100));
        userBio.setAlignmentX(Component.CENTER_ALIGNMENT);
        userBio.setBorder(BorderFactory.createTitledBorder("Biografía"));

        // Añadir componentes al contenido principal con espaciado
        mainContent.add(Box.createRigidArea(new Dimension(0, 20))); // Espaciado
        mainContent.add(profilePicPlaceholder);
        mainContent.add(Box.createRigidArea(new Dimension(0, 10))); // Espaciado
        mainContent.add(usernameLabel);
        mainContent.add(Box.createRigidArea(new Dimension(0, 10))); // Espaciado
        mainContent.add(userBio);

        add(mainContent, BorderLayout.CENTER);

        // Barra inferior con botones redondos
        JPanel bottomBar = new JPanel(new GridLayout(1, 3));
        bottomBar.setPreferredSize(new Dimension(400, 50));
        bottomBar.setBackground(Color.LIGHT_GRAY);

        // Botones de la barra inferior
        JButton greenButton = new JButton();
        greenButton.setBackground(Color.GREEN);
        greenButton.setOpaque(true);
        greenButton.setBorderPainted(false);

        JButton blueButton = new JButton();
        blueButton.setBackground(Color.BLUE);
        blueButton.setOpaque(true);
        blueButton.setBorderPainted(false);

        JButton redButton = new JButton();
        redButton.setBackground(Color.RED);
        redButton.setOpaque(true);
        redButton.setBorderPainted(false);

        // Añadir botones a la barra inferior
        bottomBar.add(greenButton);
        bottomBar.add(blueButton);
        bottomBar.add(redButton);

        add(bottomBar, BorderLayout.SOUTH);

        // Hacer visible la ventana
        setVisible(true);
    }

    /**
     * Método principal para ejecutar la aplicación.
     * Inicializa la vista principal en el hilo de eventos de Swing.
     *
     * @param args Argumentos de línea de comando.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainView::new);
    }
}
