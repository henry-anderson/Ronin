package org.henrya.dkpcounter.frames;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JTextPane;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class ConsolePane extends JTextPane {
	
	public ConsolePane() {
        this.setBackground(Color.WHITE);
        this.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
        this.setEditable(false);
    }
    public synchronized void println(String line) {
        this.print(line);
        this.newLine();
    }
    public synchronized void print(String line) {
    	try {
    		StyledDocument doc = this.getStyledDocument();
        	Style style = this.addStyle("line", null);
        	StyleConstants.setFontSize(style, 11);
        	StyleConstants.setForeground(style, Color.BLACK);
            doc.insertString(doc.getLength(), line, style);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    public synchronized void newLine() {
        try {
        	StyledDocument doc = this.getStyledDocument();
        	Style style = this.addStyle("newline", null);
            doc.insertString(doc.getLength(), "\n", style);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}
