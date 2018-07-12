package binarySearch;

public class CountOccurences {

    public static void main(String[] args){
        int nums[] = {3,4,4,4,4,4,4,4,5};
        int target = 6;
        System.out.println(countOccurences(nums,target));
    }

    public static int binarySearch(int [] nums, int low, int high, int target, boolean firstOccurence){


        while(low<high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target && mid!=low) {
                if (firstOccurence) {
                    high = mid;
                } else {
                    if(nums[mid] == nums[high]){
                        low = high;
                    }
                    else {
                        low = mid;
                    }
                }
            }
            else if(nums[mid]<target){
                low = mid+1;
            }
            else{
                high = mid-1;
            }

        }

        if(nums[low] == target){
            return low;
        }
        else{
            return -1;
        }
    }

    public static int countOccurences(int [] nums, int target){
        int low = 0;
        int high = nums.length-1;

        int firstIndex = binarySearch(nums,low,high,target,true);
        int lastIndex = binarySearch(nums,low,high,target,false);

        System.out.println("first index is " + firstIndex+" last index is "+lastIndex);
        if(firstIndex !=-1 || lastIndex!=-1) {
            return (lastIndex - firstIndex + 1);
        }
        return -1;
    }


}
