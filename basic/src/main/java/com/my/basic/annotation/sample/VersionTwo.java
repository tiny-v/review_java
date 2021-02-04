package com.my.basic.annotation.sample;

/**
 * @author mayue
 * @date 2021/2/3.
 */
@VersionTag(value=Version.VERSION_2)
public class VersionTwo implements VersionInterface{

    @Override
    public String processLogical() {
        return "i'm version two logical";
    }
}
