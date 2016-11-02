package com.szadowsz.babby.data.gender;

/**
 * Created on 28/10/2016.
 */
public enum Gender {

    BOY("boy","male","m"), GIRL("girl","female","f"), BOTH("both","either");


    final String[] synonyms;

    Gender(String... syns) {
        synonyms = syns;
    }

    @Override
    public String toString() {
        switch (this){
            case BOY:
                return "m";
            case GIRL:
                return "f";
            default:
                return "";
        }
    }
}