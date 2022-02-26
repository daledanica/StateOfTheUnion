package com.danicadale.stateoftheunion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import com.fasterxml.jackson.databind.ObjectMapper;


public class AtlasServiceReal implements AtlasService{

    @Override
    public StateInfo lookUp(String nameOrAbbr) {

        try {

            String baseUrl = "https://project13.us/cgi-bin/states.py?state=";
            URL url = new URL(baseUrl + nameOrAbbr);
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

        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }
        return null;
    }


    private String convertQuotes(String quote) {

        String translated = new String();
        for (int i =  0; i < quote.length(); i++) {
            if (quote.charAt(i) == '\'') {
                translated += '"';
            }
            else {
                translated += quote.charAt(i);
            }
        }

        return translated;
    }

}
