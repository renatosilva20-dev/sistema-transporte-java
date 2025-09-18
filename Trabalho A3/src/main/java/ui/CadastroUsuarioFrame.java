package ui;

import dao.UsuarioDAO;
import model.Usuario;

import javax.swing.*;
import java.awt.*;

public class CadastroUsuarioFrame extends JFrame {
    private final UsuarioDAO usuarioDAO = new UsuarioDAO();

    public CadastroUsuarioFrame() {
        setTitle("Cadastrar Usuário");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(6, 2, 5, 5));

        JTextField txtNome = new JTextField();
        JTextField txtEmail = new JTextField();
        JPasswordField txtSenha = new JPasswordField();
        JTextField txtTelefone = new JTextField();

        String[] tipos = {"Aluno", "Motorista", "Gestor"};
        JComboBox<String> comboTipo = new JComboBox<>(tipos);

        JButton btnSalvar = new JButton("Salvar");

        panel.add(new JLabel("Nome:")); panel.add(txtNome);
        panel.add(new JLabel("Email:")); panel.add(txtEmail);
        panel.add(new JLabel("Senha:")); panel.add(txtSenha);
        panel.add(new JLabel("Telefone:")); panel.add(txtTelefone);
        panel.add(new JLabel("Tipo:")); panel.add(comboTipo);
        panel.add(new JLabel()); panel.add(btnSalvar);

        btnSalvar.addActionListener(e -> {
            String nome = txtNome.getText().trim();
            String email = txtEmail.getText().trim();
            String senha = new String(txtSenha.getPassword());
            String telefone = txtTelefone.getText().trim();
            String tipo = (String) comboTipo.getSelectedItem();

            if (nome.isEmpty() || email.isEmpty() || senha.isEmpty() || tipo == null) {
                JOptionPane.showMessageDialog(this, "Preencha todos os campos obrigatórios.");
                return;
            }

            Usuario novoUsuario = new Usuario(0, nome, email, senha, telefone, tipo);
            usuarioDAO.inserir(novoUsuario);
            JOptionPane.showMessageDialog(this, "Usuário cadastrado com sucesso!");
            dispose();
        });

        add(panel);
    }
}
