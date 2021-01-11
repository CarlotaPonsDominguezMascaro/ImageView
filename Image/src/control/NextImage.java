package control;


import view.ImageDisplay;

public class NextImage implements ChangeImage {

    private ImageDisplay image;


    public NextImage(ImageDisplay image) {
        this.image = image;
    }



    @Override
    public void execute() {
        image.show(image.current().next());
    }
}
