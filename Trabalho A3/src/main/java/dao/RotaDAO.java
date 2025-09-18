package dao;

import database.Database;
import model.Rota;

import java.sql.*;

public class RotaDAO {
    public void criarTabela() {
        String sql = """
            CREATE TABLE IF NOT EXISTS rota (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                origem TEXT NOT NULL,
                destino TEXT NOT NULL,
                horario TEXT NOT NULL
            );
        """;

        try (Connection conn = Database.connect();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void inserir(Rota r) {
        String sql = "INSERT INTO rota (origem, destino, horario) VALUES (?, ?, ?)";
        try (Connection conn = Database.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, r.getOrigem());
            stmt.setString(2, r.getDestino());
            stmt.setString(3, r.getHorario());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public int contarRotas() {
        String sql = "SELECT COUNT(*) FROM rota";
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
