import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        EditorDeComposicao editor = new EditorDeComposicao("patio.csv");
        Scanner ler = new Scanner(System.in);
        int opcao;
        do {
            System.out.println("+===========================================+");
            System.out.println("|     1 - Criar uma nova composição         |");
            System.out.println("|     2 - Editar uma composição             |");
            System.out.println("|     3 - Listar todas composições          |");
            System.out.println("|     4 - Desfazer uma composição           |");
            System.out.println("|     5 - Sair                              |");
            System.out.println("+===========================================+");
            System.out.print("Digite a opção: ");
            opcao = ler.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o ID da composicao que deseja inserir: ");
                    int idComposicao = ler.nextInt();
                    editor.listarLocomotivasDisponiveis();
                    System.out.println("Digite o id da Locomotiva que deseja inserir");
                    editor.criarComposicao(idComposicao, ler.nextInt());
                    break;
                case 2:
                    int novaOpcao;
                    System.out.println("Digite o ID da composicao que deseja editar: ");
                    Composicao composicao = editor.buscaComposicao(ler.nextInt());
                    do {
                        System.out.println("+================================================+");
                        System.out.println("|     1 - Inserir uma locomotiva                 |");
                        System.out.println("|     2 - Inserir um vagão                       |");
                        System.out.println("|     3 - Removero último elemento da composição |");
                        System.out.println("|     4 - Listar locomotivas livres              |");
                        System.out.println("|     5 - Listar vagões livres                   |");
                        System.out.println("|     6 - Encerrar a edição da composição        |");
                        System.out.println("+================================================+");
                        novaOpcao = ler.nextInt();

                        switch (novaOpcao) {
                            case 1:
                                System.out.println("Digite o ID da locomotiva que deseja inserir");
                                boolean locResult = composicao.addLocomotiva(editor.buscaLocomotiva(ler.nextInt()));
                                System.out.println(locResult ? "Inserida" : "Não inserida");
                                break;
                            case 2:
                                System.out.println("Digite o ID do vagao que deseja inserir");
                                boolean vagResult = composicao.addVagao(editor.buscaVagao(ler.nextInt()));
                                System.out.println(vagResult ? "Inserido" : "Não inserido");
                                break;
                            case 3:
                                Integer idCarro = composicao.desengatar();
                                if (idCarro != null) {
                                    editor.sinalizarDesengateNoPatio(idCarro);
                                    System.out.println("Desengatado");
                                } else {
                                    System.out.println("Não desengatado");
                                }
                                break;
                            case 4:
                                editor.listarLocomotivasDisponiveis();
                                break;
                            case 5:
                                editor.listarVagoesDisponiveis();
                                break;
                            case 6:
                                break;
                            default:
                                System.out.println("Opção Inválida!");
                                break;
                        }
                    } while (novaOpcao != 6);
                    break;
                case 3:
                    editor.listarComposicoes();
                    break;
                case 4:
                    System.out.println("Digite o ID da composição para ser desfeita");
                    editor.desfazerComposicao(ler.nextInt());
                    break;
                case 5:
                    System.out.println("Fim");
                    break;
                default:
                    System.out.println("Opção Inválida!");
                    break;
            }

        } while (opcao != 5);
    }
}

