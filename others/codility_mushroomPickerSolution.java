public class Main {

	public static void main(String[] args) {
		System.out.println((numOfMushrooms(new int[]{2,3,7,5,1,3,9},4,6)));
	}
  public static int prefixSum(int[]a,int start,int end)
	{
		int[]s=new int[end-start+1];
//		Arrays.fill(s,0);
		s[0]=a[start];
		for(int i=1;i<=s.length-1;i++)
		{
			s[i]=s[i-1]+a[start+i];
		}
		return s[s.length-1];
	}
  public static int numOfMushrooms(int[] A, int k, int m) {
  int s1=0;int s2=0;
  //go left first
	int start1=k-m>=0?k-m:0;
	//System.out.println("start1"+ start1);
	for(int i=k-1;i>=start1;i--)
	{
		int ps1=prefixSum(A,i,k);
		//System.out.println("ps1, start: "+i+"end: "+k+" "+ps1);
		if(m-2*(k-i)-1>0)
		{
			ps1+=prefixSum(A,k+1,Math.min(A.length-1,k+1+(m-2*(k-i)-1)));
			//System.out.println("ps1, start: "+(k+1)+"end: "+Math.min(A.length-1,k+1+(m-2*(k-i)-1))+" "+ps1);
		}
		s1=(s1>ps1)?s1:ps1;
	}
  //	go right first
	int end2=k+m>A.length-1?A.length-1:k+m;
	for(int i=k+1;i<=end2;i++)
	{
		int ps2=prefixSum(A,k,i);
		//System.out.println("ps2, start: "+k+"end: "+i+" "+ps2);
		if((m-(2*(i-k))-1)>0)
		{
			ps2+=prefixSum(A,Math.max((k-1)-(m-(2*(i-k))-1),0),k-1);
			//System.out.println("ps2, start: "+Math.max((k-1)-(m-(2*(i-k))-1),0)+"end: "+(k-1)+" "+ps2);
		}
		s2=(s2>ps2)?s2:ps2;
	}
	return Math.max(s1,s2);
}
}
/*
Brute force method:  Use 2 loops.  First loop go left first.  Then for remaining number of possible moves, go right from kth element.  Use same logic for 2nd loop.  
Line 26 and line 39 is a IF statement that checks if total moves, m - used moves, which is given as double the distance between starting element, either k or i, to ending element, either k or i, plus 1, is positive.
Why plus 1?  Let's say starting element k is 0 and ending element i is 2.  Distance between the two is 2.  Remaining number of moves is to be used from k+1th element (assuming it is within bounds).
There should be 1 move to be used for moving from kth element to k=1th element.  As such, we need to remove one move from the remaining number of moves.

*/
