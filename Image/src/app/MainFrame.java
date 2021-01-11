package app;

import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import javax.swing.*;

import control.ChangeImage;
import control.NextImage;
import control.PrevImage;
import model.Image;
import view.ImageDisplay;

public class MainFrame extends JFrame {

    private ImageDisplay imageDisplay;
    private HashMap<String,ChangeImage> changeImage;

    public MainFrame(Image image) {

        this.setTitle("Image Viewer"); this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(1366, 768);
        this.setLocationRelativeTo(null);
        this.getContentPane().add(imageDisplay());
        this.getContentPane().add(toolBar(),BorderLayout.SOUTH);
        getImageDisplay().show(image);

    }

    public void executed(){

        creatChangeImage();
        this.setVisible(true);
    }

    private void creatChangeImage() {
        changeImage = new HashMap<>();
        changeImage.put("<",new PrevImage(imageDisplay));
        changeImage.put(">",new NextImage(imageDisplay));
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



    private JPanel imageDisplay() {
        SwingImageDisplay sid = new SwingImageDisplay();
        this.imageDisplay = sid;
        return sid;
    }
    public ImageDisplay getImageDisplay() {
        return imageDisplay;
    }

    private class MouseHandler implements MouseListener, MouseMotionListener{
        boolean grab;
        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }

        @Override
        public void mouseDragged(MouseEvent e) {

        }

        @Override
        public void mouseMoved(MouseEvent e) {

        }
    }

}