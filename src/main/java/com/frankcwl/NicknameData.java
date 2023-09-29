package com.frankcwl;

import net.mamoe.mirai.console.data.Value;
import net.mamoe.mirai.console.data.java.JavaAutoSavePluginData;

import java.util.*;

public class NicknameData extends JavaAutoSavePluginData {
    public static final NicknameData INSTANCE = new NicknameData();

    public final Value<Map<String, List<String>>> nicknameMap = typedValue("nickname_map",
            createKType(Map.class, createKType(String.class), createKType(List.class, createKType(String.class))),
            new HashMap<String, List<String>>() {{
                put("Aru", Arrays.asList("阿露", "亞瑠", "アル"));
                put("Eimi", Arrays.asList("艾米", "英美", "エイミ"));
                put("Haruna", Arrays.asList("晴奈", "羽留奈", "ハルナ", "神秘狙"));
                put("Hifumi", Arrays.asList("日富美", "日步美", "ヒフミ", "123"));
                put("Hina", Arrays.asList("日奈", "陽奈", "ヒナ"));
                put("Hoshino", Arrays.asList("星野", "星野", "ホシノ", "大叔"));
                put("Iori", Arrays.asList("伊织", "伊織", "イオリ", "佐仓"));
                put("Maki", Arrays.asList("真纪", "真紀", "マキ", "彩蛋"));
                put("Neru", Arrays.asList("尼禄", "寧瑠", "ネル"));
                put("Izumi", Arrays.asList("泉", "泉", "イズミ", "老八", "汉堡"));
                put("Shiroko", Arrays.asList("白子", "白子", "シロコ", "xcw"));
                put("Shun", Arrays.asList("瞬", "旬", "シュン", "大瞬"));
                put("Sumire", Arrays.asList("堇", "堇", "スミレ"));
                put("Tsurugi", Arrays.asList("鹤城", "弦生", "ツルギ", "颜艺", "颜艺姐"));
                put("Akane", Arrays.asList("茜", "朱音", "アカネ"));
                put("Chise", Arrays.asList("千世", "知世", "チセ"));
                put("Akari", Arrays.asList("亚伽里", "亞伽里", "アカリ", "明里"));
                put("Hasumi", Arrays.asList("莲见", "蓮實", "ハスミ"));
                put("Nonomi", Arrays.asList("野宫", "野乃美", "ノノミ", "富婆"));
                put("Kayoko", Arrays.asList("佳代子", "佳世子", "カヨコ", "恐惧枪"));
                put("Mutsuki", Arrays.asList("睦月", "無月", "ムツキ"));
                put("Mutsuki2", Arrays.asList("大头睦月", "大头"));
                put("Junko", Arrays.asList("淳子", "淳子", "ジュンコ", "小火龙"));
                put("Serika", Arrays.asList("芹香", "茜香", "セリカ", "猫猫", "黑猫"));
                put("Tsubaki", Arrays.asList("椿", "椿", "ツバキ", "狗盾"));
                put("Yuuka", Arrays.asList("优香", "優香", "ユウカ", "邮箱", "没包人", "半包人"));
                put("Haruka", Arrays.asList("遥香", "遙香", "ハルカ"));
                put("Asuna", Arrays.asList("明日奈", "明日奈", "アスナ"));
                put("Kotori", Arrays.asList("柯托莉", "亞都梨", "コトリ", "小鸟"));
                put("Suzumi", Arrays.asList("铃美", "鈴美", "スズミ"));
                put("Pina", Arrays.asList("菲娜", "菲娜", "フィーナ"));
                put("Hibiki", Arrays.asList("响", "響", "ヒビキ"));
                put("Karin", Arrays.asList("花凛", "花凛", "カリン"));
                put("Saya", Arrays.asList("纱绫", "沙耶", "サヤ", "鼠鼠"));
                put("Airi", Arrays.asList("爱莉", "愛莉", "アイリ", "冰激凌"));
                put("Fuuka", Arrays.asList("枫香", "風華", "フウカ", "煮饭婆"));
                put("Hanae", Arrays.asList("花江", "花繪", "ハナエ", "大护士"));
                put("Hare", Arrays.asList("晴", "晴", "ハレ", "小勾八"));
                put("Utaha", Arrays.asList("歌原", "詠葉", "ウタハ"));
                put("Ayane", Arrays.asList("绫音", "綾音", "アヤネ"));
                put("Chinatsu", Arrays.asList("千夏", "千夏", "チナツ"));
                put("Kotama", Arrays.asList("小玉", "小玉", "コタマ"));
                put("Juri", Arrays.asList("茱莉", "茱莉", "ジュリ"));
                put("Serina", Arrays.asList("芹娜", "芹奈", "セリナ", "小护士"));
                put("Shimiko", Arrays.asList("志美子", "志美子", "シミコ"));
                put("Yoshimi", Arrays.asList("好美", "喜美", "ヨシミ"));
                put("Mashiro", Arrays.asList("真白", "麻白", "マシロ"));
                put("Izuna", Arrays.asList("泉奈", "伊樹菜", "イズナ", "小狐狸"));
                put("Shizuko", Arrays.asList("静子", "靜子", "シズコ"));
                put("Aris", Arrays.asList("爱丽丝", "愛麗絲", "アリス", "Alice", "alice"));
                put("Midori", Arrays.asList("绿", "綠", "ミドリ", "小绿"));
                put("Momoi", Arrays.asList("桃井", "桃井", "モモイ", "小桃"));
                put("Cherino", Arrays.asList("切里诺", "潔莉諾", "チェリノ", "斯大萝"));
                put("Nodoka", Arrays.asList("和香", "和香", "ノドカ"));
                put("Yuzu", Arrays.asList("柚子", "柚子", "ユズ"));
                put("Azusa", Arrays.asList("梓", "梓", "アズサ", "小梓"));
                put("Hanako", Arrays.asList("花子", "花子", "ハナコ"));
                put("Koharu", Arrays.asList("小春", "小春", "コハル"));
                put("Azusa_Swimsuit", Arrays.asList("梓(泳装)", "梓(泳裝)", "アズサ（水着）", "泳装梓", "水梓"));
                put("Mashiro_Swimsuit", Arrays.asList("真白(泳装)", "麻白(泳裝)", "マシロ（水着）", "泳装真白", "水真白"));
                put("Tsurugi_Swimsuit", Arrays.asList("鹤城(泳装)", "弦生(泳裝)", "ツルギ（水着）", "泳装鹤城", "水鹤城", "水颜艺"));
                put("Hifumi_Swimsuit", Arrays.asList("日富美(泳装)", "日步美(泳裝)", "ヒフミ（水着）", "泳装日富美", "水日富美", "十字军"));
                put("Hina_Swimsuit", Arrays.asList("日奈(泳装)", "陽奈(泳裝)", "ヒナ（水着）", "泳装日奈", "水日奈", "水hina"));
                put("Iori_Swimsuit", Arrays.asList("伊织(泳装)", "伊織(泳裝)", "イオリ（水着）", "泳装伊织", "水伊织"));
                put("Izumi_Swimsuit", Arrays.asList("泉(泳装)", "泉(泳裝)", "イズミ（水着）", "泳装泉", "水泉", "水老八", "水汉堡"));
                put("Shiroko_Cycling", Arrays.asList("白子(单车)", "白子(單車)", "シロコ（ライディング）", "单车白子", "小车唯"));
                put("Shun_Small", Arrays.asList("瞬(幼女)", "旬(幼女)", "シュン（幼女）", "幼女瞬", "幼瞬"));
                put("Kirino", Arrays.asList("桐乃", "桐乃", "キリノ"));
                put("Saya_Casual", Arrays.asList("纱绫(私服)", "沙耶(私服)", "サヤ（私服）", "私服纱绫", "私服鼠鼠"));
                put("Neru_Bunny", Arrays.asList("尼禄(兔女郎)", "寧瑠(兔女郎)", "ネル（バニーガール）", "兔女郎尼禄", "红兔", "兔尼禄"));
                put("Karin_Bunny", Arrays.asList("花凛(兔女郎)", "花凛(兔女郎)", "カリン（バニーガール）", "兔女郎花凛", "黑兔"));
                put("Asuna_Bunny", Arrays.asList("明日奈(兔女郎)", "明日奈(兔女郎)", "アスナ（バニーガール）", "兔女郎明日奈"));
                put("Natsu", Arrays.asList("夏", "夏", "ナツ", "小夏"));
                put("Mari", Arrays.asList("玛丽", "瑪麗", "マリー"));
                put("Hatsune_Miku", Arrays.asList("初音未来", "初音未來", "初音ミク", "初音", "miku"));
                put("Ako", Arrays.asList("亚子", "亞子", "アコ"));
                put("Cherino_HotSpring", Arrays.asList("切里诺(温泉)", "潔莉諾(溫泉)", "チェリノ（温泉）", "温泉切里诺", "温泉斯大萝"));
                put("Chinatsu_HotSpring", Arrays.asList("千夏(温泉)", "千夏(溫泉)", "チナツ（温泉）", "温泉千夏"));
                put("Tomoe", Arrays.asList("智惠", "智惠", "トモエ"));
                put("Nodoka_HotSpring", Arrays.asList("和香(温泉)", "和香(溫泉)", "ノドカ（温泉）", "温泉和香"));
                put("Aru_NewYear", Arrays.asList("阿露(正月)", "亞瑠(正月)", "アル（正月）", "正月阿露", "春阿露", "春露"));
                put("Mutsuki_NewYear", Arrays.asList("睦月(正月)", "無月(正月)", "ムツキ（正月）", "正月睦月", "春睦月", "春月"));
                put("Serika_NewYear", Arrays.asList("芹香(正月)", "茜香(正月)", "セリカ（正月）", "正月芹香", "春芹香", "春黑"));
                put("Wakamo", Arrays.asList("若藻", "若藻", "ワカモ", "大狐狸"));
                put("Fubuki", Arrays.asList("吹雪", "吹雪", "フブキ"));
                put("Sena", Arrays.asList("濑名", "瀬奈", "セナ", "救护车"));
                put("Chihiro", Arrays.asList("千寻", "千尋", "チヒロ"));
                put("Mimori", Arrays.asList("三森", "三森", "ミモリ"));
                put("Ui", Arrays.asList("忧", "憂", "ウイ"));
                put("Hinata", Arrays.asList("日向", "日向", "ヒナタ"));
                put("Marina", Arrays.asList("玛利娜", "瑪麗娜", "マリナ", "保洁"));
                put("Miyako", Arrays.asList("宫子", "都子", "ミヤコ", "夏和小"));
                put("Saki", Arrays.asList("咲", "咲希", "サキ"));
                put("Miyu", Arrays.asList("美游", "美優", "ミユ", "垃圾兔"));
                put("Kaede", Arrays.asList("枫", "楓", "カエデ"));
                put("Iroha", Arrays.asList("伊吕波", "伊呂波", "イロハ", "168"));
                put("Michiru", Arrays.asList("满", "三千留", "ミチル"));
                put("Tsukuyo", Arrays.asList("月咏", "月夜", "ツクヨ"));
                put("Misaki", Arrays.asList("美咲", "美咲", "ミサキ"));
                put("Hiyori", Arrays.asList("日和", "日和", "ヒヨリ"));
                put("Atsuko", Arrays.asList("亚津子", "敦子", "アツコ", "公主"));
                put("Wakamo_Swimsuit", Arrays.asList("若藻(泳装)", "若藻(泳裝)", "ワカモ（水着）", "泳装若藻", "水若藻"));
                put("Nonomi_Swimsuit", Arrays.asList("野宫(泳装)", "野乃美(泳裝)", "ノノミ（水着）", "泳装野宫", "水野宫", "水富婆"));
                put("Ayane_Swimsuit", Arrays.asList("绫音(泳装)", "綾音(泳裝)", "アヤネ（水着）", "泳装绫音", "水绫音", "直升机"));
                put("Hoshino_Swimsuit", Arrays.asList("星野(泳装)", "星野(泳裝)", "ホシノ（水着）", "泳装星野", "水星野", "水大叔"));
                put("Shizuko_Swimsuit", Arrays.asList("静子(泳装)", "靜子(泳裝)", "シズコ（水着）", "泳装静子", "水静子"));
                put("Izuna_Swimsuit", Arrays.asList("泉奈(泳装)", "伊樹菜(泳裝)", "イズナ（水着）", "泳装泉奈", "水泉奈", "水忍"));
                put("Chise_Swimsuit", Arrays.asList("千世(泳装)", "知世(泳裝)", "チセ（水着）", "泳装千世", "水千世"));
                put("Saori", Arrays.asList("纱织", "沙織", "サオリ"));
                put("Moe", Arrays.asList("萌绘", "萌", "モエ"));
                put("Kazusa", Arrays.asList("和纱", "千紗", "カズサ"));
                put("Kokona", Arrays.asList("心奈", "心菜", "ココナ", "ccn", "kkn"));
                put("Utaha_Cheerleader", Arrays.asList("歌原(应援团)", "ウタハ（応援団）", "ウタハ（応援団）", "应援团歌原"));
                put("Noa", Arrays.asList("诺亚", "ノア", "ノア"));
                put("Hibiki_Cheerleader", Arrays.asList("响(应援团)", "ヒビキ（応援団）", "ヒビキ（応援団）", "应援团响", "拉拉响", "拉响"));
                put("Akane_Bunny", Arrays.asList("茜(兔女郎)", "アカネ（バニーガール）", "アカネ（バニーガール）", "兔女郎茜"));
                put("Yuuka_Track", Arrays.asList("优香(体操服)", "ユウカ（体操服）", "ユウカ（体操服）", "体操服优香", "体操服邮箱", "体香"));
                put("Mari_Track", Arrays.asList("玛丽(体操服)", "マリー（体操服）", "マリー（体操服）", "体操服玛丽", "体玛"));
                put("Hasumi_Track", Arrays.asList("莲见(体操服)", "ハスミ（体操服）", "ハスミ（体操服）", "体操服莲见", "体莲"));
                put("Himari", Arrays.asList("日鞠", "陽葵", "ヒマリ", "轮椅"));
                put("Shigure", Arrays.asList("时雨", "シグレ", "シグレ"));
                put("Serina_Christmas", Arrays.asList("芹娜(圣诞)", "セリナ（クリスマス）", "セリナ（クリスマス）", "圣诞芹娜"));
                put("Hanae_Christmas", Arrays.asList("花江(圣诞)", "ハナエ（クリスマス）", "ハナエ（クリスマス）", "圣诞花江"));
                put("Haruna_NewYear", Arrays.asList("晴奈(正月)", "ハルナ（正月）", "ハルナ（正月）", "正月晴奈", "春晴奈", "春神秘狙", "爆发狙"));
                put("Fuuka_NewYear", Arrays.asList("枫香(正月)", "フウカ（正月）", "フウカ（正月）", "正月枫香", "春枫香", "春煮饭婆", "蒸饭婆"));
                put("Junko_NewYear", Arrays.asList("淳子(正月)", "ジュンコ（正月）", "ジュンコ（正月）", "正月淳子", "春淳子"));
                put("Mine", Arrays.asList("美弥", "ミネ", "ミネ", "团长"));
                put("Mika", Arrays.asList("未花", "ミカ", "ミカ"));
                put("Megu", Arrays.asList("惠", "メグ", "メグ", "喷火枪"));
                put("Kanna", Arrays.asList("叶渚", "カンナ", "カンナ", "局长"));
                put("Sakurako", Arrays.asList("樱子", "サクラコ", "サクラコ", "觉悟"));
                put("Toki", Arrays.asList("时", "トキ", "トキ", "小时"));
                put("Nagisa", Arrays.asList("渚", "ナギサ", "ナギサ"));
                put("Koyuki", Arrays.asList("小雪", "コユキ", "コユキ"));
                put("Kayoko_NewYear", Arrays.asList("佳代子(正月)", "佳世子(正月)", "カヨコ（正月）", "春佳", "春代", "春佳代子"));
                put("Haruka_NewYear", Arrays.asList("遥香(正月)", "遙香(正月)", "ハルカ（正月）", "春遥", "春香", "春遥香"));
                put("Kaho", Arrays.asList("果穗", "佳穗", "カホ"));
                put("Arona", Arrays.asList("阿罗娜", "彩奈", "アロナ"));
                put("Plana", Arrays.asList("普拉娜", "プラナ"));
                put("Aris_Maid", Arrays.asList("爱丽丝(女仆)", "アリス（メイド）", "扫地机器人", "女仆爱丽丝", "女仆爱"));
                put("Toki_Bunny", Arrays.asList("时(兔女郎)", "トキ（バニーガール）", "兔时", "兔toki"));
                put("Yuzu_Maid", Arrays.asList("柚子(女仆)", "ユズ（メイド）", "女仆柚子", "女仆柚", "柚子橱"));
                put("Reisa", Arrays.asList("玲纱", "レイサ"));
                put("Rumi", Arrays.asList("瑠美", "ルミ"));
                put("Mina", Arrays.asList("弥奈", "ミナ", "南"));
                put("Minori", Arrays.asList("实里", "ミノリ", "工头"));
                put("Miyako_Swimsuit", Arrays.asList("宫子(泳装)", "ミヤコ（水着）", "水宫子"));
                put("Saki_Swimsuit", Arrays.asList("咲(泳装)", "サキ（水着）", "水saki", "水咲", "水咲希"));
                put("Miyu_Swimsuit", Arrays.asList("美游(泳装)", "ミユ（水着）", "水美游"));
                put("Shiroko_Swimsuit", Arrays.asList("白子(泳装)", "シロコ（水着）", "水白子"));
                put("Ui_Swimsuit", Arrays.asList("忧(泳装)", "ウイ（水着）", "水忧", "水ui"));
                put("Hinata_Swimsuit", Arrays.asList("日向(泳装)", "ヒナタ（水着）", "水日向"));
                put("Koharu_Swimsuit", Arrays.asList("小春(泳装)", "コハル（水着）", "水小春", "水春"));
                put("Hanako_Swimsuit", Arrays.asList("花子(泳装)", "ハナコ（水着）", "水花子", "水花"));
                put("Mimori_Swimsuit", Arrays.asList("三森(泳装)", "ミモリ（水着）", "水三森"));
                put("Meru", Arrays.asList("芽瑠", "メル", "梅露"));
                put("Momiji", Arrays.asList("红叶", "モミジ", "熊熊"));
                put("Kotori_Cheerleader", Arrays.asList("柯托莉(应援团)", "コトリ（応援団）", "拉拉鸟", "拉鸟"));
                put("Haruna_Track", Arrays.asList("晴奈(体操服)", "ハルナ（体操服）", "体操服晴奈", "体操服神秘狙", "体奈"));
            }}
    );

    private NicknameData() {
        super("nickname");
    }
}