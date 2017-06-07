import java.io.*;

import java.util.Arrays;

public class Karatsuba {    //KARATSUBA MULTIPLICATION

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String a = br.readLine();
		String b = br.readLine();
		
		int n = a.length();
		
		System.out.println(multiply(a,b,n));
		
	
		
	}
	
	static String multiply(String a,String b,int n)
	{	
		
		
		if(n == 1)
		{
			String res = "";
			int ans = (int)(a.charAt(0)-'0') * (int)(b.charAt(0)-'0');
			if(ans < 10)
				res += "0";
			res += ans;
			return res;
				
		}
		
		String l1,l2,r1,r2;
		
		l1 = "";l2 = "";r1 = "";r2 = "";
		
		int half = n/2;
		
		for(int i=0; i<n-half; i++)
		{
			l1 += a.charAt(i);
			l2 += b.charAt(i);
		}
		for(int i=n-half; i<n; i++)
		{
			r1 += a.charAt(i);
			r2 += b.charAt(i);
		}
		
		String l1l2 = multiply(l1,l2,half);
		String r1r2 = multiply(r1,r2,half);
		
		String l1r2 = multiply(l1,r2,half);
		String l2r1 = multiply(l2,r1,half);
		
		String add = add(l1r2,l2r1);
		
		for(int i=0; i<n; i++)
			l1l2 += "0";
		for(int i=0; i<half; i++)
			add += "0";
		
		String res = add(l1l2,add);
		 res = add(res,r1r2);
		
		return res;
		
	}
	
	static String add(String a,String b)
	{
		int i = 0,j = 0,carry = 0;
		int n = Math.max(a.length(),b.length());
		char res[] = new char[n];
		
		for(int k=0; k<n; k++)
		{
			if(k >= a.length())
				carry += b.charAt(b.length()-1-k)-'0';
			else if(k >= b.length())
				carry += a.charAt(a.length()-1-k)-'0';
			else
				carry += a.charAt(a.length()-1-k)-'0' + b.charAt(b.length()-1-k)-'0';
			res[n-1-k] = (char)('0' + (carry%10));
			carry /= 10;
			
		}
		
		if(carry > 0)
			{String x = String.valueOf(carry);
			return x+""+String.valueOf(res);
			}
		else
			return String.valueOf(res);
		
		
	}

}
