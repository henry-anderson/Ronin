package org.henrya.ronin.combineddkp.backup;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
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
	private List<WebDKPPlayer> players;
	
	/** 
	 * Constructs a session
	 * @param tableURL The URL of the table such as https://www.webdkp.com/dkp/Aegwynn/ronintest/
	 * @param username The username
	 * @param password The password
	 */
	public WebDKPSession(String tableURL) {
		this.tableURL = tableURL;
		this.players = new ArrayList<WebDKPPlayer>();
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
					WebDKPPlayer player = new WebDKPPlayer(json.getString("player"), json.getInt("userid"), (int) json.getDouble("dkp"), (int) json.getDouble("lifetime"), "Ronin", json.getString("playerclass"));
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
		for(WebDKPPlayer player : this.players) {
					for(int i = 1; i < 100; i++) {
						String url = this.tableURL + "/Player/" + URLEncoder.encode(player.getName(), "UTF-8")  + "/" + i + "/date/desc";
						HttpRequest request = new HttpGet(url);
						request.setHeader(HttpHeader.USER_AGENT, "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.110 Safari/537.36\"");
						request.setHeader(HttpHeader.ACCEPT_LANGUAGE, "en-US,en;q=0.5");
						HttpResponse response = request.send();
						String page = response.getContent();
						if(page.contains("This player does not have any history in this table")) {
							break;
						}
						String firstLine = page.split("table.Add")[1];
						String jsonString = firstLine.substring(1).split("\\);")[0].trim();
						JSONObject json = new JSONObject(jsonString);
						long lastActive = json.getLong("date") * 1000;
						player.setLastActive(lastActive);
						
						String[] htmlScripts = page.split("<script");
						for(String element : htmlScripts) {
							if(element.contains("PlayerHistoryTable")) {
								String[] table = element.split("table.Add");
								for(String line : table) {
									if(line.length() > 2 && line.contains("datestring")) {
										String jsonAwardString = line.substring(1).split("\\);")[0].trim();
										JSONObject jsonAward = new JSONObject(jsonAwardString);
										int foritem = jsonAward.getInt("foritem");
										if(foritem == 0) {
											WebDKPAward award = new WebDKPAward(jsonAward.getLong("date") * 1000, (int) jsonAward.getDouble("points"), jsonAward.getString("name"), jsonAward.getInt("foritem")  == 1 ? true : false);
											player.getAwards().add(award);
										}
									}
								}	
							}
							else if(element.contains("PlayerLootTable") && i == 1) {
								String[] table = element.split("table.Add");
								for(String line : table) {
									if(line.length() > 2 && line.contains("datestring")) {
										String jsonAwardString = line.substring(1).split("\\);")[0].trim();
										JSONObject jsonAward = new JSONObject(jsonAwardString);
										WebDKPAward award = new WebDKPAward(jsonAward.getLong("date") * 1000, (int) jsonAward.getDouble("points"), jsonAward.getString("name"), jsonAward.getInt("foritem")  == 1 ? true : false);
										player.getLoot().add(award);
									}
								}	
							}
						}
					}
					Collections.reverse(player.getAwards());
					Collections.reverse(player.getLoot());
					System.out.println("Loaded awards for player: " + player.getName());

				}
	}
	
	/**
	 * Returns whether the player exists
	 * @param name The name of the player
	 * @return A boolean
	 */
	public boolean playerExists(String name) {
		for(WebDKPPlayer player : this.players) {
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
	public WebDKPPlayer getPlayer(String name) {
		for(WebDKPPlayer player : this.players) {
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
	public List<WebDKPPlayer> getPlayers() {
		return this.players;
	}

}
