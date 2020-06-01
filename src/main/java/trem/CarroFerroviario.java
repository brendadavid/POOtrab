package trem;

public abstract class CarroFerroviario {

    private int id;
    private double cargaMaxima;
    private Integer composicao;

    public CarroFerroviario(int id, double cargaMaxima) {
        this.id = id;
        this.cargaMaxima = cargaMaxima;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getCargaMaxima() {
        return cargaMaxima;
    }

    public void setCargaMaxima(double cargaMaxima) {
        this.cargaMaxima = cargaMaxima;
    }

    public Integer getComposicao() {
        return composicao;
    }

    public void setComposicao(Integer composicao) {
        this.composicao = composicao;
    }

    @Override
    public String toString() {
        return String.format("CarroFerroviario{id=%d, cargaMaxima=%s, composicao=%d}", id, cargaMaxima, composicao);
    }
}
