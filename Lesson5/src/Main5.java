import java.io.File;

public class Main5 {

    public static void main(String[] args) {
        int count = 5;
//        loopCountdown(count);
//        countdown(count);
//        System.out.println(factorial(count));

        File rootDir = new File("c:\\Users\\krylo\\Google Диск\\My Library\\");
        viewDir(rootDir, "");

    }

    private static void viewDir(File rootDir, String prefix) {
        if (rootDir.isFile()) {
            System.out.println(prefix + "File: " + rootDir.getName());
            return;
        }

        System.out.println(prefix + "Dir: " + rootDir.getName());

        for (File file : rootDir.listFiles()) {
            viewDir(file, prefix + "    ");
        }

    }

    private static int factorial(int count) {
        if (count == 1) {
            return count;
        }

        return count * factorial(count - 1);
    }

    private static void countdown(int count) {
        if (count <= 1) {
            System.out.println(count);
            return;
        }

        System.out.println(count);
        count--;
        countdown(count);
    }

    private static void loopCountdown(int count) {
        while (count >= 1) {
            System.out.println(count);
            count--;
        }
    }

}
