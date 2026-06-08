# 🏝️ Jogo da Ilha dos Tesouros

Um jogo de estratégia e sorte baseado em texto, desenvolvido inteiramente em **Java** para execução via console. O projeto simula um mapa de exploração onde o jogador deve desbravar quadrantes de uma ilha em busca de riquezas, gerenciando suas tentativas e evitando perigos ocultos.

## 🎮 Como Funciona o Jogo

O jogador é colocado em uma ilha misteriosa representada por um mapa de 15 posições desconhecidas. A cada rodada, é possível interagir com o menu principal para:
* 📜 **Visualizar as instruções** detalhadas e regras de pontuação.
* 🗺️ **Olhar o mapa** para verificar quais setores já foram explorados.
* 🕹️ **Jogar**, escolhendo uma coordenada da ilha para vasculhar.
* 📊 **Checar o status** atual (tentativas restantes, pontuação e inventário de itens).

### 💎 Elementos da Ilha e Pontuação
Cada setor da ilha pode esconder um prêmio ou uma armadilha:

| Tipo | Item | Pontuação |
| :--- | :--- | :---: |
| 💎 **Tesouro** | Ouro, Diamante ou Rubi | Ganha pontos (+10 a +20) |
| ⚠️ **Armadilha**| Buraco, Cobra ou Espinhos | Perde pontos (-5 a -10) |
| 🏜️ **Vazio** | Setor sem eventos | Não altera os pontos (0) |
