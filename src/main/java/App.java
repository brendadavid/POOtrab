import trem.Locomotiva;
import trem.Vagao;

import java.util.Random;

public class App {
    public static void main(String[] args) {

        Patio patio = new Patio("trens.csv");
        Random random = new Random();
        int idComposicao = random.nextInt();

        Composicao composicao = new Composicao(idComposicao);
        patio.getCarrosFerroviarios().removeIf(carro -> {
            if(carro instanceof Locomotiva){
                return composicao.addLocomotiva((Locomotiva) carro);
            } else if(carro instanceof Vagao){
                return composicao.addVagao((Vagao) carro);
            } else {
                return false;
            }
        });
        composicao.getCarros().stream().forEach(System.out::println);
        patio.getCarrosFerroviarios().stream().forEach(System.out::println);
    }
}

