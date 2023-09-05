class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]>b=new ArrayList<>();
        for(int i=0;i<intervals.length;i++)
        {
            if(newInterval[1]<intervals[i][0])
            {
                b.add(newInterval);
                for(int j=i;j<intervals.length;j++)
                {
                    b.add(intervals[j]);

                }
                break;
            }

            if(newInterval[0]>intervals[i][1])
            {

                    b.add(intervals[i]);

            }
            if(newInterval[0]>=intervals[i][0]&&
                    newInterval[0]<=intervals[i][1])
            {
                newInterval[0]=intervals[i][0];

            }
            if(newInterval[1]>=intervals[i][0]&&newInterval[1]<=intervals[i][1])
            {
                newInterval[1]=intervals[i][1];
            }
        }
        boolean x=false;
        for(int i=0;i<b.size();i++)
        {
            if(b.get(i).equals(newInterval))
            {
                x=true;break;
            }
        }

        int z[][]=b.toArray(new int[b.size()][2]);
        return z;
    }
}
