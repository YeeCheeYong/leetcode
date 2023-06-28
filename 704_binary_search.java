class Solution {
    public int search(int[] nums, int target) {
int first=0;
int last=nums.length-1;
int mid;
int pos=-1;
while(pos==-1&&first<=last)
{
    mid=(first+last)/2;
    if(nums[mid]==target)
    pos=mid;
    else if(nums[mid]>target)
    last=mid-1;
    else
    first=mid+1;
}
return pos;
    }
}
