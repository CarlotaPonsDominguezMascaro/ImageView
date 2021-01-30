package app.swing;

import control.ImagePresenter;
import model.Image;
import view.ImageDisplay;

import javax.swing.*;
import java.io.File;
import java.util.List;

public class Main extends JFrame {
    private  ImagePresenter imagePresenter;
    private ImagePanel imageDisplay;

    public static void main(String[] args) {
        new Main().executed();

    }

    public Main(){
        this.setTitle("Image Viewer");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(800, 1000);
        this.setLocationRelativeTo(null);
        this.getContentPane().add(imagePanel());

        List<Image> images = new FileImageLoader(new File("fotos")).load();
        this.imageDisplay.display(images.get(0));
        this.imagePresenter = new ImagePresenter(images,imageDisplay);
    }

    private JPanel imagePanel() {
        ImagePanel panel = new ImagePanel();
        this.imageDisplay = panel;
        return panel;
    }

    private void executed() {
        this.setVisible(true);
    }
}
