package model;

public class Aluno extends Usuario {
    private String matricula;
    private String curso;

    public Aluno(int id, String nome, String email, String senha, String telefone, String matricula, String curso) {
        super(id, nome, email, senha, telefone, "Aluno");
        this.matricula = matricula;
        this.curso = curso;
    }

    public void consultarHorario() {
        System.out.println("Consultando horário do aluno " + this.nome);
    }
}
