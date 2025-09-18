package ui;

import dao.VeiculoDAO;
import model.Veiculo;

import javax.swing.*;
import java.awt.*;

public class CadastroVeiculoFrame extends JFrame {
    public CadastroVeiculoFrame() {
        setTitle("Cadastro de Veículo");
        setSize(350, 250);
        setLocationRelativeTo(null);

        VeiculoDAO dao = new VeiculoDAO();
        dao.criarTabela();

        JPanel panel = new JPanel(new GridLayout(4, 2, 5, 5));
        JTextField txtPlaca = new JTextField();
        JTextField txtModelo = new JTextField();
        JTextField txtCapacidade = new JTextField();
        JButton btnSalvar = new JButton("Salvar");

        panel.add(new JLabel("Placa:"));       panel.add(txtPlaca);
        panel.add(new JLabel("Modelo:"));      panel.add(txtModelo);
        panel.add(new JLabel("Capacidade:"));  panel.add(txtCapacidade);
        panel.add(new JLabel());               panel.add(btnSalvar);

        btnSalvar.addActionListener(e -> {
            try {
                String placa = txtPlaca.getText();
                String modelo = txtModelo.getText();
                int capacidade = Integer.parseInt(txtCapacidade.getText());

                dao.inserir(new Veiculo(0, placa, modelo, capacidade));
                JOptionPane.showMessageDialog(this, "Veículo cadastrado com sucesso!");
                dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Capacidade deve ser um número inteiro.");
            }
        });

        add(panel);
    }
}
