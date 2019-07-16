package org.henrya.ronin.clanreports;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import org.henrya.httpicnic.http.HttpConnectionException;
import org.henrya.httpicnic.http.HttpHeader;
import org.henrya.httpicnic.http.HttpRequest;
import org.henrya.httpicnic.http.HttpResponse;
import org.henrya.httpicnic.requests.HttpGet;
import org.json.JSONObject;

/**
 * Represents a session on WebDKP
 * @author Henry Anderson
 * 
 */
public class WebDKPSession {
	private String tableURL;
	private List<Player> players;
	private int activeCount;
	
	/** 
	 * Constructs a session
	 * @param tableURL The URL of the table such as https://www.webdkp.com/dkp/Aegwynn/ronintest/
	 * @param username The username
	 * @param password The password
	 */
	public WebDKPSession(String tableURL) {
		this.tableURL = tableURL;
		this.players = new ArrayList<Player>();
	}
	
	/**
	 * Loads all of the players in the WebDKP table
	 * @throws HttpConnectionException Thrown when a connection cannot be established
	 */
	public void loadPlayers() throws HttpConnectionException {
		for(int pageNumber = 1; pageNumber < 100; pageNumber++) {
			String url = this.tableURL + "/" + pageNumber + "/date/desc";
			HttpRequest request = new HttpGet(url);
			request.setHeader(HttpHeader.USER_AGENT, "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.110 Safari/537.36\"");
			request.setHeader(HttpHeader.ACCEPT_LANGUAGE, "en-US,en;q=0.5");
			HttpResponse response = request.send();
			String page = response.getContent();
			if(!page.contains("table.Add")) {
				break;
			}
			String[] table = page.split("table.Add");
			for(String line : table) {
				if(line.length() > 2 && line.contains("userid")) {
					String jsonString = line.substring(1).split("\\);")[0].trim();
					JSONObject json = new JSONObject(jsonString);
					Player player = new Player(json.getString("player"), json.getInt("userid"), (int) json.getDouble("dkp"), (int) json.getDouble("lifetime"), null, null);
					this.players.add(player);
					System.out.println("Loaded player: " + player.getName());
				}
			}
		}
	}
	
	/**
	 * Loads all of the past awards for each player
	 * @throws HttpConnectionException Thrown when a connection cannot be established
	 */
	public void loadAwards() throws HttpConnectionException, UnsupportedEncodingException {
		for(Player player : this.players) {
			String url = this.tableURL + "/Player/" + URLEncoder.encode(player.getName(), "UTF-8");
			HttpRequest request = new HttpGet(url);
			request.setHeader(HttpHeader.USER_AGENT, "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.110 Safari/537.36\"");
			request.setHeader(HttpHeader.ACCEPT_LANGUAGE, "en-US,en;q=0.5");
			HttpResponse response = request.send();
			String page = response.getContent();
			String firstLine = page.split("table.Add")[1];
			String jsonString = firstLine.substring(1).split("\\);")[0].trim();
			JSONObject json = new JSONObject(jsonString);
			long lastActive = json.getLong("date") * 1000;
			player.setLastActive(lastActive);
			
			String[] table = page.split("table.Add");
			for(String line : table) {
				if(line.length() > 2 && line.contains("datestring")) {
					String jsonAwardString = line.substring(1).split("\\);")[0].trim();
					JSONObject jsonAward = new JSONObject(jsonAwardString);
					Award award = new Award(jsonAward.getLong("date") * 1000, (int) jsonAward.getDouble("points"));
					player.getAwards().add(award);
				}
			}	
			System.out.println("Loaded awards for player: " + player.getName());
		}
	}
	
	/**
	 * Sets the player's activity
	 */
	public void loadActivity() {
		for(Player player : this.getPlayers()) {
			if(player.getLastActive() + (ClanReports.MONTH) > System.currentTimeMillis()) {
				this.activeCount++;
				player.setActivity("<td style='background-color:#42f468;border:1px solid #42f468'>0-30 days ago</td>");
			}
			else if(player.getLastActive() + (ClanReports.MONTH * 2) > System.currentTimeMillis()) {
				player.setActivity("<td style='background-color:#e9ff00;border:1px solid #e9ff00'>30-60 days ago</td>");
			}
			else if(player.getLastActive() + (ClanReports.MONTH * 3) > System.currentTimeMillis()) {
				player.setActivity("<td style='background-color:#ff5c05;border:1px solid #ff5c05'>60-90 days ago</td>");
			}
			else {
				player.setActivity("<td style='background-color:#aa0000;border:1px solid #aa0000'>90+ days ago</td>");
			}
		}
	}
	
	/**
	 * Returns whether the player exists
	 * @param name The name of the player
	 * @return A boolean
	 */
	public boolean playerExists(String name) {
		for(Player player : this.players) {
			if(player.getName().equalsIgnoreCase(name)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Returns the Player from their name
	 * @param name The name
	 * @return The Player
	 */
	public Player getPlayer(String name) {
		for(Player player : this.players) {
			if(player.getName().equalsIgnoreCase(name)) {
				return player;
			}
		}
		return null;
	}
	
	/**
	 * Returns a list of every player in the table
	 * @return A list of players
	 */
	public List<Player> getPlayers() {
		return this.players;
	}
	
	/**
	 * Gets the timestamp of the
	 * @return
	 */
	public int getActiveCount() {
		return this.activeCount;
	}
}
