package UI;

import backend.services.PerfilService;
import backend.services.UsuarioService;
import backend.services.ValidadorService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Register extends JFrame {
    private JTextField emailField;
    private JTextField birthdateField;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;

    public Register() {
        showRegisterPanel();
    }

    private void showRegisterPanel() {
        setTitle("Registro de Usuario");
        setSize(400, 300);
        setLocationRelativeTo(null); // Centrar ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel registerPanel = new JPanel(new GridLayout(6, 2, 10, 10));
        registerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Espacio alrededor

        JLabel emailLabel = new JLabel("Correo electrónico:");
        emailField = new JTextField();
        JLabel birthdateLabel = new JLabel("Fecha de nacimiento:");
        birthdateField = new JTextField();
        JLabel usernameLabel = new JLabel("Nombre de usuario:");
        usernameField = new JTextField();
        JLabel passwordLabel = new JLabel("Contraseña:");
        passwordField = new JPasswordField();
        JLabel confirmPasswordLabel = new JLabel("Confirmar Contraseña:");
        confirmPasswordField = new JPasswordField();

        JButton registerButton = new JButton("Registrar");
        registerButton.addActionListener(new RegistrationHandler());

        registerPanel.add(emailLabel);
        registerPanel.add(emailField);
        registerPanel.add(birthdateLabel);
        registerPanel.add(birthdateField);
        registerPanel.add(usernameLabel);
        registerPanel.add(usernameField);
        registerPanel.add(passwordLabel);
        registerPanel.add(passwordField);
        registerPanel.add(confirmPasswordLabel);
        registerPanel.add(confirmPasswordField);
        registerPanel.add(registerButton);

        add(registerPanel);
        setVisible(true);
    }

    private class RegistrationHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String username = usernameField.getText();
            String email = emailField.getText();
            String birthdate = birthdateField.getText();
            char[] password = passwordField.getPassword();
            char[] confirmPassword = confirmPasswordField.getPassword();

            // Validaciones de campos vacíos
            if (email.isEmpty() || birthdate.isEmpty() || username.isEmpty() || password.length == 0 || confirmPassword.length == 0) {
                JOptionPane.showMessageDialog(Register.this, "Por favor, completa todos los campos.");
                return;
            }

            // Validación de fecha de nacimiento
            if (!ValidadorService.esFechaValida(birthdate)) {
                JOptionPane.showMessageDialog(Register.this, "La fecha de nacimiento no es válida. Use el formato dd/mm/aaaa.");
                return;
            }

            // Validación de correo electrónico
            if (!ValidadorService.esEmailValido(email)) {
                JOptionPane.showMessageDialog(Register.this, "El correo electrónico no es válido.");
                return;
            }

            // Validación de contraseñas coincidentes
            if (!String.valueOf(password).equals(String.valueOf(confirmPassword))) {
                JOptionPane.showMessageDialog(Register.this, "Las contraseñas no coinciden. Inténtalo nuevamente.");
                return;
            }

            // Usar UsuarioService para registrar al nuevo usuario
            UsuarioService usuarioService = new UsuarioService();
            usuarioService.setEmail(email);
            usuarioService.setContrasennia(String.valueOf(password));
            usuarioService.registrarUsuario(); // Crea el perfil automáticamente

            // Configurar el perfil del usuario
            PerfilService perfil = usuarioService.getPerfil();
            if (perfil != null) {
                perfil.setNombreUsuario(username);
                perfil.setCiudadResidencia("Tu Ciudad"); // Puedes obtener esto de otro campo de entrada
                perfil.setGenero("Género"); // Puedes agregar más campos en el formulario para estos valores
                perfil.setBiografia("Bio");
            }

            JOptionPane.showMessageDialog(Register.this, "Registro exitoso.");
            dispose(); // Cerrar la ventana de registro después de registrar

            // Opcional: abrir ventana de login o una nueva vista principal
            new Login(); // Reabrir la ventana de login
        }
    }

}
