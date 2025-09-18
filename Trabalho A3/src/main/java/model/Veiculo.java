package model;

public class Veiculo {
    private int id;
    private String placa;
    private String modelo;
    private int capacidade;

    public Veiculo(int id, String placa, String modelo, int capacidade) {
        this.id = id;
        this.placa = placa;
        this.modelo = modelo;
        this.capacidade = capacidade;
    }

    public int getId() { return id; }
    public String getPlaca() { return placa; }
    public String getModelo() { return modelo; }
    public int getCapacidade() { return capacidade; }
}
