package org.henrya.ronin.dkpcombiner;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.TreeMap;

/**
 * A class that listens for when the button is pressed
 * @author Henry Anderson
 * 
 */
public class ButtonListener implements ActionListener {
	private MainFrame mainFrame;
	
	/**
	 * Constructs the instance from the main frame
	 * @param mainFrame
	 */
	public ButtonListener(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}

	/**
	 * Called when the button is pressed
	 * It opens a new window and parses the data creating a point total
	 * That total is displayed in a new window, or CountedFrame instance
	 */
	@Override
	public void actionPerformed(ActionEvent event) {
		final ResultFrame frame = new ResultFrame();
		frame.setVisible(true);
		
		ArrayList<TreeMap<String, Integer>> groups = new ArrayList<TreeMap<String, Integer>>();
		groups.add(new TreeMap<String, Integer>());
		for(String line : this.mainFrame.getArea().getText().split("\n")) {
			line = line.toLowerCase();
			if(line.isEmpty()) {
				groups.add(new TreeMap<String, Integer>());
			}
			else {
				String[] separated = line.split(", ");
				String name = separated[0];
				int points = Integer.parseInt(separated[1]);
				TreeMap<String, Integer> currentGroup = groups.get(groups.size() - 1);
				currentGroup.put(name, points);
			}
		}
		TreeMap<String, Integer> total = new TreeMap<String, Integer>();
		for(TreeMap<String, Integer> group : groups) {
			for(String name : group.keySet()) {
				if(total.containsKey(name)) {
					total.put(name, total.get(name) + group.get(name));
				}
				else {
					total.put(name, group.get(name));
				}
			}
		}
		for(String name : total.keySet()) {
			frame.getPane().println(name + ", " + total.get(name));
		}
	}	
}
