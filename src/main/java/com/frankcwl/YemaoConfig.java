package com.frankcwl;

import net.mamoe.mirai.console.data.Value;
import net.mamoe.mirai.console.data.java.JavaAutoSavePluginConfig;

public class YemaoConfig extends JavaAutoSavePluginConfig {
    public static final YemaoConfig INSTANCE = new YemaoConfig();
    public final Value<Long> yemaoPath = value("admin", 123456L);
    private YemaoConfig() {
        super("yemao");
    }
}
