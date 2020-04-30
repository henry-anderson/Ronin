package org.henrya.ronin.clanreports;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.henrya.httpicnic.http.HttpConnectionException;

/**
 * Generates HTML reports about clan activity
 * @author Henry Anderson
 *
 */
public class ClanReports {	
	public static void main(String[] main) {
		try {
			WebDKPPublicSession session = new WebDKPPublicSession("https://webdkp.com/dkp/Agamaggan/uuirvjj");
			System.out.println("Loading players...");
			session.loadPlayers();
			System.out.println("Loading awards...");
			session.loadAwards();
			System.out.println("Loading activity...");
			session.loadActivity();
			System.out.println("Creating report...");
			HtmlTable html = new HtmlTable(session);
			
			SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
		    Date date = new Date(System.currentTimeMillis());
		    String filename = "RoninReport_" + sdf.format(date) + ".html";
		    File jarFile = new File(ClanReports.class.getProtectionDomain().getCodeSource().getLocation().getPath());
		    File file = new File(jarFile.getParent(), filename);
		    if(file.exists()) {
		    	file.delete();
		    }
		    file.createNewFile();
		    BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
			bw.append(html.getHtmlFile());
			bw.close();
		    System.out.println("Report: " + file.getAbsolutePath() + " has been created");
		} catch(IOException | HttpConnectionException e) {
			e.printStackTrace();
		}
	}
}