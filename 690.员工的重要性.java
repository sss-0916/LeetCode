/*
// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
*/
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        if (employees.isEmpty()) {
            return 0;
        }

        HashMap<Integer, Employee> info = new HashMap<>();
        for (Employee e : employees) {
            info.put(e.id, e);
        }

        int result = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(id);
        while (!queue.isEmpty()) {
            int curId = queue.poll();
            result += info.get(curId).importance;
            for (int subid : info.get(curId).subordinates) {
                queue.offer(subid);
            }
        }

        return result;
    }
}