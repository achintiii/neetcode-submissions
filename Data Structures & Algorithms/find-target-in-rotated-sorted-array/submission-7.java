class Solution {
    public int search(int[] nums, int target) {
        
        int minIndex = findMin(nums, target);
        int left = binarySearch(nums, 0, minIndex - 1, target);
        int right = binarySearch(nums, minIndex, nums.length - 1, target);
        if (left != -1){
            return left;
        }
        if (right != -1){
            return right;
        }
        return -1;
        
    }
    private int findMin(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        if (nums[0] <= nums[nums.length - 1]){
            return 0;
        }
        while (left <= right){
            int mid = left + (right - left)  / 2;
            if (mid < nums.length - 1 && nums[mid] > nums[mid + 1]){
                return mid + 1;
            }
            if (mid > 0 && nums[mid] < nums[mid - 1]){
                return mid;
            }
            if (nums[mid] >= nums[0]){
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }

        }
        return -1;
    }
    private int binarySearch(int[] nums, int left, int right, int target){
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (nums[mid] == target){
                return mid;
            }
            else if (nums[mid] < target){
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
