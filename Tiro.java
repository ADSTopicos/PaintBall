public class Tiro {
    public int raio;
    public int posX;
    public int posY;
    public int velX;
    public int velY;
    public boolean visible;

    public int centroX;
    public int centroY;

    // ATRIBUTOS TIRO 2
    public int raio2;
    public int posX2;
    public int posY2;
    public int velX2;
    public int velY2;
    public boolean visible2;

    public int centroX2;
    public int centroY2;

    public Tiro(){
        raio = 4;
        visible = false;
        velX = 0;
        velY = 0;




        // ATRIBUTOS TIRO 2
        raio2 = 4;
        visible2 = false;
        velX2 = 0;
        velY2 = 0;

        // COLISAO ENTRE TIRO E PERSONAGEM 2
        centroX = posX + raio;
        centroY = posY + raio;

        // COLISAO ENTRE TIRO 2 E PERSONAGEM 1
        centroX2 = posX2 + raio2;
        centroY2 = posY2 + raio2;
    }

    
    


}
