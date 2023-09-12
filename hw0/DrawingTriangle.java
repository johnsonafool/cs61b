public class DrawingTriangle {
    public static void main (String[] args) {
        int floor = 1;
        while (floor < 6) {            
            for (int i = 0; i < floor; i++) {
                System.out.print('*');
            }
            System.out.println();
            floor++;
        }
    }
}