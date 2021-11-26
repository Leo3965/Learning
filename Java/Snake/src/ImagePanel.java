import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImagePanel extends JComponent {

    private Image image;

    private void setImagem() throws IOException {
        File file = new File("images\\grama.jpg");
        BufferedImage image = ImageIO.read(file);
    }

}
