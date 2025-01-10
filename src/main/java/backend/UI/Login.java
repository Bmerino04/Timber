package backend.UI;

import backend.TimberApplication;
import backend.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
@Component

public class Login extends JFrame {
    @Autowired
    private UsuarioService usuarioService;
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

    private class LoginHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String email = emailField.getText();
            char[] password = passwordField.getPassword();

            if (email.isEmpty() || password.length == 0) {
                JOptionPane.showMessageDialog(Login.this, "Por favor, completa todos los campos.");
                return;
            }

            // Crear el servicio y usar el método 'iniciarSesion'
            usuarioService.iniciarSesion(email, String.valueOf(password));

            // Limpiar contraseña por seguridad
            java.util.Arrays.fill(password, ' ');
        }
    }

    private class RegistrationHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
            // Reutiliza el contexto de Spring
            SwingUtilities.invokeLater(() -> {
                Register register = TimberApplication.getContext().getBean(Register.class);
                register.setVisible(true);
            }); // Llamamos al constructor de Register
        }
    }

    public static void main(String[] args) {
        if (GraphicsEnvironment.isHeadless()) {
            System.out.println("El entorno no admite gráficos.");
            return;
        }

        // Código para inicializar la ventana
        javax.swing.SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Login");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(300, 200);
            frame.setVisible(true);
        });
    }
}
