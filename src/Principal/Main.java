package Principal;

import java.io.IOException;

/** Classe principal, apenas para executar a aplicação/animação.
 *
 * @author Luiz Fernando Perez Redondaro
 */
public class Main {
    
    /** Executa a animação. :D
     * 
     * @param args não usado
     * @throws InterruptedException
     * @throws IOException 
     */
    public static void main(String[] args) throws InterruptedException, IOException {
        new Engine().rodar();
    }
    
}
