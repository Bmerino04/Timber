package UI;

import backend.services.UsuarioService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 * Clase que representa la ventana de inicio de sesión de la aplicación.
 * Permite a los usuarios iniciar sesión o registrarse.
 */
public class Login extends JFrame {
    private JTextField emailField;
    private JPasswordField passwordField;

    /**
     * Constructor de la clase Login.
     * Inicializa y muestra el panel de inicio de sesión.
     */
    public Login() {
        showLoginPanel();
    }

    /**
     * Configura y muestra el panel de inicio de sesión.
     * Contiene campos para el correo electrónico, contraseña y botones para iniciar sesión o registrarse.
     */
    private void showLoginPanel() {
        setTitle("Inicio de Sesión");
        setSize(400, 200);
        setLocationRelativeTo(null); // Centrar ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel loginPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        loginPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Espacio alrededor

        JLabel emailLabel = new JLabel("Correo electrónico:");
        emailField = new JTextField();
        addPlaceholder(emailField, "Introduce tu correo electrónico");

        JLabel passwordLabel = new JLabel("Contraseña:");
        passwordField = new JPasswordField();
        addPlaceholder(passwordField, "...");

        JButton loginButton = new JButton("Iniciar Sesión");
        loginButton.addActionListener(new LoginHandler());

        JButton registerButton = new JButton("Registrar");
        registerButton.addActionListener(new RegistrationHandler());

        loginPanel.add(emailLabel);
        loginPanel.add(emailField);
        loginPanel.add(passwordLabel);
        loginPanel.add(passwordField);
        loginPanel.add(loginButton);
        loginPanel.add(registerButton);

        add(loginPanel);
        setVisible(true);
    }

    /**
     * Añade un marcador de posición a un campo de texto.
     * Cambia el texto y el color cuando el campo gana o pierde el foco.
     *
     * @param field       El campo de texto al que se añadirá el marcador de posición.
     * @param placeholder El texto del marcador de posición.
     */
    private void addPlaceholder(JTextField field, String placeholder) {
        field.setText(placeholder);
        field.setForeground(Color.GRAY);

        field.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (field.getText().equals(placeholder)) {
                    field.setText("");
                    field.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (field.getText().isEmpty()) {
                    field.setText(placeholder);
                    field.setForeground(Color.GRAY);
                }
            }
        });
    }

    /**
     * Clase interna que maneja el evento de iniciar sesión.
     */
    private class LoginHandler implements ActionListener {
        /**
         * Realiza las acciones necesarias para el inicio de sesión cuando se pulsa el botón.
         *
         * @param e El evento de acción asociado al botón.
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            String email = emailField.getText();
            char[] password = passwordField.getPassword();

            if (email.isEmpty() || password.length == 0) {
                JOptionPane.showMessageDialog(Login.this, "Por favor, completa todos los campos.");
                return;
            }

            // Crear el servicio y usar el método 'iniciarSesion'
            UsuarioService usuarioService = new UsuarioService();
            usuarioService.iniciarSesion(email, String.valueOf(password));

            // Limpiar contraseña por seguridad
            java.util.Arrays.fill(password, ' ');
        }
    }

    /**
     * Clase interna que maneja el evento de registrar un nuevo usuario.
     */
    private class RegistrationHandler implements ActionListener {
        /**
         * Realiza las acciones necesarias para abrir la ventana de registro cuando se pulsa el botón.
         *
         * @param e El evento de acción asociado al botón.
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            // Cierra la ventana de login
            dispose();

            // Abre la ventana de registro
            new Register(); // Llamamos al constructor de Register
        }
    }

    /**
     * Método principal que inicializa la aplicación y muestra la ventana de inicio de sesión.
     *
     * @param args Argumentos de línea de comandos.
     */
    public static void main(String[] args) {
        if (GraphicsEnvironment.isHeadless()) {
            System.out.println("El entorno no admite gráficos.");
            return;
        }

        // Código para inicializar la ventana
        javax.swing.SwingUtilities.invokeLater(() -> {
            JFrame frame = new Login();
        });
    }
}
