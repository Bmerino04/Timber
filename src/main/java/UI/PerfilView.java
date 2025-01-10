package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class PerfilView extends JFrame {

    public PerfilView() {
        setTitle("Perfil");
        setSize(400, 350); // Tamaño vertical simulando un teléfono
        setLocationRelativeTo(null); // Centrar ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Barra superior
        JPanel topBar = new JPanel(new BorderLayout());
        topBar.setPreferredSize(new Dimension(400, 50));
        topBar.setBackground(Color.LIGHT_GRAY);

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
        mainContent.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        JLabel titleLabel = new JLabel("Perfil", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel attributesPanel = new JPanel();
        attributesPanel.setLayout(new GridLayout(0, 1, 0, 10)); // Usar GridLayout para alineación izquierda
        attributesPanel.setBackground(Color.WHITE);

        JLabel ageLabel = new JLabel("Edad: 25");
        ageLabel.setFont(new Font("Arial", Font.PLAIN, 14));

        JLabel genderLabel = new JLabel("Género: Masculino");
        genderLabel.setFont(new Font("Arial", Font.PLAIN, 14));

        JLabel cityLabel = new JLabel("Ciudad: Ciudad Ejemplo");
        cityLabel.setFont(new Font("Arial", Font.PLAIN, 14));

        JLabel pronounsLabel = new JLabel("Pronombres: Él/Ello");
        pronounsLabel.setFont(new Font("Arial", Font.PLAIN, 14));

        attributesPanel.add(ageLabel);
        attributesPanel.add(genderLabel);
        attributesPanel.add(cityLabel);
        attributesPanel.add(pronounsLabel);

        JTextArea userBio = new JTextArea("Biografía del usuario...");
        userBio.setWrapStyleWord(true);
        userBio.setLineWrap(true);
        userBio.setEditable(false);
        userBio.setMaximumSize(new Dimension(350, 100));
        userBio.setBorder(BorderFactory.createTitledBorder("Biografía"));

        JButton editProfileButton = new JButton("Editar Perfil");
        editProfileButton.setFont(new Font("Arial", Font.PLAIN, 14));
        editProfileButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        mainContent.add(titleLabel);
        mainContent.add(Box.createRigidArea(new Dimension(0, 20))); // Espaciado
        mainContent.add(attributesPanel);
        mainContent.add(Box.createRigidArea(new Dimension(0, 20))); // Espaciado
        mainContent.add(userBio);
        mainContent.add(Box.createRigidArea(new Dimension(0, 20))); // Espaciado
        mainContent.add(editProfileButton);

        add(mainContent, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(PerfilView::new);
    }
}

