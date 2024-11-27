package Q3;

public class Q3 {

    public static void main(String[] args) {
        // Original string
        String str = "Carter MacLennan is me";

        // Actual length of the string excluding extra spaces
        int actual_length = str.length();

        // Allocate a larger array with enough room for replacements
        char[] char_array = new char[actual_length + 10]; // Adding 10 extra spaces for replacements
        System.arraycopy(str.toCharArray(), 0, char_array, 0, actual_length);

        Q3 q3 = new Q3();
        q3.URLify(char_array, actual_length); // Pass actual length
        q3.display(char_array);
    }

    public void URLify(char[] char_array, int actual_length) {
        int whitespace_count = 0;

        // Count spaces in the actual string
        for (int i = 0; i < actual_length; i++) {
            if (char_array[i] == ' ') {
                whitespace_count++;
            }
        }

        // Calculate new length
        int backwards_ptr = actual_length + whitespace_count * 2 - 1;

        // Perform the URLify process from the end
        for (int i = actual_length - 1; i >= 0; i--) {
            if (char_array[i] == ' ') {
                char_array[backwards_ptr] = '0';
                char_array[backwards_ptr - 1] = '2';
                char_array[backwards_ptr - 2] = '%';
                backwards_ptr -= 3;
            } else {
                char_array[backwards_ptr] = char_array[i];
                backwards_ptr--;
            }
        }
    }

    public void display(char[] char_array) {
        System.out.println("-------------");
        for (char i : char_array) {
            System.out.print(i);
        }
        System.out.println("\n-------------");
    }
}
