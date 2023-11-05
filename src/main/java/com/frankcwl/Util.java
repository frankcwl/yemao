package com.frankcwl;

import net.mamoe.mirai.console.data.Value;
import net.mamoe.mirai.contact.Friend;
import net.mamoe.mirai.message.data.*;
import net.mamoe.mirai.utils.ExternalResource;
import net.mamoe.mirai.utils.MiraiLogger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {
    public static Map<String, String> cvMap;
    public static Map<String, String> redirectMap;
    public static Map<String, String> costumeMap;
    public static Map<String, List<String>> nicknameMap;
    public static MiraiLogger logger = Yemao.INSTANCE.getLogger();
    public static Friend friend;

    public static void initialize() {
        Value<Map<String, String>> cvMap = PathnameData.INSTANCE.cvMap;
        Value<Map<String, String>> redirectMap = PathnameData.INSTANCE.redirectMap;
        Value<Map<String, String>> costumeMap = PathnameData.INSTANCE.costumeMap;
        Value<Map<String, List<String>>> nicknameMap = NicknameData.INSTANCE.nicknameMap;
        Util.cvMap = cvMap.get();
        Util.redirectMap = redirectMap.get();
        Util.costumeMap = costumeMap.get();
        Util.nicknameMap = nicknameMap.get();
    }

    public static String checkName(String nickname) {
        for (String name : nicknameMap.keySet()) {
            if (nicknameMap.get(name).contains(nickname)) {
                return name;
            }
        }
        return nickname;
    }

    public static String getNameString(Element element) {
        int contentNum = 0;
        if (element.child(0).text().equals("")) contentNum++;
        StringBuilder name = new StringBuilder();
        for (Node node : element.child(contentNum).childNodes()) {
            if (node.nodeName().equals("span")) break;
            if (node.nodeName().equals("#text")) name.append(node);
            else name.append(Jsoup.parse(node.outerHtml()).text());
        }
        return name.toString().replaceAll("&nbsp;", "");
    }

    public static String findNextImg(Element line) {
        Element figure = line.nextElementSibling();
        while (figure != null && !figure.tagName().equals("figure")) {
            figure = figure.nextElementSibling();
        }
        if (figure == null) return null;
        return "https:" + figure.select("img").attr("data-src");
    }

    public static void download(String schoolName, boolean forceDownload) throws IOException {
        // 解析网页
        Document doc = Jsoup.connect("https://www.bilibili.com/read/" + cvMap.get(schoolName))
                .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36; wbxapp 1.0.0; Zoom 3.6.0)")
                .timeout(3000)
                .get();
        // 获取含有角色名的段落
        Elements lines = doc.select("p:matches([あ-んア-ン])");
        ArrayList<String> pathnameList = new ArrayList<>();

        for (Element line : lines) {
            String pathname;
            // 获取角色英文名
            Matcher matcher = Pattern.compile("[(|/](\\w+?)[/|)]").matcher(line.text());
            if (matcher.find()) {
                pathname = matcher.group(1);
            } else {
                logger.warning(line.text() + "中没有检测到角色名（" + schoolName +"）");
                friend.sendMessage(line.text() + "中没有检测到角色名（" + schoolName +"）");
                lines.remove(line);
                continue;
            }
            pathname = pathname.toLowerCase().replaceFirst("^(\\w)", String.valueOf(pathname.charAt(0)).toUpperCase());
            // 重定向角色名（食蜂操祈重名特殊处理）
            if (pathname.equals("Misaki") && line.text().contains("连动")) {
                pathname += "_Special";
            }
            if (redirectMap.get(pathname) != null) {
                pathname = redirectMap.get(pathname);
            }
            // 获取角色皮肤名
            for (String key : costumeMap.keySet()) {
                matcher = Pattern.compile("\\. *" + key).matcher(line.text());
                if (matcher.find()) {
                    pathname = pathname + "_" + costumeMap.get(key);
                    break;
                }
            }
            // 检查是否重复
            for (int i = 0; i < pathnameList.size(); i++) {
                if (pathnameList.get(i).equals(pathname)) {
                    logger.warning(pathname + "重复(" + schoolName + ")");
                    friend.sendMessage(pathname + "重复\n" + getNameString(line) + "\n"
                            + getNameString(lines.get(i)) + "\n请添加皮肤条目\n" +
                            "格式：/yemao costume 皮肤名 皮肤英文");
                }
            }
            pathnameList.add(pathname);
        }
        // 下载图片
        for (int i = 0; i < pathnameList.size(); i++) {
            File file = Yemao.INSTANCE.resolveDataFile("yemao/" + pathnameList.get(i) + ".png");
            if (!file.exists() || forceDownload) {
                String imgUrl = findNextImg(lines.get(i));
                if (imgUrl == null) {
                    logger.warning(pathnameList.get(i) + "没有找到图片（" + schoolName + "）");
                    friend.sendMessage(pathnameList.get(i) + "没有找到图片（" + schoolName + "）");
                    continue;
                }
                BufferedImage img = ImageIO.read(new URL(imgUrl));
                ImageIO.write(img, "png", file);
                logger.info(pathnameList.get(i) + "已下载完成");
            }
            if (!nicknameMap.containsKey(pathnameList.get(i))) {
                friend.sendMessage(
                        new PlainText("请为" + pathnameList.get(i) + "添加昵称（" + schoolName + "）\n" +
                        "格式：/yemao nickname " + pathnameList.get(i) +"昵称1 昵称2 ...")
                        .plus(ExternalResource.uploadAsImage(file, friend)));
            }
        }
    }

    public static void downloadAll(boolean forceDownload) {
        logger.info("开始下载图片");
        for (String schoolName : cvMap.keySet()) {
            try {
                download(schoolName, forceDownload);
            } catch (IOException e) {
                logger.warning("下载" + schoolName + "时出现IO错误\n" + e);
                friend.sendMessage("下载" + schoolName + "时出现IO错误\n" + e);
            }
        }
        logger.info("下载完成");
    }
}