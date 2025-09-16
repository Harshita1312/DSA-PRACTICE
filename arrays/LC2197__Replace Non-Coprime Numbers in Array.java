class Solution {

    public static int gcd(int a, int b){
        while(b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static int lcm(int a, int b){
        return ((a / gcd(a,b)) * b);
    }
    
    public List<Integer> replaceNonCoprimes(int[] nums) {
        List<Integer> res = new ArrayList<>();

        for (int num : nums) {
            res.add(num);
            while(res.size() >= 2){
                int ist = res.get(res.size()-1);
                int scd = res.get(res.size()-2);
                if(gcd(ist, scd) > 1){
                    res.remove(res.size()-1);
                    res.remove(res.size()-1);
                    res.add(lcm(ist, scd));
                }
                else{
                    break;
                }
            }
        }

        return res;
        
    }
}
