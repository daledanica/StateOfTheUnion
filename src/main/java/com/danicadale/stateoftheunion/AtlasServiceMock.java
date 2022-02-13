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



    public AtlasServiceMock() {

        states.add(new StateInfo("Oregon", "OR", "Salem", "Oregon Grape",
                                 "Western Meadowlark", "It sux here.", "Formed 1848"));
        states.add(new StateInfo("Alaska", "AK", "Juneau", "Forget-me-not",
                                 "Willow Ptarmigan", "It do be cold.", "Formed neverary"));
        states.add(new StateInfo("Florida", "FL", "Tallahasse", "Orange Blossom",
                                 "Mockingbird", "It do be warm.", "Formed neverary"));

    }
}
