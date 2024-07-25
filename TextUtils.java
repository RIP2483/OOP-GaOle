

public class TextUtils {

    // Constant for text scrolling delay in milliseconds
    private static long TEXT_DELAY = 30;
    
    public TextUtils() {
        
    }

    public static void setDelay(long speed) {
        TEXT_DELAY = speed;
    }

    public static long getDelay() {
        return TEXT_DELAY;
    }

    public static void printWithDelay(String text) {
        for (char c : text.toCharArray()) {
            System.out.print(c);
            try {
                Thread.sleep(TEXT_DELAY);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
    }
}
