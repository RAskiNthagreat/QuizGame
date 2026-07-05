package main;

import javax.swing.SwingUtilities;
import ui.MainMenu;
import java.awt.event.ActionListener;

public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            new MainMenu();

        });

    }

}