//LC 621 TaskScheduler
class Solution {
    class Task{
        int time;
        int count;
        Task(int t, int c){
            this.time = t; 
            this.count = c;
        }
    }
    public int leastInterval(char[] tasks, int n) {
        int time = 0;
        int[] freq = new int[26];
        for(char task : tasks){
            freq[task-'A']++;
        }

        PriorityQueue<Task> pq = new PriorityQueue<>(new Comparator<Task>(){
            public int compare(Task t1, Task t2){
                return -Integer.compare(t1.count, t2.count);
            }
        });
        for(int i=0; i<26; i++){
            if(freq[i] >= 1){
                pq.add(new Task(time, freq[i]));
            } 
        }

        Queue<Task> q = new LinkedList<>();

        while(!pq.isEmpty() || !q.isEmpty()){
            
            if(!q.isEmpty() && time-q.peek().time > n){
                pq.add(q.remove());
            }
            
            if(!pq.isEmpty()){
                Task t = pq.remove();
                t.time = time;
                t.count--;
                if (t.count > 0){
                    q.add(t);
                }
            }
            
            time++;
        }

        return time;

    }
}
