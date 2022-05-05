package controller;

import model.Button;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.List;

public class PuzzlePanel extends JPanel {
    private JPanel panel;
    private Button first, second;
    List<Button> buttonList;
    private boolean win;


    /**
     * creates a panel and reads the buttons from buttonlist, assigns buttonlisteners
     * @throws IOException
     */
    public PuzzlePanel() throws IOException {
        panel = new JPanel();
        setBounds(100, 100, 700, 600);
        panel.setBorder(BorderFactory.createLineBorder(Color.gray));
        panel.setLayout(new GridLayout(3, 3, 0, 0));

        add(panel, BorderLayout.CENTER);

        buttonList = ButtonController.getButtonList();
        buttonList.forEach(myButton -> {
            setButtonListener(myButton);
            panel.add(myButton);
        });

        win = false;
        panel.setVisible(true);
    }

    /**
     *   checks if buttons are in the right order
     */
    public boolean isGameWon() {
        for (int i = 0; i < buttonList.size() - 1; i++)
            if (buttonList.get(i).getNumber() > buttonList.get(i + 1).getNumber())
                return false;
        return true;
    }

    /**
     * if a button is clicked:
     *          1. border is set and the button is saved in "first" variable
     *          2. border is set and button saved
     *             borders are undone and 1-2 buttons swapped
     *             check if game is won: end/reset first and second variables
     * @param myButton = clicked button
     */
    private void setButtonListener(Button myButton){
        myButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if (first == null) {
                    first = myButton;
                    first.setBorder(BorderFactory.createLineBorder(Color.white));
                } else if (second == null) {
                    second = myButton;
                    second.setBorder(BorderFactory.createLineBorder(Color.white));
                    first.setBorder(BorderFactory.createLineBorder(Color.gray));
                    second.setBorder(BorderFactory.createLineBorder(Color.gray));
                    first.swap(second);

                    if (isGameWon()) {
                        end("Congratulations!");
                    }
                    else{
                    first = null;
                    second = null;}
                }
            }
        });
    }


    public void end(String message){
        panel.removeAll();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 380, 380));
        JLabel label = new JLabel(message);
        label.setFont(new Font("Serif", Font.PLAIN, 50));
        panel.add(label);
        panel.revalidate();
        panel.repaint();
    }

}
