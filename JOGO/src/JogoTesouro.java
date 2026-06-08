import java.util.Scanner;

public class JogoTesouro {

    Scanner leitor = new Scanner(System.in);
    String[] ilhas = new String[15];

    public void exibirMenu() {

        int opcao = 0;

        while (opcao != 5) {

            System.out.println("===== ILHA DOS TESOUROS =====");
            System.out.println("1 - Mostrar instruções");
            System.out.println("2 - Mostrar mapa");
            System.out.println("3 - Jogar");
            System.out.println("4 - Mostrar status");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = leitor.nextInt();

            switch (opcao) {
                case 1:
                    exibirInstrucoes();
                    break;

                case 2:
                    mostrarMapaExplorado();
                    break;

                case 3:
                    
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
        System.out.println("\nBem vindo ao jogo da Ilha dos Tesouros! \r\n" + //
                            "Tente sobreviver as armadilhas, resgate tesouros e ganhe pontos.Explore esse novo mundo e vença para sair vivo!");
                    System.out.println("\n===== Como jogar =====");
                    System.out.println(
                            "Para escolher uma ilha você deve digitar o número desejado. Cada ilha pode conter um tesouro, uma armadilha ou estar vazia.\r\n"
                                    + //
                                    "");
                    System.out.println("===== Tesouros =====");
                    System.out.println("Os tesouros escondidos são: Ouro, Diamante e Rubi.");
                    System.out.println("\n===== Armadilhas =====");
                    System.out.println("As armadilhas espalhadas pelas ilhas são: Buraco, Cobra e Espinhos.");
                    System.out.println("\n===== Ilhas vazias =====");
                    System.out.println(
                            "Se em uma tentativa o jogador escolher e cair em uma ilha vazia ele não pontua, e não perde pontos também."
                                    + //
                                    "");
                    System.out.println("\n===== Pontuação =====");
                    System.out.println("Ouro      |     +10 pontos");
                    System.out.println("Diamante  |     +20 pontos");
                    System.out.println("Rubi      |     +15 pontos");
                    System.out.println("Cobra     |     -10 pontos");
                    System.out.println("Espinhos  |     -7 pontos");
                    System.out.println("Buraco    |     -5 pontos");
                    System.out.println("Vazio     |      0 pontos");
                    System.out.println("\n===== Tentativas =====");
                    System.out.println(
                            "O jogador tem direito a 8 rodadas. Se ao final dessas rodadas ele tiver pontos positivos o jogador vence o jogo, se a pontuação for negativa ele perde o jogo. Se desejar finalizar o jogo antes, precisa ir ao menu inicial e escolher a opção \"5 - Sair\".");
                    System.out.println();

    }

    private void mostrarMapaExplorado() {

    }

    private void inicializarIlha() {
        for (int i = 0; i < ilhas.length; i++) {
            ilhas[i] = sortear();
        }
    }

    private void inicializarControleExplorado() {

    }

    private void mostrarStatus() {

    }

    private String sortear() {
        String[] tipos = {"VAZIO", "OURO", "DIAMANTE","RUBI", "BURADO", "COBRA", "ESPINHOS"};
      

        int posicao = (int)(Math.random() * 7);
        System.out.println(posicao + " " + tipos[posicao]);


        return tipos[posicao];
    }

    private void lerPosicao(){

    }

    private void posicaoJaExplorada(){

    }

    private void calcularPontuacao(){

    }

    private void contarTesouros(){

    }

    private void verificarFimDeJogo(){

    }

    private void perguntarSeDesejaReiniciar(){


    }

    private void reiniciarJogo(){

    }

    private void mostrarResultadoFinal(){
        
    }

    

}