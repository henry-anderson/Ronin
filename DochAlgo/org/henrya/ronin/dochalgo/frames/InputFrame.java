package org.henrya.ronin.dochalgo.frames;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.henrya.ronin.dochalgo.Handler;

import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JButton;

public class InputFrame extends JFrame {

	private JPanel contentPane;
	private List<TableRow> rows;
	private JTextField playerField1;
	private JTextField playerField2;
	private JTextField playerField3;
	private JTextField playerField4;
	private JTextField playerField5;
	private JTextField playerField6;
	private JTextField playerField7;
	private JTextField playerField8;
	private JTextField playerField9;
	private JTextField playerField10;
	private JTextField playerField11;
	private JTextField playerField12;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InputFrame frame = new InputFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InputFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel toonsLabel = new JLabel("Toons");
		toonsLabel.setBounds(6, 6, 79, 16);
		contentPane.add(toonsLabel);
		
		JLabel helmLabel = new JLabel("Helm");
		helmLabel.setBounds(411, 6, 33, 16);
		contentPane.add(helmLabel);
		
		JLabel bootsLabel = new JLabel("Boots");
		bootsLabel.setBounds(364, 6, 35, 16);
		contentPane.add(bootsLabel);
		
		JLabel legsLabel = new JLabel("Legs");
		legsLabel.setBounds(323, 6, 29, 16);
		contentPane.add(legsLabel);
		
		JLabel chestLabel = new JLabel("Chest");
		chestLabel.setBounds(275, 6, 36, 16);
		contentPane.add(chestLabel);
		
		JLabel glovesLabel = new JLabel("Gloves");
		glovesLabel.setBounds(221, 6, 42, 16);
		contentPane.add(glovesLabel);
		
		playerField1 = new JTextField();
		playerField1.setBounds(6, 23, 213, 26);
		contentPane.add(playerField1);
		playerField1.setColumns(10);
		
		JCheckBox glovesBox1 = new JCheckBox("");
		glovesBox1.setBounds(231, 26, 29, 23);
		contentPane.add(glovesBox1);
		
		JCheckBox chestBox1 = new JCheckBox("");
		chestBox1.setBounds(275, 26, 29, 23);
		contentPane.add(chestBox1);
		
		JCheckBox legsBox1 = new JCheckBox("");
		legsBox1.setBounds(323, 26, 29, 23);
		contentPane.add(legsBox1);
		
		JCheckBox bootsBox1 = new JCheckBox("");
		bootsBox1.setBounds(364, 26, 29, 23);
		contentPane.add(bootsBox1);
		
		JCheckBox helmBox1 = new JCheckBox("");
		helmBox1.setBounds(411, 26, 29, 23);
		contentPane.add(helmBox1);
		
		playerField2 = new JTextField();
		playerField2.setColumns(10);
		playerField2.setBounds(6, 61, 213, 26);
		contentPane.add(playerField2);
		
		JCheckBox glovesBox2 = new JCheckBox("");
		glovesBox2.setBounds(231, 64, 29, 23);
		contentPane.add(glovesBox2);
		
		JCheckBox chestBox2 = new JCheckBox("");
		chestBox2.setBounds(275, 64, 29, 23);
		contentPane.add(chestBox2);
		
		JCheckBox legsBox2 = new JCheckBox("");
		legsBox2.setBounds(323, 64, 29, 23);
		contentPane.add(legsBox2);
		
		JCheckBox bootsBox2 = new JCheckBox("");
		bootsBox2.setBounds(364, 64, 29, 23);
		contentPane.add(bootsBox2);
		
		JCheckBox helmBox2 = new JCheckBox("");
		helmBox2.setBounds(411, 64, 29, 23);
		contentPane.add(helmBox2);
		
		playerField3 = new JTextField();
		playerField3.setColumns(10);
		playerField3.setBounds(6, 99, 213, 26);
		contentPane.add(playerField3);
		
		JCheckBox glovesBox3 = new JCheckBox("");
		glovesBox3.setBounds(231, 102, 29, 23);
		contentPane.add(glovesBox3);
		
		JCheckBox chestBox3 = new JCheckBox("");
		chestBox3.setBounds(275, 102, 29, 23);
		contentPane.add(chestBox3);
		
		JCheckBox legsBox3 = new JCheckBox("");
		legsBox3.setBounds(323, 102, 29, 23);
		contentPane.add(legsBox3);
		
		JCheckBox bootsBox3 = new JCheckBox("");
		bootsBox3.setBounds(364, 102, 29, 23);
		contentPane.add(bootsBox3);
		
		JCheckBox helmBox3 = new JCheckBox("");
		helmBox3.setBounds(411, 102, 29, 23);
		contentPane.add(helmBox3);
		
		playerField4 = new JTextField();
		playerField4.setColumns(10);
		playerField4.setBounds(6, 137, 213, 26);
		contentPane.add(playerField4);
		
		JCheckBox glovesBox4 = new JCheckBox("");
		glovesBox4.setBounds(231, 140, 29, 23);
		contentPane.add(glovesBox4);
		
		JCheckBox chestBox4 = new JCheckBox("");
		chestBox4.setBounds(275, 140, 29, 23);
		contentPane.add(chestBox4);
		
		JCheckBox legsBox4 = new JCheckBox("");
		legsBox4.setBounds(323, 140, 29, 23);
		contentPane.add(legsBox4);
		
		JCheckBox bootsBox4 = new JCheckBox("");
		bootsBox4.setBounds(364, 140, 29, 23);
		contentPane.add(bootsBox4);
		
		JCheckBox helmBox4 = new JCheckBox("");
		helmBox4.setBounds(411, 140, 29, 23);
		contentPane.add(helmBox4);
		
		playerField5 = new JTextField();
		playerField5.setColumns(10);
		playerField5.setBounds(6, 175, 213, 26);
		contentPane.add(playerField5);
		
		JCheckBox glovesBox5 = new JCheckBox("");
		glovesBox5.setBounds(231, 178, 29, 23);
		contentPane.add(glovesBox5);
		
		JCheckBox chestBox5 = new JCheckBox("");
		chestBox5.setBounds(275, 178, 29, 23);
		contentPane.add(chestBox5);
		
		JCheckBox legsBox5 = new JCheckBox("");
		legsBox5.setBounds(323, 178, 29, 23);
		contentPane.add(legsBox5);
		
		JCheckBox bootsBox5 = new JCheckBox("");
		bootsBox5.setBounds(364, 178, 29, 23);
		contentPane.add(bootsBox5);
		
		JCheckBox helmBox5 = new JCheckBox("");
		helmBox5.setBounds(411, 178, 29, 23);
		contentPane.add(helmBox5);
		
		playerField6 = new JTextField();
		playerField6.setColumns(10);
		playerField6.setBounds(6, 213, 213, 26);
		contentPane.add(playerField6);
		
		JCheckBox glovesBox6 = new JCheckBox("");
		glovesBox6.setBounds(231, 216, 29, 23);
		contentPane.add(glovesBox6);
		
		JCheckBox chestBox6 = new JCheckBox("");
		chestBox6.setBounds(275, 216, 29, 23);
		contentPane.add(chestBox6);
		
		JCheckBox legsBox6 = new JCheckBox("");
		legsBox6.setBounds(323, 216, 29, 23);
		contentPane.add(legsBox6);
		
		JCheckBox bootsBox6 = new JCheckBox("");
		bootsBox6.setBounds(364, 216, 29, 23);
		contentPane.add(bootsBox6);
		
		JCheckBox helmBox6 = new JCheckBox("");
		helmBox6.setBounds(411, 216, 29, 23);
		contentPane.add(helmBox6);
		
		playerField7 = new JTextField();
		playerField7.setColumns(10);
		playerField7.setBounds(6, 251, 213, 26);
		contentPane.add(playerField7);
		
		JCheckBox glovesBox7 = new JCheckBox("");
		glovesBox7.setBounds(231, 254, 29, 23);
		contentPane.add(glovesBox7);
		
		JCheckBox chestBox7 = new JCheckBox("");
		chestBox7.setBounds(275, 254, 29, 23);
		contentPane.add(chestBox7);
		
		JCheckBox legsBox7 = new JCheckBox("");
		legsBox7.setBounds(323, 254, 29, 23);
		contentPane.add(legsBox7);
		
		JCheckBox bootsBox7 = new JCheckBox("");
		bootsBox7.setBounds(364, 254, 29, 23);
		contentPane.add(bootsBox7);
		
		JCheckBox helmBox7 = new JCheckBox("");
		helmBox7.setBounds(411, 254, 29, 23);
		contentPane.add(helmBox7);
		
		
		
		playerField8 = new JTextField();
		playerField8.setColumns(10);
		playerField8.setBounds(6, 289, 213, 26);
		contentPane.add(playerField8);
		
		JCheckBox glovesBox8 = new JCheckBox("");
		glovesBox8.setBounds(231, 292, 29, 23);
		contentPane.add(glovesBox8);
		
		JCheckBox chestBox8 = new JCheckBox("");
		chestBox8.setBounds(275, 292, 29, 23);
		contentPane.add(chestBox8);
		
		JCheckBox legsBox8 = new JCheckBox("");
		legsBox8.setBounds(323, 292, 29, 23);
		contentPane.add(legsBox8);
		
		JCheckBox bootsBox8 = new JCheckBox("");
		bootsBox8.setBounds(364, 292, 29, 23);
		contentPane.add(bootsBox8);
		
		JCheckBox helmBox8 = new JCheckBox("");
		helmBox8.setBounds(411, 292, 29, 23);
		contentPane.add(helmBox8);
		
		playerField9 = new JTextField();
		playerField9.setColumns(10);
		playerField9.setBounds(6, 327, 213, 26);
		contentPane.add(playerField9);
		
		JCheckBox glovesBox9 = new JCheckBox("");
		glovesBox9.setBounds(231, 330, 29, 23);
		contentPane.add(glovesBox9);
		
		JCheckBox chestBox9 = new JCheckBox("");
		chestBox9.setBounds(275, 330, 29, 23);
		contentPane.add(chestBox9);
		
		JCheckBox legsBox9 = new JCheckBox("");
		legsBox9.setBounds(323, 330, 29, 23);
		contentPane.add(legsBox9);
		
		JCheckBox bootsBox9 = new JCheckBox("");
		bootsBox9.setBounds(364, 330, 29, 23);
		contentPane.add(bootsBox9);
		
		JCheckBox helmBox9 = new JCheckBox("");
		helmBox9.setBounds(411, 330, 29, 23);
		contentPane.add(helmBox9);
		
		playerField10 = new JTextField();
		playerField10.setColumns(10);
		playerField10.setBounds(6, 365, 213, 26);
		contentPane.add(playerField10);
		
		JCheckBox glovesBox10 = new JCheckBox("");
		glovesBox10.setBounds(231, 368, 29, 23);
		contentPane.add(glovesBox10);
		
		JCheckBox chestBox10 = new JCheckBox("");
		chestBox10.setBounds(275, 368, 29, 23);
		contentPane.add(chestBox10);
		
		JCheckBox legsBox10 = new JCheckBox("");
		legsBox10.setBounds(323, 368, 29, 23);
		contentPane.add(legsBox10);
		
		JCheckBox bootsBox10 = new JCheckBox("");
		bootsBox10.setBounds(364, 368, 29, 23);
		contentPane.add(bootsBox10);
		
		JCheckBox helmBox10 = new JCheckBox("");
		helmBox10.setBounds(411, 368, 29, 23);
		contentPane.add(helmBox10);
		
		playerField11 = new JTextField();
		playerField11.setColumns(10);
		playerField11.setBounds(6, 403, 213, 26);
		contentPane.add(playerField11);
		
		JCheckBox glovesBox11 = new JCheckBox("");
		glovesBox11.setBounds(231, 406, 29, 23);
		contentPane.add(glovesBox11);
		
		JCheckBox chestBox11 = new JCheckBox("");
		chestBox11.setBounds(275, 406, 29, 23);
		contentPane.add(chestBox11);
		
		JCheckBox legsBox11 = new JCheckBox("");
		legsBox11.setBounds(323, 406, 29, 23);
		contentPane.add(legsBox11);
		
		JCheckBox bootsBox11 = new JCheckBox("");
		bootsBox11.setBounds(364, 406, 29, 23);
		contentPane.add(bootsBox11);
		
		JCheckBox helmBox11 = new JCheckBox("");
		helmBox11.setBounds(411, 406, 29, 23);
		contentPane.add(helmBox11);
		
		playerField12 = new JTextField();
		playerField12.setColumns(10);
		playerField12.setBounds(6, 441, 213, 26);
		contentPane.add(playerField12);
		
		JCheckBox glovesBox12 = new JCheckBox("");
		glovesBox12.setBounds(231, 444, 29, 23);
		contentPane.add(glovesBox12);
		
		JCheckBox chestBox12 = new JCheckBox("");
		chestBox12.setBounds(275, 444, 29, 23);
		contentPane.add(chestBox12);
		
		JCheckBox legsBox12 = new JCheckBox("");
		legsBox12.setBounds(323, 444, 29, 23);
		contentPane.add(legsBox12);
		
		JCheckBox bootsBox12 = new JCheckBox("");
		bootsBox12.setBounds(364, 444, 29, 23);
		contentPane.add(bootsBox12);
		
		JCheckBox helmBox12 = new JCheckBox("");
		helmBox12.setBounds(411, 444, 29, 23);
		contentPane.add(helmBox12);
		
		
		
		
		JButton submitButton = new JButton("Submit");
		submitButton.setBounds(54, 479, 117, 29);
		contentPane.add(submitButton);
		submitButton.addActionListener(new ActionListener() {

		    @Override
		    public void actionPerformed(ActionEvent e) {
		        new Handler(rows).onSubmitClick();
		        setVisible(false);
		    }
		});
		
		this.rows = new ArrayList<TableRow>();
		this.rows.add(new TableRow(playerField1, glovesBox1, chestBox1, legsBox1, bootsBox1, helmBox1));
		this.rows.add(new TableRow(playerField2, glovesBox2, chestBox2, legsBox2, bootsBox2, helmBox2));
		this.rows.add(new TableRow(playerField3, glovesBox3, chestBox3, legsBox3, bootsBox3, helmBox3));
		this.rows.add(new TableRow(playerField4, glovesBox4, chestBox4, legsBox4, bootsBox4, helmBox4));
		this.rows.add(new TableRow(playerField5, glovesBox5, chestBox5, legsBox5, bootsBox5, helmBox5));
		this.rows.add(new TableRow(playerField6, glovesBox6, chestBox6, legsBox6, bootsBox6, helmBox6));
		this.rows.add(new TableRow(playerField7, glovesBox7, chestBox7, legsBox7, bootsBox7, helmBox7));
		this.rows.add(new TableRow(playerField8, glovesBox8, chestBox8, legsBox8, bootsBox8, helmBox8));
		this.rows.add(new TableRow(playerField9, glovesBox9, chestBox9, legsBox9, bootsBox9, helmBox9));
		this.rows.add(new TableRow(playerField10, glovesBox10, chestBox10, legsBox10, bootsBox10, helmBox10));
		this.rows.add(new TableRow(playerField11, glovesBox11, chestBox11, legsBox11, bootsBox11, helmBox11));
		this.rows.add(new TableRow(playerField12, glovesBox12, chestBox12, legsBox12, bootsBox12, helmBox12));
	}
	
	public List<TableRow> getRows() {
		return this.rows;
	}
}
