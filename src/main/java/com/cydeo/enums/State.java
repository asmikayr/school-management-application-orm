package com.cydeo.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum State {
    ALABAMA("Alabama", "AL"), ALASKA("Alaska", "AK"), AMERICAN_SAMOA("American Samoa", "AS"), ARIZONA("Arizona", "AZ"), ARKANSAS("Arkansas", "AR"), CALIFORNIA("California", "CA"), COLORADO("Colorado", "CO"), CONNECTICUT("Connecticut", "CT"), DELAWARE("Delaware", "DE"), DISTRICT_OF_COLUMBIA("District of Columbia", "DC"), FEDERATED_STATES_OF_MICRONESIA("Federated States of Micronesia", "FM"), FLORIDA("Florida", "FL"), GEORGIA("Georgia", "GA"), GUAM("Guam", "GU"), HAWAII("Hawaii", "HI"), IDAHO("Idaho", "ID"), ILLINOIS("Illinois", "IL"), INDIANA("Indiana", "IN"), IOWA("Iowa", "IA"), KANSAS("Kansas", "KS"), KENTUCKY("Kentucky", "KY"), LOUISIANA("Louisiana", "LA"), MAINE("Maine", "ME"), MARYLAND("Maryland", "MD"), MARSHALL_ISLANDS("Marshall Islands", "MH"), MASSACHUSETTS("Massachusetts", "MA"), MICHIGAN("Michigan", "MI"), MINNESOTA("Minnesota", "MN"), MISSISSIPPI("Mississippi", "MS"), MISSOURI("Missouri", "MO"), MONTANA("Montana", "MT"), NEBRASKA("Nebraska", "NE"), NEVADA("Nevada","NV"), NEW_HAMPSHIRE("New Hampshire", "NH"), NEW_JERSEY("New Jersey", "NJ"), NEW_MEXICO("New Mexico", "NM"), NEW_YORK("New York", "NY"), NORTH_CAROLINA("North Carolina", "NC"), NORTH_DAKOTA("North Dakota", "ND"), NORTHERN_MARIANA_ISLANDS("Northern Mariana Islands", "MP"), OHIO("Ohio", "OH"), OKLAHOMA("Oklahoma", "OK"), OREGON("Oregon", "OR"), PALAU("Palau","PW"), PENNSYLVANIA("Pennsylvania", "PA"), PUERTO_RICO("Puerto Rico", "PR"), RHODE_ISLAND("Rhode Island", "RI"), SOUTH_CAROLINA("South Carolina", "SC"), SOUTH_DAKOTA("South Dakota", "SD"), TENNESSEE("Tennessee", "TN"), TEXAS("Texas", "TX"), UTAH("Utah", "UT"), VERMONT("Vermont", "VT"), VIRGIN_ISLANDS("Virgin Islands", "VI"), VIRGINIA("Virginia", "VA"), WASHINGTON("Washington", "WA"), WEST_VIRGINIA("West Virginia", "WV"), WISCONSIN("Wisconsin", "WI"), WYOMING("Wyoming", "WY"), UNKNOWN(
            "Unknown", "");

    private final String name;
    private final String abbreviation;
}
