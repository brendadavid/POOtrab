import trem.Locomotiva;
import trem.Vagao;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.emptyList;
import static java.util.Collections.replaceAll;

public class EditorDeComposicao {

    private final Patio patio;
    private final List<Composicao> composicoes;

    public EditorDeComposicao() {
        this.patio = new Patio(emptyList());
        this.composicoes = new ArrayList<>();
    }

    public EditorDeComposicao(String path) {
        this.composicoes = new ArrayList<>();
        this.patio = new Patio(path);
    }

    public Composicao buscaComposicao(int id){
        return composicoes.stream()
            .filter(carro -> id == carro.getId())
            .findFirst()
            .orElseThrow(() -> new RuntimeException("Composição não encontrada"));
    }

    public void criarComposicao(int id, int idLocomotiva) {
        Locomotiva loc = patio.buscaLocomotiva(idLocomotiva);
        Composicao composicao = new Composicao(id);
        composicao.addLocomotiva(loc);
        composicoes.add(composicao);
    }

    public void listarComposicoes() {
        patio.listar();
        System.out.println("\n");
        composicoes.forEach(Composicao::listar);
    }

    public void listarLocomotivasDisponiveis(){
        patio.listarLocomotivasDisponiveis();
    }

    public void listarVagoesDisponiveis(){
        patio.listarVagoesDisponiveis();
    }

    public Locomotiva buscaLocomotiva(int id){
        return patio.buscaLocomotiva(id);
    }

    public Vagao buscaVagao(int id){
        return patio.buscaVagao(id);
    }

    public void sinalizarDesengateNoPatio(int idCarro) {
        patio.getCarrosFerroviarios().forEach(carro -> {
            if(idCarro == carro.getId()){
                carro.setComposicao(null);
            }
        });
    }

    public void desfazerComposicao(int id) {
        composicoes.removeIf(composicao -> {
            if (id == composicao.getId()){
                removeComposicaoDoCarroNoPatio(id);
                return true;
            }
            return false;
        });
    }

    private void removeComposicaoDoCarroNoPatio(Integer id) {
        patio.getCarrosFerroviarios().forEach(carro -> {
            if(id.equals(carro.getComposicao())){
                carro.setComposicao(null);
            }
        });
    }
}
