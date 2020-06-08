package com.mjherich.ImpactTest;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        JFrame application = createGUI();
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        application.setVisible(true);
    }

    private static JFrame createGUI() {
        // Delimited List GUI elements
        JLabel title1 = new JLabel("Delimited List");
        JTextField input1 = new JTextField();
        input1.setPreferredSize(new Dimension(300, 40));

        JButton btn1 = new JButton("Create Delimited List");

        JLabel output1 = new JLabel();
        output1.setPreferredSize(new Dimension(500, 40));

        btn1.addActionListener(event -> {
            // Parse input
            try {
                String in1 = input1.getText();
                String str[] = in1.split(",");
                List<String> al = Arrays.asList(str);
                List<Integer> parsed1 = new ArrayList<Integer>();
                for(String s: al){
                    parsed1.add(Integer.parseInt(s));
                }
                DelimitedList dlist = new DelimitedList(parsed1);
                output1.setText(dlist.toString());
            } catch (Exception e) {
                System.err.println("list format: 2,4,8,16,32,64 (comma separated, no spaces)");
                output1.setText("list format: 2,4,8,16,32,64 (comma separated, no spaces)");
            }
        });

        JPanel panel1 = new JPanel();
        panel1.add(title1);
        panel1.add(input1);
        panel1.add(btn1);
        panel1.add(output1);


        // Good Strings GUI elements
        JLabel title2 = new JLabel("Good Strings");
        JTextField input2 = new JTextField();
        input2.setPreferredSize(new Dimension(300, 40));

        JButton btn2 = new JButton("Convert");

        JLabel output2 = new JLabel();
        output2.setPreferredSize(new Dimension(500, 40));

        btn2.addActionListener(event -> {
            GoodString gs = new GoodString(input2.getText());
            output2.setText(gs.toString());
        });

        JPanel panel2 = new JPanel();
        panel2.add(title2);
        panel2.add(input2);
        panel2.add(btn2);
        panel2.add(output2);

        // Find Duplicates GUI elements
        JLabel title3 = new JLabel("Find Duplicates");
        JTextField input3 = new JTextField();
        input3.setPreferredSize(new Dimension(300, 40));

        JButton btn3 = new JButton("Find Duplicates");

        JLabel output3 = new JLabel();
        output3.setPreferredSize(new Dimension(500, 40));

        btn3.addActionListener(event -> {
            // Parse input
            try {
                String in1 = input3.getText();
                String str[] = in1.split(",");
                List<String> al2 = Arrays.asList(str);
                List<Integer> parsed2 = new ArrayList<Integer>();
                for(String s: al2){
                    parsed2.add(Integer.parseInt(s));
                }
                DuplicateElements dupeEle = new DuplicateElements(parsed2);
                output3.setText(dupeEle.getDuplicates().toString());
            } catch (Exception e) {
                System.err.println("list format: 2,4,8,16,32,64 (comma separated, no spaces)");
                output3.setText("list format: 2,4,8,16,32,64 (comma separated, no spaces)");
            }
        });

        JPanel panel3 = new JPanel();
        panel3.add(title3);
        panel3.add(input3);
        panel3.add(btn3);
        panel3.add(output3);

        // Complete String GUI elements
        JLabel title4 = new JLabel("Complete String");
        JTextField input4 = new JTextField();
        input4.setPreferredSize(new Dimension(300, 40));

        JButton btn4 = new JButton("Is Complete String?");

        JLabel output4 = new JLabel();
        output4.setPreferredSize(new Dimension(500, 40));

        btn4.addActionListener(event -> {
            Boolean isComplete = CompleteString.check(input4.getText());
            if (isComplete) {
                output4.setText("The string IS complete!");
            } else {
                output4.setText("The string IS NOT complete!");
            }
        });

        JPanel panel4 = new JPanel();
        panel4.add(title4);
        panel4.add(input4);
        panel4.add(btn4);
        panel4.add(output4);

        JFrame gui = new JFrame("Matt Herich - Impact Java Test");
        gui.setPreferredSize(new Dimension(1400, 500));
        JPanel mainGUI = new JPanel();
        mainGUI.setLayout(new BoxLayout(mainGUI, BoxLayout.Y_AXIS));
        mainGUI.add(panel1);
        mainGUI.add(panel2);
        mainGUI.add(panel3);
        mainGUI.add(panel4);

        // See codepen
        JButton codepenBtn = new JButton("Matt's Codepen Solution");
        codepenBtn.addActionListener(event -> {
            try {
                Desktop.getDesktop().browse(new URL("https://codepen.io/mjherich/pen/MWKwMJY").toURI());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        mainGUI.add(codepenBtn);

        mainGUI.setAlignmentX(Component.RIGHT_ALIGNMENT);
        gui.add(mainGUI);
        gui.pack();
//        gui.setLocationRelativeTo(null); // Centering the screen

        return gui;
    }

}
