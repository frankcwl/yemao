package com.frankcwl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

public class Util {
    static String filePath = null;
    public static HashMap<String,String> readData() throws Exception {
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(
                        Files.newInputStream(Paths.get(filePath +"nickname.txt")), StandardCharsets.UTF_8));


        HashMap<String,String> nicknameMap = new HashMap<>();

        String temp = null;
        String name = null;
        String nickname = null;
        while ((temp=bufferedReader.readLine())!=null){
            if (temp.startsWith("-")) {
                name = temp.substring(1);
                nickname = null;
            }
            if (temp.startsWith("=")) nickname = temp.substring(1);
            if (name != null && nickname != null) nicknameMap.put(nickname, name);
        }
        return nicknameMap;
    }

    public static String checkName(String nickname, HashMap<String,String> nicknameMap) {
        if (nicknameMap.get(nickname) != null) {
            return nicknameMap.get(nickname);
        } else {
            return nickname;
        }
    }

}
