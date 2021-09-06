package lession4.week1;

import javafx.util.Pair;

import java.util.*;

/**
 * 239. 滑动窗口最大值
 */
public class Lc239_MaxSlidingWindow {
    /**
     * 最大堆
     * 懒删除
     * pair 存放num[i],i 两个值，每次 push 后，判断堆顶 pair 的的索引是否在区间内（i - k）
     * 不在则 pop
     * 最后取最大堆到数组中。
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (null == nums || k > nums.length) return null;
        List<Integer> ans = new ArrayList<>();
        Comparator<Pair<Integer, Integer>> comparator = new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> a, Pair<Integer, Integer> b) {
                return b.getKey() - a.getKey();
            }
        };
        PriorityQueue<Pair<Integer, Integer>> queue = new PriorityQueue<>(comparator);
        //此处取 截止到 k-1 是因为，可以让第一个数组最大值放在 下面的循环中处理 ans.add
        for (int i = 0; i < k - 1; i++) {
            queue.offer(new Pair(nums[i], i));
        }
        for (int i = k - 1; i < nums.length; i++) {
            queue.offer(new Pair(nums[i], i));
            while (queue.peek().getValue() <= i - k) queue.poll();
            ans.add(queue.peek().getKey());
        }
        int[] result = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }
        return result;
    }
}
