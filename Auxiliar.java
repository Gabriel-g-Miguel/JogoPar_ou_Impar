import java.util.Random;
import java.util.Scanner;

/**
 * A classe {@code Auxiliar} contém um subprograma
 * que permite com que a máquina escolha um número aleatório
 * de 0 a 5 para realizar sua jogada contra o jogador.
 * @author Gabriel Miguel (GABRIEL.MIGUEL@edu.pucrs.br)
 * @version 2021-06-20
 */
public class Auxiliar {    
    /**
     * O método sorteioNumero() retorna um número aleatório 
     * de 0 a 5.
     */
    public static int sorteioNumero() {
        int random = (int) (Math.random() *5 );
        return random;
    }
}
    
    
