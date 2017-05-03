/**
 * @author yuminchen
 * @version V1.0
 * @date 2017/5/3
 */
public class MinLargestSum {
    public int splitArray(int[] nums, int m) {
        int len = nums.length;
        int[][] mem = new int[len+1][m + 1];
        return subSplitArray(nums, mem, 0, m);
    }

    private int subSplitArray(int[] nums, int[][] mem, int index, int m){
        if(mem[index][m] != 0){
            return mem[index][m];
        }
        if(index == nums.length){
            return Integer.MAX_VALUE;
        }
        if(m == 1){
            int sum = 0;
            for (int i = index; i < nums.length; i++){
                sum +=  nums[i];
            }
            return sum;
        }

        int min = Integer.MAX_VALUE;
        for(int i = index; i < nums.length; i++){
            int sum = 0;
            for(int j = index; j <= i; j++){
                sum += nums[j];
            }
            min = Math.min(min, Math.max(sum, subSplitArray(nums, mem, i + 1, m-1)));
        }

        mem[index][m] = min;
        return min;
    }

    public static void main(String[] args) {
        System.out.println(new MinLargestSum().splitArray(new int[]{7,2,5,10,8}, 2));
    }
}
