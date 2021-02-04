package com.my.others;

/**
 * @author mayue
 * @date 2021/2/3.
 */
public enum Version {

    VERSION_1("1"),
    VERSION_2("2")
    ;

    private final String versionNumber;

    Version(String versionNumber){
        this.versionNumber = versionNumber;
    }

}
