package OtherProblems;

public class DrawALine {
    static char[][] canvas =  new char[20][20];

    public static void insertZeros() {
        for (int i = 0; i < 20 ; i++) {
            for (int j = 0; j < 20; j++) {
                canvas[i][j] = '*';
            }
        }
    }

    public static void printCanvas() {
        for (int i = 0; i < 20 ; i++) {
            for (int j = 0; j < 20; j++) {
                System.out.print(canvas[i][j] + "  ");
            }
            System.out.println(" ");
        }
    }

    public static void drawLine(float startx, float starty, float endx, float endy) {
        //calculate slop
        double slop = (endy - starty)/(endx - startx);
        double precision = 0.5;

        double offset = starty - (slop*startx);

        for (int i = (int) startx; i <= endx; i++) {
            for (int j = (int) starty; j <= endy; j++) {
                double offsetCheck = j - slop*i;
                if (offsetCheck > offset-precision && offsetCheck < offset+precision) {
                    canvas[i][j] = '@';
                }
            }
        }
    }
}
