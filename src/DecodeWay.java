/**
 *
 *  https://leetcode.com/problems/decode-ways/#/description
 * @author yuminchen
 * @version V1.0
 * @date 2017/5/18
 */
public class DecodeWay {
    public int numDecodings(String s) {
        if(s.length()==0){
            return 0;
        }

        if(s.length()==1){
            return 1;
        }

        if(s.charAt(0)<='2' && s.charAt(1)<='6'){
            return 1 + numDecodings(s.substring(1)) + numDecodings(s.substring(2));
        }
        else{
            return numDecodings(s.substring(1));
        }
    }

    public static void main(String[] args) {
        System.out.println(new DecodeWay().numDecodings("12"));
    }
}
