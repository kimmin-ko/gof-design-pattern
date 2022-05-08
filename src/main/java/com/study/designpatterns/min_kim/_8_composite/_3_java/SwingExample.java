package com.study.designpatterns.min_kim._8_composite._3_java;

import javax.swing.*;

public class SwingExample {

    public static void main(String[] args) {
        JFrame frame = new JFrame();

        JTextField textField = new JTextField();

        JButton button = new JButton();
        button.add(textField);

        frame.add(button);
        frame.setVisible(true);
    }
}
