package trem;

public class Vagao extends CarroFerroviario {

    public Vagao(int id, double cargaMaxima) {
        super(id, cargaMaxima);
    }

    @Override
    public String toString() {
        return String.format("Vagao{id=%d, cargaMaxima=%s, composicao=%d}",
            super.getId(), super.getCargaMaxima(), super.getComposicao());
    }
}
