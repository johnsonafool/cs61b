public class BreakContinue {
  public static void windowPosSum(int[] a, int n) {
    /** your code here */ 
    for (int i = 0; i < a.length; i++) {
        if (a[i] < 0) {
          continue;
        }        
        int newValue = 0;
        for (int j=i; j < i+n+1; j++) {
            if (j == a.length) {
                break;
            }
            newValue+=a[j];
        }        
        a[i] = newValue;
    }
  }

  public static void main(String[] args) {
    int[] a = {1, 2, -3, 4, 5, 4};
    int n = 3;

    int[] a2 = {1, -1, -1, 10, 5, -1};
    int n2 = 2;
    windowPosSum(a2, n2);

    // Should print 4, 8, -3, 13, 9, 4
    System.out.println(java.util.Arrays.toString(a2));
  }
}