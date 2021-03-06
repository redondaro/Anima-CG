package Principal;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import static java.lang.Math.sqrt;

/** Classe com funções para exibir algumas formas geométricas e cenários da animação.
 * 
 * @author Luiz Fernando Perez Redondaro
 */
public class Graficos {
    
    /** Desenha uma reta usando o algoritmo de Bresenham.
     * 
     * @param x1 Ponto inicial de x
     * @param y1 Ponto inicial de y
     * @param x2 Ponto final de x
     * @param y2 Ponto final de y
     * @param g
     * @param cor 
     */
    public static void reta(int x1, int y1, int x2, int y2, Graphics2D g, Color cor) {
        int x, y, d, dx, dy, transf, DE, DNE;
        g.setColor(cor);
        dx = x2-x1;
        dy = y2-y1;
        x = x1;
        y = y1;
        if ((dx > 1) || (dy > 1))
            g.drawLine(x, y, x, y);
        if (dx > 0) {
            if (dy > 0) {
                if (dx >= dy)
                    transf = 1;
                else{
                    transf = dx;
                    dx = dy;
                    dy = transf;
                    transf = x1;
                    x1 = y1;
                    y1 = transf;
                    x2 = y2;
                    x = x1;
                    y = y1;
                    transf = 2;
                }
            }else{
                dy = dy*(-1);
                if (dx >= dy)
                    transf = 3;
                else { //dx < dy
                    transf = dx;
                    dx = dy;
                    dy = transf;
                    transf = x1;
                    x1 = y1;
                    y1 = transf;
                    x2 = y2;
                    transf = x2;
                    x2 = x1;
                    x1 = transf;
                    x = x1;
                    y = y1;
                    transf = 4;
                }
            }
        }else{ //dx <= 0
            dx = dx*(-1);
            transf = x1;
            x1 = x2;
            x2 = transf;
            if (dy > 0) {
                if (dx >= dy) {
                    x = x1;
                    transf = 5;
                }else{ //dx < dy
                    transf = dx;
                    dx = dy;
                    dy = transf;
                    transf = x1;
                    x1 = y1;
                    y1 = transf;
                    transf = x2;
                    x2 = y2;
                    y2 = transf;
                    x = x1;
                    y = y1;
                    transf = 6;
                }
            }else{
                dy = dy*(-1);
                if (dx >= dy){ 
                    x = x1;
                    transf = 7;
                }else{ //dx < dy
                    transf = y1;
                    y1 = y2;
                    y2 = transf;
                    transf = dx;
                    dx = dy;
                    dy = transf;
                    transf = x1;
                    x1 = y1;
                    y1 = transf;
                    transf = x2;
                    x2 = y2;
                    y2 = transf;
                    x = x1;
                    y = y1;
                    transf = 8;
                }
            }
        }
        d = 2*dy - dx;
        DE = 2*dy;
        DNE = 2*(dy-dx);
        while (x < x2) {
            if (d <= 0){
                d = d+DE;
                x = x+1;
            }else{
                d = d+DNE;
                x = x+1;
                y = y+1;
            }
            switch (transf) {
                case 1: {
                    g.drawLine(x, y, x, y);
                    break;
                }
                case 2: {
                    g.drawLine(y, x, y, x);
                    break;
                }
                case 3: {
                    g.drawLine(x, y1-(y-y1), x, y1-(y-y1));
                    break;
                }
                case 4: {
                    g.drawLine(y1+dy-(y-y1), x, y1+dy-(y-y1), x);
                    break;
                }
                case 5: {
                    g.drawLine(x1+dx-(x-x1), y, x1+dx-(x-x1), y);
                    break;
                }
                case 6: {
                    g.drawLine(y, x1+dx-(x-x1), y, x1+dx-(x-x1));
                    break;
                }
                case 7: {
                    g.drawLine(x1+dx-(x-x1), y1-(y-y1), x1+dx-(x-x1), y1-(y-y1));
                    break;
                }
                case 8: {
                    g.drawLine(y1+dy-(y-y1),x1+dx-(x-x1), y1+dy-(y-y1),x1+dx-(x-x1));
                    break;
                }
            }
        }
    }
    
    /** Desenha um círculo usando o algoritmo de Bresenham.
     * 
     * @param x1 Ponto inicial de x
     * @param y1 Ponto inicial de y
     * @param x2 Ponto final de x
     * @param y2 Ponto final de y
     * @param g
     * @param cor 
     */
    public static void circulo(int x1, int y1, int x2, int y2, Graphics2D g, Color cor) {
        int x,y,d,R ;
        x = 0;
        R = (int)sqrt((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1));
        y = R;
        d = 1-R;
        g.setColor(cor);
        g.drawLine(x1, y1, x1+R, y1);
        g.drawLine(x1, y1, x1, y1+R);
        g.drawLine(x1, y1, x1-R, y1);
        g.drawLine(x1, y1, x1, y1-R);
        while (x < y) {
            if (d < 0) {
                d = d + 2*x + 3;
                x = x + 1;
            }else{
                d = d + 2*(x-y) + 5;
                x = x + 1;
                y = y - 1;
            }
            g.drawLine(x1+x,y1+y,x1+x,y1+y);
            g.drawLine(x1+y,y1+x,x1+y,y1+x);
            g.drawLine(x1-x,y1+y,x1-x,y1+y);
            g.drawLine(x1+y,y1-x,x1+y,y1-x);
            g.drawLine(x1+x,y1-y,x1+x,y1-y);
            g.drawLine(x1-y,y1+x,x1-y,y1+x);
            g.drawLine(x1-x,y1-y,x1-x,y1-y);
            g.drawLine(x1-y,y1-x,x1-y,y1-x);
        }
    }
    
    /** Desenha uma elipse.
     * 
     * @param x2
     * @param y2
     * @param x1
     * @param y1
     * @param g
     * @param cor 
     */
    public static void elipse(int x2, int y2, int x1, int y1, Graphics2D g, Color cor) {
        int a2, b2, fa2, fb2, dx, dy, xc, yc;
        float sigma;
        if (x2 > x1)
            dx = x2 - x1;
        else
            dx = x1 - x2;
        if (y2 > y1)
            dy = y2 - y1;
        else
            dy = y1 - y2;
        a2 = dx*dx;
        b2 = dy*dy;
        fa2 = 4 * a2;
        fb2 = 4 * b2;
        xc = 0;
        yc = dy;
        sigma = 2*b2+a2*(1-2*dy);
        g.setColor(cor);
        while (b2*xc <= a2*yc) {
            g.drawLine(x1+xc,y1+yc,x1+xc,y1+yc);
            g.drawLine(x1-xc,y1+yc,x1-xc,y1+yc);
            g.drawLine(x1+xc,y1-yc,x1+xc,y1-yc);
            g.drawLine(x1-xc,y1-yc,x1-xc,y1-yc);
            if (sigma >= 0.0f) {
                sigma = sigma + fa2 * (1 - yc);
                yc = yc-1;
            }
           sigma = sigma + b2 * ((4 * xc) + 6);
           xc = xc+1;
        }
        xc = dx;
        yc = 0;
        sigma = 2*a2+b2*(1-2*dx);
        while (a2*yc <= b2*xc) {
            g.drawLine(x1+xc,y1+yc,x1+xc,y1+yc);
            g.drawLine(x1-xc,y1+yc,x1-xc,y1+yc);
            g.drawLine(x1+xc,y1-yc,x1+xc,y1-yc);
            g.drawLine(x1-xc,y1-yc,x1-xc,y1-yc);
            if (sigma >= 0.0f) {
                sigma = sigma + fb2 * (1 - xc);
                xc = xc-1;
            }
           sigma = sigma + a2 * ((4 * yc) + 6);
           yc = yc+1;
        }
    }
    
    /** Desenha uma casa. Usada na primeira parte da animação.
     * 
     * @param portaAberta Se a porta deve ser desenhada aberta (fechada se false)
     * @param g 
     */
    public static void fundoCasa(boolean portaAberta, Graphics2D g) {
        //grama
        reta(0,172,400,172, g, Color.BLACK);
        for (int y = 173; y <= 270; y++)
            reta(0,y,400,y, g, new Color(0,128,0));
        reta(0,271,400,271, g, Color.BLACK);
        //casa/parede branca
        reta(47,89,47,231, g, Color.BLACK);
        reta(47,231,345,231, g, Color.BLACK);
        reta(345,89,345,231, g, Color.BLACK);
        for (int y = 90; y < 231; y++)
            reta(48,y,344,y, g, Color.LIGHT_GRAY);
        //porta
        reta(165,134,225,134, g, Color.BLACK);
        reta(165,134,165,231, g, Color.BLACK);
        reta(225,134,225,231, g, Color.BLACK);
        if (portaAberta) {
            for (int y = 135; y <= 193; y++)
                reta(166,y,196,y, g, new Color(128,128,255));
            reta(166,194,196,194, g, Color.BLACK);
            for (int y = 195; y <= 230; y++)
                reta(166,y,222,y, g, new Color(128,64,0));
            reta(197,135,197,204, g, Color.BLACK);
            reta(197,204,223,230, g, Color.BLACK);
            for (int y = 135; y < 204; y++)
                reta(198,y,224,y, g, new Color(128,0,0));
            for (int y = 204; y <= 230; y++)
                reta(198,204,224,y, g, new Color(128,0,0));
        }else
            for (int y = 135; y < 231; y++)
                reta(166,y,224,y, g, new Color(128,0,0));
        //janela esquerda
        reta(74,142,138,142, g, Color.BLACK);
        reta(74,190,138,190, g, Color.BLACK);
        reta(74,142,74,190, g, Color.BLACK);
        reta(138,142,138,190, g, Color.BLACK);
        for (int y = 143; y < 190; y++)
            reta(75,y,137,y, g, new Color(0,0,128));
        reta(106,142,106,190, g, Color.BLACK);
        reta(74,166,138,166, g, Color.BLACK);
        //janela direita
        reta(251,142,315,142, g, Color.BLACK);
        reta(251,190,315,190, g, Color.BLACK);
        reta(251,142,251,190, g, Color.BLACK);
        reta(315,142,315,190, g, Color.BLACK);
        for (int y = 143; y < 190; y++)
            reta(252,y,314,y, g, new Color(0,0,128));
        reta(283,142,283,190, g, Color.BLACK);
        reta(251,166,314,166, g, Color.BLACK);
        //telhado
        for (int x = 2; x <= 84; x++)
            reta(x,88,84,6,g, new Color(128,0,0));
        for (int x = 315; x <= 398; x++)
            reta(x,89,315,6,g, new Color(128,0,0));
        for (int y = 6; y <= 88; y++)
            reta(84,y,315,y,g, new Color(128,0,0));
        reta(84,5,315,5, g, Color.BLACK);
        reta(84,5,0,89, g, Color.BLACK);
        reta(315,5,399,89, g, Color.BLACK);
        reta(0,89,400,89, g, Color.BLACK);
        //estrelas
        reta(24,10,26,10, g, Color.LIGHT_GRAY);
        reta(25,9,25,12, g, Color.LIGHT_GRAY);
        reta(14,52,16,52, g, Color.LIGHT_GRAY);
        reta(15,51,15,54, g, Color.LIGHT_GRAY);
        reta(13,112,15,112, g, Color.LIGHT_GRAY);
        reta(14,111,14,114, g, Color.LIGHT_GRAY);
        reta(38,102,40,102, g, Color.LIGHT_GRAY);
        reta(39,101,39,104, g, Color.LIGHT_GRAY);
        reta(351,13,353,13, g, Color.LIGHT_GRAY);
        reta(352,12,352,15, g, Color.LIGHT_GRAY);
        reta(381,16,383,16, g, Color.LIGHT_GRAY);
        reta(382,15,382,18, g, Color.LIGHT_GRAY);
        reta(370,37,372,37, g, Color.LIGHT_GRAY);
        reta(371,36,371,39, g, Color.LIGHT_GRAY);
        reta(371,105,373,105, g, Color.LIGHT_GRAY);
        reta(372,104,372,107, g, Color.LIGHT_GRAY);
    }
    
    /** Desenha o personagem sem camisa, com a barriga grande e uma tatuagem de
     * coração escrito Raimunda. Usada na segunda parte da animação.
     * 
     * @param g 
     */
    public static void fundoTatuagem(Graphics2D g) {
        for (int i = 0; i < 300; i++) {
            reta(0,i,400,i,g, Color.white);
        }
        Color ponto = new Color(102,86,77), pele = new Color(255,198,165);
        int a = 2, b = 37;
        
        //ombros
        elipse(2,37,89,124,g, ponto);
        elipse(397,37,311,124,g, ponto);
        for (int i = 1; i < 87; i++)
            for (int j = 0; j < 7; j++){
                elipse(2+i+j,37+i,89+j,124,g, pele);
                elipse(397-i-j,37+i,311-j,124,g, pele);
            }
        
        //pescoço
        for (int i = 0; i < 38; i++)
            reta(136,i,266,i,g,pele);
        elipse(159,37,136,14,g, ponto);
        elipse(243,37,266,14,g, ponto);
        for (int i = 0; i <= 20; i++){
            elipse(158-i,36,136-i,12,g, Color.white);
            elipse(244+i,36,266+i,13,g, Color.white);
        }
        for (int i = 0; i < 19; i++) {
            reta(113,i,159,i,g,Color.white);
            reta(113,i+18,136,i+18,g,Color.white);
            reta(243,i,315,i,g,Color.white);
            reta(266,i+18,315,i+18,g,Color.white);
        }
        reta(159,0,159,19,g,ponto);
        reta(243,0,243,19,g,ponto);
        
        //corpo
        reta(89,37,136,37,g,ponto);
        reta(266,37,311,37,g,ponto);
        for (int i = 38; i < 130; i++)
            reta(89,i,311,i,g,pele);
        for (int i = 124; i <= 300; i++)
            reta(3,i,396,i,g,pele);
        reta(2,124,2,300,g,ponto);
        reta(397,124,397,300,g,ponto);
        elipse(71,179,199,261,g, ponto);
        for (int i = 0; i < 3; i++)
            elipse(197+i,285+i,200,287,g, ponto);
        
        //peito
        elipse(75,134,137,157,g, ponto);
        elipse(200,134,263,157,g, ponto);
        for (int i = 134; i < 158; i++)
            reta(75,i,324,i,g, pele);
        for (int i = 0; i < 6; i++) {
            elipse(128+i,156+i,137,163,g, ponto);
            elipse(254+i,156+i,263,163,g, ponto);
        }
        
        //braços
        reta(75,114,75,240,g,ponto);
        reta(75,282,75,300,g,ponto);
        reta(325,114,325,245,g,ponto);
        reta(325,278,325,300,g,ponto);
        
        //coração
        elipse(168,42,204,78,g, ponto);
        elipse(239,42,275,78,g, ponto);
        for (int i = 71; i < 115; i++)
            reta(180,i,298,i,g,pele);
        reta(180,105,239,151,g,ponto);
        reta(298,105,239,151,g,ponto);
        
        //texto
        g.setColor(ponto);
        g.setFont(new Font("", Font.ITALIC, 20));
        g.drawString("RAIMUNDA", 184, 100);
    }
    
    /** Desenha o cenário de prisão. Usado na terceira parte da animação.
     * 
     * @param g 
     */
    public static void fundoPrisao(Graphics2D g) {
        //luz no chão
        for (int i = 0; i < 12; i++){
            elipse(130+i,179+i,189,237,g,new Color(128,128,56));
            elipse(131+i,179+i,190,237,g,new Color(128,128,56));
            elipse(132+i,179+i,191,237,g,new Color(128,128,56));
        }
        for (int i = 12; i < 30; i++){
            elipse(130+i,179+i,189,237,g,new Color(128,128,0));
            elipse(131+i,179+i,190,237,g,new Color(128,128,0));
            elipse(132+i,179+i,191,237,g,new Color(128,128,0));
        }
        for (int i = 30; i < 50; i++){
            elipse(130+i,179+i,189,237,g,new Color(150,150,0));
            elipse(131+i,179+i,190,237,g,new Color(150,150,0));
            elipse(132+i,179+i,191,237,g,new Color(150,150,0));
        }
        for (int i = 50; i < 59; i++){
            elipse(130+i,179+i,189,237,g,new Color(180,180,0));
            elipse(131+i,179+i,190,237,g,new Color(180,180,0));
            elipse(132+i,179+i,191,237,g,new Color(180,180,0));
        }
        //paredes
        for (int i = 0; i <= 149; i++){
            reta(0,i,400,155+i,g,Color.gray);
            reta(0,i,400,i,g,Color.gray);
        }
        for (int i = 0; i < 30;i++)
            reta(380,149+i,400,149+i,g,Color.gray);
        //luz de cima
        for (int i = 0; i < 8; i++) {
            elipse(172+i,32+i,199,59,g,new Color(128,128,56));
            elipse(172+i,32+i,200,59,g,new Color(128,128,56));
            elipse(172+i,32+i,201,59,g,new Color(128,128,56));
        }
        for (int i = 8; i < 16; i++) {
            elipse(172+i,32+i,199,59,g,new Color(128,128,0));
            elipse(172+i,32+i,200,59,g,new Color(128,128,0));
            elipse(172+i,32+i,201,59,g,new Color(128,128,0));
        }
        for (int i = 16; i < 22; i++) {
            elipse(172+i,32+i,199,59,g,new Color(150,150,0));
            elipse(172+i,32+i,200,59,g,new Color(150,150,0));
            elipse(172+i,32+i,201,59,g,new Color(150,150,0));
        }
        for (int i = 22; i <= 26; i++) {
            elipse(172+i,32+i,199,59,g,new Color(180,180,0));
            elipse(172+i,32+i,200,59,g,new Color(180,180,0));
            elipse(172+i,32+i,201,59,g,new Color(180,180,0));
        }
        reta(194,33,206,33,g,Color.darkGray);
        
        //luminária
        for (int i = 0; i <= 5; i++) {
            elipse(191+i,29+i,200,33,g, Color.darkGray);
            elipse(192+i,29+i,201,33,g, Color.darkGray);
        }
        elipse(191,29,200,33,g, Color.black);
        for (int i = 192; i <= 196; i++)
            reta(i,31,196,20,g,Color.darkGray);
        for (int i = 204; i <= 209; i++)
            reta(i,32,204,20,g,Color.darkGray);
        for (int i = 17; i < 30; i++)
            reta(196,i,204,i,g,Color.darkGray);
        for (int i = 0; i < 5; i++)
            elipse(196+i,14+i,200,19,g, Color.darkGray);
        for (int i = 15; i <= 21; i++)
            reta(203,i,208,i,g,Color.darkGray);
        reta(192,31,196,19,g,Color.black);
        reta(209,32,204,20,g,Color.black);
        reta(202,14,207,14,g,Color.black);
        reta(204,22,207,22,g,Color.black);
        reta(207,14,209,16,g,Color.black);
        reta(207,22,209,20,g,Color.black);
        reta(209,16,209,20,g,Color.black);
        elipse(196,14,200,19,g, Color.black);
        
        //celas
        for (int i = -15; i < 149; i++)
            reta(0,i,37,15+i,g,Color.lightGray);
        for (int i = 17; i <= 181; i++)
            reta(85,i,310,88+i,g,Color.lightGray);
        for (int i = 123; i < 289; i++)
            reta(357,i,400,16+i,g,Color.lightGray);
        reta(87,181,207,66,g,Color.black);
        reta(359,288,399,250,g,Color.black);
        
        //grades
        reta(357,122,399,138,g,Color.black);
        reta(357,123,399,139,g,Color.black);
        reta(85,16,310,104,g,Color.black);
        reta(85,17,310,105,g,Color.black);
        reta(5,0,5,151,g,Color.black);
        reta(6,0,6,151,g,Color.black);
        reta(21,0,21,157,g,Color.black);
        reta(22,0,22,158,g,Color.black);
        reta(37,0,37,164,g,Color.black);
        reta(38,0,38,164,g,Color.black);
        for (int i = 0; i < 15; i++) {
            reta(85+16*i,17+6*i+((i-4)/2),85+16*i,182+6*i+((i-1)/2),g,Color.black);
            reta(86+16*i,17+6*i+((i-4)/2),86+16*i,182+6*i+((i-1)/2),g,Color.black);
        }
        reta(357,123,357,289,g,Color.black);
        reta(358,123,358,289,g,Color.black);
        reta(373,129,373,295,g,Color.black);
        reta(374,129,374,295,g,Color.black);
        reta(389,135,389,301,g,Color.black);
        reta(390,135,390,301,g,Color.black);
        
        //contorno chão
        reta(0,148,385,298,g,Color.black);
        reta(0,149,385,299,g,Color.black);
    }
    
}
