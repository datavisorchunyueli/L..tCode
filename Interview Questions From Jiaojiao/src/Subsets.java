import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Christina on 1/13/16.
 */
public class Subsets {

    //BFS
    //类似数电
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> rst = new ArrayList<>();
        if (nums.length == 0) return rst;
        rst.add(new ArrayList<>());
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int size = rst.size();
            for (int j = 0; j < size; j++) {
                List<Integer> temp = new ArrayList<>(rst.get(j));
                temp.add(nums[i]);
                rst.add(temp);
            }
        }
        return rst;
    }


    //bit maniputation
    //O(n^2), O(1<<len)
    public List<List<Integer>> subsets1(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> rst = new ArrayList<>();
        if (nums.length == 0) return rst;
        int len = nums.length;
        int n = 1 << len;
        for (int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < len && (i >> j) != 0; j++) {
                if ((((i >> j)) & 1) == 1) list.add(nums[j]);
            }
            rst.add(list);
        }
        return rst;
    }

    //dfs
    public List<List<Integer>> subsets2(int[] nums) {
        Arrays.sort(nums);
        return dfs(nums, 0);
    }

    private List<List<Integer>> dfs(int[] nums, int start) {
        if (start == nums.length) {
            List<List<Integer>> ret = new ArrayList<>();
            ret.add(new ArrayList<>());
            return ret;
        }
        List<List<Integer>> next = dfs(nums, start + 1);
        List<List<Integer>> ret = new ArrayList<>();
        for (List list : next) {
            List<Integer> temp = new ArrayList<>(list);
            temp.add(0, nums[start]);
            ret.add(temp);
            ret.add(list);
        }
        return ret;
    }


    public static void main(String[] arg) {
        Subsets a = new Subsets();
        System.out.println(a.subsets(new int[]{1, 2, 3}));
        System.out.println(a.subsets1(new int[]{1, 2, 3}));
        System.out.println(a.subsets2(new int[]{1, 2, 3}));
        System.out.println(a.subsets1(new int[]{4, 1, 0}));
    }
}
