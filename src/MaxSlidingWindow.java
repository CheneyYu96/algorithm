import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author yuminchen
 * @version V1.0
 * @date 2017/5/8
 */
public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(k == 1 || nums.length == 0){
            return nums;
        }
        int len = nums.length;
        int[] re = new int[len - k + 1];

        int max = Integer.MIN_VALUE;
        Set<Integer> maxIndex = new HashSet<>();
        for(int i = 0; i < k; i++){
            if(max < nums[i]){
                maxIndex.clear();
                maxIndex.add(i);
                max = nums[i];
            }
            else if(max == nums[i]){
                maxIndex.add(i);
            }
        }

        re[0] = max;

        for(int i = k; i < len; i++){
            if(maxIndex.contains(i - k)){
                maxIndex.remove(i - k);
            }
            if(nums[i] > max){
                max = nums[i];
                re[i - k + 1] = max;
                maxIndex.clear();
                maxIndex.add(i);
            }
            else if(nums[i] == max){
                maxIndex.add(i);
                re[i - k + 1] = max;
            }
            else {
                if(maxIndex.isEmpty()){
                    max = nums[i];
                    maxIndex.add(i);
                    for(int j = i - k + 1; j < i; j++){
                        if(max < nums[j]){
                            maxIndex.clear();
                            maxIndex.add(j);
                            max = nums[j];
                        }
                        else if(max == nums[j]){
                            maxIndex.add(j);
                        }
                    }
                    re[i - k + 1] = max;
                }
                else {
                    re[i - k + 1] = max;
                }
            }


        }
        return re;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new MaxSlidingWindow().maxSlidingWindow(new int[]{}, 0)));
    }
}
