class TaskManager {

    static class Task{
        int userId, taskId, priority;
        Task(int priority, int taskId, int userId){
            this.userId = userId;
            this.taskId = taskId; 
            this.priority = priority; 
        }
    }

    HashMap<Integer, Task> taskToObj;

    // PriorityQueue<Task> pq = new PriorityQueue<>(new Comparator<Task>(){
    //     if(a.priority != b.priority){
    //         return b.priority-a.priority;
    //     }
    //     return b.taskId-a.taskId;
    // });    --- wrong way

    PriorityQueue<Task> pq = new PriorityQueue<>((a, b) -> {
        if (a.priority != b.priority) return b.priority - a.priority;
        return b.taskId - a.taskId;
    });

    

    public TaskManager(List<List<Integer>> tasks) {
        
        taskToObj = new HashMap<>();

        for(List<Integer> task : tasks){
            int userId = task.get(0);
            int taskId = task.get(1);
            int priority = task.get(2);

            Task t = new Task(priority, taskId, userId);
            taskToObj.put(taskId, t);
            pq.add(t);
        }
    }
    
    public void add(int userId, int taskId, int priority) {
        if(!taskToObj.containsKey(taskId)){
            Task t = new Task(priority, taskId, userId);
            taskToObj.put(taskId, t);
            pq.add(t);
        }
    }
    
    public void edit(int taskId, int newPriority) {
        Task old = taskToObj.get(taskId);
        if(old != null){
            Task updated = new Task(newPriority, taskId, old.userId);
            taskToObj.put(taskId, updated);
            pq.add(updated);
        }
    }
    
    public void rmv(int taskId) {
        if(taskToObj.containsKey(taskId)){
            Task t = taskToObj.get(taskId);
            taskToObj.remove(taskId);
        }
    }
    
    public int execTop() {
        while(!pq.isEmpty()){
            Task top = pq.poll();
            Task curr = taskToObj.get(top.taskId);
            if(curr != null && curr == top){
                taskToObj.remove(top.taskId);
                return top.userId;
            }
        }
        return -1;        
    }
}


// /**
//  * Your TaskManager object will be instantiated and called as such:
//  * TaskManager obj = new TaskManager(tasks);
//  * obj.add(userId,taskId,priority);
//  * obj.edit(taskId,newPriority);
//  * obj.rmv(taskId);
//  * int param_4 = obj.execTop();
//  */
