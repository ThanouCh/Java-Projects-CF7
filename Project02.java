package gr.aueb.cf.solutions.projects;

/*
Εύρεση του υπο-πίνακα με το μέγιστο άθροισμα(maximum sum sub-array) σε έναν πίνακα ακεραίων.
 */
public class Project02 {

    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int maxSum = maxSubarraySum(arr);
        System.out.println("Maximum Subarray Sum: " + maxSum);
    }



    public static int maxSubarraySum(int[] arr) {
        int res = arr[0];           //μέγιστο άθροισμα υπο-πίνακα
        int maxEnding = arr[0];     //τρέχον μέγιστο άθροισμα
        int start = 0;              //αρχή του υπο-πίνακα
        int end = 0;                //τέλος του υπο-πίνακα
        int tempStart = 0;          //προσωρινό index για νέο ξεκίνημα

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > maxEnding + arr[i]) {
                maxEnding = arr[i];
                tempStart = i;
            } else {
                maxEnding = maxEnding + arr[i];
            }

            if (maxEnding > res) {
                res = maxEnding;
                start = tempStart; // Ορίζουμε την αρχή
                end = i;           // Ορίζουμε το τέλος
            }
        }
        System.out.print("Maximum Subarray: ");
        for (int i = start; i <= end; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        return res;
    }

}