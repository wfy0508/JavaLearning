package LearningTest.StringTest;
/*
    PROJECT_NAME: AlgorithmLearning
    User: Summer
    Create time: 2021/8/8 13:26
*/

import org.junit.Test;

public class StringDemo {
    /*
    方法一：将一个字符串指定范围进行翻转
     */
    public String reverse(String str, int startIndex, int endIndex) {
        char[] charArray = str.toCharArray();
        if (str.length() == 0) {
            for (int x = startIndex, y = endIndex; x < y; x++, y--) {
                char temp = charArray[x];
                charArray[x] = charArray[y];
                charArray[y] = temp;
            }
            return new String(charArray);
        } else return null;
    }

    /*
    方法二：使用StringBuilder
     */
    public String reverse1(String str, int startIndex, int endIndex) {
        StringBuilder builder = new StringBuilder(str.length());
        builder.append(str, 0, startIndex);
        for (int i = endIndex; i >= startIndex; i--) {
            builder.append(str.charAt(i));
        }
        builder.append(str.substring(endIndex + 1));
        return builder.toString();
    }

    /*
    方法三：使用字符串拼接
     */
    public String reverse2(String str, int startIndex, int endIndex) {
        // 第一部分
        String reverseStr = str.substring(0, startIndex);
        // 第二部分
        for (int x = endIndex; x >= startIndex; x--) {
            reverseStr += str.charAt(x);
        }
        // 第三部分
        reverseStr += str.substring(endIndex + 1);
        return reverseStr;

    }

    /*
    查找字符串在长字符串中出现的次数
      比如"ab"在"absdkfjskdabsjdabsdfsabireutiab"中出现的次数
     */
    public int getCount(String mainStr, String subStr) {
        int mainLength = mainStr.length();
        int subLength = subStr.length();
        int count = 0;
        int index;
        if (subLength <= mainLength) {
            while ((index = mainStr.indexOf(subStr)) != -1) {
                count++;
                mainStr = mainStr.substring(index + subStr.length());
            }
            return count;
        } else return 0;
    }

    @Test
    public void testCount() {
        String subStr = "ab";
        String mainStr = "absdkfjskdabsjdabsdfsabireutiab";
        System.out.println(getCount(mainStr, subStr));
    }

    @Test
    public void testReverse() {
        String str = "helloworld";
        System.out.println(str);
        System.out.println(reverse(str, 1, 3));
    }

    @Test
    public void testReverse1() {
        String str = "HelloWorld";
        System.out.println(str);
        System.out.println(reverse1(str, 1, 3));
    }

}
