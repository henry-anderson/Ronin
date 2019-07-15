package org.henrya.ronin.dkpcounter.frames;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.ScrollPaneConstants;

public class MainFrame extends JFrame {
	private JPanel contentPane;
	private JTextArea area = new JTextArea();
	
	public MainFrame() {
		/* Creates the frame */
		this.setTitle("DKP Counter");
		this.setResizable(true);
		this.area.setEditable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/* Creates the scroll pane that the text area is stored in */
		JScrollPane scrollPane = new JScrollPane(this.area);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(0, 0, 500, 482);
		contentPane.add(scrollPane);

		/* Creates the count button */
		JButton checkButton = new JButton("Count");
		checkButton.setBounds(100, 482, 300, 96);
		checkButton.addActionListener(new ButtonListener(this));
		contentPane.add(checkButton);
	}
	
	/**
	 * Returns the text area
	 * @return A JTextArea instance
	 */
	public JTextArea getArea() {
		return this.area;
	}
}
