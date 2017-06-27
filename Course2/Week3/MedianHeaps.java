package Course2.Week3;

import java.io.*;
import java.util.*;

public class MedianHeaps {

	public static void main(String[] args)throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = 10000;
		
		
		
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>(){
			
			public int compare(Integer i1,Integer i2)
			{
				return i2-i1;
			}
			
		});
		
		int ans = 0;
		
		for(int i=0; i<n; i++)
		{
			int x =  Integer.parseInt(br.readLine());
				
			if(i == 0)
				{
					maxHeap.add(x);
					//System.out.println(x);
					ans += x;
					continue;
				}
			if(i == 1)
			{
				if(maxHeap.peek() > x)
				{
					minHeap.add(maxHeap.poll());
					maxHeap.add(x);
				}
				else
					minHeap.add(x);
				ans += (maxHeap.peek());
				continue;
			}
			
				int max = maxHeap.peek();
				if(x < max)
				{
					minHeap.add(max);
					maxHeap.poll();
					maxHeap.add(x);
				}
				else
				{
					minHeap.add(x);
				}
			
				if(minHeap.size() - maxHeap.size() > 0)
					maxHeap.add(minHeap.poll());
			
				ans += maxHeap.peek();
				ans %= 10000;
			
				
		}
		System.out.println(ans);
	}

}
