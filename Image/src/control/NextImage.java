package control;

import model.Image;
import view.ImageDisplay;

import java.util.List;

public class NextImage implements ChangeImage {
    private final List<Image> images;
    private final ImageDisplay imageDisplay;

    public NextImage(List<Image> images, ImageDisplay imageDisplay) {
        this.images = images;
        this.imageDisplay = imageDisplay;
    }

    @Override
    public void execute(){
        imageDisplay.display(next());
    }

    private Image next(){
        return images.get(nextIndex());
    }

    private int nextIndex(){
        return (getIndex()+1) % images.size();
    }

    private int getIndex(){
        return images.indexOf(imageDisplay.getImage());
    }
}
