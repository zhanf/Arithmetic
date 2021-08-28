package lession2.week2;

import java.util.ArrayList;
import java.util.List;

public class Lc046_Permute {
    List<List<Integer>> ans = new ArrayList();
    List<Integer> set = new ArrayList();

    public List<List<Integer>> permute(int[] nums) {
        findSubsets(0,nums);
        return ans;
    }

    private void findSubsets(int i, int[] nums) {
        if (i == nums.length) {
            //copy
            if (set.size() == nums.length){
                ans.add(new ArrayList<Integer>(set));
            }
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
