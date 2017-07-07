package Course3.Week3;

import java.io.*;
import java.util.*;

public class Huffman {
	
	public static void main(String[] args)  throws  IOException{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\SAWANT\\Desktop\\huffman.txt"));
		
		int n = Integer.parseInt(br.readLine());
		
		PriorityQueue<Node> pq = new PriorityQueue<Node>(new Comparator<Node>(){
			
			public int compare(Node n1,Node n2)
			{
				if(n1.w < n2.w)
					return -1;
				else if(n1.w > n2.w)
					return 1;
				else return 0;
			}
		});
		
		for(int i=0; i<n; i++)
		{
			int w = Integer.parseInt(br.readLine());
			pq.add(new Node(w,0,0));
		}
		
		while(pq.size() > 1)
		{
			Node n1 = pq.remove();
			Node n2 = pq.remove();
			
			pq.add(new Node(n1.w + n2.w, Math.max(n1.max_bits , n2.max_bits) + 1,Math.min(n1.min_bits, n2.min_bits) + 1));
		}
		
		System.out.println(pq.peek().max_bits);
		System.out.println(pq.peek().min_bits);
		
	}

	static class Node{
		long w;
		int max_bits,min_bits;
		Node(long w,int max_bits,int min_bits)
		{
			this.w = w;
			this.min_bits = min_bits;
			this.max_bits = max_bits;
		}
	}
	
}
