class Solution {
    public int partition(int[] arr, int low, int high){
        int pivot = arr[low];
        int i=low, j=high, temp;
        while(i<j){
            while(i<=high-1 && arr[i] <= pivot) {i++;}
            while(j>=low+1 && arr[j] > pivot) {j--;}
            if(i<j){
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        temp = arr[j];
        arr[j] = arr[low];
        arr[low] = temp;

        return j;
    }
    public int[] quickSort(int[] arr, int low, int high) {
        if(low<high){
            int partition_index = partition(arr, low, high);
            quickSort(arr, low, partition_index-1);
            quickSort(arr, partition_index+1, high);
        }
        return arr;
    }
    public int[] quickSort(int[] nums) {
        return quickSort(nums, 0, nums.length-1);
    }
}
