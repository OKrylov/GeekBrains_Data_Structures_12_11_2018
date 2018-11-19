import java.util.Stack;

public class Brackets {

    private String input;

    public Brackets(String input) {
        this.input = input;
    }

    public void check() {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            switch (ch) {
                case '{':
                case '[':
                case '(':
                    stack.push(ch);
                    break;
                case '}':
                case ']':
                case ')':
                    if (stack.isEmpty()) {
                        System.out.println("Error: " + ch + " at " + i);
                    } else {
                        Character topChar = stack.pop();
                        if (ch == '}' && topChar != '{' ||
                                ch == ']' && topChar != '[' ||
                                ch == ')' && topChar != '(') {
                            System.out.println("Error: " + ch + " at " + i);
                        }
                    }
                    break;
                default:
                    break;
            }
        }

        if ( !stack.isEmpty() ) {
            System.out.println("Error: missing right delimiter");
        }
    }
}
