package model;

public class Usuario {
    private int id;
    protected String nome;
    private String email;
    private String senha;
    private String telefone;
    private String tipo;

    public Usuario(int id, String nome, String email, String senha, String telefone, String tipo) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
        this.tipo = tipo;
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getEmail() { return email; }
    public String getSenha() { return senha; }
    public String getTelefone() { return telefone; }
    public String getTipo() { return tipo; }
}