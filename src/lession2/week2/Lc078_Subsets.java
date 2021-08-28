package lession2.week2;

import java.util.ArrayList;
import java.util.List;

public class Lc078_Subsets {

    List<List<Integer>> ans = new ArrayList();
    List<Integer> set = new ArrayList();

    /**
     * 78. 子集
     */
    public List<List<Integer>> subsets(int[] nums) {
        findSubsets(0, nums);
        return ans;
    }

    private void findSubsets(int i, int[] nums) {
        if (i == nums.length) {
            //copy
            ans.add(new ArrayList<Integer>(set));
            return;
        }
        //不选
        findSubsets(i + 1, nums);
        set.add(nums[i]);
        //选
        findSubsets(i + 1, nums);
        set.remove(set.size() - 1);
    }

}
