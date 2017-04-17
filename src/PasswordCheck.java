import java.util.ArrayList;
import java.util.List;

/**
 * @author yuminchen
 * @version V1.0
 * @date 2017/4/16
 */
public class PasswordCheck {
    public int strongPasswordChecker(String s) {
        return strongPasswordChecker(s,false);
    }
    public int strongPasswordChecker(String s, boolean hasAll) {
        int min = 0;
        int count = 1;
        char repeat = ' ';
        if(s==null||s.length()==0){
            return 6;
        }
        boolean hasLow = false;
        boolean hasUp = false;
        boolean hasDigit = false;
        List<Integer> indexes = new ArrayList<>();
        List<Integer> replaces = new ArrayList<>();

        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c<='9' && c>='0'){
                hasDigit = true;
            }

            if(c<='Z' && c>='A'){
                hasUp = true;
            }

            if(c<='z' && c>='a'){
                hasLow = true;
            }

            if(c==repeat){
                count++;
            }
            else{
                repeat = c;
                count = 1;
            }

            if(count == 3){
                indexes.add(i);
                if(s.length()>i+1 && s.charAt(i+1)==repeat){
                    replaces.add(i);
                }
                repeat = ' ';
                min ++;
            }
        }

        int falseNumber = hasAll? min : numebrOfBoolean(hasLow, hasUp, hasDigit);

        if(s.length()<6){
            if(falseNumber>min){
                min = falseNumber;
            }
            if(min + s.length()<6){
                min = 6 - s.length();
            }
        }
        else if(s.length()>20){
            // todo
            int offset = s.length() -20;
            if(min > offset){
                if(replaces.size()>0) {
                    for (int i = 0; i < replaces.size(); i++) {
                        int index = replaces.get(i);
                        s = s.substring(0, index) + change(s.charAt(index)) + s.substring(index + 1);
                    }
                    min = replaces.size() + strongPasswordChecker(s,min>=2);
                }
                else {
                    for(int i = offset-1; i>= 0; i--){
                        int index = indexes.get(i);
                        s = s.substring(0,index) + s.substring(index+1);
                    }
                    min = offset + strongPasswordChecker(s,hasAll);
                }
            }
            else if (min <= offset){
                if(min==0){
                    return offset+falseNumber;
                }
                for(int i = min-1; i>= 0; i--){
                    int index = indexes.get(i);
                    s = s.substring(0,index) + s.substring(index+1);
                }
                min = min + strongPasswordChecker(s,hasAll);
            }

        }
        else{
            if(falseNumber>min){
                min = falseNumber;
            }
        }
        return min;
    }

    public char change(char c){
        if(c<='Z' && c>='A'){
            return (char)(c + 'a'-'A');
        }
        else if(c<='z' && c>='a'){
            return (char)(c+'A'-'a');
        }
        else{
            if(c=='9'){
                return '0';
            }
            return (char)(c + 1);
        }
    }

    public int numebrOfBoolean(boolean up, boolean low, boolean digit){
        int number = 0;
        if(!up){
            number++;
        }
        if(!low){
            number++;
        }
        if(!digit){
            number++;
        }
        return number;
    }

    public static void main(String[] args) {
        PasswordCheck check = new PasswordCheck();
        System.out.println(check.strongPasswordChecker("aaaaaaaaaaaaaaaaaaaaa"));
//        System.out.println(check.strongPasswordChecker("aaAaaAaaAaaAaaAaaAaaa"));
    }
}
