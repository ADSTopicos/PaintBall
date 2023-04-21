import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;


public class Personagem {
    // ATRIBUTOS PERSONAGEM 1
    public BufferedImage mBlueDireita;
    public BufferedImage mBlueEsqueda;
    public BufferedImage mBlueCima;
    public BufferedImage mBlueBaixo;
    
    public int raio;
    public int posX;
    public int posY;
    public int velX;
    public int velY;

    // ATRIBUTOS PERSONAGEM 2
    public int raio2;
    public int posX2;
    public int posY2;
    public int velX2;
    public int velY2;
    public BufferedImage mGreeDireita;
    public BufferedImage mGreenEsquerda;
    public BufferedImage mGreenCima;
    public BufferedImage mGreenBaixo;

    public Personagem() {
        // PERSONAGEM 1
        raio = 25;
        velX = 2;
        velY = 2;
        posX = 100;
        posY = 100;

        // ATRIBUTOS PERSONAGEM 2
        raio2 = 25;
        velX2 = 2;
        velY2 = 2;
        posX2 = 500;
        posY2 = 300;

        try {
            // PERS1 MAN BLUE
			mBlueDireita = ImageIO.read(getClass().getResource("imgs_manBlue/manBlue_direita.png"));
			mBlueEsqueda = ImageIO.read(getClass().getResource("imgs_manBlue/manBlue_esquerda.png"));
			mBlueCima = ImageIO.read(getClass().getResource("imgs_manBlue/manBlue_cima.png"));
			mBlueBaixo = ImageIO.read(getClass().getResource("imgs_manBlue/manBlue_baixo.png"));
			// PERS2 MAN GREEN
            mGreeDireita = ImageIO.read(getClass().getResource("imgs_manGreen/manGreen_direita.png"));
			mGreenEsquerda = ImageIO.read(getClass().getResource("imgs_manGreen/manGreen_esquerda.png"));
			mGreenCima = ImageIO.read(getClass().getResource("imgs_manGreen/manGreen_cima.png"));
			mGreenBaixo = ImageIO.read(getClass().getResource("imgs_manGreen/manGreen_baixo.png"));
			
		}catch (Exception e) {
			System.out.println("Erro ao carregar a imagem!" + e);
		}


    }

}
