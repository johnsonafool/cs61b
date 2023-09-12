public class ArrayMaxValue {
    /** Returns the maximum value from m. */
    public static int max(int[] m) {
        int index = 0;
        int max = -1;
        while (index < m.length) {
            int element = m[index];
            if (element > max) {
                max = element;
            } 
            index++;
        }
        return max;
    }
    public static void main(String[] args) {
       int[] numbers = new int[]{9, 2, 15, 2, 22, 10, 6};      
       int maximum = max(numbers);
       System.out.println(maximum);       
    }
}
