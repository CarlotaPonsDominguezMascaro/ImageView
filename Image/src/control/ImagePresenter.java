package control;

import model.Image;
import view.ImageDisplay;

import java.util.List;

public class ImagePresenter {
    private final List<Image> images;
    private final ImageDisplay imageDisplay;

    public ImagePresenter(List<Image> images, ImageDisplay imageDisplay) {
        this.images = images;
        this.imageDisplay = imageDisplay;
        this.imageDisplay.on(shift());
    }
    private int current(){
        return images.indexOf(imageDisplay.currentImage());
    }

    private ImageDisplay.Shift shift() {
        return new ImageDisplay.Shift() {
            @Override
            public Image left() {
                return images.get((current()+1)%images.size());
            }

            @Override
            public Image rigth() {
                return images.get((current()-1+images.size())%images.size());

            }
        };
    }
}
