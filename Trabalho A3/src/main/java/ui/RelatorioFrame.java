package ui;

import dao.RotaDAO;
import dao.UsuarioDAO;
import dao.VeiculoDAO;

import javax.swing.*;
import java.awt.*;

public class RelatorioFrame extends JFrame {
    public RelatorioFrame() {
        setTitle("Relatórios");
        setSize(400, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        VeiculoDAO veiculoDAO = new VeiculoDAO();
        RotaDAO rotaDAO = new RotaDAO();
        usuarioDAO.criarTabela();
        veiculoDAO.criarTabela();
        rotaDAO.criarTabela();

        int totalUsuarios = usuarioDAO.contarUsuarios();
        int totalVeiculos = veiculoDAO.contarVeiculos();
        int totalRotas = rotaDAO.contarRotas();

        JPanel panel = new JPanel(new GridLayout(3, 1, 5, 5));
        panel.add(new JLabel("Total de Usuários: " + totalUsuarios));
        panel.add(new JLabel("Total de Veículos: " + totalVeiculos));
        panel.add(new JLabel("Total de Rotas: " + totalRotas));

        add(panel);
    }
}
