//link :    https://www.geeksforgeeks.org/problems/mila-and-strings0435/1
// User function Template for Java
class Solution {
    static boolean checkPowerOfTwo(int n){
        if(n<=0) return false;
        while(n%2==0){
            n = n/2;
        }
        return n == 1;
    }
    static String lexicographicallySmallest(String s, int k) {
        // code here
        k = checkPowerOfTwo(s.length()) ? k/2 : k*2 ;
        
        if(k>s.length()) return "-1";
        
        Stack<Character> st = new Stack<>();
        StringBuilder sb;
        
        for(char c : s.toCharArray()){
            if(st.isEmpty()){
                st.push(c);
            }
            else{
                while(!st.isEmpty() && st.peek()>c && k>0){
                    st.pop();
                    k--;
                }
                st.push(c);
            }
        }
        while(k>0 && !st.isEmpty()){
            st.pop();
            k--;
        }
        
        if(st.isEmpty()) return "-1";
        
        sb = new StringBuilder();
        
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        sb.reverse();
        
        return sb.toString();
        
        
    }
}
