package lession2.homework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lc811_SubdomainVisits {

    private HashMap<String, Integer> map = new HashMap();

    /**
     * 811. 子域名访问计数
     * 1、遍历数组
     * 截取字符串分为 count + 域名
     * 截取域名，生成子域名，保存在 map 中，key 为子域名，value 为 count
     * 遍历 map ，生成结果
     */
    public List<String> subdomainVisits(String[] cpdomains) {
        ArrayList<String> res = new ArrayList();
        if (null == cpdomains || cpdomains.length == 0) return res;
        for (String cpdomain : cpdomains) {
            collectCpdomain(cpdomain);
        }
        for (Map.Entry entry : map.entrySet()) {
            res.add(entry.getValue() + " " + entry.getKey());
        }
        return res;
    }

    private void collectCpdomain(String cpdomain) {
        if (null == cpdomain || cpdomain.length() == 0) return;
        String[] split = cpdomain.split(" ");
        String[] subRes = getSubCpdomain(split[1]);
        for (String s : subRes) {
            System.out.println(s);
            map.put(s, map.getOrDefault(s, 0) + Integer.valueOf(split[0]));
        }
    }

    private String[] getSubCpdomain(String cpdomain) {
        String[] result = cpdomain.split("\\.");
        for (int index = result.length - 1; index >= 0; index--) {
            if (index == result.length - 1) continue;
            result[index] = result[index] + "." + result[index + 1];
        }
        return result;
    }

}
