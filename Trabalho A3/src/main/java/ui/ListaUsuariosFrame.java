package ui;

import dao.UsuarioDAO;
import model.Usuario;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class ListaUsuariosFrame extends JFrame {
    public ListaUsuariosFrame() {
        setTitle("Usuários Cadastrados");
        setSize(600, 300);
        setLocationRelativeTo(null);

        UsuarioDAO dao = new UsuarioDAO();
        List<Usuario> usuarios = dao.listarTodos();

        String[] colunas = {"ID", "Nome", "Email", "Telefone", "Tipo"};
        DefaultTableModel model = new DefaultTableModel(colunas, 0);

        for (Usuario u : usuarios) {
            Object[] linha = { u.getId(), u.getNome(), u.getEmail(), u.getTelefone(), u.getTipo() };
            model.addRow(linha);
        }

        JTable tabela = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(tabela);

        add(scrollPane, BorderLayout.CENTER);
    }
}