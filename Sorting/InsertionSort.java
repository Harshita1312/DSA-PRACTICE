class Solution {
    public int[] insertionSort(int[] arr) {
        for(int i=1; i<arr.length; i++){
            int j = i;
            while(j>0 && arr[j]<arr[j-1]){
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                    j--;
            }
        }
        return arr;
    }
}
