package com.frankcwl;

import net.mamoe.mirai.console.command.CommandManager;
import net.mamoe.mirai.console.data.Value;
import net.mamoe.mirai.console.plugin.jvm.JavaPlugin;
import net.mamoe.mirai.console.plugin.jvm.JvmPluginDescriptionBuilder;
import net.mamoe.mirai.event.Event;
import net.mamoe.mirai.event.EventChannel;
import net.mamoe.mirai.event.GlobalEventChannel;
import net.mamoe.mirai.event.events.*;
import net.mamoe.mirai.message.data.*;
import net.mamoe.mirai.utils.ExternalResource;

import java.io.*;
import java.util.Timer;
import java.util.TimerTask;

public final class Yemao extends JavaPlugin {
    public static final Yemao INSTANCE = new Yemao();
    private Yemao() {
        super(new JvmPluginDescriptionBuilder("com.frankcwl.yemao", "2.1.1")
                .name("yemao")
                .author("frankcwl")
                .build());
    }

    @Override
    public void onEnable() {
        CommandManager.INSTANCE.registerCommand(YemaoCommand.INSTANCE, true);
        reloadPluginData(PathnameData.INSTANCE);
        reloadPluginData(NicknameData.INSTANCE);
        reloadPluginConfig(YemaoConfig.INSTANCE);

        Value<Long> theAdmin = YemaoConfig.INSTANCE.admin;
        Long admin = theAdmin.get();
        Util.initialize();

        EventChannel<Event> eventChannel = GlobalEventChannel.INSTANCE.parentScope(this);
        // 每隔一天检查图片
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Util.downloadAll(false);
            }
        };
        // bot上线时获得管理员
        eventChannel.subscribeOnce(BotOnlineEvent.class, event -> {
            Util.friend = event.getBot().getFriend(admin);
            timer.schedule(task, 0, 24 * 60 * 60 * 1000);
        });
        // 回复消息
        eventChannel.subscribeAlways(GroupMessageEvent.class, event -> {
            String message = event.getMessage().contentToString();
            if (message.startsWith(".")) {
                String context = message.substring(1);
                String name = Util.checkName(context);
                if (name != null) {
                    File file = resolveDataFile("yemao/" + name + ".png");
                    if (file.exists()) {
                        Image image = ExternalResource.uploadAsImage(file, event.getSubject());
                        event.getSubject().sendMessage(image);
                    }
                }
            }
        });
        eventChannel.subscribeAlways(FriendMessageEvent.class, event -> {
            String message = event.getMessage().contentToString();
            if (message.startsWith(".")) {
                String context = message.substring(1);
                String name = Util.checkName(context);
                if (name != null) {
                    File file = resolveDataFile("yemao/" + name + ".png");
                    if (file.exists()) {
                        Image image = ExternalResource.uploadAsImage(file, event.getSubject());
                        event.getSubject().sendMessage(image);
                    }
                }
            }
        });

    }
}