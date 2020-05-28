package org.henrya.ronin.combineddkp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.henrya.ronin.combineddkp.backup.WebDKPAward;
import org.henrya.ronin.combineddkp.backup.WebDKPPlayer;
import org.henrya.ronin.combineddkp.backup.WebDKPSession;

public class ParsedDKPTable {
	private List<WebDKPPlayer> players;
	
	public ParsedDKPTable(File file) {
		try {
			this.players = new ArrayList<WebDKPPlayer>();
			BufferedReader br = new BufferedReader(new FileReader(file));
	    	String line = "";
	
	        while((line = br.readLine()) != null){
	            if(line.startsWith("PLAYER")) {
	            	String[] split = line.split(" \\| ");
	            	String name = split[0].split(" ", 2)[1].toLowerCase();
	            	String[] secondSplit = split[1].split(" ");
	            	int points = Integer.parseInt(secondSplit[0]);
	            	int lifetime = Integer.parseInt(secondSplit[1]);
	            	players.add(new WebDKPPlayer(name, 0, points, lifetime, null, null));
	            }
	            if(line.startsWith("POINTS") || line.startsWith("LOOT")) {
	            	boolean isItem = line.startsWith("LOOT") ? true : false;
	            	String[] split = line.split(" \\| ");
	            	String name = split[0].split(" ", 2)[1];
	            	String[] secondSplit = split[1].split(" ");
	            	int points = Integer.parseInt(secondSplit[0]);
	            	long time = Long.parseLong(secondSplit[1]);
	            	String text = String.join(" ", Arrays.copyOfRange(secondSplit, 2, secondSplit.length));
	            	this.getPlayer(name).getAwards().add(new WebDKPAward(time, points, text, isItem));
	            }
			}
	        br.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public ParsedDKPTable(WebDKPSession session) {
		this.players = session.getPlayers();
	}
	
	public void saveFile(File file) {
		try {
			FileOutputStream fos = new FileOutputStream(file);
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
			
			for(WebDKPPlayer player : this.players) {
				bw.write("PLAYER " + player.getName() + " | " + player.getPoints() + " " + player.getLifetimePoints());
				bw.newLine();
				for(WebDKPAward award : player.getAwards()) {
					if(award.isItem()) {
						bw.write("LOOT " + player.getName() + " | " + award.getPoints() + " " + award.getDate() + " \"" + award.getText() + "\"");
						bw.newLine();
					}
					else {
						bw.write("POINTS " + player.getName() + " | " + award.getPoints() + " " + award.getDate() + " \"" + award.getText() + "\"");
						bw.newLine();
					}
				}
			}
			bw.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<WebDKPPlayer> getPlayers() {
		return this.players;
	}
	
	public WebDKPPlayer getPlayer(String name) {
		for(WebDKPPlayer player : this.players) {
			if(player.getName().equalsIgnoreCase(name)) {
				return player;
			}
		}
		return null;
	}
	
	public boolean playerExists(String name) {
		if(this.getPlayer(name) != null) {
			return true;
		}
		return false;
	}

}
