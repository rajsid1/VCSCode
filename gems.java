//Sample code
import java.io.*;
import java.util.*;
class gems
{
	static byte arr[] ={1,2,4,8,16,32,37};
	static ArrayList<String> alist=new ArrayList<String>(10);
	public static void main(String args[])throws IOException
	{
		Scanner sc=new Scanner(System.in);
		byte n=0,d=0;
		byte input=0;
		try
		{
			n=sc.nextByte();
			if(n<1||n>100)
				throw new Exception("raj");
			input++;	
			d=sc.nextByte();
			if(d<1||d>100)
				throw new Exception("raj");
			
			if(n>37)  //n=75
			{
				n=(byte)(100-n); //n=25
				byte sum=0;
				byte k;
				for(k=0;k<7;k++)
				{
					sum+=arr[k];
					if(sum>n)
						break;
				}
						
				//System.out.println("->"+(byte)(n-sum+arr[k]));
				arr[k++]=(byte)(n-sum+arr[k-1]);
				//System.out.println("->"+arr[k]);
				arr[k++]=(byte)(100-n);
				
				for(;k<7;k++)
					arr[k]=0;
			}
			else if(n<37)  //n=10
			{
				byte k;
				byte sum=0;
				for(k=0;k<7;k++)
				{
					sum+=arr[k];
					if(arr[k]>n)
						break;
				}
				sum-=arr[k];
				if(arr[k-1]!=n)
				{
					arr[k++]=n;
					sum+=n;
					for(;k<7;k++)
					{
						if(sum<48)	
							arr[k]=(byte)(sum+1);
						else
						{
							arr[k]=(byte)(100-sum);
						}
						sum+=arr[k];
					}
				}
			}
			
			sort();
			
			for(byte k=0;k<7;k++)
			{
				System.out.print(arr[k]+" ");
			}
			System.out.println();
			
			permute("","0123456",d);
				
			for(byte k=0;k<alist.get(0).length();k++)
			{
				System.out.print(arr[Integer.parseInt(String.valueOf(alist.get(0).charAt(k)))]+" ");
			}
			
			System.exit(0);
		}
		catch(InputMismatchException e)
		{
			
		}
		catch(Exception e)
		{
		}
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		while(input++<1)
			br.readLine();
			
		System.out.print("Invalid Input");
	}
	
	static void permute(String parsed, String left, byte sum)
	{	
		//System.out.println("parsed : "+parsed+"   left : "+left+"   sum : "+sum);
		
		if(sum==0)
		{
			alist.add(parsed);
			//System.out.println("answer:"+parsed);
		}
		else if(sum>0)
		{
			for(byte k=0;k<left.length();k++)
			{
				if(arr[Integer.parseInt(String.valueOf(left.charAt(k)))]<=sum)
				{
					permute((parsed+String.valueOf(left.charAt(k))), (left.substring(0,k)+left.substring(k+1)), (byte)(sum-arr[Integer.parseInt(String.valueOf(left.charAt(k)))]));
				}
			}
		}
	}
	static void sort()
	{	
		for(byte i=0;i<7;i++)
		{
			for(byte j=(byte)(i+1);j<7;j++)
			{
				if(arr[i]>arr[j])
				{
					arr[i]=(byte)(arr[i]+arr[j]);
					arr[j]=(byte)(arr[i]-arr[j]);
					arr[i]=(byte)(arr[i]-arr[j]);
				}
			}
		}
	}
}