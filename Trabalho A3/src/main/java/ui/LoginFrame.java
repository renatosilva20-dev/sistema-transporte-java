package ui;

import dao.UsuarioDAO;
import model.Usuario;

import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {
    private final UsuarioDAO usuarioDAO = new UsuarioDAO();
    public LoginFrame() {
        usuarioDAO.criarTabela();
        if (usuarioDAO.listarTodos().isEmpty()) inserirExemplos();
        setTitle("Login");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel panel = new JPanel(new GridLayout(3, 2));
        JTextField txtEmail = new JTextField();
        JPasswordField txtSenha = new JPasswordField();
        JButton btnLogin = new JButton("Entrar");
        panel.add(new JLabel("Email:")); panel.add(txtEmail);
        panel.add(new JLabel("Senha:")); panel.add(txtSenha);
        panel.add(new JLabel()); panel.add(btnLogin);
        btnLogin.addActionListener(e -> {
            Usuario u = usuarioDAO.buscarPorEmailESenha(txtEmail.getText(), new String(txtSenha.getPassword()));
            if (u != null) {
                abrirMenu(u);
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Usuário ou senha incorretos.");
            }
        });

        add(panel);
    }

    private void abrirMenu(Usuario u) {
        JFrame menu = new JFrame("Menu - " + u.getTipo());
        menu.setSize(300, 300);
        menu.setLocationRelativeTo(null);
        menu.setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel;

        switch (u.getTipo().toLowerCase()) {
            case "gestor" -> panel = painelGestor(u, menu);
            case "motorista" -> panel = painelMotorista(u, menu);
            case "aluno" -> panel = painelAluno(u, menu);
            default -> panel = painelPadrao(u, menu);
        }


        menu.add(panel);
        menu.setVisible(true);
    }
    private JPanel painelGestor(Usuario u, JFrame menu) {
        JPanel panel = criarPainelBase(u);
        JButton btnRelatorios = new JButton("Relatórios");
        btnRelatorios.addActionListener(e -> new RelatorioFrame().setVisible(true));
        panel.add(btnRelatorios);

        JButton btnListar = new JButton("Listar Usuários");
        btnListar.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnListar.addActionListener(e -> new ListaUsuariosFrame().setVisible(true));

        JButton btnCadastrarUsuario = new JButton("Cadastrar Usuário");
        btnCadastrarUsuario.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnCadastrarUsuario.addActionListener(e -> new CadastroUsuarioFrame().setVisible(true));

        JButton btnCadastrarVeiculo = new JButton("Cadastrar Veículo");
        btnCadastrarVeiculo.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnCadastrarVeiculo.addActionListener(e -> new CadastroVeiculoFrame().setVisible(true));

        JButton btnCadastrarRota = new JButton("Cadastrar Rota");
        btnCadastrarRota.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnCadastrarRota.addActionListener(e -> new CadastroRotaFrame().setVisible(true));
        panel.add(Box.createVerticalStrut(10));
        panel.add(btnListar);
        panel.add(Box.createVerticalStrut(10));
        panel.add(btnCadastrarUsuario);
        panel.add(Box.createVerticalStrut(10));
        panel.add(btnCadastrarVeiculo);
        panel.add(Box.createVerticalStrut(10));
        panel.add(btnCadastrarRota);
        panel.add(Box.createVerticalStrut(10));
        panel.add(btnRelatorios);
        panel.add(Box.createVerticalStrut(20));
        panel.add(botaoDeslogar(menu));
        return panel;

    }


    private JPanel painelMotorista(Usuario u, JFrame menu) {
        JPanel panel = criarPainelBase(u);

        JButton btnIniciar = new JButton("Iniciar Viagem");
        btnIniciar.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnIniciar.addActionListener(e -> JOptionPane.showMessageDialog(menu, "Viagem iniciada!"));

        JButton btnEncerrar = new JButton("Encerrar Viagem");
        btnEncerrar.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnEncerrar.addActionListener(e -> JOptionPane.showMessageDialog(menu, "Viagem encerrada!"));

        panel.add(Box.createVerticalStrut(10));
        panel.add(btnIniciar);
        panel.add(Box.createVerticalStrut(10));
        panel.add(btnEncerrar);

        panel.add(Box.createVerticalStrut(20));
        panel.add(botaoDeslogar(menu));

        return panel;
    }

    private JPanel painelPadrao(Usuario u, JFrame menu) {
        JPanel panel = criarPainelBase(u);

        JLabel lblInfo = new JLabel("Sem ações disponíveis.");
        lblInfo.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(Box.createVerticalStrut(10));
        panel.add(lblInfo);

        panel.add(Box.createVerticalStrut(20));
        panel.add(botaoDeslogar(menu));

        return panel;
    }
    private JPanel criarPainelBase(Usuario u) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel lblBoasVindas = new JLabel("Bem-vindo, " + u.getNome());
        lblBoasVindas.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(lblBoasVindas);

        return panel;
    }

    private JButton botaoDeslogar(JFrame frameAtual) {
        JButton btn = new JButton("Deslogar");
        btn.setAlignmentX(Component.CENTER_ALIGNMENT);
        btn.addActionListener(e -> {
            frameAtual.dispose();
            new LoginFrame().setVisible(true);
        });
        return btn;
    }
    private JPanel painelAluno(Usuario u, JFrame menu) {
        JPanel panel = criarPainelBase(u);

        JButton btnPresenca = new JButton("Marcar Presença");
        btnPresenca.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnPresenca.addActionListener(e -> {
            JOptionPane.showMessageDialog(menu, "Presença marcada com sucesso!");
        });

        JButton btnHorario = new JButton("Consultar Horário");
        btnHorario.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnHorario.addActionListener(e -> {
            JOptionPane.showMessageDialog(menu, "Horário da próxima viagem: 07:00");
        });

        panel.add(Box.createVerticalStrut(10));
        panel.add(btnPresenca);
        panel.add(Box.createVerticalStrut(10));
        panel.add(btnHorario);

        panel.add(Box.createVerticalStrut(20));
        panel.add(botaoDeslogar(menu));

        return panel;
    }




    private void inserirExemplos() {
        usuarioDAO.inserir(new Usuario(0, "Carlos", "carlos@email.com", "123", "99999", "Aluno"));
        usuarioDAO.inserir(new Usuario(0, "João", "joao@email.com", "123", "88888", "Motorista"));
        usuarioDAO.inserir(new Usuario(0, "Maria", "maria@email.com", "123", "77777", "Gestor"));
    }
}