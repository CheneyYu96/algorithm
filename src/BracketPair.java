/**
 * @author yuminchen
 * @version V1.0
 * @date 2017/4/25
 */
public class BracketPair {

    public int findNumber(int bracketNum){
        return findByloc(bracketNum,bracketNum);
    }

    public int findByloc(int x, int y){
        if(x==1||y==0){
            return 1;
        }
        int nexty = y - 1;
        int nextx = x - 1;
        int first = 0;
        int second = 0;
        if(nextx - y >= 0){
            first =  findByloc(nextx, y);
        }
        if(nexty >=0 ){
            second = findByloc(x, nexty);
        }
        return first + second;
    }

    public static void main(String[] args) {
        System.out.println(new BracketPair().findNumber(6));
    }
}
