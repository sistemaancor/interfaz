import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JFrame {

    private JTextField userField;
    private JPasswordField passField;
    private JComboBox<String> roleSelector;
    private JLabel errorLabel;

    public LoginForm() {
        setTitle("Login Form");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Crear el panel principal
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        
        // Etiqueta y campo de usuario
        JLabel userLabel = new JLabel("Usuario:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(userLabel, gbc);
        
        userField = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(userField, gbc);
        
        // Etiqueta y campo de contraseña
        JLabel passLabel = new JLabel("Contraseña:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(passLabel, gbc);
        
        passField = new JPasswordField(15);
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(passField, gbc);
        
        // Selector de rol
        JLabel roleLabel = new JLabel("Rol:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(roleLabel, gbc);
        
        String[] roles = {"Administrador", "Usuario", "Invitado"};
        roleSelector = new JComboBox<>(roles);
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(roleSelector, gbc);
        
        // Botón para reiniciar campos
        JButton resetButton = new JButton("Reiniciar");
        gbc.gridx = 0;
        gbc.gridy = 3;
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userField.setText("");
                passField.setText("");
                roleSelector.setSelectedIndex(0);
                errorLabel.setText("");
            }
        });
        panel.add(resetButton, gbc);
        
        // Botón para confirmar datos
        JButton confirmButton = new JButton("Confirmar");
        gbc.gridx = 1;
        gbc.gridy = 3;
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleLogin();
            }
        });
        panel.add(confirmButton, gbc);
        
        // Etiqueta de error
        errorLabel = new JLabel("");
        errorLabel.setForeground(Color.RED);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        panel.add(errorLabel, gbc);
        
        // Añadir el panel a la ventana
        add(panel);
    }
    
    private void handleLogin() {
        String username = userField.getText();
        String password = new String(passField.getPassword());
        String role = (String) roleSelector.getSelectedItem();
        
        if (username.isEmpty() || password.isEmpty() || role == null) {
            errorLabel.setText("Todos los campos son obligatorios.");
        } else {
            errorLabel.setText("Inicio de sesión exitoso.");
            // Aquí puedes añadir la lógica de autenticación
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginForm().setVisible(true);
            }
        });
    }
}