
import java.math.BigInteger;
import java.util.*;


public class LittlePandaPower {
    public static void main(String args[] ) throws Exception {
    	Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int i = 0; i < T; i++)
        {
        	BigInteger A = in.nextBigInteger();
        	BigInteger B = in.nextBigInteger();
        	BigInteger X = in.nextBigInteger();
        	BigInteger ans = BigInteger.ZERO;
        	if(B.compareTo(BigInteger.ZERO) >= 0)
        	{
        		ans = A.modPow(B, X);
        	} else
        	{
        		B = B.abs();
        		ans = A.modInverse(X);
        		ans = ans.modPow(B, X);
        	}
        	
        	System.out.println(ans);
        }
        in.close();
    }
}
