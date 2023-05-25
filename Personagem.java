import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;


public class Personagem {
    // ATRIBUTOS PERSONAGEM 1
    public BufferedImage mBlueDireita;
    public BufferedImage mBlueEsqueda;
    public BufferedImage mBlueCima;
    public BufferedImage mBlueBaixo;
    public BufferedImage mBlueCimaDireita;
    public BufferedImage mBlueCimaEsquerda;
    public BufferedImage mBlueBaixoDireita;
    public BufferedImage mBlueBaixoEsquerda;
    public int raio;
    public int posX;
    public int posY;
    public int velX;
    public int velY;

    public int centroX; // VARIAVEIS PARA COLISAO DO PERSONANGENS
	public int centroY;

    // ATRIBUTOS PERSONAGEM 2
    public int raio2;
    public int posX2;
    public int posY2;
    public int velX2;
    public int velY2;
    public BufferedImage mGreenDireita;
    public BufferedImage mGreenEsquerda;
    public BufferedImage mGreenCima;
    public BufferedImage mGreenBaixo;
    public BufferedImage mGreenCimaDireita;
    public BufferedImage mGreenCimaEsquerda;
    public BufferedImage mGreenBaixoDireita;
    public BufferedImage mGreenBaixoEsquerda;

    public int centroX2; // VARIAVEIS PARA COLISAO DO PERSONANGENS
	public int centroY2;

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
			mBlueCimaDireita = ImageIO.read(getClass().getResource("imgs_manBlue/manBlue_cima_direita.png"));
			mBlueCimaEsquerda = ImageIO.read(getClass().getResource("imgs_manBlue/manBlue_cima_esquerda.png"));
			mBlueBaixoDireita = ImageIO.read(getClass().getResource("imgs_manBlue/manBlue_baixo_direita.png"));
			mBlueBaixoEsquerda = ImageIO.read(getClass().getResource("imgs_manBlue/manBlue_baixo_esquerda.png"));
			
			// PERS2 MAN GREEN
            mGreenDireita = ImageIO.read(getClass().getResource("imgs_manGreen/manGreen_direita.png"));
			mGreenEsquerda = ImageIO.read(getClass().getResource("imgs_manGreen/manGreen_esquerda.png"));
			mGreenCima = ImageIO.read(getClass().getResource("imgs_manGreen/manGreen_cima.png"));
			mGreenBaixo = ImageIO.read(getClass().getResource("imgs_manGreen/manGreen_baixo.png"));
			mGreenCimaDireita = ImageIO.read(getClass().getResource("imgs_manGreen/manGreen_cima_direita.png"));
			mGreenCimaEsquerda = ImageIO.read(getClass().getResource("imgs_manGreen/manGreen_cima_esquerda.png"));
			mGreenBaixoDireita = ImageIO.read(getClass().getResource("imgs_manGreen/manGreen_baixo_direita.png"));
			mGreenBaixoEsquerda = ImageIO.read(getClass().getResource("imgs_manGreen/manGreen_baixo_esquerda.png"));
		}catch (Exception e) {
			System.out.println("Erro ao carregar a imagem!" + e);
		}


        // COLISAO ENTRE PERSONAGENS
        centroX = posX + raio;
        centroY = posY + raio;

        centroX2 = posX2 + raio2;
        centroY2 = posY2 + raio2;
    }

}
