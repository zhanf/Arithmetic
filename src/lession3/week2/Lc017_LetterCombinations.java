package lession3.week2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Lc017_LetterCombinations {

    public List<String> letterCombinations(String digits) {
        ans = new ArrayList<>();
        if (null == digits || digits.length() == 0) return ans;
        phone = new HashMap<>();

        phone.put('2', "abc");
        phone.put('3', "def");
        phone.put('4', "ghi");
        phone.put('5', "jkl");
        phone.put('6', "mno");
        phone.put('7', "pqrs");
        phone.put('8', "tuv");
        phone.put('9', "wxyz");

        dsf(digits, 0);
        return ans;
    }

    private void dsf(String digits, int index) {
        if (index == digits.length()) {
            ans.add(sb.toString());
            return;
        }
        char[] array = phone.get(digits.charAt(index)).toCharArray();
        for (char c : array) {
            //添加到 sb
            sb.append(c);
            dsf(digits, index + 1);
            //sb 还原现场
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    private StringBuilder sb = new StringBuilder();
    private HashMap<Character, String> phone;
    private List<String> ans;
}
