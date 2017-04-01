package me.yokeyword.indexablelistview.help;

import com.github.promeg.pinyinhelper.Pinyin;

import java.util.regex.Pattern;

/**
 * Created by YoKeyword on 16/3/20.
 */
public class PinyinUtil {
    private static final String PATTERN_POLYPHONE = "^#[a-zA-Z]+#.+";
    private static final String PATTERN_LETTER = "^[a-zA-Z].*+";

    /**
     * 将字符串中的中文转化为拼音,其他字符不变
     */
    public static String getPingYin(String inputString) {

        char[] input = inputString.trim().toCharArray();
        String output = "";
        for (int i = 0; i < input.length; i++)
        {
            output += Pinyin.toPinyin(input[i]);
        }
        return output.toLowerCase();  // 字符串 转为小写
    }

    /**
     * 是否以#[a-zA-Z]#开头,用以处理多音字
     */
    public static boolean matchingPolyphone(String inputString) {
        return Pattern.matches(PATTERN_POLYPHONE, inputString);
    }

    /**
     * 是否以字母开头,如果不是, 索引: #
     */
    public static boolean matchingLETTER(String inputString) {
        return Pattern.matches(PATTERN_LETTER, inputString);
    }

    /**
     * 获取多音字的 开头字母
     */
    public static String getMatchingFirstPinyin(String inputString) {
        return inputString.substring(1, 2);
    }

    /**
     * 获取多音字的 真实拼音
     */
    public static String getMatchingPinyin(String inputString) {
        String[] splits = inputString.split("#");
        return splits[1];
    }

    /**
     * 获取多音字的 真实汉字
     */
    public static String getMatchingHanzi(String inputString) {
        String[] splits = inputString.split("#");
        return splits[2];
    }
}
