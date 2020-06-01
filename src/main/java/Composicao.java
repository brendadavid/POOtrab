import trem.CarroFerroviario;
import trem.Locomotiva;
import trem.Vagao;

import java.util.ArrayList;
import java.util.List;

public class Composicao {

    private final List<CarroFerroviario> carros;
    private int id;
    private boolean bloqueado;
    private int vagoesDisponiveisBruto;
    private int vagoesDisponiveis;
    private double cargaDisnivel;

    public Composicao(int id) {
        this.id = id;
        this.vagoesDisponiveisBruto = 0;
        this.vagoesDisponiveis = 0;
        this.cargaDisnivel = 0;
        this.carros = new ArrayList<>();
    }

    public boolean addLocomotiva(Locomotiva loc) {
        if (bloqueado) {
            return false;
        } else {
            carros.add(loc);
            addVagoesMaximos(loc.getVagoesMaximos());
            addCargaMaxima(loc.getCargaMaxima());
            loc.setComposicao(id);
            return true;
        }
    }

    public boolean addVagao(Vagao vag) {
        if (vagoesDisponiveis > 0 && cargaDisnivel - vag.getCargaMaxima() >= 0) {
            this.bloqueado = true;
            carros.add(vag);
            addVagoesMaximos(-1);
            addCargaMaxima(0 - vag.getCargaMaxima());
            vag.setComposicao(id);
            return true;
        } else {
            return false;
        }
    }

    private void addVagoesMaximos(int vagoesMaximos) {
        this.vagoesDisponiveisBruto += vagoesMaximos;
        if (vagoesMaximos > 1) {
            this.vagoesDisponiveis = (int) (this.vagoesDisponiveisBruto * 0.9);
        } else {
            this.vagoesDisponiveis = this.vagoesDisponiveisBruto;
        }
    }

    private void addCargaMaxima(double cargaMaxima) {
        this.cargaDisnivel += cargaMaxima;
    }

    private CarroFerroviario desengatar() {
        if (carros.size() > 1) {
            CarroFerroviario carro = carros.remove(carros.size() - 1);
            carro.setComposicao(null);
            if (carros.size() <= 1) {
                bloqueado = false;
            } else {
                if (carros.get(carros.size() - 1) instanceof Locomotiva) {
                    bloqueado = false;
                }
            }
            return carro;
        } else {
            return null;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<CarroFerroviario> getCarros() {
        return carros;
    }

    public int getCapacidade() {
        return this.vagoesDisponiveis;
    }

    @Override
    public String toString() {
        return String.format(
            "Composicao{" +
                "id=%d, " +
                "bloqueado=%s, " +
                "vagoesDisponiveisBruto=%d, " +
                "vagoesDisponiveis=%d, " +
                "cargaDisnivel=%s, " +
                "carros=\n%s\n}",
            id,
            bloqueado,
            vagoesDisponiveisBruto,
            vagoesDisponiveis,
            cargaDisnivel,
            carros);
    }
}
