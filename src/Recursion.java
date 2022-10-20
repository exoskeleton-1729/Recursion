public class Recursion {

    //How many subsets are there of the numbers 1...n
    // that don't contain any consecutive integers?
	public static long nonConsecutiveSubsets(int n) {
    	if(n == 1)
    		return 2;
    	if(n == 2)
    		return 3;
    	else
    		return(nonConsecutiveSubsets(n-1) + nonConsecutiveSubsets(n-2));
    }

    //A kid at the bottom of the stairs can jump up 1, 2, or 3 stairs at a time.
    //How many different ways can they jump up n stairs?
    // Jumping 1-1-2 is considered different than jumping 1-2-1
	public static long waysToJumpUpStairs(int n) {
    	if(n == 1)
    		return 1;
    	if(n == 2)
    		return 2;
    	if(n == 3)
    		return 4;
    	else
    		return(waysToJumpUpStairs(n-3) + waysToJumpUpStairs(n-2) + waysToJumpUpStairs(n-1));
    }

    //Prints the value of every node in the singly linked list with the given head, but in reverse
	public static void reverseList(ListNode head) {
		if(head == null)
			return;
		reverseList(head.getNext());
		System.out.println(head.getValue());
	}

    //For the given 2D array of Strings, replaces the String at index[x][y]
    //with "infected" unless the String is "vaccinated";
    // also, any Strings they are orthogonally adjacent to
    //that are not "vaccinated" will also be infected, and any adjacent to
    //them as well etc.
    public static void infect(String[][] grid, int x, int y) {
    	if(grid[x][y].equals("vaccinated"))
    	{
    		return;
    	}
    	else if(grid[x][y].equals("infected"))
    	{
    		return;
    	}
    	else
    	{
    		grid[x][y] = "infected";
    		
    		if(x < grid.length-1)
    			infect(grid, x+1, y);
    		if(y < grid[0].length-1)
    			infect(grid, x, y+1);
    		if(x > 0)
    			infect(grid, x-1, y);
    		if(y > 0)
    			infect(grid, x, y-1);
    	}

    }


    //Prints all the permutations of str on separate lines
    //You may assume that str has no repeated characters
    //Order is your choice
    public static void permute(String str) {
    	if(str.length() == 0)
    	{
    		throw new IndexOutOfBoundsException();
    	}
    	else
    	{
    		permuteWithPrefix(str, "");
    	}

    }

    //ALTERNATIVE POTENTIAL helper method:
    //prints all the permutations of str, BUT with prefix attached at the beginning
    //of each permutation
    private static void permuteWithPrefix(String str, String prefix) {
        if (str.length() == 0)
        	System.out.println(prefix);
        else
        {
            for (int i = 0; i < str.length(); i++)
            {
                permuteWithPrefix(str.substring(0, i) + str.substring(i + 1, str.length()), prefix + str.charAt(i));
            }
        }
    }

    //Prints all the subsets of str on separate lines
    //You may assume that str has no repeated characters
    //For example, subsets("abc") would print out "", "a", "b", "c", "ab", "ac", "bc", "abc"
    //Order is your choice
    public static void subsets(String str) {
    	subsetsWithPrefix(str, "");
    }

    //ALTERNATIVE POTENTIAL helper method:
    //prints all the subsetsof str, BUT with prefix attached at the beginning
    //of each subset
    private static void subsetsWithPrefix(String str, String prefix) {
    	System.out.println(prefix);
        for (int i = 0; i < str.length(); i++)
        {
            subsetsWithPrefix(str.substring(i + 1), prefix + str.charAt(i));
        }
    }

    //Performs a mergeSort on the given array of ints
    public static void mergeSort(int[] ints) {
    	mergeSort(ints, 0, ints.length-1);
    }

    //Performs a mergeSort on ints ONLY from index start to end
    private static void mergeSort(int[] ints, int start, int end) {
    	if (start < end)
    	{
            int mid = start + (end - start)/2;
            mergeSort(ints, start, mid);
            mergeSort(ints, mid + 1, end);
            merge(ints, start, mid, end);
        }
    }


    //PRECONDITION: ints is sorted from start to mid, and also from 
    //mid+1 to end is sorted
    //Merges the two halves (start to mid and mid+1 to end)
    public static void merge(int[] ints, int start, int mid,  int end) {
    	int first = mid - start + 1;
        int second = end - mid;
        int firstArr[] = new int[first];
        int secondArr[] = new int[second];
        
        for (int i = 0; i < first; i++)
        {
            firstArr[i] = ints[start + i];
        }
        
        for (int i = 0; i < second; i++)
        {
            secondArr[i] = ints[mid + i + 1];
        }
        
        int x = 0;
        int y = 0;
        int k = start;
        
        while (x < first && y < second) 
        {
            if (firstArr[x] <= secondArr[y])
            {
                ints[k] = firstArr[x];
                x++;
            }
            else 
            {
                ints[k] = secondArr[y];
                y++;
            }
           k++;
        }
        
        while (x < first) 
        {
            ints[k] = firstArr[x];
            x++;
            k++;
        }
        
        while (y < second)
        {
            ints[k] = secondArr[y];
            y++;
            k++;
        }
    }

    //Performs a quickSort on the given array of ints
    //Use the middle element (rounding up) as the pivot
    public static void quickSort(int[] ints) {
    	quickSort(ints, 0, ints.length-1);

    }

    //Performs a quickSort on ints ONLY from index start to end
    private static void quickSort(int[] ints, int start, int end) {
    	if(start < end)
    	{
            int pivot = pivot(ints, start, end, ints[end]);
            quickSort(ints, start, pivot - 1);
            quickSort(ints, pivot + 1, end);
        }
    }


    //Pivots the section of ints from start to end around the pivot.
    //Returns the final index of the pivot
    public static int pivot(int[] ints, int start, int end, int pivot) {
        int i = start - 1;
        for(int j = start; j < end; j++)
        {
            if (ints[j] <= pivot)
            {
                i++;
                int temp = ints[i];
                ints[i] = ints[j];
                ints[j] = temp;
            }
        }

        int temp = ints[i+1];
        ints[i+1] = ints[end];
        ints[end] = temp;
        return i+1;
    }

    // You are partaking in a scavenger hunt!
    // You've gotten a secret map to find many of the more difficult
    // items, but they are only available at VERY specific times at
    // specific places.  You have an array, times[], that lists at which
    // MINUTE an item is available.
    // Items in the ScavHunt are worth varying numbers of points.
    // You also have an array, points[], same length as times[],
    // that lists how many points each of the corresponding items is worth.
    // Problem is: to get from one location to the other takes 5 minutes,
    // so if there is an item, for example, available at time 23 and another
    // at time 27, it's just not possible for you to make it to both: you'll
    // have to choose!
    // Write a method that returns the maximum POINTS you can get.
    public static int scavHunt(int[] times, int[] points) {
    	int[] linearPts = makeLinear(times, points);
    	return linearScavHunt(linearPts);
    }
    
    // I made this method, it performs a scavHunt on a linearPts array.
    public static int linearScavHunt(int[] linearPts) {
    	if(linearPts.length == 0)
    		return 0;
    	if(linearPts.length == 1)
    		return linearPts[0];
    	if (linearPts.length == 2 || linearPts.length == 3 || linearPts.length == 4 || linearPts.length == 5)
    		return arrMax(linearPts);
    	else
    	{
    		return max(linearPts[linearPts.length-1] + linearScavHunt(removeLastN(linearPts, 5)), linearScavHunt(removeLastN(linearPts, 1)));
    	}
    }
    
    // I made this method, it removes the last n elements of an array and returns a new array
    public static int[] removeLastN(int[] arr, int n)
    {
    	int[] newArr = new int[arr.length-n];
    	for(int i = 0; i < newArr.length; i++)
    	{
    		newArr[i] = arr[i];
    	}
    	return newArr;
    }
    
    // Converts to a linear pts array. For example, if the code gives me items at time = 2 has points 200, 
    // and item at time = 5 has points 40, it'll convert this to an array [0, 0, 200, 0, 0, 40] where the index represents time
    public static int[] makeLinear(int[] times, int[] points) {
    	int[] linearPts = new int[times[times.length-1] + 1];
    	for(int i = 0; i < linearPts.length; i++)
    	{
    		linearPts[i] = 0;
    	}
        for(int i = 0; i < points.length; i++)
        {
        	linearPts[times[i]] = points[i];
        }
        return linearPts;
    }
    
    public static int arrMax(int[] arr)
    {
    	int max = arr[0];
    	for(int i = 1; i < arr.length; i++)
    	{
    		max = max(max, arr[i]);
    	}
    	return max;
    }
    
    public static int max(int a, int b)
    {
    	if(a > b)
    		return a;
    	else
    		return b;
    }

    //Prints a sequence of moves (one on each line)
    // to complete a Towers of Hanoi problem with
    //n disks starting on tower 0, ending on tower 1.
    // The towers are number 0, 1, 2, and each move should be of
    //the form "1 -> 2", meaning "take the top disk of tower 1 and 
    //put it on tower 2" etc.
    public static void solveHanoi(int n) {
    	hanoiHelper(n, 0, 1, 2);
    }
    
    public static void hanoiHelper(int n, int initialTower, int finalTower, int otherTower) {
    	if (n == 1)
        {
            System.out.println(initialTower + " -> " + finalTower);
            return;
        }
        hanoiHelper(n - 1, initialTower, otherTower, finalTower);
        System.out.println(initialTower + " -> " + finalTower);
        hanoiHelper(n - 1, otherTower, finalTower, initialTower);
    }
    
}