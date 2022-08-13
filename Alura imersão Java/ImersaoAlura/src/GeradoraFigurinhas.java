import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class GeradoraFigurinhas {

    public void criar(InputStream aInputStream, String aNomeArquivo) throws IOException{ //Nesse caso, não estou tratando as excessões e sim sinalizando que quem utilizar essa classe deve tratar.
                                            // Outro modo seria utilizar Try Catch dentro da própria classe, tratando as excessões localmente
        //Leitura de imagem

        BufferedImage imageOriginal = ImageIO.read(aInputStream);
        // Cria nova imagem com novo tamanho e transparencia
        int width = imageOriginal.getWidth();
        int height = imageOriginal.getHeight();

        int newHeight = height + 200; //altura
        
        BufferedImage imageNova = new BufferedImage(width, newHeight, BufferedImage.TRANSLUCENT);
        Graphics2D graphics = (Graphics2D)imageNova.getGraphics();
        graphics.drawImage(imageOriginal, 0, 0, null);
        // Escrever frase na iamgem
        Font fonte = new Font(Font.SERIF, Font.ITALIC, 12);
        graphics.setFont(fonte);
        graphics.drawString("TopZeraaa", 10, height + 10);
        //Salvar em disco nova imagem
        ImageIO.write(imageNova, "PNG", new File(aNomeArquivo));
    }
}
