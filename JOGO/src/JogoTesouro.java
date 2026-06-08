import java.util.Scanner;

public class JogoTesouro {

    Scanner leitor = new Scanner(System.in);

    public void exibirMenu() {

        int opcao = 0;

        while (opcao != 5) {

            System.out.println("===== ILHA DOS TESOUROS =====");
            System.out.println("1 - Mostrar instruções");
            System.out.println("2 - Mostrar mapa");
            System.out.println("3 - Jogar");
            System.out.println("4 - Mostrar status");
            System.out.println("5 - Sair");
            System.out.println("Escolha uma opção:");
            opcao = leitor.nextInt();

            switch (opcao) {
                case 1:
                    exibirInstrucoes();
                    break;

                case 2:
                    mostrarMapaExplorado();
                    break;

                case 3:
                    inicializarIlha();
                    inicializarControleExplorado();
                    break;

                case 4:
                    mostrarStatus();
                    break;

                case 5:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção Inválida...");
                    break;
            }
        }

    }

    private void exibirInstrucoes() {
       
    }

    private void mostrarMapaExplorado() {
        
    }

    private void inicializarIlha() {
        
    }

    private void inicializarControleExplorado() {
        
    }

    private void mostrarStatus() {
        
    }

}