package com.frankcwl;

import net.mamoe.mirai.console.command.CommandSender;
import net.mamoe.mirai.console.command.java.JCompositeCommand;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class YemaoCommand extends JCompositeCommand {
    public static final YemaoCommand INSTANCE = new YemaoCommand();

    private YemaoCommand() {
        super(Yemao.INSTANCE, "yemao");
    }

    @SubCommand
    @Description("添加昵称条目")
    public void nickname(CommandSender sender, String pathname, String... nicknames ) {
        Map<String, List<String>> nicknameMap = Util.nicknameMap;
        if (nicknameMap.containsKey(pathname)) {
            for (String nickname : nicknames) {
                if (!nicknameMap.get(pathname).contains(nickname))
                    nicknameMap.get(pathname).add(nickname);
            }
        } else {
            nicknameMap.put(pathname, Arrays.asList(nicknames));
        }
        if (sender.getSubject() != null) sender.getSubject().sendMessage("添加成功");
    }

    @SubCommand
    @Description("重新下载所有图片")
    public void download(CommandSender sender) {
        if (sender.getSubject() != null) sender.getSubject().sendMessage("开始下载");
        Util.downloadAll(true);
        if (sender.getSubject() != null) sender.getSubject().sendMessage("下载完成");
    }
}
