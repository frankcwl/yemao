package com.frankcwl;

import net.mamoe.mirai.console.plugin.jvm.JavaPlugin;
import net.mamoe.mirai.console.plugin.jvm.JvmPluginDescriptionBuilder;
import net.mamoe.mirai.event.Event;
import net.mamoe.mirai.event.EventChannel;
import net.mamoe.mirai.event.GlobalEventChannel;
import net.mamoe.mirai.event.events.GroupMessageEvent;
import net.mamoe.mirai.message.data.Image;
import net.mamoe.mirai.message.data.PlainText;
import net.mamoe.mirai.utils.ExternalResource;
import org.jetbrains.annotations.NotNull;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

public final class Yemao extends JavaPlugin {
    public static final Yemao INSTANCE = new Yemao();
    public static HashMap<String,String> nicknameMap;
    public static String filePath = "C:/mirai/data/BlueArchive/";
    private Yemao() {
        super(new JvmPluginDescriptionBuilder("com.frankcwl.yemao", "1.0.0")
                .name("yemao")
                .author("frankcwl")
                .build());
    }

    private static void accept(@NotNull GroupMessageEvent event) {
        String message = event.getMessage().contentToString();
        if (message.startsWith(".")) {
            String context = message.substring(1);
            String name = Util.checkName(context, nicknameMap);
            if (name != null) {
                File file = new File(filePath + "yemao/" + name + ".png");
                if (file.exists()) {
                    Image image = ExternalResource.uploadAsImage(file, event.getSubject());
                    event.getSubject().sendMessage(image);
                }
            }
            if (event.getSender().getId() == 1174525384) {
                PlainText text = (PlainText) event.getMessage().stream().filter(PlainText.class::isInstance).findFirst().orElse(null);
                Image newImage = (Image) event.getMessage().stream().filter(Image.class::isInstance).findFirst().orElse(null);
                if (text != null && newImage != null) {
                    String newName = text.toString().substring(1);
                    newName = newName.replaceAll("\n", "");
                    String[] names = newName.split("=");
                    if (names.length >= 2) {
                        try {
                            BufferedWriter writer = new BufferedWriter(
                                    new OutputStreamWriter(
                                            new FileOutputStream(filePath + "nickname.txt", true), StandardCharsets.UTF_8));
                            writer.write("-" + names[0] + "\n");
                            for (int i = 1; i < names.length; i++) {
                                writer.write("=" + names[i] + "\n");
                            }
                            writer.close();
                            event.getSubject().sendMessage("已储存昵称");
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    }
                    String newFileName = names[0] + ".png";
                    File newFile = new File(filePath + newFileName);
                    try {
                        BufferedImage img = ImageIO.read(new URL(Image.queryUrl(newImage)));
                        ImageIO.write(img, "png", newFile);
                        event.getSubject().sendMessage("已储存" + newFileName);
                    } catch (IOException e) {
                        event.getSubject().sendMessage("图片储存失败");
                    }
                }
            }
            try {
                nicknameMap = Util.readData();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void onEnable() {
        Util.filePath = filePath;
        try {
            nicknameMap = Util.readData();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
//        getLogger().info("Plugin loaded!");
        EventChannel<Event> eventChannel = GlobalEventChannel.INSTANCE.parentScope(this);
        eventChannel.subscribeAlways(GroupMessageEvent.class, Yemao::accept);
    }
}