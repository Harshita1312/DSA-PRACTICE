class Solution {
    public void merge(int[] arr, int low, int mid, int high){
        ArrayList<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid+1;
        while(left<=mid && right<=high){
            if(arr[left] <= arr[right]){
                temp.add(arr[left++]);
            }
            else{
                temp.add(arr[right++]);
            }
        }
        while(left<=mid){
            temp.add(arr[left++]);
        }
        while(right<=high){
            temp.add(arr[right++]);
        }
        for(int i=low; i<=high; i++){
            arr[i] = temp.get(i-low);
        }
    }
    public int[] mergeSort(int[] arr, int low, int high) {
        if(low<high){
            int mid = (low + high)/2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid+1, high);
            merge(arr, low, mid, high);
        }
        return arr;
    }
    public int[] mergeSort(int[] nums) {
        
        return mergeSort(nums, 0, nums.length-1);
    }
}

---------------------------------------------------------------------------------
    
class Solution {
    public void conquer(int[] arr, int s, int mid, int e){
        int[] merged = new int[e-s+1];
        int i = s, j = mid+1, x=0;
        while(i<=mid && j<=e){
            if(arr[i]<=arr[j]) merged[x++] = arr[i++];
            else merged[x++] = arr[j++];
        }
        while(i<=mid){
            merged[x++] = arr[i++];
        }
        while(j<=e){
            merged[x++] = arr[j++];
        }
        for(int k=0, l=s; k<merged.length; k++, l++){
            arr[l] = merged[k];
        }
    }
    public void divide(int[] nums, int s, int e){
        if(s>=e) return;
        int mid = s + (e-s)/2;
        divide(nums, s, mid);
        divide(nums, mid+1, e);
        conquer(nums, s, mid, e);
    }
    public int[] sortArray(int[] nums) {
        divide(nums, 0, nums.length-1);
        return nums;
    }
}
