package control;

import model.Image;
import view.ImageDisplay;

import java.util.List;

public class PrevImage implements ChangeImage {
    private final List<Image> images;
    private final ImageDisplay imageDisplay;

    public PrevImage(List<Image> images, ImageDisplay imageDisplay){
        this.images = images;
        this.imageDisplay = imageDisplay;
    }

    @Override
    public void execute(){
        imageDisplay.display(prev());
    }

    private Image prev(){
        return images.get(prevIndex());
    }

    private int prevIndex(){
        return (getIndex() - 1 + images.size()) % images.size();
    }

    private int getIndex(){
        return images.indexOf(imageDisplay.getImage());
    }
}
