package UI;

import backend.services.PerfilService;
import backend.services.UsuarioService;
import backend.services.ValidadorService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Register extends JFrame {
    private JTextField emailField;
    private JTextField birthdateField;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;

    private JComboBox<String> genderComboBox;
    private JTextField otherGenderField;
    private JTextField cityField;
    private JTextField pronounsField;
    private JTextArea bioField;

    private JPanel firstPanel;
    private JPanel secondPanel;
    private JPanel thirdPanel;
    private CardLayout cardLayout;

    public Register() {
        showRegisterPanel();
    }

    private void showRegisterPanel() {
        setTitle("Registro de Usuario");
        setSize(400, 300);
        setLocationRelativeTo(null); // Centrar ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Usando un CardLayout para manejar los paneles
        cardLayout = new CardLayout();
        setLayout(cardLayout);

        // Panel para la primera parte
        firstPanel = new JPanel(new GridLayout(6, 2, 10, 10));
        firstPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel emailLabel = new JLabel("Correo electrónico:");
        emailField = new JTextField();
        addPlaceholder(emailField, "Introduce tu correo electrónico");

        JLabel birthdateLabel = new JLabel("Fecha de nacimiento:");
        birthdateField = new JTextField();
        addPlaceholder(birthdateField, "dd/mm/aaaa");

        JLabel usernameLabel = new JLabel("Nombre de usuario:");
        usernameField = new JTextField();
        addPlaceholder(usernameField, "Introduce tu nombre de usuario");

        JLabel passwordLabel = new JLabel("Contraseña:");
        passwordField = new JPasswordField();
        addPlaceholder(passwordField, "...");

        JLabel confirmPasswordLabel = new JLabel("Confirmar Contraseña:");
        confirmPasswordField = new JPasswordField();
        addPlaceholder(confirmPasswordField, "...");

        JButton nextButton = new JButton("Siguiente");
        nextButton.addActionListener(new NextButtonHandler());

        firstPanel.add(usernameLabel);
        firstPanel.add(usernameField);
        firstPanel.add(emailLabel);
        firstPanel.add(emailField);
        firstPanel.add(birthdateLabel);
        firstPanel.add(birthdateField);
        firstPanel.add(passwordLabel);
        firstPanel.add(passwordField);
        firstPanel.add(confirmPasswordLabel);
        firstPanel.add(confirmPasswordField);
        firstPanel.add(nextButton);

        // Panel para la segunda parte
        secondPanel = new JPanel(new GridLayout(6, 2, 10, 10));
        secondPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel genderLabel = new JLabel("Género:");
        genderComboBox = new JComboBox<>(new String[] {"Hombre", "Mujer", "Otro"});
        genderComboBox.addActionListener(e -> otherGenderField.setEnabled(genderComboBox.getSelectedIndex() == 2));

        JLabel otherGenderLabel = new JLabel("Otro (especificar):");
        otherGenderField = new JTextField();
        otherGenderField.setEnabled(false);

        JLabel cityLabel = new JLabel("Ciudad:");
        cityField = new JTextField();

        JLabel pronounsLabel = new JLabel("Pronombres:");
        pronounsField = new JTextField();

        JButton nextButton2 = new JButton("Siguiente");
        nextButton2.addActionListener(new NextButtonHandler2());

        secondPanel.add(genderLabel);
        secondPanel.add(genderComboBox);
        secondPanel.add(otherGenderLabel);
        secondPanel.add(otherGenderField);
        secondPanel.add(cityLabel);
        secondPanel.add(cityField);
        secondPanel.add(pronounsLabel);
        secondPanel.add(pronounsField);
        secondPanel.add(nextButton2);

        // Panel para la tercera parte (Biografía)
        thirdPanel = new JPanel(new GridLayout(2, 1, 10, 10));
        thirdPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel bioLabel = new JLabel("Biografía (máximo 199 caracteres):");
        bioField = new JTextArea();
        bioField.setLineWrap(true);
        bioField.setWrapStyleWord(true);

        JButton submitButton = new JButton("Registrar");
        submitButton.addActionListener(new RegistrationHandler());

        thirdPanel.add(bioLabel);
        thirdPanel.add(new JScrollPane(bioField));
        thirdPanel.add(submitButton);

        // Agregar paneles al CardLayout
        add(firstPanel, "first");
        add(secondPanel, "second");
        add(thirdPanel, "third");

        cardLayout.show(getContentPane(), "first");
        setVisible(true);
    }

    private void addPlaceholder(JTextField field, String placeholder) {
        field.setText(placeholder);
        field.setForeground(Color.GRAY);

        field.addFocusListener(new java.awt.event.FocusListener() {
            @Override
            public void focusGained(java.awt.event.FocusEvent e) {
                if (field.getText().equals(placeholder)) {
                    field.setText("");
                    field.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent e) {
                if (field.getText().isEmpty()) {
                    field.setText(placeholder);
                    field.setForeground(Color.GRAY);
                }
            }
        });
    }

    private class NextButtonHandler implements ActionListener {
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

            // Cambiar al siguiente panel
            cardLayout.show(getContentPane(), "second");
        }
    }

    private class NextButtonHandler2 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Cambiar al siguiente panel
            cardLayout.show(getContentPane(), "third");
        }
    }

    private class RegistrationHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String username = usernameField.getText();
            String email = emailField.getText();
            String birthdate = birthdateField.getText();
            String gender = (String) genderComboBox.getSelectedItem();
            String otherGender = otherGenderField.getText();
            String city = cityField.getText();
            String pronouns = pronounsField.getText();
            String bio = bioField.getText();

            // Procesar pronombres a formato lista
            List<String> pronounsList = Arrays.asList(pronouns.split("[/,-]"));

            // Usar UsuarioService para registrar al nuevo usuario
            UsuarioService usuarioService = new UsuarioService();
            usuarioService.setEmail(email);
            usuarioService.setContrasennia(new String(passwordField.getPassword()));
            usuarioService.setFechaNacimiento(birthdate);
            usuarioService.registrarUsuario(); // Crea el perfil automáticamente

            // Configurar el perfil del usuario
            PerfilService perfil = usuarioService.getPerfil();
            if (perfil != null) {
                perfil.setNombreUsuario(username);
                perfil.setCiudadResidencia(city);
                perfil.setGenero(gender.equals("Otro") ? otherGender : gender);
                perfil.setPronombres(pronounsList);
                perfil.setBiografia(bio);
            }

            JOptionPane.showMessageDialog(Register.this, "Registro exitoso.");
            dispose();

            // Abrir ventana de login o principal
            new Login();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Register::new);
    }
}
