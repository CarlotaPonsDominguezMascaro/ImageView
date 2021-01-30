package app.swing;

import control.ChangeImage;
import control.ImagePresenter;
import control.NextImage;
import control.PrevImage;
import model.Image;
import view.ImageDisplay;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.HashMap;
import java.util.List;

public class Main extends JFrame {
    private  ImagePresenter imagePresenter;
    private ImagePanel imageDisplay;
    private HashMap<String, ChangeImage> changeImage;

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
        this.getContentPane().add(toolBar(),BorderLayout.SOUTH);
        creatChangeImage(images);
    }
    private void creatChangeImage(List<Image> images) {
        changeImage = new HashMap<>();
        changeImage.put("<",new PrevImage(images,imageDisplay));
        changeImage.put(">",new NextImage(images,imageDisplay));
    }

    private JMenuBar toolBar() {
        JMenuBar jMenuBar= new JMenuBar();
        jMenuBar.setLayout(new FlowLayout(FlowLayout.CENTER));
        jMenuBar.add(addButton("<"));
        jMenuBar.add(addButton(">"));
        return jMenuBar;
    }

    private JButton addButton(String button) {
        JButton jButton= new JButton(button);
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeImage.get(button).execute();
            }
        });
        return jButton;
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
