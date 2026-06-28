class Solution {
    public int search(int[] nums, int target) {
        int minIndex = findMinIndex(nums);
        int left = binarySearch(nums, 0, minIndex - 1, target);
        int right = binarySearch(nums, minIndex, nums.length - 1, target);
        if (left == -1 && right == -1){
            return -1;
        }
        else if (left != -1){
            return left;
        }
        return right;
    }
    public int findMinIndex(int[] nums){
        int left = 0;
        int right = nums.length - 1;
        if (nums.length == 1){
            return nums[0];
        }
        if (nums[left] < nums[right]){
                return left;
        }
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (mid > 0 && nums[mid] < nums[mid - 1]){
                return mid;
            }
            if (mid < nums.length - 1 && nums[mid] > nums[mid + 1]){
                return mid + 1;
            }
            if (nums[mid] > nums[0]){
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        
        }
        return -1;
        
    }
    public int binarySearch(int[] nums, int left, int right, int target){
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (nums[mid] == target){
                return mid;
            }
            if (nums[mid] < target){
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
