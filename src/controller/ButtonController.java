package controller;

import model.Button;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *  returns a list of Buttons and assigns images to every button from the given path, sets their size and number
 */
public class ButtonController {

    private static String PATH = "src/resources/images";

    public static List<Button> getButtonList() throws IOException {
        List<Button> buttonList = new ArrayList<>();

        File folderInput = new File(PATH);
        File[] listOfFiles = folderInput.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {

            Image img = ImageIO.read(new File(PATH + "/" + listOfFiles[i].getName()));
            img = img.getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH);
            Button button = new Button(img, i, 200, 200);
            buttonList.add(button);
        }
        Collections.shuffle(buttonList);

        return buttonList;
    }

}
