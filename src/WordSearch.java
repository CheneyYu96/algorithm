/**
 * @author yuminchen
 * @version V1.0
 * @date 2017/4/26
 */
public class WordSearch {
    int xBound;
    int yBound;
    public boolean exist(char[][] board, String word) {
        int xl = board.length;
        if(xl == 0){
            return false;
        }
        int yl = board[0].length;
        xBound = xl;
        yBound = yl;
        for(int i = 0; i < xl; i++){
            for(int j = 0; j < yl; j++){
                if(exist(board,word,i,j,0)){
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * @param board
     * @param word
     * @param x
     * @param y
     * @return
     */
    public boolean exist(char[][] board, String word, int x, int y, int direction) {
        if(word.length()==0){
            return true;
        }
        if(word.charAt(0)!=board[x][y]){
            return false;
        }

        String next = word.substring(1);
        if(next.length() == 0){
            return true;
        }

        switch (direction){
            case 0 :
                return (x - 1 >= 0 && exist(board, next, x - 1, y, 3))
                        || (x + 1 < xBound && exist(board, next, x + 1, y, 1))
                        || (y - 1 >= 0 && exist(board, next, x, y - 1, 2))
                        || (y + 1 < yBound && exist(board, next, x, y + 1, 4));

            case 1 :
                return (x + 1 < xBound && exist(board, next, x + 1, y, 1))
                        || (y - 1 >= 0 && exist(board, next, x, y - 1, 2))
                        || (y + 1 < yBound && exist(board, next, x, y + 1, 4));

            case 2 :
                return (x - 1 >= 0 && exist(board, next, x - 1, y, 3))
                        || (x + 1 < xBound && exist(board, next, x + 1, y, 1))
                        || (y - 1 >= 0 && exist(board, next, x, y - 1, 2));

            case 3 :
                return (x - 1 >= 0 && exist(board, next, x - 1, y, 3))
                        || (y - 1 >= 0 && exist(board, next, x, y - 1, 2))
                        || (y + 1 < yBound && exist(board, next, x, y + 1, 4));

            case 4 :
                return (x - 1 >= 0 && exist(board, next, x - 1, y, 3))
                        || (x + 1 < xBound && exist(board, next, x + 1, y, 1))
                        || (y + 1 < yBound && exist(board, next, x, y + 1, 4));

            default:return false;
        }

    }

    public static void main(String[] args) {
        char[][] board = {{'a', 'a'}, {'a', 'a'}};
        System.out.println(new WordSearch().exist(board,"aaaaa"));
    }
}
