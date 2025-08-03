class Solution {

    HashSet<List<Integer>> set = new HashSet<>();

    public void CB(int[] arr, int target, int i, List<Integer> combi, List<List<Integer>> ans){ 
        if(target == 0){
            if(!set.contains(combi)){
                ans.add(new ArrayList<>(combi));
                set.add(combi);
            }
            
            return;
        }
        if(i >= arr.length || target<0) return;

        combi.add(arr[i]);
        CB(arr, target-arr[i], i+1, combi, ans);
        CB(arr, target-arr[i], i, combi, ans);
        combi.remove(combi.size()-1);
        CB(arr, target, i+1, combi, ans);
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> combi = new ArrayList<>(); 
        List<List<Integer>> ans = new ArrayList<>();
        CB(candidates, target, 0, combi, ans);
        return ans;
    }
}
