package model;

public class Rota {
    private int id;
    private String origem;
    private String destino;
    private String horario;

    public Rota(int id, String origem, String destino, String horario) {
        this.id = id;
        this.origem = origem;
        this.destino = destino;
        this.horario = horario;
    }

    public int getId() { return id; }
    public String getOrigem() { return origem; }
    public String getDestino() { return destino; }
    public String getHorario() { return horario; }
}