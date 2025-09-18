package model;

public class Gestor extends Usuario {

    public Gestor(int id, String nome, String email, String senha, String telefone) {
        super(id, nome, email, senha, telefone, "Gestor");
    }

    public void gerarRelatorios() {
        System.out.println("Gerando relatórios...");
    }
}
