package org.henrya.ronin.dkpcounter.frames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.henrya.ronin.dkpcounter.PointParser;
import org.henrya.ronin.dkpcounter.PointStore;
import org.henrya.ronin.dkpcounter.PointType;

/**
 * A class that listens for when the "Count" button is pressed
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
	 * See PointParser.java for the syntax
	 */
	@Override
	public void actionPerformed(ActionEvent event) {
		final CountedFrame frame = new CountedFrame();
		frame.setVisible(true);
		this.mainFrame.setVisible(false);
		
		PointStore store = new PointStore();
		for(String line : this.mainFrame.getArea().getText().split("\n")) {
			try {
				PointParser parser = new PointParser(line);
				if(parser.getType() == PointType.KILL) {
					int points = parser.getBoss().getKillPoints(parser.getStars());
					for(String player : parser.getPlayers()) {
						store.addPoint(player, points);
					}
				}
				else if(parser.getType() == PointType.CAMP) {
					int points = parser.getBoss().getCampPoints();
					for(String player : parser.getPlayers()) {
						store.addPoint(player, points);
					}
				}
				else if(parser.getType() == PointType.CAMP_KILL) {
					int points = parser.getBoss().getKillPoints(parser.getStars()) + parser.getBoss().getCampPoints();
					for(String player : parser.getPlayers()) {
						store.addPoint(player, points);
					}
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		for(String key : store.getMap().keySet()) {
			frame.getPane().println(key + ", " + store.getMap().get(key));
		}
	}	
}
