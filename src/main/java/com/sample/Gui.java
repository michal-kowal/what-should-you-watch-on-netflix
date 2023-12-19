package com.sample;

import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Gui {
    private static JFrame frame;
    private String question;
    private HashMap<String, String> answers;
    private String answerKey;

    public Gui(String question, HashMap<String, String> answers) {
        this.question = question;
        this.answers = answers;
    }

    public String displayQuestion() {
        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel(this.question));

        ButtonGroup buttonGroup = new ButtonGroup();
        boolean sel = false;

        for (HashMap.Entry<String, String> entry : answers.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();

            JRadioButton radioButton = new JRadioButton(value);
            radioButton.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent arg0) {
                    if (arg0.getStateChange() == ItemEvent.SELECTED) {
                        answerKey = key;
                    }
                }
            });

            if (!sel) {
                radioButton.setSelected(true);
                sel = true;
            }

            buttonGroup.add(radioButton);
            panel.add(radioButton);
        }

        if ((JOptionPane.showConfirmDialog(Gui.frame, panel, "Question", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE)) < 0) {
            return "no answer";
        } else {
            return this.answerKey;
        }
    }
}