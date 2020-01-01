package Principal;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferStrategy;
import java.io.File;
import javax.swing.JFrame;

/** Como o nome sugere, esta classe é baseada em uma engine de jogo. Carrega
 * elementos e executa a animação, de acordo com o tempo em segundos.
 * 
 * @author Luiz Fernando Perez Redondaro
 */
public class Engine implements WindowListener, KeyListener{

    /** Janela principal, na qual a animação será exibida. */
    JFrame janela = new JFrame("Trabalho de CG");
    
    /** Se a animação está sendo executada. */
    boolean ativa = false;
    
    /** Se iniciou a animação. */
    boolean iniciou = false;
    
    /** Buffer para a exibição gráfica da animação. */
    BufferStrategy bufferStrategy;
    
    /** Tempo de execução, em segundos. */
    int segundos = 0;
    
    Caminhao caminhão = new Caminhao();
    
    /** Variáveis auxiliares. */
    int evento = 0, auxiliar = 0, faixa = 0;
    
    /** Figuras e personagens a serem exibidos. */
    BufferedImage mulher1, mulher2, logo, homem1, homem2, preso;
    
    /** Posições x e y. */
    int x = 125, y = 140;
    
    /** Música a ser tocada */
    AudioClip musica;
    
    /** Define propriedades da janela e outros elementos, carrega imagens,
     * carrega e toca a música.
     * 
     * @throws IOException 
     */
    public void iniciar() throws IOException {
        
        //propriedades da janela
        janela.setSize(400, 300);
        janela.addWindowListener(this);
        janela.addKeyListener(this);
        janela.setUndecorated(true);
        janela.setIgnoreRepaint(true);
        janela.setLocationRelativeTo(null);
        janela.setVisible(true);
        janela.createBufferStrategy(2);
        
        //propriedades diversas
        bufferStrategy = janela.getBufferStrategy();
        caminhão.escala(1.7f);
        caminhão.mover(100,110,0);
        ativa = true;
        
        //carregar imagens de personagens
        URL imgUrl = getClass().getResource("objetos/mulher1.png");
        mulher1 = ImageIO.read(imgUrl);
        imgUrl = getClass().getResource("objetos/mulher2.png");
        mulher2 = ImageIO.read(imgUrl);
        imgUrl = getClass().getResource("objetos/log.png");
        logo = ImageIO.read(imgUrl);
        imgUrl = getClass().getResource("objetos/homem1.png");
        homem1 = ImageIO.read(imgUrl);
        imgUrl = getClass().getResource("objetos/homem2.png");
        homem2 = ImageIO.read(imgUrl);
        imgUrl = getClass().getResource("objetos/preso.png");
        preso = ImageIO.read(imgUrl);
        
        //carregar e tocar música
        String diretorio = new File("").getCanonicalPath();
        File f = new File(diretorio + "/src/Principal/objetos/caminhao.wav");
        URL url = f.toURI().toURL();
        musica = Applet.newAudioClip(url);
    }
    
    /** Aguardar apertar ENTER para iniciar a animação. */
    public void pausa() throws InterruptedException {
        
        //exibir tela preta
        Graphics2D g = (Graphics2D) bufferStrategy.getDrawGraphics();
        g.setColor(new Color(44,44,44));
        g.fillRect(0, 0, janela.getWidth(), janela.getHeight());
        g.drawImage(logo, 340, 265, null); //logo CG TV
        g.dispose();
        bufferStrategy.show();
        
        //aguardar apertar ENTER para iniciar
        while (!iniciou) {
            Thread.sleep(100);
        }
    }
    
    /** Renderiza os elementos da animação, de acordo com o evento.
     * 
     * @param g 
     */
    public void exibir(Graphics2D g) {
        
        //título
        if (segundos < 10) {
            
            if (segundos == 0 && evento == 0)
                g.setFont(new Font("", Font.BOLD, 10));
            
            //cor do texto
            if (evento == 0)
                g.setColor(new Color(44,44,44));
            else
                if (evento < 10)
                    g.setColor(Color.darkGray);
                else
                    if (evento < 20)
                        g.setColor(Color.gray);
                    else
                        if (evento < 30)
                            g.setColor(Color.lightGray);
                        else
                            g.setColor(Color.white);
            
            if (segundos < 8) {
                if (evento < 30)
                    evento++;
            }else
                if (evento > 0)
                    evento--;
            
            g.drawString("Música: Ela Roubou Meu Caminhão", 10, 240);
            g.drawString("Artista: Matanza", 10, 255);
            g.drawString("Álbum: Santa Madre Cassino", 10, 270);
            g.drawString("Ano de lançamento: 2001", 10, 285);
            
        }else
            
            //mulher mostra o dedo, dá partida e sai com caminhão
            if (segundos < 25) {
                
                //desenhar casa, caminhão e mulher
                Graficos.fundoCasa(false,g);
                caminhão.desenhar(g);
                if (segundos < 13)
                    g.drawImage(mulher1, x, y, null);
                else
                    if (segundos < 15)
                        g.drawImage(mulher2, x, y, null);
                    else{
                        g.drawImage(mulher1, x, y, null);
                        
                        //partida no caminhão
                        if (segundos < 17) {
                            if (segundos == 16) {
                                switch (evento) {
                                    case 0:
                                        caminhão.mover(0, -3, 0);
                                        y -= 2;
                                        break;
                                    case 2:
                                        caminhão.mover(0, 3, 0);
                                        y += 2;
                                        break;
                                    case 4:
                                        evento = -1;
                                        break;
                                    default:
                                        break;
                                }
                                evento++;
                            }
                        }else{
                            caminhão.mover(-5, 0, 0);
                            x -= 5;
                            
                            if (evento != 0) //preparar para a próxima cena
                                evento = 0;
                        }
                    }
            }else
                
                //porta abre, personagem sai, vira para direita, esquerda, direita
                //olhos ficam azuis e cai lágrimas
                if (segundos < 39) {
                    Graficos.fundoCasa(true,g);
                    
                    //desenhar personagem
                    if (segundos > 25) {
                        if (segundos < 28)
                            g.drawImage(homem1, 150, 150, null);
                        else
                            if (segundos < 29)
                                g.drawImage(homem2, 150, 150, null);
                            else
                                if (segundos < 30)
                                    g.drawImage(homem1, 150, 150, null);
                                else
                                    if (segundos < 31)
                                        g.drawImage(homem2, 150, 150, null);
                                    else
                                        g.drawImage(homem1, 150, 150, null);
                    }
                    
                    //olho do personagem fica azul de lágrimas
                    if (segundos > 32) {
                        Graficos.reta(166,168,170,168,g,new Color (0,0,255));
                        Graficos.reta(167,169,169,169,g,new Color (0,0,255));
                        Graficos.reta(175,171,179,171,g,new Color (0,0,255));
                        Graficos.reta(174,170,180,170,g,new Color (0,0,255));
                    }
                    
                    //lágrimas caindo dos olhos do personagem
                    if (segundos > 33) {
                        Graficos.reta(169,169+5*auxiliar,169,171+5*auxiliar,g, new Color (0,0,255));
                        Graficos.reta(170,169+5*auxiliar,170,171+5*auxiliar,g, new Color (0,0,255));
                        Graficos.reta(171,169+5*auxiliar,171,171+5*auxiliar,g, new Color (0,0,255));
                        Graficos.reta(176,171+5*auxiliar,176,174+5*auxiliar,g, new Color (0,0,255));
                        Graficos.reta(177,171+5*auxiliar,177,174+5*auxiliar,g, new Color (0,0,255));
                        Graficos.reta(178,171+5*auxiliar,178,174+5*auxiliar,g, new Color (0,0,255));
                        if (auxiliar == 15)
                            auxiliar = 0;
                        else
                            auxiliar++;
                    }
                }else
                    
                    //cena tatuagem
                    if (segundos < 46)
                        Graficos.fundoTatuagem(g);
                    else
                        
                        //cena prisão
                        if (segundos < 53) {
                            Graficos.fundoPrisao(g);
                            g.drawImage(preso, 161, 119, null);
                            
                            if (segundos == 52) //preparar cena do caminhão rodando
                                evento = auxiliar = 0;
                        }else
                            
                            //caminhão rodando
                            if (segundos < 64) {
                                
                                if (auxiliar % 4 == 0) { //retardar velocidade de rotação
                                    caminhão = new Caminhao();
                                    caminhão.rotacionar(evento, 'y');
                                    caminhão.rotacionar(-5, 'x');
                                    caminhão.centro();
                                    evento += 5;
                                    if (faixa == 2)
                                        faixa = 0;
                                    else
                                        faixa++;
                                    if (evento >= 360)
                                        evento = 0;
                                }
                                auxiliar++;
                                caminhão.desenharFundo(faixa, g);
                                caminhão.desenhar(g);
                                
                            }else
                                
                                //créditos
                                if (segundos < 100) {
                                    g.setFont(new Font("Century Schoolbook L", Font.ITALIC, 18));
                                    g.setColor(Color.white);
                                    
                                    g.drawString("UNIVERSIDADE ESTADUAL PAULISTA", 20, 60);
                                    g.drawString("\"JÚLIO DE MESQUITA FILHO\"", 60, 80);
                                    g.setFont(new Font("Century Schoolbook L", Font.ITALIC, 14));
                                    g.drawString("CÂMPUS DE PRESIDENTE PRUDENTE", 60, 98);
                                    
                                    g.drawString("COMPUTAÇÃO GRÁFICA 2016", 60, 160);
                                    g.setFont(new Font("Century Schoolbook L", Font.ITALIC, 18));
                                    g.drawString("PROF. DR. ALMIR O. ARTERO", 60, 180);
                                    
                                    g.setFont(new Font("Century Schoolbook L", Font.ITALIC, 14));
                                    g.drawString("ALUNO", 60, 240);
                                    g.setFont(new Font("Century Schoolbook L", Font.ITALIC, 18));
                                    g.drawString("LUIZ F. P. REDONDARO", 60, 260);
                                }
        
        //exibir logotipo CG TV
        g.drawImage(logo, 340, 265, null);
    }
    
    /** Execução.
     * 
     * @throws InterruptedException 
     * @throws java.io.IOException 
     */
    public void rodar() throws InterruptedException, IOException {
        long contaSegundo = System.currentTimeMillis(),
             tempoCiclo = -1000,
             tempoAtual;
        
        //carregar elementos iniciais
        iniciar();
        
        //inserir pausa aqui
        pausa();
        
        musica.play();
        while (ativa) {
            tempoAtual = System.currentTimeMillis();
            
            //conta cada segundo de execução
            if (tempoAtual > contaSegundo + 1000) {
                contaSegundo = tempoAtual;
                segundos++;
                //System.out.println(segundos);
            }
            
            //executar aprox 30 FPS (1000 milissegundos/30 FPS = aprox 33 milissegundos de intervalo)
            if (tempoAtual >= tempoCiclo + 33) {
                tempoCiclo = tempoAtual;
                
                //atualizar e renderizar elementos gráficos
                Graphics2D g = (Graphics2D) bufferStrategy.getDrawGraphics();
                g.setColor(new Color(44,44,44));
                g.fillRect(0, 0, janela.getWidth(), janela.getHeight());
                exibir(g);
                g.dispose();
                bufferStrategy.show();
            }
        }
        
        //encerrar música, elementos gráficos e aplicação
        musica.stop();
        bufferStrategy.dispose();
        janela.dispose();
        System.exit(0);
    }
    
    /** Terminar a execução ao fechar janela.
     * 
     * @param e 
     */
    @Override
    public void windowClosing(WindowEvent e) {
        ativa = false;
    }
    
    /** Tratamento de teclas ao serem apertadas. [Esc] encerra aplicação, [Enter]
     * inicia animação e música.
     * 
     * @param e 
     */
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE)
            ativa = false;
        else
            if (e.getKeyCode() == KeyEvent.VK_ENTER && !iniciou)
                iniciou = true;
    }
    
    @Override
    public void windowOpened(WindowEvent e) {}
    @Override
    public void windowClosed(WindowEvent e) {}
    @Override
    public void windowIconified(WindowEvent e) {}
    @Override
    public void windowDeiconified(WindowEvent e) {}
    @Override
    public void windowActivated(WindowEvent e) {}
    @Override
    public void windowDeactivated(WindowEvent e) {}
    @Override
    public void keyReleased(KeyEvent e) {}
    @Override
    public void keyTyped(KeyEvent e) {}
}
