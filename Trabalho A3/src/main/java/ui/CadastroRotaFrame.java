package ui;

import dao.RotaDAO;
import model.Rota;

import javax.swing.*;
import java.awt.*;

public class CadastroRotaFrame extends JFrame {
    public CadastroRotaFrame() {
        setTitle("Cadastro de Rota");
        setSize(350, 250);
        setLocationRelativeTo(null);

        RotaDAO dao = new RotaDAO();
        dao.criarTabela();

        JPanel panel = new JPanel(new GridLayout(4, 2, 5, 5));
        JTextField txtOrigem = new JTextField();
        JTextField txtDestino = new JTextField();
        JTextField txtHorario = new JTextField();
        JButton btnSalvar = new JButton("Salvar");

        panel.add(new JLabel("Origem:"));   panel.add(txtOrigem);
        panel.add(new JLabel("Destino:"));  panel.add(txtDestino);
        panel.add(new JLabel("Horário:"));  panel.add(txtHorario);
        panel.add(new JLabel());            panel.add(btnSalvar);

        btnSalvar.addActionListener(e -> {
            String origem = txtOrigem.getText();
            String destino = txtDestino.getText();
            String horario = txtHorario.getText();

            dao.inserir(new Rota(0, origem, destino, horario));
            JOptionPane.showMessageDialog(this, "Rota cadastrada com sucesso!");
            dispose();
        });

        add(panel);
    }
}
