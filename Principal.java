import javax.swing.JFrame;
import java.awt.Dimension;


public class Principal {

    public Principal() {
        
    }

    public static final int LARGURA_TELA = 640;
    public static final int ALTURA_TELA = 480;

    public static void main(String[] args) {
        // CRIA A JANELA ------------------------------------
        JFrame janela = new JFrame("PaintBall");
        
        Game game = new Game();
        game.setPreferredSize(new Dimension(LARGURA_TELA, ALTURA_TELA)); // precisa importar a classe "dimension"
        janela.add(game);

        // DEFINE CARACTERISTICAS DA JANELA
        // janela.setSize(LARGURA_TELA, ALTURA_TELA);
        janela.setResizable(false); // desabilita opção do jogador redimensionar
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // fecha completamente o jogo
        janela.setLocation(350, 150); // define local onde a janela vai aparecer no monitor
        janela.setVisible(true); // torna a janela visivel

        janela.pack(); // infla, redimensiona tela a partir da classe "game"
    }
}