import java.util.Scanner;
import java.util.Random;

/**
 * A classe {@code MainApp} contém um programa que atende 
 * ao enunciado da Avalição 4 e que apresenta mensagens
 * de orientação ao usuário e que roda o programa principal
 * do jogo Par ou Ímpar de um jogador contra uma máquina, 
 * além disso, verifica os valores de entrada, bem como, a 
 * lógica do programa.
 * @author Gabriel Miguel (GABRIEL.MIGUEL@edu.pucrs.br)
 * @version 2021-06-20
 */
public class MainApp {
 /**
 * O método main(String[]args) contém o programa principal que
 * realiza a entrada de dados, verifica sua validade e imprime
 * a saída dos resultados tanto do jogador, quanto da máquina.
 * @param String[] args não recebe nada.
 */
 public static void main (String[]args) {
  System.out.println("SEJA BEM-VINDO AO JOGO PAR OU ÍMPAR");
  System.out.println("REGRAS DO JOGO: ");
  System.out.println();
  System.out.println("- O jogo Par ou Ímpar possui dois jogadores,");
  System.out.println("  sendo o jogador contra a máquina.");
  System.out.println();
  System.out.println("- Quando o jogo iniciar, você deve escolher");
  System.out.println("  o número de rodadas que deseja jogar contra");
  System.out.println("  a máquina, esse número vai de 1 a 10.");
  System.out.println();
  System.out.println("- Após o início do jogo, você deve selecionar");
  System.out.println("  sua escolhe entre números pares e ímpares.");
  System.out.println();
  System.out.println("- Após a seleção, você deve escolher um número");
  System.out.println("  de 0 a 5, a máquina fará o mesmo e escolherá");
  System.out.println("  um número aleatório de 0 a 5.");
  System.out.println();
  System.out.println("- No final da rodada, os números escolhidos");
  System.out.println("  pelo jogador e pela máquina são somados");
  System.out.println("  e divididos por 2, se o resto dessa divisão");
  System.out.println("  for 0, então, quem escolheu par vence. Se o");
  System.out.println("  o resto da divisão for 1, então, quem escolheu");
  System.out.println("  ímpar vence.");
  System.out.println();
  System.out.println("- Sempre no final da rodada, o vencedor acumulará");
  System.out.println("  um ponto de vitória, que sempre será exibibido");
  System.out.println("  pela tabela de pontuação.");
  System.out.println();
  System.out.println("- Após o término de todas as rodadas, a tabela");
  System.out.println("  de pontuação mostrará quantos pontos o jogador");
  System.out.println("  e a máquina possuem, quem tiver mais pontos vence");
  System.out.println("  o game!"); 

  //objetos
  Scanner sc = new Scanner(System.in);
  Auxiliar maquina = new Auxiliar();//objeto utilizado para chamar os métodos da classe auxiliar 
  int[] jogadas = new int [2];
  int[] vitorias = new int[2]; 

  //variaveis
  int escolhaJogada = 0;
  int numeroEscolhido;
  int valorJogada = 0;
  int contadorJogadas = 0;
  int rodadas = 0;
  int numeroRodadas = 0;
  boolean continuar = true;

  //jogada ímpar
  jogadas[0] = 1; // 1 = ímpar

  //jogada par
  jogadas[1] = 2; // 2 = par

  System.out.println("\nSelecione o número de rodadas que você deseja jogar:");
    
  while(numeroRodadas == 0) {
   numeroRodadas = sc.nextInt();
   if(numeroRodadas < 1 || numeroRodadas > 10) {
          System.out.println("O número de rodadas deve ser de 1 a 10. Digite novamente.");
          numeroRodadas = 0;
   }
  }
    
  System.out.println();
    
  //while(continuar) {
   while(rodadas < numeroRodadas) {
   boolean whileJogadas = true;
    
   System.out.println("--------- JOGADOR 1 ----------");
   System.out.println();

    while (whileJogadas) {
    System.out.println("Digite 1 para escolher ÍMPAR" +" ou 2 para escolher PAR: ");
    escolhaJogada = sc.nextInt();
    if (escolhaJogada == jogadas[0]) {
        System.out.println();
        System.out.println("Você escolheu ÍMPAR");
        System.out.println();
        whileJogadas = false;
    } else if (escolhaJogada == jogadas[1]) {
        System.out.println();
        System.out.println("Você escolheu PAR");
        System.out.println();
        whileJogadas = false;
    } else {
        System.out.println("\nHá algo de errado com a escolha das jogadas, tente novamente.\n");
    }
   }

   boolean whileJogadas2 = true;

    while (whileJogadas2) {
    System.out.println("Digite o valor da sua jogada (de 0 a 5): ");
    valorJogada = sc.nextInt();
    System.out.println();
    if (valorJogada >= 0 && valorJogada <= 5) {
      whileJogadas2 = false;
    } else {
        System.out.println("Há algo de errado com o valor da jogada, tente novamente.");
    }
   }

   System.out.println("--------- FIM DA JOGADA ----------\n");
   System.out.println();

   int jogadaDaMaquina = maquina.sorteioNumero();

   System.out.println("--------- VEZ DA MÁQUINA ---------");
   System.out.println();
   System.out.println("Valor da Jogada = " + jogadaDaMaquina);
   System.out.println();
   System.out.println("--------- FIM DA JOGADA ----------\n");
   System.out.println();
   System.out.println("----------- VENCEDOR: ------------\n"); 

   if((valorJogada + jogadaDaMaquina) % 2 == 0){
    if(escolhaJogada == jogadas[1]) {
     System.out.println("            JOGADOR 1\n");
     vitorias[0]++;
    } else {
        System.out.println("             MÁQUINA\n");
        vitorias[1]++;
    }
   } else {
    if(escolhaJogada == jogadas[0]){
     System.out.println("            JOGADOR 1\n");
     vitorias[0]++;
    } else {
        System.out.println("             MÁQUINA\n");
        vitorias[1]++;
    }
   }
   System.out.println("----------------------------------\n");

   // imprime em tela o resultado de vitorias
   System.out.printf("------------------\n" +
                     "|  MELHOR DE %d  |\n" +
                     "------------------\n" +
                     "| Jogador : %d   |\n" +
                     "| Máquina : %d   |\n" +
                     "------------------\n\n", numeroRodadas, vitorias[0], vitorias[1]);
   rodadas++;
  }

  if (vitorias[0] > vitorias[1]) {
    System.out.println("O vencedor final é o Jogador!");
  } else
      if(vitorias[1] > vitorias[0]) {   
       System.out.println("O vencedor final é a Máquina!");
      } else{
          System.out.println("Empate!");
  }
 }
}
 

