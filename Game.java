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

    // CONTROLE PERS1
    private boolean k_cima = false;
    private boolean k_baixo = false;
    private boolean k_direita = false;
    private boolean k_esquerda = false;
    

    // CONTROLE PERS2
    private boolean k_cima2 = false;
    private boolean k_baixo2 = false;
    private boolean k_direita2 = false;
    private boolean k_esquerda2 = false;
    

    // ATRIBUTOS QUE AS IMAGENS DOS PERSONAGENS SERAO CARREGADAS
    private BufferedImage imgAtual;
    private BufferedImage imgPers2;

    // MÉTODO CONSTRUTOR ---------------------------------------
    public Game() {
        setBackground(Color.decode("#ffe6f9"));
        setFocusable(true);
        setLayout(null);

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

    // GAMELOOP CADA EVENTO SEPARADO (handlerEvents / update / render)-------------------------------
    public void handlerEvents() {

        // CONTROLANDO PERS1
        pers1.velX = 0;
        pers1.velY = 0;

        // SE O PERSONAGEM 1 ESTIVER A ESQUERDA DO PERS 2 ENTAO VIRE PERS 1 PARA DIREITA
        if(pers2.posX2 < pers1.posX){
            imgAtual = pers1.mBlueEsqueda;
            } else {
                imgAtual = pers1.mBlueDireita;
        }
        
        if (k_cima == true) {
            pers1.velY = -3;
            imgAtual = pers1.mBlueCima;

            if (k_direita == true){
                pers1.velX = 3;
                imgAtual = pers1.mBlueCimaDireita;
            }
            if(k_esquerda == true){
                pers1.velX = -3;
                imgAtual = pers1.mBlueCimaEsquerda;
            }
        } else if(k_baixo == true){
            pers1.velY = 3;
            imgAtual = pers1.mBlueBaixo;

            if(k_direita == true){
                pers1.velX = 3;
                imgAtual = pers1.mBlueBaixoDireita;
            }
            if(k_esquerda == true){
                pers1.velX = -3;
                imgAtual = pers1.mBlueBaixoEsquerda;
            }
        } else if (k_esquerda == true){
            pers1.velX = -3;
            imgAtual = pers1.mBlueEsqueda;
        } else if(k_direita == true){
            pers1.velX = 3;
            imgAtual = pers1.mBlueDireita;
        }
        
        // CONTROLANDO PERS2
        pers2.velX2 = 0;
        pers2.velY2 = 0;

        // SE O PERSONAGEM 2 ESTIVER A ESQUERDA DO PERS 1 ENTAO VIRE PERS 2 PARA DIREITA
        if(pers2.posX2 < pers1.posX){
        imgPers2 = pers2.mGreenDireita;
        } else {
            imgPers2 = pers2.mGreenEsquerda;
        }
        
        // PRECISA IMPLEMENTAR MOVIMENTOS DIAGONAIS DO PERS 2
        if (k_cima2 == true) {
            pers2.velY2 = -3;
            imgPers2 = pers2.mGreenCima;
        }
        if (k_direita2 == true) {
            pers2.velX2 = 3;
            imgPers2 = pers2.mGreenDireita;
        }
        if (k_esquerda2 == true) {
            pers2.velX2 = -3;
            imgPers2 = pers2.mGreenEsquerda;
        }
        if (k_baixo2 == true) {
            pers2.velY2 = 3;
            imgPers2 = pers2.mGreenBaixo;
        }

    }

    public void update() {
        // MANIPULAÇÃO DO PERSONAGEM 1
        pers1.posX = pers1.posX + pers1.velX;
        pers1.posY = pers1.posY + pers1.velY;

        // MANIPULAÇÃO DO PERSONAGEM 2
        pers2.posX2 = pers2.posX2 + pers2.velX2;
        pers2.posY2 = pers2.posY2 + pers2.velY2;

        testeColisoes();
    }

    public void render() {
        repaint();
    }

    // OUTROS METODOS -------------------------
    public void testeColisoes() {
        // TESTA COLISAO DO JOGADOR 1
        if (pers1.posX + (pers1.raio * 2) >= Principal.LARGURA_TELA || pers1.posX <= 0) {
            pers1.posX = pers1.posX - pers1.velX; // desfaz o movimento
        }
        if (pers1.posY + (pers1.raio * 2) >= Principal.ALTURA_TELA || pers1.posY <= 0) {
            pers1.posY = pers1.posY - pers1.velY; // desfaz o movimento
        }

        // TESTA COLISAO DO JOGADOR 2
        if (pers2.posX2 + (pers2.raio2 * 2) >= Principal.LARGURA_TELA || pers2.posX2 <= 0) {
            pers2.posX2 = pers2.posX2 - pers2.velX2; // desfaz o movimento
        }
        if (pers2.posY2 + (pers2.raio2 * 2) >= Principal.ALTURA_TELA || pers2.posY2 <= 0) {
            pers2.posY2 = pers2.posY2 - pers2.velY2; // desfaz o movimento
        }

    }

    // MÉTODOS SOBRESCRITOS -----------------------------------
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // faça o que a classe original faz

        // DESENHANDO BOLA NA TELA
        // g.setColor(Color.decode("#FF8095")); // MUDA A COR DO PERS1
        // g.fillOval(pers1.posX, pers1.posY, pers1.raio * 2, pers1.raio * 2); //
        // desenha bola
        g.setColor(Color.decode("#80FF80")); // MUDA A COR DO PERS2
        // g.fillOval(pers2.posX2, pers2.posY2, pers2.raio * 2, pers2.raio * 2); //
        // desenha bola

        g.drawImage(imgAtual, pers1.posX, pers1.posY, null); // comando
        g.drawImage(imgPers2, pers2.posX2, pers2.posY2, null); // comando
        // que desenha a bola COM IMAGEM

    }
}
