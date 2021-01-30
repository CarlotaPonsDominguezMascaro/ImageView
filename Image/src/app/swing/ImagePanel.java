package app.swing;

import view.ImageDisplay;
import model.Image;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class ImagePanel extends JPanel implements ImageDisplay {
    private BufferedImage bitmap;
    private BufferedImage bitmap2;
    private Image image;
    private int offset;
    private Shift shift;

    public ImagePanel() {
        MouseHandler mouseHandler = new  MouseHandler();
        this.addMouseListener(mouseHandler);
        this.addMouseMotionListener(mouseHandler);
    }

    @Override
    public void paint(Graphics g) {
        if(bitmap != null) g.drawImage(bitmap, offset,0,null);
        if(bitmap2 != null&& offset != 0)g.drawImage(bitmap2, offset <0 ? bitmap.getWidth()+ offset : offset -bitmap2.getWidth(),0,null);
    }


    @Override
    public void display(Image image) {
        this.image = image;
        this.bitmap = loadBitmapI(image);
        repaint();

    }
    private static BufferedImage loadBitmapI(Image image){
        try{
            return ImageIO.read(new File(image.getName()));
        }catch (IOException e){
            return null;
        }
    }

    private Image imageAt(int shift){
        if (shift >0) return this.shift.left();
        if( shift<0) return this.shift.rigth();
        return null;
    }

    @Override
    public Image currentImage() {
        return image;
    }

    @Override
    public void on(Shift shift) {
        this.shift = shift;
    }

    @Override
    public Image getImage() {
        return this.image;
    }


    private class MouseHandler implements MouseListener, MouseMotionListener {
        private int initial;
        int shift;

        public MouseHandler() {
        }

        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {
            this.initial = e.getX();
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            int shift= shift(e.getX());

            if (Math.abs(shift)> getWidth()/2) {
                image = imageAt(shift);
                bitmap = loadBitmapI(image);
            }
            offset= 0;
            repaint();
        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }

        @Override
        public void mouseDragged(MouseEvent e) {
            shift =shift(e.getX());
            if(shift ==0) bitmap2 =null;
            else if (  offset / shift <=0)  bitmap2 = loadBitmapI(imageAt(shift));


            offset = shift;
            repaint();
        }

        private int shift(int x) {
            return x-initial;
        }

        @Override
        public void mouseMoved(MouseEvent e) {

        }


    }
}
