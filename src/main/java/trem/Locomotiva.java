package trem;

public class Locomotiva extends CarroFerroviario {

    private int vagoesMaximos;

    public Locomotiva(int id, double cargaMaxima, int vagoesMaximos) {
        super(id, cargaMaxima);
        this.vagoesMaximos = vagoesMaximos;
    }

    public int getVagoesMaximos() {
        return vagoesMaximos;
    }

    public void setVagoesMaximos(int vagoesMaximos) {
        this.vagoesMaximos = vagoesMaximos;
    }

    @Override
    public String toString() {
        return String.format("Locomotiva{vagoesMaximos=%d id=%d, cargaMaxima=%s, composicao=%d}",
            this.getVagoesMaximos(), super.getId(), super.getCargaMaxima(), super.getComposicao());
    }
}

