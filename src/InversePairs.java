/**
 * reference : http://blog.csdn.net/hiphopmattshi/article/details/7315654
 *
 * @author yuminchen
 * @version V1.0
 * @date 2017/4/17
 */
public class InversePairs {
    private int L[] = new int[100];
    private int R[] = new int[100];

    private int merge_sort(int Array[], int p, int q, int r)
    {
        int n1 = q-p+1;
        int n2 = r-q;
        System.arraycopy(Array, p, L, 0, n1);
        int infinite_num = 1000;
        L[n1] = infinite_num;
        for(int i=0;i<n2;i++)
        {
            R[i] = Array[q+i+1];
        }
        R[n2] = infinite_num;
        int inversions = 0;
        boolean count = false;
        int j=0;
        int i=0;
        for(int k=p;k<=r;k++)
        {
            if(!count &&(L[i]>R[j])&&(R[i]!= infinite_num))
            {
                inversions = inversions+n1-i;
                count = true;
            }
            if(L[i]<=R[j])
            {
                Array[k] = L[i];
                i++;
            }
            else
            {
                Array[k] = R[j];
                j++;
                count = false;
            }
        }
        return inversions;

    }
    private int merge_inverse(int Array[], int p, int r)
    {
        int inversions = 0;
        int q;
        if(p < r)
        {
            q = (p+r)/2;
            inversions = inversions+merge_inverse(Array,p,q);
            inversions = inversions+merge_inverse(Array,q+1,r);
            inversions = inversions+merge_sort(Array,p,q,r);
        }
        return inversions;
    }

    public static void main(String[] args) {
        System.out.println(new InversePairs().merge_inverse(new int[]{1,3,7,8,2,4,6,5},0,7));
    }
}
