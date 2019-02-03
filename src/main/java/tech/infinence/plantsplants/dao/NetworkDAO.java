package tech.infinence.plantsplants.dao;


import sun.net.www.protocol.http.HttpURLConnection;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class NetworkDAO {


	/**
	 * Return the data found at the given endpoint
	 *
	 * @param endpoint String endpoint to hit for retrieving the data
	 * @return
	 * @throws Exception
	 */

	public String request(String endpoint) throws Exception {
		StringBuilder sb = new StringBuilder();
		URL url = new URL(endpoint);
		//open a connection
		HttpURLConnection urlCon = (HttpURLConnection) url.openConnection();

		try {
			//read raw bytes
			InputStream is = urlCon.getInputStream();
			BufferedInputStream bis = new BufferedInputStream(is);

			//read as characters
			InputStreamReader isr = new InputStreamReader(bis);
			BufferedReader br = new BufferedReader(isr);

			//read one line at a time
			String inputLine = br.readLine();
			while (inputLine != null) {
				//add this to our output
				sb.append(inputLine);
				inputLine = br.readLine();
			}
		} finally {
			urlCon.disconnect();
		}
		return "";
	}
}
