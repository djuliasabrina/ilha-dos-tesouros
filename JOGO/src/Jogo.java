import java.util.Scanner;

public class Jogo {

    public Jogo() {
        Scanner leitor = new Scanner(System.in);
        String[] ilhas = new String[15]; // vetor principal

        inicializarIlha(ilhas);

        iniciar(leitor, ilhas);

        leitor.close();
    }

    public void iniciar(Scanner leitor, String[] ilhas) {
        System.out.println("Bem-vindo ao jogo Ilha dos Tesouros!");
        System.out.println("A ilha possui 15 posições, numeradas de 0 a 14.");
        System.out.println("Você possui 8 tentativas para encontrar os tesouros.");

        int pontuacaoAtual = 0;
        int tentativas = 8;
        int tesourosEncontrados = 0;
        int armadilhasEncontradas = 0;
        int posicoesVaziasEncontradas = 0;
        boolean[] exploradas = new boolean[15];

        exibirMenu(leitor, ilhas, exploradas, tentativas, pontuacaoAtual, 
                   tesourosEncontrados, armadilhasEncontradas, posicoesVaziasEncontradas);

    }

    private void exibirMenu(Scanner leitor, String[] ilhas, boolean[] exploradas, int tentativas, int pontuacaoAtual,
            int tesourosEncontrados, int armadilhasEncontradas, int posicoesVaziasEncontradas) {
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
                    mostrarMapaExlorado(ilhas, exploradas);

                    break;

                case 3:
                    if (tentativas > 0) {

                        String resultado = lerPosicao(leitor, ilhas, exploradas);

                        tentativas--;
                        pontuacaoAtual += pontuacao(resultado);

                        resultadoPosicao(resultado);

                        if (resultado.equals("OURO") || resultado.equals("DIAMANTE") || resultado.equals("RUBI")) {
                            tesourosEncontrados++;
                        } else if (resultado.equals("BURACO") || resultado.equals("COBRA") || resultado.equals("ESPINHOS")) {
                            armadilhasEncontradas++;
                        } else {
                            posicoesVaziasEncontradas++;
                        }


                        System.out.println("Rodada concluída! Tentativas restantes: " + tentativas);
                        System.out.println("---------------------------------------------");

                        if (verificarQtdTesouros(ilhas, tesourosEncontrados)) {
                            System.out.println("\n---------------------------------------------");
                            System.out.println("Você encontrou todos os tesouros da ilha!");
                            exibirFimDeJogo(pontuacaoAtual, tentativas, tesourosEncontrados, armadilhasEncontradas, posicoesVaziasEncontradas);
                            opcao = 5; // Força a saída do laço while, encerrando o programa

                        } else if (tentativas == 0) {
                            System.out.println("\n---------------------------------------------");
                            System.out.println("Fim de jogo! Suas 8 tentativas acabaram.");
                            exibirFimDeJogo(pontuacaoAtual, tentativas, tesourosEncontrados, armadilhasEncontradas, posicoesVaziasEncontradas);
                            opcao = 5; // Força a saída do laço while, encerrando o programa
                        }
                    } else {
                        System.out.println("Você não possui mais jogadas disponíveis nesta partida.");
                    }

                    break;

                case 4:
                    statusAtual(pontuacaoAtual, tentativas, tesourosEncontrados, armadilhasEncontradas, posicoesVaziasEncontradas);
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

    private String sortear() {
        String[] tipos = { "VAZIO", "OURO", "DIAMANTE", "RUBI", "BURACO", "COBRA", "ESPINHOS" };

        int posicao = (int) (Math.random() * 7);

        return tipos[posicao];
    }

    private void inicializarIlha(String[] ilhas) {
        for (int i = 0; i < ilhas.length; i++) {
            ilhas[i] = sortear();
        }
    }

    private String lerPosicao(Scanner leitor, String[] ilhas, boolean[] exploradas) {

        System.out.print("Escolha uma posição: ");
        int posicao = leitor.nextInt();

        while (posicao < 0 || posicao >= ilhas.length) {
            System.out.println("Posição inválida. Tente novamente.");
            System.out.print("Escolha uma posição: ");
            posicao = leitor.nextInt();
        }

        while (exploradas[posicao]) {
            System.out.println("Você já explorou essa posição! Escolha outra: ");
            posicao = leitor.nextInt();

            while (posicao < 0 || posicao >= ilhas.length) {
                System.out.println("Posição inválida. Tente novamente.");
                System.out.print("Escolha uma posição: ");
                posicao = leitor.nextInt();
            }

        }

        exploradas[posicao] = true;
        return ilhas[posicao];

    }

    private void resultadoPosicao(String resultado) {
        if (resultado.equals("OURO")) {
            System.out.println("Você encontrou " + resultado + "! +10 pontos.");
        } else if (resultado.equals("DIAMANTE")) {
            System.out.println("Você encontrou " + resultado + "! +20 pontos.");
        } else if (resultado.equals("RUBI")) {
            System.out.println("Você encontrou " + resultado + "! +15 pontos.");
        } else if (resultado.equals("BURACO")) {
            System.out.println("Você encontrou uma armadilha: " + resultado + "! -5 pontos.");
        } else if (resultado.equals("COBRA")) {
            System.out.println("Você encontrou uma armadilha: " + resultado + "! -10 pontos.");
        } else if (resultado.equals("ESPINHOS")) {
            System.out.println("Você encontrou uma armadilha: " + resultado + "! -7 pontos.");
        } else {
            System.out.println("Você encontrou uma posição " + resultado + "! 0 pontos.");
        }
    }

    private boolean verificarQtdTesouros(String[] ilhas, int tesourosEncontrados) {
        int qtdTesourosDessaPartida = 0;
        for (int i = 0; i < ilhas.length; i++) {
            if (ilhas[i].equals("OURO") || ilhas[i].equals("DIAMANTE") || ilhas[i].equals("RUBI")) {
                qtdTesourosDessaPartida++;
            }
        }

        return qtdTesourosDessaPartida == tesourosEncontrados;
    }

    private void statusAtual(int pontuacaoAtual, int tentativas, int tesourosEncontrados, int armadilhasEncontradas, int posicoesVaziasEncontradas) {
        System.out.println("\nStatus atual:");
        System.out.println("Pontuação: " + pontuacaoAtual + " pontos");
        System.out.println("Tentativas Restantes: " + tentativas);
        System.out.println("Tesouros Encontrados: " + tesourosEncontrados);
        System.out.println("Armadilhas Encontradas: " + armadilhasEncontradas);
        System.out.println("Posições vazias exploradas: " +  posicoesVaziasEncontradas + "\n");
    }

    private int pontuacao(String resultado) {
        int pontos = 0;

        switch (resultado) {
            case "OURO":
                pontos += 10;
                break;
            case "DIAMANTE":
                pontos += 20;
                break;
            case "RUBI":
                pontos += 15;
                break;
            case "COBRA":
                pontos -= 10;
                break;
            case "ESPINHOS":
                pontos -= 7;
                break;
            case "BURACO":
                pontos -= 5;
                break;
            case "VAZIO":
                // sem pontuação
                break;
        }

        return pontos;

    }

    private void exibirFimDeJogo(int pontuacaoFinal, int tentativas, int tesourosEncontrados, int armadilhasEncontradas, int posicoesVaziasEncontradas) {
        statusAtual(pontuacaoFinal, tentativas, tesourosEncontrados, armadilhasEncontradas, posicoesVaziasEncontradas);
        System.out.println("Pontuação final: " + pontuacaoFinal + " pontos.");
        if(pontuacaoFinal > 0){
            System.out.println("Você venceu!");
        }
        else{
            System.out.println("Você perdeu. Tente novamente!");
        }
        System.out.println("---------------------------------------------\n");
    }

    private void mostrarMapaExlorado(String[] ilhas, boolean[] exploradas){
        System.out.println("Mapa da ilha:");
        for(int i = 0; i < ilhas.length; i++){ // passa por todas as posições para conferir
            if(exploradas[i] == true){
                System.out.println("[" + i + "]" + " EXPLORADO");
            } else{
                System.out.println("[" + i + "]" + " ?");
            }
        }
    }

}