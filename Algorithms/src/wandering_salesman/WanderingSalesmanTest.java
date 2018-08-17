package wandering_salesman;

import java.util.Arrays;

// always chose the closest town as next destination as long as the town has not been previously visited
// for ease of comprehension algorithm works from 0 upwards, but input/output is from 1 upwards
// (town 1 will be treaded in the algorithm as index 0 and so forth

class HeuristicWanderingSalesman
{
	int[][] distances;
	int[] path;
	int startingNode;
	
	HeuristicWanderingSalesman(int[][] distances, int startingNode)
	{
		this.distances = distances;
		this.startingNode = startingNode;
		path = new int[distances.length + 1];
		path[0] = startingNode;
		path[path.length - 1] = startingNode;
	}
	
	public int[] getPath()
	{
		int visitedTowns = 1;
		int destinationCandidate;
		
		// prime while loop and arbitrarily choose the new candidate as 0 if the departure town is not the first town or 1 otherwise
		if (startingNode == 0)
			destinationCandidate = 1;
		else 
			destinationCandidate = 0;
				
		
		while (visitedTowns < distances.length)
		{			
											
			// find the closest unvisited town
			for (int i = 0; i < distances.length; i++)
			{
				//display comparisons														
				//System.out.println(distances[path[visitedTowns-1]][destinationCandidate]);
				//System.out.println(distances[path[visitedTowns-1]][i]);
				//System.out.println();
				
				// check if the closest available town has been visited before and eliminate same-town minimum value
				if (distances[path[visitedTowns - 1]][destinationCandidate] >= distances[path[visitedTowns -1 ]][i] &&  
						distances[path[visitedTowns - 1]][i]!=0 && i != startingNode)
				{ 
					// store current candidate in case it is not valid
					int previousCandidate = destinationCandidate;
					destinationCandidate = i;
					
					for (int j = visitedTowns; j >= 0; j--)
						if(path[j] == i)
						{
							// reset and break loop;
							destinationCandidate = previousCandidate;
							break;
						}
				}
			}
			
			// add candidate to path and increase visitedTowns counter
			path[visitedTowns] = destinationCandidate;
			visitedTowns ++;
			
			// intermediate visual aid
			//System.out.println(Arrays.toString(path));
			//System.out.println();
			
			
			// propose next candidate by finding the first unvisited town
			destinationCandidate = 0;
			for(int i = 0; i < visitedTowns; i ++)
				if (destinationCandidate >= path[i])
					destinationCandidate = i + 1;
		}
		
		return path;
	}
}

public class WanderingSalesmanTest 
{
	public static void main(String[] args)
	{
		int[][] testArray = {{0, 8, 4, 9, 9},
							 {8, 0, 6, 7, 10},
							 {4, 6, 0, 5, 6},
							 {9, 7, 5, 0, 4},
							 {9, 10, 6, 4, 0},
							 };
		int startingNode = 0;
		
		
		HeuristicWanderingSalesman test = new HeuristicWanderingSalesman(testArray, startingNode);
		
		System.out.println(Arrays.toString(test.getPath()));
					
		
	}
}
