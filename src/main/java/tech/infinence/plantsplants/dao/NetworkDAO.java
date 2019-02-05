package tech.infinence.plantsplants.dao;


import org.springframework.stereotype.Component;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

@Component
public class NetworkDAO {


	/**
	 * Return the data found at the given endpoint
	 * @param endpoint String endpoint to hit for retrieving the data
	 * @return response in String format
	 * @throws IOException may thrown at some point in the method
	 */
	String request(String endpoint) throws IOException {
		StringBuilder response = new StringBuilder();
		try (BufferedReader br = new BufferedReader(
				new InputStreamReader(
						new BufferedInputStream(new URL(endpoint).openConnection().getInputStream())
				)
		)) {
			String inputLine;
			while (true) {
				inputLine = br.readLine();
				if (inputLine == null) {
					break;
				}
				//add this to our output
				response.append(inputLine);
			}
		}
		return response.toString();
	}
}