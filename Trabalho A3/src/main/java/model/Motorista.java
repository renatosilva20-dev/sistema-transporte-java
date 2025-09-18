package model;

public class Motorista extends Usuario {
    private String cnh;
    private String validadeCnh;

    public Motorista(int id, String nome, String email, String senha, String telefone, String cnh, String validadeCnh) {
        super(id, nome, email, senha, telefone, "Motorista");
        this.cnh = cnh;
        this.validadeCnh = validadeCnh;
    }

    public void iniciarViagem() {
        System.out.println("Viagem iniciada pelo motorista " + nome);
    }
}
