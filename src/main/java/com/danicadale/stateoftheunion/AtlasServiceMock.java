package com.danicadale.stateoftheunion;

import java.util.Collection;
import java.util.LinkedList;



/**
 * This is for local desktop testing when we don't have a remote microservice available
 */
// Intellij and code smell sniffers will flag this as unused unless we are testing within the
// desktop
public class AtlasServiceMock implements AtlasService {

    private static final Collection<StateInfo> states = new LinkedList<>();

    static {
        states.add(new StateInfo("Oregon",
                                 "OR",
                                 "Salem",
                                 "Oregon Grape",
                                 "Western Meadowlark",
                                 1848));
    }


    @Override
    public StateInfo lookUp(String uspsAbbr) {

        System.out.println("---> This is where the microservice will be used <----");
        for (StateInfo stateInfo : states) {
            if (stateInfo.getAbbr().equalsIgnoreCase(uspsAbbr)) return stateInfo;
        }
        return null;
    }


}
