package control;

import view.ImageDisplay;
import view.SwingImageDisplay;

public class PrevImage implements ChangeImage {


    private ImageDisplay image;


    public PrevImage(ImageDisplay image) {
        this.image = image;
    }


    @Override
    public void execute() {
        image.show(image.current().prev());
    }
}