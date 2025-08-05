class Solution {
    // public int[] prefixSum(int[] nums){
    //     int[] ps = new int[nums.length];
    //     ps[0] = nums[0];
    //     for(int i=1; i<nums.length; i++){
    //         ps[i] = ps[i-1] + nums[i];
    //     }
    //     return ps;
    // }
    public int subarraySum(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1); // empty subarray

        int count=0, sum=0;

        for(int j=0; j<nums.length; j++){
            sum += nums[j];
            if(map.containsKey(sum - k)) count += map.get(sum-k);
            map.put(sum, map.getOrDefault(sum,0)+1);
        }
        return count;
    }
}
