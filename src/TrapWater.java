/**
 * reference : https://leetcode.com/problems/trapping-rain-water/#/solutions
 * @author yuminchen
 * @version V1.0
 * @date 2017/4/28
 */
public class TrapWater {

    public int trap(int[] height) {
        int a=0;
        int b=height.length-1;
        int max=0;
        int leftBound=0;
        int rightBound=0;
        while(a<=b){
            leftBound=Math.max(leftBound,height[a]);
            rightBound=Math.max(rightBound,height[b]);
            if(leftBound<rightBound){
                max += leftBound-height[a];
                a++;
            }
            else{
                max += rightBound-height[b];
                b--;
            }
        }
        return max;
    }


    public static void main(String[] args) {
        System.out.println(new TrapWater().trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}

