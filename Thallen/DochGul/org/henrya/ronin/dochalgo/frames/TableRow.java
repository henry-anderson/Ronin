package org.henrya.ronin.dochalgo.frames;

import javax.swing.JCheckBox;
import javax.swing.JTextField;

public class TableRow {
	private JTextField playerField;
	private JCheckBox glovesBox;
	private JCheckBox chestBox;
	private JCheckBox legsBox;
	private JCheckBox bootsBox;
	private JCheckBox helmBox;
	
	public TableRow(JTextField playerField, JCheckBox glovesBox, JCheckBox chestBox, JCheckBox legsBox, JCheckBox bootsBox, JCheckBox helmBox) {
		this.playerField = playerField;
		this.glovesBox = glovesBox;
		this.chestBox = chestBox;
		this.legsBox = legsBox;
		this.bootsBox = bootsBox;
		this.helmBox = helmBox;
	}
	
	public String getPlayerText() {
		return this.playerField.getText();
	}
	
	public boolean hasGloves() {
		return this.glovesBox.isSelected();
	}
	
	public boolean hasChest() {
		return this.chestBox.isSelected();
	}
	
	public boolean hasLegs() {
		return this.legsBox.isSelected();
	}
	
	public boolean hasBoots() {
		return this.bootsBox.isSelected();
	}
	
	public boolean hasHelm() {
		return this.helmBox.isSelected();
	}
}
