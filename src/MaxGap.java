/**
 * @author yuminchen
 * @version V1.0
 * @date 2017/5/6
 */
public class MaxGap {
    /**
     * use radix sort in O(n) time cost
     * @param nums non-negative array
     * @return
     */
    public int maximumGap(int[] nums) {
        if(nums.length < 2){
            return 0;
        }

        int max = nums[0];
        for(int i = 1; i < nums.length; i++){
            max = Math.max(max, nums[i]);
        }

        int exp = 1;
        int[] sorted = new int[nums.length];
        while (max / exp > 0){
            int[] counter = new int[10];
            for (int num : nums) {
                counter[(num / exp) % 10]++;
            }

            for(int i = 1; i < 10; i++){
                counter[i] += counter[i-1];
            }

            for(int i = nums.length - 1; i >= 0; i--){
                sorted[--counter[(nums[i]/exp)%10]] = nums[i];
            }

            System.arraycopy(sorted, 0, nums, 0, nums.length);
            exp *= 10;
        }

        int gap = nums[1] - nums[0];
        for(int i = 1; i < nums.length - 1; i++){
            gap = Math.max(gap, nums[i+1] - nums[i]);
        }

        return gap;
    }

    public static void main(String[] args) {

    }
}
