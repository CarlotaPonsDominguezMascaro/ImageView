package view;

import model.Image;

public interface ImageDisplay {
    void display(Image image);
    Image currentImage();
    void on(Shift shift);


    Image getImage();



    interface Shift{
        Image left();
        Image rigth();
    }
}
