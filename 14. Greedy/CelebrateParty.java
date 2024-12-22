
// Problem Statement 

// You are organizing a celebration party for a group of children 
// and need to divide them into smaller groups based on their ages. 
// To ensure that the children in each group can play together harmoniously, 
// the age difference between the youngest and the oldest child in any group must not exceed 2 years. 
// Your objective is to minimize the total number of groups formed while adhering to this age restriction.

// For example, if the ages are [5, 6, 7, 10], the groups could be [[5, 6, 7], [10]]



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CelebrateParty {
    public static void groupChildren(int[] ages) {
        Arrays.sort(ages);
        List<List<Integer>> groups = new ArrayList<>();
        List<Integer> currentgroup = new ArrayList<>();

        for(int age : ages)
        {
            if(currentgroup.isEmpty() || age <= currentgroup.get(0) + 2)
            {
                currentgroup.add(age);
            }else 
            {
                groups.add(new ArrayList<>(currentgroup));
                currentgroup.clear();
                currentgroup.add(age);
            }
        }
        if(!currentgroup.isEmpty())
        {
            groups.add(currentgroup);
        }

        for (int i = 0; i < groups.size(); i++) {
            System.out.println("Group " + (i + 1) + ": " + groups.get(i));
        }
    }

    public static void main(String[] args) {
        int[] testAges = {10, 7, 5, 6, 8, 11, 9};
        groupChildren(testAges);
    }
}
