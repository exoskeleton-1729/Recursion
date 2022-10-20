public class RecursionTester {
	public static int scavHunt(int[] times, int[] points) {
    	int[] linearPts = new int[times[times.length-1] + 1];
    	for(int i = 0; i < linearPts.length; i++)
    	{
    		linearPts[i] = 0;
    	}
        for(int i = 0; i < points.length; i++)
        {
        	linearPts[times[i]] = points[i];
        }
        for(int i = 0; i < linearPts.length; i++)
        {
        	System.out.println(linearPts[i]);
        }
        return 21;
    }
	public static void main(String[] args)
	{
		int[] arr = {1, 5, 6, 7, 11};
		int[] arr2 = {200, 300, 400, 45, 87};
		scavHunt(arr, arr2);
	}

}
