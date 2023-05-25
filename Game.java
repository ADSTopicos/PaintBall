import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.awt.event.KeyEvent;

public class Game extends JPanel {

    // ATRIBUTOS ---------------------------------------
    public Personagem pers1 = new Personagem();

    public Personagem pers2 = new Personagem();

    // CRIANDO OBJETO TIRO
    Tiro tiro = new Tiro();

    Tiro tiro2 = new Tiro();

    // CONTROLE PERS1
    private boolean k_cima = false;
    private boolean k_baixo = false;
    private boolean k_direita = false;
    private boolean k_esquerda = false;
    private boolean k_tiro = false;

    // CONTROLE PERS2
    private boolean k_cima2 = false;
    private boolean k_baixo2 = false;
    private boolean k_direita2 = false;
    private boolean k_esquerda2 = false;
    private boolean k_tiro2 = false;

    // ATRIBUTOS QUE AS IMAGENS DOS PERSONAGENS SERAO CARREGADAS
    private BufferedImage imgAtual;
    private BufferedImage imgPers2;

    // MÉTODO CONSTRUTOR ---------------------------------------
    public Game() {
        setBackground(Color.decode("#fa66948"));
        setFocusable(true);
        setLayout(null);

        imgAtual = pers1.mBlueDireita;
        imgPers2 = pers2.mGreenEsquerda;

        // INICIA TRATAMETNO COM TECLADO DO PERS1
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            // RELEASED = QUANDO SOLTA A TECLA
            @Override
            public void keyReleased(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_W:
                        k_cima = false;
                        break;
                    case KeyEvent.VK_S:
                        k_baixo = false;
                        break;
                    case KeyEvent.VK_A:
                        k_esquerda = false;
                        break;
                    case KeyEvent.VK_D:
                        k_direita = false;
                        break;
                }
            }

            // PRESSED = QUANDO APERTA A TECLA
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_W:
                        k_cima = true;
                        break;
                    case KeyEvent.VK_S:
                        k_baixo = true;
                        break;
                    case KeyEvent.VK_A:
                        k_esquerda = true;
                        break;
                    case KeyEvent.VK_D:
                        k_direita = true;
                        break;
                    case KeyEvent.VK_Q:
                        k_tiro = true;
                        break;
                }
            }
        });

        // INICIA TRATAMETNO COM TECLADO DO PERS2
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            // RELEASED = QUANDO SOLTA A TECLA PERS 2
            @Override
            public void keyReleased(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        k_cima2 = false;
                        break;
                    case KeyEvent.VK_DOWN:
                        k_baixo2 = false;
                        break;
                    case KeyEvent.VK_LEFT:
                        k_esquerda2 = false;
                        break;
                    case KeyEvent.VK_RIGHT:
                        k_direita2 = false;
                        break;                       
                }
            }

            // PRESSED = QUANDO APERTA A TECLA PERS 2
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        k_cima2 = true;
                        break;
                    case KeyEvent.VK_DOWN:
                        k_baixo2 = true;
                        break;
                    case KeyEvent.VK_LEFT:
                        k_esquerda2 = true;
                        break;
                    case KeyEvent.VK_RIGHT:
                        k_direita2 = true;
                        break;
                    case KeyEvent.VK_CONTROL:
                        k_tiro2 = true;
                        break; 
                }
            }
        });

        // THREAD DENTRO DO CONSTRUTOR
        new Thread(new Runnable() { //

            @Override
            public void run() {
                gameloop(); // inicia o gameloop
            }
        }).start(); // dispara a Thread

    }

    // GAMELOOP -------------------------------
    public void gameloop() {
        while (true) { // repetição intermitente do gameloop
            handlerEvents();
            update();
            render();

            try {
                Thread.sleep(17);
            } catch (Exception e) {
            }
        }
    }

    // GAMELOOP CADA EVENTO SEPARADO (handlerEvents / update /
    // render)-------------------------------
    public void handlerEvents() {

        // CONTROLANDO PERS1
        pers1.velX = 0;
        pers1.velY = 0;

        // SE O PERSONAGEM 1 ESTIVER A ESQUERDA DO PERS 2 ENTAO VIRE PERS 1 PARA DIREITA
        /*if (pers2.posX2 < pers1.posX) {
            imgAtual = pers1.mBlueEsqueda;
        } else {
            imgAtual = pers1.mBlueDireita;
        }*/

        // TECLA QUE DISPARA O TIRO
        if (k_tiro == true) {
            update();
        }

        // MOVIMENTOS EM TODOS OS SENTIDOS PERS 1
        if (k_cima == true) {
            pers1.velY = -3;
            imgAtual = pers1.mBlueCima;

            if (k_direita == true) {
                pers1.velX = 3;
                imgAtual = pers1.mBlueCimaDireita;
            }
            if (k_esquerda == true) {
                pers1.velX = -3;
                imgAtual = pers1.mBlueCimaEsquerda;
            }
        } else if (k_baixo == true) {
            pers1.velY = 3;
            imgAtual = pers1.mBlueBaixo;

            if (k_direita == true) {
                pers1.velX = 3;
                imgAtual = pers1.mBlueBaixoDireita;
            }
            if (k_esquerda == true) {
                pers1.velX = -3;
                imgAtual = pers1.mBlueBaixoEsquerda;
            }
        } else if (k_esquerda == true) {
            pers1.velX = -3;
            imgAtual = pers1.mBlueEsqueda;
        } else if (k_direita == true) {
            pers1.velX = 3;
            imgAtual = pers1.mBlueDireita;
        }

        // CONTROLANDO PERS2
        pers2.velX2 = 0;
        pers2.velY2 = 0;

        // SE O PERSONAGEM 2 ESTIVER A ESQUERDA DO PERS 1 ENTAO VIRE PERS 2 PARA DIREITA
        /*if (pers2.posX2 < pers1.posX) {
            imgPers2 = pers2.mGreenDireita;
        } else {
            imgPers2 = pers2.mGreenEsquerda;
        }*/

        // TECLA QUE DISPARA O TIRO
        if (k_tiro2 == true) {
            update();
        }

        // MOVIMENTOS EM TODOS OS SENTIDOS PERS 2
        if (k_cima2 == true) {
            pers2.velY2 = -3;
            imgPers2 = pers2.mGreenCima;

            if (k_direita2 == true) {
                pers2.velX2 = 3;
                imgPers2 = pers2.mGreenCimaDireita;
            }
            if (k_esquerda2 == true) {
                pers2.velX2 = -3;
                imgPers2 = pers2.mGreenCimaEsquerda;
            }
        } else if (k_baixo2 == true) {
            pers2.velY2 = 3;
            imgPers2 = pers2.mGreenBaixo;

            if (k_direita2 == true) {
                pers2.velX2 = 3;
                imgPers2 = pers2.mGreenBaixoDireita;
            }
            if (k_esquerda2 == true) {
                pers2.velX2 = -3;
                imgPers2 = pers2.mGreenBaixoEsquerda;
            }
        } else if (k_esquerda2 == true) {
            pers2.velX2 = -3;
            imgPers2 = pers2.mGreenEsquerda;
        } else if (k_direita2 == true) {
            pers2.velX2 = 3;
            imgPers2 = pers2.mGreenDireita;
        }

    }

    public void update() {
        // MANIPULAÇÃO DO PERSONAGEM 1
        pers1.posX = pers1.posX + pers1.velX;
        pers1.posY = pers1.posY + pers1.velY;

        // TIRO DE PERS 1
        if (k_tiro == true) {
            k_tiro = false;
            tiro.visible = true;
            tiro.posX = pers1.posX;
            tiro.posY = pers1.posY;
            // DEFINE A DIREÇÃO DO TIRO
            tiro.velX = 0;
            tiro.velY = 0;
            if (imgAtual == pers1.mBlueDireita) {
                tiro.velX = 4;
            } else if (imgAtual == pers1.mBlueEsqueda) {
                tiro.velX = -4;
            } else if (imgAtual == pers1.mBlueBaixo) {
                tiro.velY = 4;
            } else if (imgAtual == pers1.mBlueCima) {
                tiro.velY = -4;
            }
        }

        // ATUALIZA POSIÇÃO DO TIRO
        tiro.posX += tiro.velX;
        tiro.posY += tiro.velY;

        // MANIPULAÇÃO DO PERSONAGEM 2
        pers2.posX2 = pers2.posX2 + pers2.velX2;
        pers2.posY2 = pers2.posY2 + pers2.velY2;

        // TIRO DE PERS 2
        if (k_tiro2 == true) {
            k_tiro2 = false;
            tiro2.visible2 = true;
            tiro2.posX2 = pers2.posX2;
            tiro2.posY2 = pers2.posY2;
            // DEFINE A DIREÇÃO DO TIRO 2
            tiro2.velX2 = 0;
            tiro2.velY2 = 0;
            if (imgPers2 == pers2.mGreenDireita) {
                tiro2.velX2 = 4;
            } else if (imgPers2 == pers2.mGreenEsquerda) {
                tiro2.velX2 = -4;
            } else if (imgPers2 == pers2.mGreenBaixo) {
                tiro2.velY2 = 4;
            } else if (imgPers2 == pers2.mGreenCima) {
                tiro2.velY2 = -4;
            }

            
        }

        // ATUALIZA POSIÇÃO DO TIRO 2
        tiro2.posX2 += tiro2.velX2;
        tiro2.posY2 += tiro2.velY2;

        // ATUALIZAÇÃO DO CENTRO DO PERSONAGEM 1
        pers1.centroX = pers1.posX + pers1.raio;
        pers1.centroY = pers1.posY + pers1.raio;

        // ATUALIZAÇÃO DO CENTRO DO PERSONAGEM 2
        pers2.centroX2 = pers2.posX2 + pers2.raio2;
        pers2.centroY2 = pers2.posY2 + pers2.raio2;

        // ATUALIZAÇÃO DO CENTRO DO TIRO
        tiro.centroX = tiro.posX + tiro.raio;
        tiro.centroY = tiro.posY + tiro.raio;

        // ATUALIZAÇÃO DO CENTRO DO TIRO 2
        tiro2.centroX2 = tiro2.posX2 + tiro2.raio2;
        tiro2.centroY2 = tiro2.posY2 + tiro2.raio2;

        testeColisoes();
    }

    public void render() {
        repaint();
    }

    // OUTROS METODOS -------------------------
    public void testeColisoes() {
        // TESTA COLISAO DO JOGADOR 1 COM A TELA
        if (pers1.posX + (pers1.raio * 2) >= Principal.LARGURA_TELA || pers1.posX <= 0) {
            pers1.posX = pers1.posX - pers1.velX; // desfaz o movimento
        }
        if (pers1.posY + (pers1.raio * 2) >= Principal.ALTURA_TELA || pers1.posY <= 0) {
            pers1.posY = pers1.posY - pers1.velY; // desfaz o movimento
        }

        // TESTA COLISAO DO JOGADOR 2 COM A TELA
        if (pers2.posX2 + (pers2.raio2 * 2) >= Principal.LARGURA_TELA || pers2.posX2 <= 0) {
            pers2.posX2 = pers2.posX2 - pers2.velX2; // desfaz o movimento
        }
        if (pers2.posY2 + (pers2.raio2 * 2) >= Principal.ALTURA_TELA || pers2.posY2 <= 0) {
            pers2.posY2 = pers2.posY2 - pers2.velY2; // desfaz o movimento
        }

        // TESTE DE COLISAO ENTRE JOGADORES (DO 1 PARA 2)
        int ch = Math.abs(pers1.centroX - pers2.centroX2);
        int cv = Math.abs(pers1.centroY - pers2.centroY2);
        double h = Math.sqrt((ch * ch) + (cv * cv));

        if (h <= pers1.raio + pers2.raio2) {
            // DESFAZER O ULTIMO MOVIMENTO
            pers1.posX = pers1.posX - pers1.velX;
            pers1.posY = pers1.posY - pers1.velY;
        }

        // TESTE DE COLISAO ENTRE JOGADORES (DO 2 PARA 1)
        int ch2 = Math.abs(pers2.centroX2 - pers1.centroX);
        int cv2 = Math.abs(pers2.centroY2 - pers1.centroY);
        double h2 = Math.sqrt((ch2 * ch2) + (cv2 * cv2));

        if (h2 <= pers2.raio2 + pers1.raio) {
            // DESFAZER O ULTIMO MOVIMENTO
            pers2.posX2 = pers2.posX2 - pers2.velX2;
            pers2.posY2 = pers2.posY2 - pers2.velY2;
        }

        // TESTE DE COLISAO ENTRE TIRO (DO 1 PARA 2)
        int chT = Math.abs(tiro.centroX - pers2.centroX2);
        int cvT = Math.abs(tiro.centroY - pers2.centroY2);
        double hT = Math.sqrt((chT * chT) + (cvT * cvT));

        if (hT <= tiro.raio + pers2.raio2) {
            tiro.visible = false;
        }

        // TESTE DE COLISAO ENTRE TIRO (DO 2 PARA 1)
        int chT2 = Math.abs(tiro2.centroX2 - pers1.centroX);
        int cvT2 = Math.abs(tiro2.centroY2 - pers1.centroY);
        double hT2 = Math.sqrt((chT2 * chT2) + (cvT2 * cvT2));

        if (hT2 <= tiro2.raio2 + pers1.raio) {
            tiro2.visible2 = false;
        }
    }

    // MÉTODOS SOBRESCRITOS -----------------------------------
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // faça o que a classe original faz
       
        g.setColor(Color.decode("#290066")); // MUDA A COR DO TIRO

        if (tiro.visible == true) {
            g.fillOval(tiro.posX, tiro.posY, tiro.raio * 2, tiro.raio * 2);

        }
        g.setColor(Color.decode("#29FFE2"));
        
        if (tiro2.visible2 == true) {
            g.fillOval(tiro2.posX2, tiro2.posY2, tiro2.raio2 * 2, tiro2.raio2 * 2);
        }

        g.drawImage(imgAtual, pers1.posX, pers1.posY, null); 
        g.drawImage(imgPers2, pers2.posX2, pers2.posY2, null);

    }
}