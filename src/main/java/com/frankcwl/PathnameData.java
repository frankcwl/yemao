package com.frankcwl;

import net.mamoe.mirai.console.data.Value;
import net.mamoe.mirai.console.data.java.JavaAutoSavePluginData;

import java.util.HashMap;
import java.util.Map;

public class PathnameData extends JavaAutoSavePluginData {
    public static final PathnameData INSTANCE = new PathnameData();
    public final Value<Map<String, String>> cvMap = typedValue("cv_map",
            createKType(Map.class, createKType(String.class), createKType(String.class)),
            new HashMap<String, String>() {{
                put("Gehenna", "cv20550762");
                put("Trinity", "cv20557188");
                put("Millennium", "cv20560474");
                put("Abydos", "cv20550621");
                put("SRT", "cv20550020");
            }}
    );
    public final Value<Map<String, String>> redirectMap = typedValue("redirect_map",
            createKType(Map.class, createKType(String.class), createKType(String.class)),
            new HashMap<String, String>() {{
                put("Yuka", "Yuuka");
                put("Arisu", "Aris");
                put("Miku", "Hatsune_Miku");
                put("Mikoto", "Misaka_Mikoto");
                put("Ruiko", "Saten_Ruiko");
                put("Misaki_Special", "Shokuhou_Misaki");
            }}
    );

    public final Value<Map<String, String>> costumeMap = typedValue("costume_map",
            createKType(Map.class, createKType(String.class), createKType(String.class)),
            new HashMap<String, String>() {{
                put("泳装", "Swimsuit");
                put("正月", "NewYear");
                put("圣诞", "Christmas");
                put("温泉", "HotSpring");
                put("幼女", "Small");
                put("兔女郎", "Bunny");
                put("女仆", "Maid");
                put("自行车", "Cycling");
                put("运动服", "Track");
                put("应援团", "Cheerleader");
                put("私服", "Casual");
            }}
    );

    private PathnameData() {
        super("pathname");
    }
}
