class Solution {
    // HashSet<List<Integer>> set = new HashSet<>();

    public void CB(int[] arr, int target, int start, List<Integer> combi, List<List<Integer>> ans){   
        if(target == 0){
            ans.add(new ArrayList<>(combi));
            return;
        }
        for(int i=start; i<arr.length; i++){
            if(i>start && arr[i]==arr[i-1]) continue;
            if(arr[i]>target) break;
            combi.add(arr[i]);
            CB(arr, target-arr[i], i+1, combi, ans);
            combi.remove(combi.size()-1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> combi = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        CB(candidates, target, 0, combi, ans);
        return ans;
    }
}
