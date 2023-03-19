package com.emurugova.config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config/credentials.properties"})
public interface BrowserstackConfig extends Config {

    @Config.Key("browserstackUser")
    String getBrowserstackUser();

    @Config.Key("browserstackKey")
    String getBrowserstackKey();

    @Config.Key("browserstackUrl")
    String getBrowserstackUrl();
}
