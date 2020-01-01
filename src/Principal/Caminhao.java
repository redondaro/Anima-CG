package Principal;

import java.awt.Graphics2D;
import java.awt.Color;
import static java.lang.Math.cos;
import static java.lang.Math.sin;

/** Classe usada para definir, alterar e exibir o caminhão 3D.
 * 
 * @author Luiz Fernando Perez Redondaro
 */
public class Caminhao {
    
    /** Representa um ponto em um plano cartesiano 3D. */
    public class ponto {
        int x, y, z;
    }
    
    /** Tonalidade vermelha do caminhão. */
    public static Color vermelho = new Color(219,0,0);
    
    /** Tonalidade cinza escura do caminhão. */
    public static Color cinzaEscuro = new Color(88,88,88);
    
    /** Tonalidade cinza clara do caminhão. */
    public static Color cinzaClaro = new Color(160,160,160);
    
    /** Pontos dos elementos do caminhão. */
    ponto[] cabine_esq = new ponto[34], cabine_dir = new ponto[34], parabrisa = new ponto[4],
            estrada = new ponto[24],
            pneu_esq_fora = new ponto[6], pneu_esq_dentro = new ponto[6],
            pneu_dir_fora = new ponto[6], pneu_dir_dentro = new ponto[6];
    
    /** Método construtor que cria o caminhão com todos os seus pontos. */
    public Caminhao() {
        for (int i = 0; i < 34; i++) {
            cabine_esq[i] = new ponto();
            cabine_dir[i] = new ponto();
        }
        for (int i = 0; i < 6; i++) {
            pneu_esq_fora[i] = new ponto();
            pneu_esq_dentro[i] = new ponto();
            pneu_dir_fora[i] = new ponto();
            pneu_dir_dentro[i] = new ponto();
        }
        for (int i = 0; i < 4; i++)
            parabrisa[i] = new ponto();
        
        //parabrisa
        parabrisa[0].x = parabrisa[1].x = parabrisa[2].x = parabrisa[3].x = 0;
        parabrisa[0].y = parabrisa[1].y = 26;
        parabrisa[2].y = parabrisa[3].y = 52;
        parabrisa[0].z = parabrisa[2].z = 14;
        parabrisa[1].z = parabrisa[3].z = 66;
        
        //cabine e escapamento superior
        cabine_esq[0].x = cabine_dir[0].x = 0;
        cabine_esq[0].y = cabine_dir[0].y = 22;
        cabine_esq[0].z = 10; cabine_dir[0].z = 70;
        cabine_esq[1].x = cabine_dir[1].x = 66;
        cabine_esq[1].y = cabine_dir[1].y = 22;
        cabine_esq[1].z = 10; cabine_dir[1].z = 70;
        cabine_esq[2].x = cabine_dir[2].x = 66;
        cabine_esq[2].y = cabine_dir[2].y = 0;
        cabine_esq[2].z = 10; cabine_dir[2].z = 70;
        cabine_esq[3].x = cabine_dir[3].x = 77;
        cabine_esq[3].y = cabine_dir[3].y = 0;
        cabine_esq[3].z = 10; cabine_dir[3].z = 70;
        cabine_esq[4].x = cabine_dir[4].x = 77;
        cabine_esq[4].y = cabine_dir[4].y = 76;
        cabine_esq[4].z = 10; cabine_dir[4].z = 70;
        cabine_esq[5].x = cabine_dir[5].x = 90;
        cabine_esq[5].y = cabine_dir[5].y = 76;
        cabine_esq[5].z = 10; cabine_dir[5].z = 70;
        cabine_esq[6].x = cabine_dir[6].x = 90;
        cabine_esq[6].y = cabine_dir[6].y = 86;
        cabine_esq[6].z = 10; cabine_dir[6].z = 70;
        cabine_esq[7].x = cabine_dir[7].x = 66;
        cabine_esq[7].y = cabine_dir[7].y = 86;
        cabine_esq[7].z = 10; cabine_dir[7].z = 70;
        cabine_esq[8].x = cabine_dir[8].x = 0;
        cabine_esq[8].y = cabine_dir[8].y = 86;
        cabine_esq[8].z = 10; cabine_dir[8].z = 70;
        
        //porta
        cabine_esq[9].x = cabine_dir[9].x = 4;
        cabine_esq[9].y = cabine_dir[9].y = 26;
        cabine_esq[9].z = 10; cabine_dir[9].z = 70;
        cabine_esq[10].x = cabine_dir[10].x = 38;
        cabine_esq[10].y = cabine_dir[10].y = 26;
        cabine_esq[10].z = 10; cabine_dir[10].z = 70;
        cabine_esq[11].x = cabine_dir[11].x = 38;
        cabine_esq[11].y = cabine_dir[11].y = 52;
        cabine_esq[11].z = 10; cabine_dir[11].z = 70;
        cabine_esq[12].x = cabine_dir[12].x = 38;
        cabine_esq[12].y = cabine_dir[12].y = 73;
        cabine_esq[12].z = 10; cabine_dir[12].z = 70;
        cabine_esq[13].x = cabine_dir[13].x = 4;
        cabine_esq[13].y = cabine_dir[13].y = 73;
        cabine_esq[13].z = 10; cabine_dir[13].z = 70;
        cabine_esq[14].x = cabine_dir[14].x = 4;
        cabine_esq[14].y = cabine_dir[14].y = 52;
        cabine_esq[14].z = 10; cabine_dir[14].z = 70;
        
        //janelinha
        cabine_esq[15].x = cabine_dir[15].x = 42;
        cabine_esq[15].y = cabine_dir[15].y = 28;
        cabine_esq[15].z = 10; cabine_dir[15].z = 70;
        cabine_esq[16].x = cabine_dir[16].x = 62;
        cabine_esq[16].y = cabine_dir[16].y = 28;
        cabine_esq[16].z = 10; cabine_dir[16].z = 70;
        cabine_esq[17].x = cabine_dir[17].x = 62;
        cabine_esq[17].y = cabine_dir[17].y = 50;
        cabine_esq[17].z = 10; cabine_dir[17].z = 70;
        cabine_esq[18].x = cabine_dir[18].x = 42;
        cabine_esq[18].y = cabine_dir[18].y = 50;
        cabine_esq[18].z = 10; cabine_dir[18].z = 70;
        
        //carroceria frente
        cabine_esq[19].x = cabine_dir[19].x = 0;
        cabine_esq[19].y = cabine_dir[19].y = 86;
        cabine_esq[19].z = 10; cabine_dir[19].z = 70;
        cabine_esq[20].x = cabine_dir[20].x = 35;
        cabine_esq[20].y = cabine_dir[20].y = 86;
        cabine_esq[20].z = 10; cabine_dir[20].z = 70;
        cabine_esq[21].x = cabine_dir[21].x = 35;
        cabine_esq[21].y = cabine_dir[21].y = 101;
        cabine_esq[21].z = 10; cabine_dir[21].z = 70;
        cabine_esq[22].x = cabine_dir[22].x = 0;
        cabine_esq[22].y = cabine_dir[22].y = 101;
        cabine_esq[22].z = 10; cabine_dir[22].z = 70;
        
        //tanque
        cabine_esq[23].x = cabine_dir[23].x = 35;
        cabine_esq[23].y = cabine_dir[23].y = 86;
        cabine_esq[23].z = 10; cabine_dir[23].z = 70;
        cabine_esq[24].x = cabine_dir[24].x = 46;
        cabine_esq[24].y = cabine_dir[24].y = 86;
        cabine_esq[24].z = 10; cabine_dir[24].z = 70;
        cabine_esq[25].x = cabine_dir[25].x = 62;
        cabine_esq[25].y = cabine_dir[25].y = 86;
        cabine_esq[25].z = 10; cabine_dir[25].z = 70;
        cabine_esq[26].x = cabine_dir[26].x = 72;
        cabine_esq[26].y = cabine_dir[26].y = 86;
        cabine_esq[26].z = 10; cabine_dir[26].z = 70;
        cabine_esq[27].x = cabine_dir[27].x = 35;
        cabine_esq[27].y = cabine_dir[27].y = 104;
        cabine_esq[27].z = 10; cabine_dir[27].z = 70;
        cabine_esq[28].x = cabine_dir[28].x = 46;
        cabine_esq[28].y = cabine_dir[28].y = 104;
        cabine_esq[28].z = 10; cabine_dir[28].z = 70;
        cabine_esq[29].x = cabine_dir[29].x = 62;
        cabine_esq[29].y = cabine_dir[29].y = 104;
        cabine_esq[29].z = 10; cabine_dir[29].z = 70;
        cabine_esq[30].x = cabine_dir[30].x = 72;
        cabine_esq[30].y = cabine_dir[30].y = 104;
        cabine_esq[30].z = 10; cabine_dir[30].z = 70;
        
        //carroceria traseira
        cabine_esq[31].x = cabine_dir[31].x = 160;
        cabine_esq[31].y = cabine_dir[31].y = 86;
        cabine_esq[31].z = 10; cabine_dir[31].z = 70;
        cabine_esq[32].x = cabine_dir[32].x = 160;
        cabine_esq[32].y = cabine_dir[32].y = 101;
        cabine_esq[32].z = 10; cabine_dir[32].z = 70;
        cabine_esq[33].x = cabine_dir[33].x = 72;
        cabine_esq[33].y = cabine_dir[33].y = 101;
        cabine_esq[33].z = 10; cabine_dir[33].z = 70;
        
        //pneus
        pneu_esq_fora[0].x = pneu_esq_dentro[0].x = pneu_dir_fora[0].x = pneu_dir_dentro[0].x = 4;
        pneu_esq_fora[0].y = pneu_esq_dentro[0].y = pneu_dir_fora[0].y = pneu_dir_dentro[0].y = 82;
        pneu_esq_fora[1].x = pneu_esq_dentro[1].x = pneu_dir_fora[1].x = pneu_dir_dentro[1].x = 18;
        pneu_esq_fora[1].y = pneu_esq_dentro[1].y = pneu_dir_fora[1].y = pneu_dir_dentro[1].y = 96;
        pneu_esq_fora[2].x = pneu_esq_dentro[2].x = pneu_dir_fora[2].x = pneu_dir_dentro[2].x = 105;
        pneu_esq_fora[2].y = pneu_esq_dentro[2].y = pneu_dir_fora[2].y = pneu_dir_dentro[2].y = 82;
        pneu_esq_fora[3].x = pneu_esq_dentro[3].x = pneu_dir_fora[3].x = pneu_dir_dentro[3].x = 119;
        pneu_esq_fora[3].y = pneu_esq_dentro[3].y = pneu_dir_fora[3].y = pneu_dir_dentro[3].y = 96;
        pneu_esq_fora[4].x = pneu_esq_dentro[4].x = pneu_dir_fora[4].x = pneu_dir_dentro[4].x = 136;
        pneu_esq_fora[4].y = pneu_esq_dentro[4].y = pneu_dir_fora[4].y = pneu_dir_dentro[4].y = 82;
        pneu_esq_fora[5].x = pneu_esq_dentro[5].x = pneu_dir_fora[5].x = pneu_dir_dentro[5].x = 150;
        pneu_esq_fora[5].y = pneu_esq_dentro[5].y = pneu_dir_fora[5].y = pneu_dir_dentro[5].y = 96;
        pneu_esq_fora[0].z = pneu_esq_fora[1].z = pneu_esq_fora[2].z = pneu_esq_fora[3].z = pneu_esq_fora[4].z = pneu_esq_fora[5].z = 0;
        pneu_esq_dentro[0].z = pneu_esq_dentro[1].z = pneu_esq_dentro[2].z = pneu_esq_dentro[3].z = pneu_esq_dentro[4].z = pneu_esq_dentro[5].z = 9;
        pneu_dir_fora[0].z = pneu_dir_fora[1].z = pneu_dir_fora[2].z = pneu_dir_fora[3].z = pneu_dir_fora[4].z = pneu_dir_fora[5].z = 80;
        pneu_dir_dentro[0].z = pneu_dir_dentro[1].z = pneu_dir_dentro[2].z = pneu_dir_dentro[3].z = pneu_dir_dentro[4].z = pneu_dir_dentro[5].z = 71;
        
        //estrada
        for (int i = 0; i < 20; i++) {
            estrada[i] = new ponto();
            estrada[i].x = -450 + i*55;
            estrada[i].y = 110;
            estrada[i].z = -20;
        }
        for (int i = 20; i < 24; i++) {
            estrada[i] = new ponto();
            estrada[i].y = 110;
        }
        estrada[20].x = estrada[22].x = -450;
        estrada[20].z = estrada[21].z = -110;
        estrada[21].x = estrada[23].x = 600;
        estrada[22].z = estrada[23].z = 100;
    }
    
    /** Movimentar o caminhão, acrescentando o deslocamento (x,y,z) em seus pontos.
     * 
     * @param x
     * @param y
     * @param z 
     */
    public void mover(int x, int y, int z) {
        for (int i = 0; i < 34; i ++) {
            cabine_esq[i].x += x;
            cabine_esq[i].y += y;
            cabine_esq[i].z += z;
            cabine_dir[i].x += x;
            cabine_dir[i].y += y;
            cabine_dir[i].z += z;
        }
        for (int i = 0; i < 6; i++) {
            pneu_esq_fora[i].x += x;
            pneu_esq_fora[i].y += y;
            pneu_esq_fora[i].z += z;
            pneu_esq_dentro[i].x += x;
            pneu_esq_dentro[i].y += y;
            pneu_esq_dentro[i].z += z;
            pneu_dir_fora[i].x += x;
            pneu_dir_fora[i].y += y;
            pneu_dir_fora[i].z += z;
            pneu_dir_dentro[i].x += x;
            pneu_dir_dentro[i].y += y;
            pneu_dir_dentro[i].z += z;
        }
        for (int i = 0; i < 4; i++) {
            parabrisa[i].x += x;
            parabrisa[i].y += y;
            parabrisa[i].z += z;
        }
        for (int i = 0; i < 24; i++) {
            estrada[i].x += x;
            estrada[i].y += y;
            estrada[i].z += z;
        }
    }
    
    /** Aumentar/diminuir tamanho do caminhão, com um determinado valor de escala.
     * 
     * @param valor Escala de transformação
     */
    public void escala(float valor) {
        for (int i = 0; i < 34; i ++) {
            cabine_esq[i].x *= valor;
            cabine_esq[i].y *= valor;
            cabine_dir[i].x *= valor;
            cabine_dir[i].y *= valor;
        }
        for (int i = 0; i < 6; i++) {
            pneu_esq_fora[i].x *= valor;
            pneu_esq_fora[i].y *= valor;
            pneu_esq_dentro[i].x *= valor;
            pneu_esq_dentro[i].y *= valor;
            pneu_dir_fora[i].x *= valor;
            pneu_dir_fora[i].y *= valor;
            pneu_dir_dentro[i].x *= valor;
            pneu_dir_dentro[i].y *= valor;
        }
        for (int i = 0; i < 4; i++) {
            parabrisa[i].x *= valor;
            parabrisa[i].y *= valor;
            parabrisa[i].z *= valor;
        }
    }
    
    /** Posiciona o caminhão de acordo com sua posição central. */
    public void centro() {
        int deslX = 200-((cabine_esq[31].x+cabine_esq[8].x+cabine_dir[31].x+cabine_dir[8].x)/4);
        int deslY = 160 - cabine_esq[2].y;
        mover(deslX, deslY, 0);
    }
    
    /** Desenhar pneus do lado esquerdo do caminhão.
     * 
     * @param g 
     */
    private void desenharPneuEsq(Graphics2D g) {
        if (pneu_esq_dentro[1].x > pneu_esq_dentro[0].x) {
            for (int i = pneu_esq_dentro[1].x; i >= pneu_esq_dentro[0].x; i--)
                Graficos.elipse(i, pneu_esq_dentro[0].y, pneu_esq_dentro[1].x, pneu_esq_dentro[1].y, g, Color.black);
        }else{
            for (int i = pneu_esq_dentro[0].x; i >= pneu_esq_dentro[1].x; i--)
                Graficos.elipse(i, pneu_esq_dentro[0].y, pneu_esq_dentro[1].x, pneu_esq_dentro[1].y, g, Color.black);
        }
        Graficos.reta(pneu_esq_dentro[1].x, pneu_esq_dentro[0].y, pneu_esq_dentro[1].x, 2*pneu_esq_dentro[1].y - pneu_esq_dentro[0].y, g, Color.black);
        int a, b;
        
        //entre pneus
        if (pneu_esq_dentro[1].x < pneu_esq_fora[1].x) {
            a = pneu_esq_dentro[1].x;
            b = pneu_esq_fora[1].x;
        }else{
            b = pneu_esq_dentro[1].x;
            a = pneu_esq_fora[1].x;
        }
        for (int i = a; i <= b; i++) {
            Graficos.reta(i,pneu_esq_dentro[0].y, i+1,2*pneu_esq_fora[1].y - pneu_esq_fora[0].y, g, Color.black);
            Graficos.reta(i,pneu_esq_fora[0].y, i+1,2*pneu_esq_dentro[1].y - pneu_esq_dentro[0].y, g, Color.black);
        }
        if (pneu_esq_fora[1].x > pneu_esq_fora[0].x) {
            for (int i = pneu_esq_fora[1].x; i >= pneu_esq_fora[0].x; i--)
                Graficos.elipse(i, pneu_esq_fora[0].y, pneu_esq_fora[1].x, pneu_esq_fora[1].y, g, Color.black);
        }else{
            for (int i = pneu_esq_fora[0].x; i >= pneu_esq_fora[1].x; i--)
                Graficos.elipse(i, pneu_esq_fora[0].y, pneu_esq_fora[1].x, pneu_esq_fora[1].y, g, Color.black);
        }
        Graficos.reta(pneu_esq_fora[1].x, pneu_esq_fora[0].y, pneu_esq_fora[1].x, 2*pneu_esq_fora[1].y - pneu_esq_fora[0].y, g, Color.black);
        
        //entre pneus
        if (pneu_esq_dentro[3].x < pneu_esq_fora[3].x) {
            a = pneu_esq_dentro[3].x;
            b = pneu_esq_fora[3].x;
        }else{
            b = pneu_esq_dentro[3].x;
            a = pneu_esq_fora[3].x;
        }
        for (int i = a; i <= b; i++) {
            Graficos.reta(i,pneu_esq_dentro[2].y, i+1,2*pneu_esq_fora[3].y - pneu_esq_fora[2].y, g, Color.black);
            Graficos.reta(i,pneu_esq_fora[2].y, i+1,2*pneu_esq_dentro[3].y - pneu_esq_dentro[2].y, g, Color.black);
        }
        if (pneu_esq_dentro[3].x > pneu_esq_dentro[2].x) {
            for (int i = pneu_esq_dentro[3].x; i >= pneu_esq_dentro[2].x; i--)
                Graficos.elipse(i, pneu_esq_dentro[2].y, pneu_esq_dentro[3].x, pneu_esq_dentro[3].y, g, Color.black);
        }else{
            for (int i = pneu_esq_dentro[2].x; i >= pneu_esq_dentro[3].x; i--)
                Graficos.elipse(i, pneu_esq_dentro[2].y, pneu_esq_dentro[3].x, pneu_esq_dentro[3].y, g, Color.black);
        }
        Graficos.reta(pneu_esq_dentro[3].x, pneu_esq_dentro[2].y, pneu_esq_dentro[3].x, 2*pneu_esq_dentro[3].y - pneu_esq_dentro[2].y, g, Color.black);
        if (pneu_esq_fora[3].x > pneu_esq_fora[2].x) {
            for (int i = pneu_esq_fora[3].x; i >= pneu_esq_fora[2].x; i--)
                Graficos.elipse(i, pneu_esq_fora[2].y, pneu_esq_fora[3].x, pneu_esq_fora[3].y, g, Color.black);
        }else{
            for (int i = pneu_esq_fora[2].x; i >= pneu_esq_fora[3].x; i--)
                Graficos.elipse(i, pneu_esq_fora[2].y, pneu_esq_fora[3].x, pneu_esq_fora[3].y, g, Color.black);
        }
        Graficos.reta(pneu_esq_fora[3].x, pneu_esq_fora[2].y, pneu_esq_fora[3].x, 2*pneu_esq_fora[3].y - pneu_esq_fora[2].y, g, Color.black);
        if (pneu_esq_dentro[5].x > pneu_esq_dentro[4].x) {
            for (int i = pneu_esq_dentro[5].x; i >= pneu_esq_dentro[4].x; i--)
                Graficos.elipse(i, pneu_esq_dentro[4].y, pneu_esq_dentro[5].x, pneu_esq_dentro[5].y, g, Color.black);
        }else{
            for (int i = pneu_esq_dentro[4].x; i >= pneu_esq_dentro[5].x; i--)
                Graficos.elipse(i, pneu_esq_dentro[4].y, pneu_esq_dentro[5].x, pneu_esq_dentro[5].y, g, Color.black);
        }
        Graficos.reta(pneu_esq_dentro[5].x, pneu_esq_dentro[4].y, pneu_esq_dentro[5].x, 2*pneu_esq_dentro[5].y - pneu_esq_dentro[4].y, g, Color.black);
        
        //entre pneus
        if (pneu_esq_dentro[5].x < pneu_esq_fora[5].x) {
            a = pneu_esq_dentro[5].x;
            b = pneu_esq_fora[5].x;
        }else{
            b = pneu_esq_dentro[5].x;
            a = pneu_esq_fora[5].x;
        }
        for (int i = a; i <= b; i++) {
            Graficos.reta(i,pneu_esq_dentro[4].y, i+1,2*pneu_esq_fora[5].y - pneu_esq_fora[4].y, g, Color.black);
            Graficos.reta(i,pneu_esq_fora[4].y, i+1,2*pneu_esq_dentro[5].y - pneu_esq_dentro[4].y, g, Color.black);
        }
        if (pneu_esq_fora[5].x > pneu_esq_fora[4].x) {
            for (int i = pneu_esq_fora[5].x; i >= pneu_esq_fora[4].x; i--)
                Graficos.elipse(i, pneu_esq_fora[4].y, pneu_esq_fora[5].x, pneu_esq_fora[5].y, g, Color.black);
        }else{
            for (int i = pneu_esq_fora[4].x; i >= pneu_esq_fora[5].x; i--)
                Graficos.elipse(i, pneu_esq_fora[4].y, pneu_esq_fora[5].x, pneu_esq_fora[5].y, g, Color.black);
        }
        Graficos.reta(pneu_esq_fora[5].x, pneu_esq_fora[4].y, pneu_esq_fora[5].x, 2*pneu_esq_fora[5].y - pneu_esq_fora[4].y, g, Color.black);
    }
    
    /** Desenhar pneus do lado direito do caminhão.
     * 
     * @param g 
     */
    private void desenharPneuDir(Graphics2D g) {
        if (pneu_dir_dentro[1].x > pneu_dir_dentro[0].x) {
            for (int i = pneu_dir_dentro[1].x; i >= pneu_dir_dentro[0].x; i--)
                Graficos.elipse(i, pneu_dir_dentro[0].y, pneu_dir_dentro[1].x, pneu_dir_dentro[1].y, g, Color.black);
        }else{
            for (int i = pneu_dir_dentro[0].x; i >= pneu_dir_dentro[1].x; i--)
                Graficos.elipse(i, pneu_dir_dentro[0].y, pneu_dir_dentro[1].x, pneu_dir_dentro[1].y, g, Color.black);
        }
        Graficos.reta(pneu_dir_dentro[1].x, pneu_dir_dentro[0].y, pneu_dir_dentro[1].x, 2*pneu_dir_dentro[1].y - pneu_dir_dentro[0].y, g, Color.black);
        int a, b;
        
        //entre pneus
        if (pneu_dir_dentro[1].x < pneu_dir_fora[1].x) {
            a = pneu_dir_dentro[1].x;
            b = pneu_dir_fora[1].x;
        }else{
            b = pneu_dir_dentro[1].x;
            a = pneu_dir_fora[1].x;
        }
        for (int i = a; i <= b; i++) {
            Graficos.reta(i,pneu_dir_dentro[0].y, i+1,2*pneu_dir_fora[1].y - pneu_dir_fora[0].y, g, Color.black);
            Graficos.reta(i,pneu_dir_fora[0].y, i+1,2*pneu_dir_dentro[1].y - pneu_dir_dentro[0].y, g, Color.black);
        }
        if (pneu_dir_fora[1].x > pneu_dir_fora[0].x) {
            for (int i = pneu_dir_fora[1].x; i >= pneu_dir_fora[0].x; i--)
                Graficos.elipse(i, pneu_dir_fora[0].y, pneu_dir_fora[1].x, pneu_dir_fora[1].y, g, Color.black);
        }else{
            for (int i = pneu_dir_fora[0].x; i >= pneu_dir_fora[1].x; i--)
                Graficos.elipse(i, pneu_dir_fora[0].y, pneu_dir_fora[1].x, pneu_dir_fora[1].y, g, Color.black);
        }
        Graficos.reta(pneu_dir_fora[1].x, pneu_dir_fora[0].y, pneu_dir_fora[1].x, 2*pneu_dir_fora[1].y - pneu_dir_fora[0].y, g, Color.black);
        
        //entre pneus
        if (pneu_dir_dentro[3].x < pneu_dir_fora[3].x) {
            a = pneu_dir_dentro[3].x;
            b = pneu_dir_fora[3].x;
        }else{
            b = pneu_dir_dentro[3].x;
            a = pneu_dir_fora[3].x;
        }
        for (int i = a; i <= b; i++) {
            Graficos.reta(i,pneu_dir_dentro[2].y, i+1,2*pneu_dir_fora[3].y - pneu_dir_fora[2].y, g, Color.black);
            Graficos.reta(i,pneu_dir_fora[2].y, i+1,2*pneu_dir_dentro[3].y - pneu_dir_dentro[2].y, g, Color.black);
        }
        if (pneu_dir_dentro[3].x > pneu_dir_dentro[2].x) {
            for (int i = pneu_dir_dentro[3].x; i >= pneu_dir_dentro[2].x; i--)
                Graficos.elipse(i, pneu_dir_dentro[2].y, pneu_dir_dentro[3].x, pneu_dir_dentro[3].y, g, Color.black);
        }else{
            for (int i = pneu_dir_dentro[2].x; i >= pneu_dir_dentro[3].x; i--)
                Graficos.elipse(i, pneu_dir_dentro[2].y, pneu_dir_dentro[3].x, pneu_dir_dentro[3].y, g, Color.black);
        }
        Graficos.reta(pneu_dir_dentro[3].x, pneu_dir_dentro[2].y, pneu_dir_dentro[3].x, 2*pneu_dir_dentro[3].y - pneu_dir_dentro[2].y, g, Color.black);
        if (pneu_dir_fora[3].x > pneu_dir_fora[2].x) {
            for (int i = pneu_dir_fora[3].x; i >= pneu_dir_fora[2].x; i--)
                Graficos.elipse(i, pneu_dir_fora[2].y, pneu_dir_fora[3].x, pneu_dir_fora[3].y, g, Color.black);
        }else{
            for (int i = pneu_dir_fora[2].x; i >= pneu_dir_fora[3].x; i--)
                Graficos.elipse(i, pneu_dir_fora[2].y, pneu_dir_fora[3].x, pneu_dir_fora[3].y, g, Color.black);
        }
        Graficos.reta(pneu_dir_fora[3].x, pneu_dir_fora[2].y, pneu_dir_fora[3].x, 2*pneu_dir_fora[3].y - pneu_dir_fora[2].y, g, Color.black);
        if (pneu_dir_dentro[5].x > pneu_dir_dentro[4].x) {
            for (int i = pneu_dir_dentro[5].x; i >= pneu_dir_dentro[4].x; i--)
                Graficos.elipse(i, pneu_dir_dentro[4].y, pneu_dir_dentro[5].x, pneu_dir_dentro[5].y, g, Color.black);
        }else{
            for (int i = pneu_dir_dentro[4].x; i >= pneu_dir_dentro[5].x; i--)
                Graficos.elipse(i, pneu_dir_dentro[4].y, pneu_dir_dentro[5].x, pneu_dir_dentro[5].y, g, Color.black);
        }
        Graficos.reta(pneu_dir_dentro[5].x, pneu_dir_dentro[4].y, pneu_dir_dentro[5].x, 2*pneu_dir_dentro[5].y - pneu_dir_dentro[4].y, g, Color.black);
        
        //entre pneus
        if (pneu_dir_dentro[5].x < pneu_dir_fora[5].x) {
            a = pneu_dir_dentro[5].x;
            b = pneu_dir_fora[5].x;
        }else{
            b = pneu_dir_dentro[5].x;
            a = pneu_dir_fora[5].x;
        }
        for (int i = a; i <= b; i++) {
            Graficos.reta(i,pneu_dir_dentro[4].y, i+1,2*pneu_dir_fora[5].y - pneu_dir_fora[4].y, g, Color.black);
            Graficos.reta(i,pneu_dir_fora[4].y, i+1,2*pneu_dir_dentro[5].y - pneu_dir_dentro[4].y, g, Color.black);
        }
        if (pneu_dir_fora[5].x > pneu_dir_fora[4].x) {
            for (int i = pneu_dir_fora[5].x; i >= pneu_dir_fora[4].x; i--)
                Graficos.elipse(i, pneu_dir_fora[4].y, pneu_dir_fora[5].x, pneu_dir_fora[5].y, g, Color.black);
        }else{
            for (int i = pneu_dir_fora[4].x; i >= pneu_dir_fora[5].x; i--)
                Graficos.elipse(i, pneu_dir_fora[4].y, pneu_dir_fora[5].x, pneu_dir_fora[5].y, g, Color.black);
        }
        Graficos.reta(pneu_dir_fora[5].x, pneu_dir_fora[4].y, pneu_dir_fora[5].x, 2*pneu_dir_fora[5].y - pneu_dir_fora[4].y, g, Color.black);
    }
    
    /** Desenha o fundo preto e uma estrada.
     * 
     * @param cont
     * @param g 
     */
    public void desenharFundo(int cont, Graphics2D g) {
        for(int i = 230; i <= 300; i++)
            Graficos.reta(0,i,400,i,g,cinzaEscuro);
        switch (cont) {
            case 0 :{
                Graficos.reta(estrada[0].x,estrada[0].y,estrada[1].x,estrada[1].y,g,Color.white);
                Graficos.reta(estrada[3].x,estrada[3].y,estrada[4].x,estrada[4].y,g,Color.white);
                Graficos.reta(estrada[6].x,estrada[6].y,estrada[7].x,estrada[7].y,g,Color.white);
                Graficos.reta(estrada[9].x,estrada[9].y,estrada[10].x,estrada[10].y,g,Color.white);
                Graficos.reta(estrada[12].x,estrada[12].y,estrada[13].x,estrada[13].y,g,Color.white);
                Graficos.reta(estrada[15].x,estrada[15].y,estrada[16].x,estrada[16].y,g,Color.white);
                Graficos.reta(estrada[18].x,estrada[18].y,estrada[19].x,estrada[19].y,g,Color.white);
                break;
            }
            case 1 :{
                Graficos.reta(estrada[1].x,estrada[1].y,estrada[2].x,estrada[2].y,g,Color.white);
                Graficos.reta(estrada[2].x,estrada[2].y,estrada[3].x,estrada[3].y,g,Color.white);
                Graficos.reta(estrada[7].x,estrada[7].y,estrada[8].x,estrada[8].y,g,Color.white);
                Graficos.reta(estrada[10].x,estrada[10].y,estrada[11].x,estrada[11].y,g,Color.white);
                Graficos.reta(estrada[13].x,estrada[13].y,estrada[14].x,estrada[14].y,g,Color.white);
                Graficos.reta(estrada[16].x,estrada[16].y,estrada[17].x,estrada[17].y,g,Color.white);
                break;
            }
            case 2 :{
                Graficos.reta(estrada[2].x,estrada[2].y,estrada[3].x,estrada[3].y,g,Color.white);
                Graficos.reta(estrada[5].x,estrada[5].y,estrada[6].x,estrada[6].y,g,Color.white);
                Graficos.reta(estrada[8].x,estrada[8].y,estrada[9].x,estrada[9].y,g,Color.white);
                Graficos.reta(estrada[11].x,estrada[11].y,estrada[12].x,estrada[12].y,g,Color.white);
                Graficos.reta(estrada[14].x,estrada[14].y,estrada[15].x,estrada[15].y,g,Color.white);
                Graficos.reta(estrada[17].x,estrada[17].y,estrada[18].x,estrada[18].y,g,Color.white);
                break;
            }
        }
        Graficos.reta(estrada[20].x, estrada[20].y, estrada[21].x, estrada[21].y, g, Color.black);
        Graficos.reta(estrada[22].x, estrada[22].y, estrada[23].x, estrada[23].y, g, Color.black);
        /*
        for (int i = 0; i < 30; i++) {
            if (estrada[20].y < estrada[22].y) {
                reta(estrada[20].x, estrada[20].y-i, estrada[21].x, estrada[21].y-i, g, Color.green);
                reta(estrada[22].x, estrada[22].y+i, estrada[23].x, estrada[23].y+i, g, Color.green);
            }else{
                reta(estrada[20].x, estrada[20].y+i, estrada[21].x, estrada[21].y+i, g, Color.green);
                reta(estrada[22].x, estrada[22].y-i, estrada[23].x, estrada[23].y-i, g, Color.green);
            }
            if (estrada[20].x < estrada[22].x) {
                reta(estrada[20].x-i, estrada[20].y, estrada[21].x-i, estrada[21].y, g, Color.green);
                reta(estrada[22].x+i, estrada[22].y, estrada[23].x+i, estrada[23].y, g, Color.green);
            }else{
                reta(estrada[20].x+i, estrada[20].y, estrada[21].x+i, estrada[21].y, g, Color.green);
                reta(estrada[22].x-i, estrada[22].y, estrada[23].x-i, estrada[23].y, g, Color.green);
            }
        }
        */
        for(int i = 210; i <= 230; i++)
            Graficos.reta(0,i,400,i,g,new Color(44,44,44));
    }
    
    /** Desenhar parte da frente do caminhão.
     * 
     * @param g 
     */
    public void desenharFrente(Graphics2D g) {
        for (int i = 1; i < cabine_esq[8].y-cabine_esq[0].y; i++)
            Graficos.reta(cabine_esq[0].x, cabine_esq[0].y+i, cabine_dir[0].x, cabine_dir[0].y+i, g, vermelho);
        for (int i = 0; i <= 20; i++)
            Graficos.reta(cabine_esq[2].x, cabine_esq[2].y+i, cabine_dir[2].x, cabine_dir[2].y+i, g, cinzaClaro);
        for (int i = 1; i < cabine_esq[22].y-cabine_esq[19].y; i++)
            Graficos.reta(cabine_esq[19].x, cabine_esq[19].y+i, cabine_dir[19].x, cabine_dir[19].y+i, g, cinzaClaro);
        Graficos.reta(cabine_esq[0].x,cabine_esq[0].y,cabine_dir[0].x,cabine_dir[0].y,g,Color.black);
        Graficos.reta(cabine_esq[8].x,cabine_esq[8].y,cabine_dir[8].x,cabine_dir[8].y,g,Color.black);
        Graficos.reta(cabine_esq[22].x,cabine_esq[22].y,cabine_dir[22].x,cabine_dir[22].y,g,Color.black);
        Graficos.reta(cabine_esq[0].x,cabine_esq[0].y,cabine_esq[22].x,cabine_esq[22].y,g,Color.black);
        Graficos.reta(cabine_dir[0].x,cabine_dir[0].y,cabine_dir[22].x,cabine_dir[22].y,g,Color.black);
        Graficos.reta(cabine_esq[1].x,cabine_esq[1].y,cabine_dir[1].x,cabine_dir[1].y,g,Color.black);
        Graficos.reta(cabine_esq[2].x,cabine_esq[2].y,cabine_dir[2].x,cabine_dir[2].y,g,Color.black);
        Graficos.reta(cabine_esq[1].x,cabine_esq[1].y,cabine_esq[2].x,cabine_esq[2].y,g,Color.black);
        Graficos.reta(cabine_dir[1].x,cabine_dir[1].y,cabine_dir[2].x,cabine_dir[2].y,g,Color.black);
        
        //desenhar parabrisa
        for (int i = 1; i < parabrisa[2].y-parabrisa[0].y; i++)
            Graficos.reta(parabrisa[0].x, parabrisa[0].y+i, parabrisa[1].x, parabrisa[1].y+i, g, cinzaEscuro);
        Graficos.reta(parabrisa[0].x,parabrisa[0].y,parabrisa[1].x,parabrisa[1].y,g,Color.black);
        Graficos.reta(parabrisa[0].x,parabrisa[0].y,parabrisa[2].x,parabrisa[2].y,g,Color.black);
        Graficos.reta(parabrisa[1].x,parabrisa[1].y,parabrisa[3].x,parabrisa[3].y,g,Color.black);
        Graficos.reta(parabrisa[2].x,parabrisa[2].y,parabrisa[3].x,parabrisa[3].y,g,Color.black);
    }
    
    /** Desenhar parte traseira do caminhão.
     * 
     * @param g 
     */
    public void desenharTras(Graphics2D g) {
        for (int i = 1; i < cabine_esq[4].y-cabine_esq[3].y; i++)
            Graficos.reta(cabine_esq[3].x, cabine_esq[3].y+i, cabine_dir[3].x, cabine_dir[3].y+i, g, cinzaClaro);
        for (int i = 1; i < cabine_esq[6].y-cabine_esq[5].y; i++)
            Graficos.reta(cabine_esq[5].x, cabine_esq[5].y+i, cabine_dir[5].x, cabine_dir[5].y+i, g, cinzaClaro);
        for (int i = 1; i < cabine_esq[32].y-cabine_esq[31].y; i++)
            Graficos.reta(cabine_esq[31].x, cabine_esq[31].y+i, cabine_dir[31].x, cabine_dir[31].y+i, g, cinzaClaro);
        Graficos.reta(cabine_esq[3].x,cabine_esq[3].y,cabine_dir[3].x,cabine_dir[3].y,g,Color.black);
        Graficos.reta(cabine_esq[4].x,cabine_esq[4].y,cabine_dir[4].x,cabine_dir[4].y,g,Color.black);
        Graficos.reta(cabine_esq[5].x,cabine_esq[5].y,cabine_dir[5].x,cabine_dir[5].y,g,Color.black);
        Graficos.reta(cabine_esq[6].x,cabine_esq[6].y,cabine_dir[6].x,cabine_dir[6].y,g,Color.black);
        Graficos.reta(cabine_esq[31].x,cabine_esq[31].y,cabine_dir[31].x,cabine_dir[31].y,g,Color.black);
        Graficos.reta(cabine_esq[32].x,cabine_esq[32].y,cabine_dir[32].x,cabine_dir[32].y,g,Color.black);
        Graficos.reta(cabine_esq[3].x,cabine_esq[3].y,cabine_esq[4].x,cabine_esq[4].y,g,Color.black);
        Graficos.reta(cabine_dir[3].x,cabine_dir[3].y,cabine_dir[4].x,cabine_dir[4].y,g,Color.black);
        Graficos.reta(cabine_esq[5].x,cabine_esq[5].y,cabine_esq[6].x,cabine_esq[6].y,g,Color.black);
        Graficos.reta(cabine_dir[5].x,cabine_dir[5].y,cabine_dir[6].x,cabine_dir[6].y,g,Color.black);
        Graficos.reta(cabine_esq[31].x,cabine_esq[31].y,cabine_esq[32].x,cabine_esq[32].y,g,Color.black);
        Graficos.reta(cabine_dir[31].x,cabine_dir[31].y,cabine_dir[32].x,cabine_dir[32].y,g,Color.black);
    }
    
    /** Desenhar parte de cima do caminhão.
     * 
     * @param g 
     */
    public void desenharCima(Graphics2D g) {
        for (int i = 0; i < 10; i++) {
            Graficos.reta(cabine_esq[0].x,cabine_esq[0].y+i,cabine_dir[0].x,cabine_dir[0].y+i,g,vermelho);
            Graficos.reta(cabine_esq[1].x,cabine_esq[1].y+i,cabine_dir[1].x,cabine_dir[1].y+i,g,vermelho);
            Graficos.reta(cabine_esq[0].x,cabine_esq[0].y+i,cabine_esq[1].x,cabine_esq[1].y+i,g,vermelho);
            Graficos.reta(cabine_dir[0].x,cabine_dir[0].y+i,cabine_dir[1].x,cabine_dir[1].y+i,g,vermelho);
            Graficos.reta(cabine_esq[2].x,cabine_esq[2].y+i,cabine_dir[2].x,cabine_dir[2].y+i,g,cinzaClaro);
            Graficos.reta(cabine_esq[3].x,cabine_esq[3].y+i,cabine_dir[3].x,cabine_dir[3].y+i,g,cinzaClaro);
            Graficos.reta(cabine_esq[2].x,cabine_esq[2].y+i,cabine_esq[3].x,cabine_esq[3].y+i,g,cinzaClaro);
            Graficos.reta(cabine_dir[2].x,cabine_dir[2].y+i,cabine_dir[3].x,cabine_dir[3].y+i,g,cinzaClaro);
            Graficos.reta(cabine_esq[4].x,cabine_esq[4].y+i,cabine_dir[4].x,cabine_dir[4].y+i,g,cinzaClaro);
            Graficos.reta(cabine_esq[5].x,cabine_esq[5].y+i,cabine_dir[5].x,cabine_dir[5].y+i,g,cinzaClaro);
            Graficos.reta(cabine_esq[4].x,cabine_esq[4].y+i,cabine_esq[5].x,cabine_esq[5].y+i,g,cinzaClaro);
            Graficos.reta(cabine_dir[4].x,cabine_dir[4].y+i,cabine_dir[5].x,cabine_dir[5].y+i,g,cinzaClaro);
            
            Graficos.reta(cabine_esq[6].x,cabine_esq[6].y+i,cabine_dir[6].x,cabine_dir[6].y+i,g,cinzaClaro);
            Graficos.reta(cabine_esq[31].x,cabine_esq[31].y+i,cabine_dir[31].x,cabine_dir[31].y+i,g,cinzaClaro);
            Graficos.reta(cabine_esq[6].x,cabine_esq[6].y+i,cabine_esq[31].x,cabine_esq[31].y+i,g,cinzaClaro);
            Graficos.reta(cabine_dir[6].x,cabine_dir[6].y+i,cabine_dir[31].x,cabine_dir[31].y+i,g,cinzaClaro);
        }
        Graficos.reta(cabine_esq[0].x,cabine_esq[0].y,cabine_dir[0].x,cabine_dir[0].y,g,Color.black);
        Graficos.reta(cabine_esq[0].x,cabine_esq[0].y,cabine_esq[1].x,cabine_esq[1].y,g,Color.black);
        Graficos.reta(cabine_esq[1].x,cabine_esq[1].y,cabine_dir[1].x,cabine_dir[1].y,g,Color.black);
        Graficos.reta(cabine_dir[0].x,cabine_dir[0].y,cabine_dir[1].x,cabine_dir[1].y,g,Color.black);
        Graficos.reta(cabine_esq[2].x,cabine_esq[2].y,cabine_dir[2].x,cabine_dir[2].y,g,Color.black);
        Graficos.reta(cabine_esq[2].x,cabine_esq[2].y,cabine_esq[3].x,cabine_esq[3].y,g,Color.black);
        Graficos.reta(cabine_esq[3].x,cabine_esq[3].y,cabine_dir[3].x,cabine_dir[3].y,g,Color.black);
        Graficos.reta(cabine_dir[2].x,cabine_dir[2].y,cabine_dir[3].x,cabine_dir[3].y,g,Color.black);
        Graficos.reta(cabine_esq[4].x,cabine_esq[4].y,cabine_dir[4].x,cabine_dir[4].y,g,Color.black);
        Graficos.reta(cabine_esq[4].x,cabine_esq[4].y,cabine_esq[5].x,cabine_esq[5].y,g,Color.black);
        Graficos.reta(cabine_esq[5].x,cabine_esq[5].y,cabine_dir[5].x,cabine_dir[5].y,g,Color.black);
        Graficos.reta(cabine_dir[4].x,cabine_dir[4].y,cabine_dir[5].x,cabine_dir[5].y,g,Color.black);
        Graficos.reta(cabine_esq[6].x,cabine_esq[6].y,cabine_dir[6].x,cabine_dir[6].y,g,Color.black);
        Graficos.reta(cabine_esq[6].x,cabine_esq[6].y,cabine_esq[31].x,cabine_esq[31].y,g,Color.black);
        Graficos.reta(cabine_esq[31].x,cabine_esq[31].y,cabine_dir[31].x,cabine_dir[31].y,g,Color.black);
        Graficos.reta(cabine_dir[6].x,cabine_dir[6].y,cabine_dir[31].x,cabine_dir[31].y,g,Color.black);
    }
    
    /** Desenhar parte de baixo do caminhão.
     * 
     * @param g 
     * 
     * @deprecated Não implementado.
     */
    public void desenharBaixo(Graphics2D g) {}
    
    /** Desenhar lado esquerdo do caminhão.
     * 
     * @param g 
     */
    public void desenharLadoEsq(Graphics2D g) {
        for (int i = 1; i < cabine_esq[8].y-cabine_esq[0].y; i++)
            Graficos.reta(cabine_esq[0].x, cabine_esq[0].y+i, cabine_esq[1].x, cabine_esq[1].y+i, g, vermelho);
        for (int i = 1; i < cabine_esq[14].y-cabine_esq[9].y; i++)
            Graficos.reta(cabine_esq[9].x, cabine_esq[9].y+i, cabine_esq[10].x, cabine_esq[10].y+i, g, cinzaEscuro);
        for (int i = 1; i < cabine_esq[18].y-cabine_esq[15].y; i++)
            Graficos.reta(cabine_esq[15].x, cabine_esq[15].y+i, cabine_esq[16].x, cabine_esq[16].y+i, g, cinzaEscuro);
        for (int i = 1; i < cabine_esq[7].y-cabine_esq[2].y; i++)
            Graficos.reta(cabine_esq[2].x, cabine_esq[2].y+i, cabine_esq[3].x, cabine_esq[3].y+i, g, cinzaClaro);
        for (int i = 1; i < cabine_esq[6].y-cabine_esq[5].y; i++)
            Graficos.reta(cabine_esq[4].x, cabine_esq[4].y+i, cabine_esq[5].x, cabine_esq[5].y+i, g, cinzaClaro);
        for (int i = 1; i < cabine_esq[22].y-cabine_esq[19].y; i++)
            Graficos.reta(cabine_esq[19].x, cabine_esq[19].y+i, cabine_esq[20].x, cabine_esq[20].y+i, g, cinzaClaro);
        for (int i = 1; i < cabine_esq[27].y-cabine_esq[23].y; i++)
            Graficos.reta(cabine_esq[23].x, cabine_esq[23].y+i, cabine_esq[26].x, cabine_esq[26].y+i, g, cinzaEscuro);
        for (int i = 1; i < cabine_esq[33].y-cabine_esq[26].y; i++)
            Graficos.reta(cabine_esq[26].x, cabine_esq[26].y+i, cabine_esq[31].x, cabine_esq[31].y+i, g, cinzaClaro);
        Graficos.reta(cabine_esq[0].x,cabine_esq[0].y,cabine_esq[1].x,cabine_esq[1].y,g,Color.black);
        Graficos.reta(cabine_esq[2].x,cabine_esq[2].y,cabine_esq[7].x,cabine_esq[7].y,g,Color.black);
        Graficos.reta(cabine_esq[2].x,cabine_esq[2].y,cabine_esq[3].x,cabine_esq[3].y,g,Color.black);
        Graficos.reta(cabine_esq[3].x,cabine_esq[3].y,cabine_esq[4].x,cabine_esq[4].y,g,Color.black);
        Graficos.reta(cabine_esq[4].x,cabine_esq[4].y,cabine_esq[5].x,cabine_esq[5].y,g,Color.black);
        Graficos.reta(cabine_esq[5].x,cabine_esq[5].y,cabine_esq[6].x,cabine_esq[6].y,g,Color.black);
        Graficos.reta(cabine_esq[0].x,cabine_esq[0].y,cabine_esq[22].x,cabine_esq[22].y,g,Color.black);
        Graficos.reta(cabine_esq[8].x,cabine_esq[8].y,cabine_esq[31].x,cabine_esq[31].y,g,Color.black);
        Graficos.reta(cabine_esq[21].x,cabine_esq[21].y,cabine_esq[22].x,cabine_esq[22].y,g,Color.black);
        Graficos.reta(cabine_esq[31].x,cabine_esq[31].y,cabine_esq[32].x,cabine_esq[32].y,g,Color.black);
        Graficos.reta(cabine_esq[33].x,cabine_esq[33].y,cabine_esq[32].x,cabine_esq[32].y,g,Color.black);
        Graficos.reta(cabine_esq[30].x,cabine_esq[30].y,cabine_esq[27].x,cabine_esq[27].y,g,Color.black);
        Graficos.reta(cabine_esq[23].x,cabine_esq[23].y,cabine_esq[27].x,cabine_esq[27].y,g,Color.black);
        Graficos.reta(cabine_esq[24].x,cabine_esq[24].y,cabine_esq[28].x,cabine_esq[28].y,g,Color.black);
        Graficos.reta(cabine_esq[25].x,cabine_esq[25].y,cabine_esq[29].x,cabine_esq[29].y,g,Color.black);
        Graficos.reta(cabine_esq[30].x,cabine_esq[30].y,cabine_esq[26].x,cabine_esq[26].y,g,Color.black);
        Graficos.reta(cabine_esq[9].x,cabine_esq[9].y,cabine_esq[10].x,cabine_esq[10].y,g,Color.black);
        Graficos.reta(cabine_esq[10].x,cabine_esq[10].y,cabine_esq[12].x,cabine_esq[12].y,g,Color.black);
        Graficos.reta(cabine_esq[13].x,cabine_esq[13].y,cabine_esq[12].x,cabine_esq[12].y,g,Color.black);
        Graficos.reta(cabine_esq[13].x,cabine_esq[13].y,cabine_esq[9].x,cabine_esq[9].y,g,Color.black);
        Graficos.reta(cabine_esq[11].x,cabine_esq[11].y,cabine_esq[14].x,cabine_esq[14].y,g,Color.black);
        Graficos.reta(cabine_esq[15].x,cabine_esq[15].y,cabine_esq[16].x,cabine_esq[16].y,g,Color.black);
        Graficos.reta(cabine_esq[17].x,cabine_esq[17].y,cabine_esq[16].x,cabine_esq[16].y,g,Color.black);
        Graficos.reta(cabine_esq[17].x,cabine_esq[17].y,cabine_esq[18].x,cabine_esq[18].y,g,Color.black);
        Graficos.reta(cabine_esq[15].x,cabine_esq[15].y,cabine_esq[18].x,cabine_esq[18].y,g,Color.black);
    }
    
    /** Desenhar lado direito do caminhão.
     * 
     * @param g 
     */
    public void desenharLadoDir(Graphics2D g) {
        for (int i = 1; i < cabine_dir[8].y-cabine_dir[0].y; i++)
            Graficos.reta(cabine_dir[0].x, cabine_dir[0].y+i, cabine_dir[1].x, cabine_dir[1].y+i, g, vermelho);
        for (int i = 1; i < cabine_dir[14].y-cabine_dir[9].y; i++)
            Graficos.reta(cabine_dir[9].x, cabine_dir[9].y+i, cabine_dir[10].x, cabine_dir[10].y+i, g, cinzaEscuro);
        for (int i = 1; i < cabine_dir[18].y-cabine_dir[15].y; i++)
            Graficos.reta(cabine_dir[15].x, cabine_dir[15].y+i, cabine_dir[16].x, cabine_dir[16].y+i, g, cinzaEscuro);
        for (int i = 1; i < cabine_dir[7].y-cabine_dir[2].y; i++)
            Graficos.reta(cabine_dir[2].x, cabine_dir[2].y+i, cabine_dir[3].x, cabine_dir[3].y+i, g, cinzaClaro);
        for (int i = 1; i < cabine_dir[6].y-cabine_dir[5].y; i++)
            Graficos.reta(cabine_dir[4].x, cabine_dir[4].y+i, cabine_dir[5].x, cabine_dir[5].y+i, g, cinzaClaro);
        for (int i = 1; i < cabine_dir[22].y-cabine_dir[19].y; i++)
            Graficos.reta(cabine_dir[19].x, cabine_dir[19].y+i, cabine_dir[20].x, cabine_dir[20].y+i, g, cinzaClaro);
        for (int i = 1; i < cabine_dir[27].y-cabine_dir[23].y; i++)
            Graficos.reta(cabine_dir[23].x, cabine_dir[23].y+i, cabine_dir[26].x, cabine_dir[26].y+i, g, cinzaEscuro);
        for (int i = 1; i < cabine_dir[33].y-cabine_dir[26].y; i++)
            Graficos.reta(cabine_dir[26].x, cabine_dir[26].y+i, cabine_dir[31].x, cabine_dir[31].y+i, g, cinzaClaro);
        Graficos.reta(cabine_dir[0].x,cabine_dir[0].y,cabine_dir[1].x,cabine_dir[1].y,g,Color.black);
        Graficos.reta(cabine_dir[2].x,cabine_dir[2].y,cabine_dir[7].x,cabine_dir[7].y,g,Color.black);
        Graficos.reta(cabine_dir[2].x,cabine_dir[2].y,cabine_dir[3].x,cabine_dir[3].y,g,Color.black);
        Graficos.reta(cabine_dir[3].x,cabine_dir[3].y,cabine_dir[4].x,cabine_dir[4].y,g,Color.black);
        Graficos.reta(cabine_dir[4].x,cabine_dir[4].y,cabine_dir[5].x,cabine_dir[5].y,g,Color.black);
        Graficos.reta(cabine_dir[5].x,cabine_dir[5].y,cabine_dir[6].x,cabine_dir[6].y,g,Color.black);
        Graficos.reta(cabine_dir[0].x,cabine_dir[0].y,cabine_dir[22].x,cabine_dir[22].y,g,Color.black);
        Graficos.reta(cabine_dir[8].x,cabine_dir[8].y,cabine_dir[31].x,cabine_dir[31].y,g,Color.black);
        Graficos.reta(cabine_dir[21].x,cabine_dir[21].y,cabine_dir[22].x,cabine_dir[22].y,g,Color.black);
        Graficos.reta(cabine_dir[31].x,cabine_dir[31].y,cabine_dir[32].x,cabine_dir[32].y,g,Color.black);
        Graficos.reta(cabine_dir[33].x,cabine_dir[33].y,cabine_dir[32].x,cabine_dir[32].y,g,Color.black);
        Graficos.reta(cabine_dir[30].x,cabine_dir[30].y,cabine_dir[27].x,cabine_dir[27].y,g,Color.black);
        Graficos.reta(cabine_dir[23].x,cabine_dir[23].y,cabine_dir[27].x,cabine_dir[27].y,g,Color.black);
        Graficos.reta(cabine_dir[24].x,cabine_dir[24].y,cabine_dir[28].x,cabine_dir[28].y,g,Color.black);
        Graficos.reta(cabine_dir[25].x,cabine_dir[25].y,cabine_dir[29].x,cabine_dir[29].y,g,Color.black);
        Graficos.reta(cabine_dir[30].x,cabine_dir[30].y,cabine_dir[26].x,cabine_dir[26].y,g,Color.black);
        Graficos.reta(cabine_dir[9].x,cabine_dir[9].y,cabine_dir[10].x,cabine_dir[10].y,g,Color.black);
        Graficos.reta(cabine_dir[10].x,cabine_dir[10].y,cabine_dir[12].x,cabine_dir[12].y,g,Color.black);
        Graficos.reta(cabine_dir[13].x,cabine_dir[13].y,cabine_dir[12].x,cabine_dir[12].y,g,Color.black);
        Graficos.reta(cabine_dir[13].x,cabine_dir[13].y,cabine_dir[9].x,cabine_dir[9].y,g,Color.black);
        Graficos.reta(cabine_dir[11].x,cabine_dir[11].y,cabine_dir[14].x,cabine_dir[14].y,g,Color.black);
        Graficos.reta(cabine_dir[15].x,cabine_dir[15].y,cabine_dir[16].x,cabine_dir[16].y,g,Color.black);
        Graficos.reta(cabine_dir[17].x,cabine_dir[17].y,cabine_dir[16].x,cabine_dir[16].y,g,Color.black);
        Graficos.reta(cabine_dir[17].x,cabine_dir[17].y,cabine_dir[18].x,cabine_dir[18].y,g,Color.black);
        Graficos.reta(cabine_dir[15].x,cabine_dir[15].y,cabine_dir[18].x,cabine_dir[18].y,g,Color.black);
    }
    
    /** Multiplica um ponto (x,y,z) por uma matriz 3x3.
     * 
     * @param p Ponto a ser multiplicado
     * @param matriz Matriz de 9 elementos [3x3]
     * @return Ponto multiplicado
     */
    public ponto multiplicarMatriz(ponto p, double matriz[]) {
        ponto retorno = new ponto();
        retorno.x = (int)((((double)(p.x))*matriz[0])+(((double)(p.y))*matriz[3])+(((double)(p.z))*matriz[6]));
        retorno.y = (int)((((double)(p.x))*matriz[1])+(((double)(p.y))*matriz[4])+(((double)(p.z))*matriz[7]));
        retorno.z = (int)((((double)(p.x))*matriz[2])+(((double)(p.y))*matriz[5])+(((double)(p.z))*matriz[8]));
        return retorno;
    }
    
    /** Aplica efeito de rotação no caminhão, atualizando todos os seus pontos.
     * 
     * @param graus Inteiro de 0 a 360
     * @param posição Em relação de que eixo será aplicada a rotação (x, y ou z)
     */
    public void rotacionar(int graus, char posição) {
        double grausRota = (((double)graus)/360.0d)*2*Math.PI;
        double[] matriz = new double[9];
        for (int i = 0; i < 9; i++)
            matriz[i] = 0.0d;
        switch (posição) {
            case 'x': {
                matriz[0] = 1.0d;
                matriz[4] = cos(grausRota);
                matriz[5] = -sin(grausRota);
                matriz[7] = sin(grausRota);
                matriz[8] = cos(grausRota);
                break;
            }
            case 'y': {
                matriz[0] = cos(grausRota);
                matriz[2] = sin(grausRota);
                matriz[4] = 1.0d;
                matriz[6] = -sin(grausRota);
                matriz[8] = cos(grausRota);
                break;
            }
            case 'z': {
                matriz[0] = cos(grausRota);
                matriz[1] = -sin(grausRota);
                matriz[3] = sin(grausRota);
                matriz[4] = cos(grausRota);
                matriz[8] = 1.0d;
                break;
            }
        }
        for (int i = 0; i < 34; i++) {
            cabine_esq[i] = multiplicarMatriz(cabine_esq[i], matriz);
            cabine_dir[i] = multiplicarMatriz(cabine_dir[i], matriz);
        }
        for (int i = 0; i < 4; i++)
            parabrisa[i] = multiplicarMatriz(parabrisa[i], matriz);
        for (int i = 0; i < 6; i++) {
            pneu_esq_dentro[i] = multiplicarMatriz(pneu_esq_dentro[i], matriz);
            pneu_esq_fora[i] = multiplicarMatriz(pneu_esq_fora[i], matriz);
            pneu_dir_dentro[i] = multiplicarMatriz(pneu_dir_dentro[i], matriz);
            pneu_dir_fora[i] = multiplicarMatriz(pneu_dir_fora[i], matriz);
        }
        for (int i = 0; i < 24; i++)
            estrada[i] = multiplicarMatriz(estrada[i], matriz);
    }
    
    /** Desenha o caminhão.
     * 
     * @param g 
     */
    public void desenhar(Graphics2D g) {
        if (pneu_esq_fora[0].z < pneu_dir_fora[0].z)
            desenharPneuDir(g);
        else
            desenharPneuEsq(g);
        desenharCima(g);
        if (cabine_esq[0].z != cabine_dir[0].z)
            if (cabine_esq[0].z < cabine_dir[0].z)
                desenharLadoEsq(g);
            else
                desenharLadoDir(g);
        if (cabine_esq[0].x != cabine_dir[0].x)
            if (cabine_esq[0].z < cabine_esq[1].z)
                desenharFrente(g);
            else
                desenharTras(g);
        if (pneu_esq_fora[0].z < pneu_dir_fora[0].z)
            desenharPneuEsq(g);
        else
            desenharPneuDir(g);
    }
}
