package dao;

import database.Database;
import model.Veiculo;

import java.sql.*;

public class VeiculoDAO {
    public void criarTabela() {
        String sql = """
            CREATE TABLE IF NOT EXISTS veiculo (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                placa TEXT NOT NULL UNIQUE,
                modelo TEXT NOT NULL,
                capacidade INTEGER NOT NULL
            );
        """;

        try (Connection conn = Database.connect();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void inserir(Veiculo v) {
        String sql = "INSERT INTO veiculo (placa, modelo, capacidade) VALUES (?, ?, ?)";
        try (Connection conn = Database.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, v.getPlaca());
            stmt.setString(2, v.getModelo());
            stmt.setInt(3, v.getCapacidade());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public int contarVeiculos() {
        String sql = "SELECT COUNT(*) FROM veiculo";
        try (Connection conn = Database.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

}
