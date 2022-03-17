package com.danicadale.stateoftheunion;

/**
 * This interface defines the functionality of an Atlas service, regardless of how implemented
 *
 * @author Danica Dale
 * @since January 2022
 */
public interface AtlasService {

    /**
     * Given a state's abbreviation, look up and return the state's information
     *
     * @param uspsAbbr the USPS standard abbreviation for the desired state.
     *
     * @return the information for the specified state abbreviation. Returns null if there is no
     * state information for the supplied abbreviation.
     */
    StateInfo lookUp(String uspsAbbr);
}
