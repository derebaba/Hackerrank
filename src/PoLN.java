//	Power of large numbers
import java.math.*;
import java.util.*;

public class PoLN {
	
	//	Fermat's little theorem: a^(p-1) = 1 (mod p) if p is prime
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i = 0; i < T; i++)
		{
			BigInteger A = sc.nextBigInteger();
			BigInteger B = sc.nextBigInteger();
			BigInteger mod = BigInteger.valueOf((long)Math.pow(10, 9) + 7);
			if(B.compareTo(mod) != -1)
			{
				B = B.remainder(mod.subtract(BigInteger.ONE));
			}
			System.out.println(A.modPow(B, mod));
		}
		sc.close();
	}
}
