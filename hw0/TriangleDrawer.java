public class TriangleDrawer {
    public static void drawTriangle(int N) {        
        int ogN = N;
        while (N > 0) {            
            for (int i = 0; i < ogN - N + 1; i++) {
                System.out.print('*');
            }
            System.out.println();
            N--;
        }
    }

    public static void main(String[] args) {
        drawTriangle(10);
    }
}