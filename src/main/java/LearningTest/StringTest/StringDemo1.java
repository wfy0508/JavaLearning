package LearningTest.StringTest;
/*
    PROJECT_NAME: AlgorithmLearning
    User: Summer
    Create time: 2021/8/9 9:39
*/

import org.junit.Test;

public class StringDemo1 {
    /*
    获取两个字符串最大相同子串
    比如"hghjgjhhellojhjy"和"sdfhelloui"相同子串为hello
     */
    // 前提是只有一个最大相同的子串
    public String getMaxSameString(String str1, String str2) {
        if (str1 != null && str2 != null) {
            String maxStr = (str1.length() >= str2.length()) ? str1 : str2;
            String minStr = (str1.length() < str2.length()) ? str1 : str2;
            int length = minStr.length();
            for (int i = 0; i < length; i++) {
                for (int x = 0, y = length - i; y <= length; x++, y++) {
                    String subStr = minStr.substring(x, y);
                    if (maxStr.contains(subStr)) {
                        return subStr;
                    }
                }
            }
        }
        return null;
    }

    @Test
    public void testDemo1(){
        String str1 = "hghjgjhhellojhjy";
        String str2 = "sdfhelloui";
        String maxSameString = getMaxSameString(str1, str2);
        System.out.println(maxSameString);
    }

    @Test
    public void testBuffer(){
        String str = null;
        StringBuffer buffer = new StringBuffer();
        buffer.append(str);
        System.out.println(buffer.length());
        System.out.println(buffer);

    }

}
