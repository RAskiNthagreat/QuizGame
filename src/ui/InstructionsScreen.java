package ui;

import javax.swing.*;
import java.awt.*;

public class InstructionsScreen extends JFrame {

    public InstructionsScreen() {

        setTitle("Instructions");
        setSize(450, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);

        initUI();

        setVisible(true);
    }

    private void initUI() {

        setLayout(new BorderLayout());

        JTextArea textArea = new JTextArea();

        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        textArea.setText(
                "HOW TO PLAY QUIZ GAME\n\n" +
                "1. Enter your name\n" +
                "2. Select difficulty (Easy / Medium / Hard)\n" +
                "3. Answer 10 multiple choice questions\n" +
                "4. Each correct answer gives 1 point\n" +
                "5. No negative marking\n" +
                "6. Final score is shown at the end\n\n" +
                "Good luck!"
        );

        add(textArea, BorderLayout.CENTER);

        JButton closeButton = new JButton("Close");

        closeButton.addActionListener(e -> dispose());

        add(closeButton, BorderLayout.SOUTH);
    }
}