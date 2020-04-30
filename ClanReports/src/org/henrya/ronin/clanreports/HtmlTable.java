package org.henrya.ronin.clanreports;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HtmlTable {
	private WebDKPPublicSession session;
	private String html = "";
	
	public HtmlTable(WebDKPPublicSession session) {
		this.session = session;
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
	    Date date = new Date(System.currentTimeMillis());
		this.html += "<html>"
				+ "<head>\n"
				+ "<script src='https://www.kryogenix.org/code/browser/sorttable/sorttable.js'></script>"
				+ "<style>\n"
				+ "table {font-family: Helvetica;border-collapse: collapse;width: 100%;}\n"
				+ "td, th {border: 1px solid #dddddd;text-align: center;padding: 8px;}\n" 
				+ "tr:nth-child(even) {background-color: #dddddd;}\n"
				+ "</style>\n"
				+ "</head>\n"
				+ "<body style='margin:0'>\n"
				+ "<br>\n"
				+ "<center>\n"
				+ "<b>" + sdf.format(date) + "</b>"
				+ "<br>\n"
				+ "Total players: <b>" + this.session.getPlayers().size() + "</b>\n"
				+ "<br>\n"
				+ "Active players: <b>" + this.session.getActiveCount() + "</b>\n"
				+ "<br>\n";
		
		int totalMonthlyPoints = 0;
		for(WebDKPPlayer player : this.session.getPlayers()) {
			totalMonthlyPoints += player.getPoints30Days();
		}
		
		this.html += "Total points this month: <b>" + totalMonthlyPoints + "</b>\n"
				+ "<br>\n"
				+ "</center>\n"
				+ "</br>\n"
				+ "<table class='sortable'>\n"
				+ "<tr>\n"
				+ "<th>Index</th>\n"
				+ "<th>Name</th>\n"
				+ "<th>Total Points</th>\n"
				+ "<th>Lifetime Points</th>\n"
				+ "<th>Points This Month</th>\n"
				+ "<th>Activity</th>\n"
				+ "</tr>\n";
		this.createTable();
	}
	
	private void createTable() {
		int index = 1;
		for(WebDKPPlayer player : this.session.getPlayers()) {
			this.html += "<tr>\n"
					+ "<td>" + index + "</td>\n"
					+ "<td>" + player.getName() + "</td>\n"
					+ "<td>" + player.getPoints() + "</td>\n"
					+ "<td>" + player.getLifetimePoints() + "</td>\n"
					+ "<td>" + player.getPoints30Days() + "</td>\n"
					+ player.getActivity() + "\n"
					+ "</tr>\n";
			index++;
		}
		this.html += "</table>"
				+ "</body>"
				+ "</html>";
	}
	
	public String getHtmlFile() {
		return this.html;
	}
}
