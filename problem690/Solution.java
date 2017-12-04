import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public int getImportance(List<Employee> employees, int id) {
        if (employees == null || employees.size() == 0) {
            return 0;
        }
        int ans = 0;
        HashMap<Integer, Employee> uidEmployee = new HashMap<Integer, Employee>();
        for (Employee employee : employees) {
            uidEmployee.put(employee.id, employee);
        }
        Queue<List<Integer>> allSubordinates = new LinkedList<>();
        allSubordinates.add(uidEmployee.get(id).subordinates);
        ans += uidEmployee.get(id).importance;
        while (!allSubordinates.isEmpty()) {
            List<Integer> tmp = allSubordinates.poll();
            for (int i = 0; i < tmp.size(); i++) {
                ans += uidEmployee.get(tmp.get(i)).importance;
                allSubordinates.add(uidEmployee.get(tmp.get(i)).subordinates);
            }
        }
        return ans;
    }
}
