package com.sample;

import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Gui {
	private static JFrame frame;
	private String question;
	private ArrayList<String> answers;
	private String answer;
	
	public Gui(String question, ArrayList<String> answers) {
		this.question = question;
		this.answers = answers;
	}
	
	public String displayQuestion() {
		JPanel panel = new JPanel(new GridLayout(0, 1));
		panel.add(new JLabel(this.question));
		
		ButtonGroup buttonGroup = new ButtonGroup();
		boolean sel = false;
		for(String i : answers) {
			JRadioButton radioButton = new JRadioButton(i);
			radioButton.addItemListener(new ItemListener() {
				@Override
				public void itemStateChanged(ItemEvent arg0) {
					if (arg0.getStateChange() == ItemEvent.SELECTED) {
						answer = i;
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
			return this.answer;

		}
	}
}
