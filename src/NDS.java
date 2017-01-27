import java.util.*;

//	Non-Divisible Subset
public class NDS {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        long[] a = new long[n];
        int[] rem = new int[k];	//	remainder count
        for(int i = 0; i < n; i++)
        {
        	a[i] = in.nextLong();
        	rem[(int)(a[i] % k)]++;
        }
        int count = 0;
        if(rem[0] > 0)
        	count++;
        for(int i = 1; i < (k + 1) / 2; i++)
        {
        	count += rem[i] > rem[k - i] ? rem[i] : rem[k - i];
        }
        if((k % 2 == 0) && (rem[k / 2] > 0))
        	count++;
        System.out.println(count);
        in.close();
    }
}