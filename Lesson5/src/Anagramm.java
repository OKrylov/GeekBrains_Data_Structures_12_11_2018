public class Anagramm {

    public static void main(String[] args) {
        Anagramm anagramm = new Anagramm("cat");
        anagramm.getAnagramm();
    }

    private final char[] chars;

    public Anagramm(String word) {
        chars = word.toCharArray();
    }
    
    public void getAnagramm() {
        getAnagramm(chars.length);
    }
    
    private void getAnagramm(int newSize) {
        if ( newSize == 1 ) {
            return;
        }

        for (int i = 0; i < newSize; i++) {
            getAnagramm(newSize - 1);
            if (newSize == 2) {
                display();
            }
            rotate(newSize);
        }
    }

    private void rotate(int newSize) {
        int pos = chars.length - newSize;
        char temp = chars[pos];
        for (int i = pos + 1; i < chars.length; i++) {
            chars[i - 1] = chars[i];
        }
        chars[chars.length - 1] = temp;
    }

    private void display() {
        for (int i = 0; i < chars.length; i++) {
            System.out.print(chars[i]);
        }
        System.out.println();
    }
}
