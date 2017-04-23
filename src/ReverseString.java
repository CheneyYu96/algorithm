/**
 * @author yuminchen
 * @version V1.0
 * @date 2017/4/23
 */
public class ReverseString {
    public String reverseWords(String s) {
        String[] spl = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < spl.length-1; i++){
            if(spl[i].equals("")) continue;
            sb.append(reverse(spl[i])).append(" ");
        }
        if(spl.length > 0) {
            sb.append(reverse(spl[spl.length - 1]));
        }
        return reverse(sb.toString());
    }

    private String reverse(String s){
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }
    public static void main(String[] args) {
        System.out.println(new ReverseString().reverseWords(" 1"));
    }
}
