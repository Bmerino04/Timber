package UI;

import backend.services.UsuarioService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {
    private JTextField emailField;
    private JPasswordField passwordField;

    public Login() {
        showLoginPanel();
    }

    private void showLoginPanel() {
        setTitle("Inicio de Sesión");
        setSize(400, 200);
        setLocationRelativeTo(null); // Centrar ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel loginPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        loginPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Espacio alrededor

        JLabel emailLabel = new JLabel("Correo electrónico:");
        emailField = new JTextField();
        JLabel passwordLabel = new JLabel("Contraseña:");
        passwordField = new JPasswordField();

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

    private class LoginHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String email = emailField.getText();
            char[] password = passwordField.getPassword();

            if (email.isEmpty() || password.length == 0) {
                JOptionPane.showMessageDialog(Login.this, "Por favor, completa todos los campos.");
                return;
            }

            UsuarioService usuarioService = new UsuarioService();
            if (usuarioService.validarInformacion(email, String.valueOf(password))) {
                JOptionPane.showMessageDialog(Login.this, "Inicio de sesión exitoso.");
                // Aquí se abriría la siguiente vista del sistema
                dispose(); // Cierra la ventana de login
                // Si quieres abrir una nueva ventana principal o dashboard, puedes hacerlo aquí
            } else {
                JOptionPane.showMessageDialog(Login.this, "Correo electrónico o contraseña incorrectos.");
            }

            // Limpiar contraseña por seguridad
            java.util.Arrays.fill(password, ' ');
        }
    }

    private class RegistrationHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Cierra la ventana de login
            dispose();

            // Abre la ventana de registro
            new Register(); // Llamamos al constructor de Register
        }
    }
}
