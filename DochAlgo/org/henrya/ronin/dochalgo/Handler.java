package org.henrya.ronin.dochalgo;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import org.henrya.ronin.dochalgo.frames.ResultsFrame;
import org.henrya.ronin.dochalgo.frames.TableRow;
import org.henrya.httpicnic.http.HttpConnectionException;
import org.henrya.ronin.dochalgo.frames.Console;


public class Handler {
	private List<TableRow> rows;
	private List<Candidate> candidates;
	private JFrame resultsFrame;
	
	public Handler(List<TableRow> rows) {
		this.rows = rows;
		this.candidates = new ArrayList<Candidate>();

	}
	public void onSubmitClick() {
		//this.resultsFrame = new ResultsFrame();
	//	new ConsoleStream();
		new Thread() {
			public void run() {
				Console console = new Console();
				System.out.println("test");
			}
		}.start();
		for(TableRow row : this.rows) {
			if(!row.getPlayerText().isEmpty()) {
				String playerText = row.getPlayerText().toLowerCase();
				if(playerText.contains(",")) {
					String[] split = playerText.split(",");
					String main = split[0].trim();
					List<String> alts = new ArrayList<String>();
					for(String alt : split) {
						alt = alt.trim();
						if(!alt.equals(main)) {
							alts.add(alt);
						}
			    	}
					candidates.add(new Candidate(main, alts, row.hasGloves(), row.hasChest(), row.hasLegs(), row.hasBoots(), row.hasHelm()));
			    }
				else {
					String main = playerText.trim();
					candidates.add(new Candidate(main, new ArrayList<String>(), row.hasGloves(), row.hasChest(), row.hasLegs(), row.hasBoots(), row.hasHelm()));
			    }
			}
		}
		
		for(Candidate candidate : candidates) {
			
			System.out.println("Found candidate: " + candidate.getMain() + " - " +  Arrays.toString(candidate.getAlts().toArray()));
		}
		
		try {
			WebDKPSession session = new WebDKPSession("https://webdkp.com/dkp/Agamaggan/uuirvjj");
			System.out.println("Loading players...");
			session.loadPlayers(candidates);
			System.out.println("Loading awards...");
			session.loadAwards(candidates);
			
			for(Candidate candidate : candidates) {
				if(session.playerExists(candidate.getMain())) {
					candidate.addCombinedLifetime(session.getPlayer(candidate.getMain()).getLifetimePoints());
					candidate.addCombined90Days(session.getPlayer(candidate.getMain()).getPoints90Days());
				}
				else {
					System.out.println("Player not found on WebDKP: " + candidate.getMain());
				}
				for(String alt : candidate.getAlts()) {
					if(session.playerExists(alt)) {
						candidate.addCombinedLifetime(session.getPlayer(alt).getLifetimePoints());
						candidate.addCombined90Days(session.getPlayer(alt).getPoints90Days());
					}
					else {
						System.out.println("Player not found on WebDKP: " + alt);
					}
				}
			}
			System.out.println("Complete... Creating table");
			
			
			
			for(Candidate candidate : candidates) {
				System.out.println(candidate.getMain() + " - " + candidate.getCombinedLifetime() + " - " + candidate.getCombined90Days());
			}
			this.createTable();
		} catch(HttpConnectionException | UnsupportedEncodingException e) {
			System.out.println("A connection error occured");
			e.printStackTrace();
		}
	}
	
	public void createTable() {
		ResultsFrame resultsFrame = new ResultsFrame();
		
		//String data[][]={ {"Name","Combined","Recent", "Pures", "Rating"}}; 
		String column[]={"name","lifetime","recent", "pures", "rating"};  
		
		String data[][] = new String[this.candidates.size()][5];
		for(int i = 0; i < this.candidates.size(); i++) {
			Candidate candidate = this.candidates.get(i);
			data[i][0] = candidate.getMain();
			data[i][1] = candidate.getCombinedLifetime() + "";
			data[i][2] = candidate.getCombinedLifetime() + "";
			data[i][3] = "0";
			data[i][4] = "0.1253";

		}
		
		JTable table = new JTable(data, column);
		table.setBounds(6, 6, 488, 466);
		table.setRowSelectionAllowed(false);
		table.setColumnSelectionAllowed(false);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
		
		resultsFrame.getPanel().add(table);
		resultsFrame.setVisible(true);
	}
	
	
}
