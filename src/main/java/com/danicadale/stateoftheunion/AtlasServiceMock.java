package com.danicadale.stateoftheunion;

import java.util.Collection;
import java.util.LinkedList;



public class AtlasServiceMock implements AtlasService {

    private final Collection<StateInfo> states = new LinkedList<>();



    @Override
    public StateInfo lookUp(String nameOrAbbr) {

        System.out.println("---> This is where the microservice will be used <----");
        for (StateInfo stateInfo : states) {
            if (stateInfo.getName().equalsIgnoreCase(nameOrAbbr)) return stateInfo;
            if (stateInfo.getAbbr().equalsIgnoreCase(nameOrAbbr)) return stateInfo;
        }
        return null;
    }


}
