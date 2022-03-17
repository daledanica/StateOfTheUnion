package com.danicadale.stateoftheunion;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;



/**
 * This implements the interface to the remote atlas microservice
 *
 * @author Danica Dale
 * @since January 2022
 */
public class AtlasServiceReal implements AtlasService {

    @Override
    public StateInfo lookUp(String uspsAbbr) {

        try {

            String baseUrl = "https://project13.us/cgi-bin/states.py?state=";
            URL url = new URL(baseUrl + uspsAbbr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                return null;
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String json = convertQuotes(br.readLine());

            ObjectMapper mapper = new ObjectMapper();
            StateInfo stateInfo = mapper.readValue(json, StateInfo.class);

            conn.disconnect();

            return stateInfo;

        } catch (IOException e) {

            e.printStackTrace();

        }
        return null;
    }



    private String convertQuotes(String quote) {

        // Convert single quotes into double quotes as in this particular case,
        // my classmate used python and it only output single quotes.
        // Java needs to read double quotes
        StringBuilder translated = new StringBuilder();
        for (int i = 0; i < quote.length(); i++) {
            if (quote.charAt(i) == '\'') {
                translated.append('"');
            }
            else {
                translated.append(quote.charAt(i));
            }
        }

        return translated.toString();
    }

}
