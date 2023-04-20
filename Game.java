import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Game extends JPanel {

    // ATRIBUTOS ---------------------------------------
    public Personagem pers1 = new Personagem();
    public Personagem pers2 = new Personagem();

    public Game() {
        this.setBackground(Color.decode("#ffe6f9"));

        
        
    }

    // MÉTODOS SOBRESCRITOS -----------------------------------
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // faça o que a classe original faz

        // DESENHANDO BOLA NA TELA
        g.setColor(Color.decode("#FF8095"));
        g.fillOval(pers1.posX, pers1.posY, pers1.raio * 2, pers1.raio * 2); // desenha bola
        g.setColor(Color.decode("#80FF80"));
        g.fillOval(pers2.posX2, pers2.posY2, pers2.raio * 2, pers2.raio * 2); // desenha bola
        // com a cor que eu quiser
        // g.drawImage(Personagem.obterImagem(), bola.posX, bola.posY, null); // comando
        // que desenha a bola COM IMAGEM

    }
}
