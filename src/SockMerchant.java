import java.util.*;

public class SockMerchant {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int c[] = new int[n];
        for(int c_i=0; c_i < n; c_i++){
            c[c_i] = in.nextInt();
        }
        int sold = 0;
        HashSet<Integer> h = new HashSet<Integer>();
        for (int i = 0; i < n; i++)
        {
        	if(!h.add(c[i]))
        	{
        		h.remove(c[i]);
        		sold++;
        	}
        }
        System.out.println(sold);
        in.close();
    }
}
