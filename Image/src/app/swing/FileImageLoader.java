package app.swing;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;
import model.Image;
import view.ImageLoader;


public class FileImageLoader implements ImageLoader {
    private final File file;

    public FileImageLoader(File file) {
        this.file = file;
    }

    @Override
    public List<Image> load() {
        List<Image> list = new ArrayList<>();
        File[] files = file.listFiles(withExtensions("jpg","png"));
        for (File file : files) {
            list.add(new Image(file.getAbsolutePath()));
        }
        return list;
    }

    private FilenameFilter withExtensions(String... extensions) {
        return new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                for(String extension: extensions)
                    if (name.endsWith(extension))return true;
                return false;

            }
        };
    }



}