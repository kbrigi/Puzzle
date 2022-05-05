package model;
import javax.swing.*;
import java.awt.*;

//Button with a given number, image, size
public class Button extends JButton {
    private int number;
    private Image image;
    private int height, width;


    public Button(Image image, int nr, int height, int width) {
        super(new ImageIcon(image));
        number = nr;
        this.image = image;
        this.height = height;
        this.width = width;
        setPreferredSize(new Dimension(width, height));
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
        this.setIcon(new ImageIcon(image));
    }

    /**
     * swapps 2 buttons: their number and picture
     * @param button = button to swap with
     */
    public void swap(Button button){
        Image tempImage = image;
        int tempNumber = number;
        this.setImage(button.getImage());
        this.setNumber(button.getNumber());
        button.setNumber(tempNumber);
        button.setImage(tempImage);
    }
}
