package me.elordenador.sima;

import java.io.IOException;

public class AnimationPlayer {
    public static void printInitAnimation() throws IOException, InterruptedException {
        ScrUtils.clearScreen();


        for (int i = 0; i < 30; i++) {
            ScrUtils.clearScreen();
            ScrUtils.go(5,1+i);
            System.out.println("   ( )   ");
            ScrUtils.go(5,2+i);
            System.out.println("   /|\\    ");
            ScrUtils.go(5,3+i);
            System.out.println("  / | \\   ");
            ScrUtils.go(5,4+i);
            System.out.println("    |    ");
            ScrUtils.go(5,5+i);
            System.out.println("   / \\");
            ScrUtils.go(5,6+i);
            System.out.println("  /   \\");
            ScrUtils.go(5,7+i);

            ScrUtils.go(1,36);
            ScrUtils.printSeparator();
            Thread.sleep(50);
        }

    }
    public static void printGOAnimation() throws IOException, InterruptedException {
        ScrUtils.clearScreen();
        int[] screenSize = ScrUtils.getScreenSize();
        int width = screenSize[1];

        boolean stick = false;

        for (int i = 6; i < width-10; i++) {
            ScrUtils.clearScreen();
            ScrUtils.go(i,29);
            System.out.println("   ( )   ");
            ScrUtils.go(i,30);
            if (stick) {
                System.out.println("    |");
                ScrUtils.go(i,31);
                System.out.println("    |");
            } else {
                System.out.println("   /|\\    ");
                ScrUtils.go(i,31);
                System.out.println("  / | \\   ");
            }


            ScrUtils.go(i,32);
            System.out.println("    |    ");
            ScrUtils.go(i,33);
            if (stick) {
                System.out.println("    |");
                ScrUtils.go(i,34);
                System.out.println("    |");
            } else {
                System.out.println("   / \\");
                ScrUtils.go(i,34);
                System.out.println("  /   \\");
            }

            ScrUtils.go(i,35);

            ScrUtils.go(1,36);
            ScrUtils.printSeparator();
            Thread.sleep(10 );
            stick = !stick;
        }

    }
}
