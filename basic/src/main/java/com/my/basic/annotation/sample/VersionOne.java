package com.my.basic.annotation.sample;

/**
 * @author mayue
 * @date 2021/2/3.
 */
@VersionTag(Version.VERSION_1)
public class VersionOne implements VersionInterface {

    @Override
    public String processLogical() {
        return "i'm version one logical";
    }
}
