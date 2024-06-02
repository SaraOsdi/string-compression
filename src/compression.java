public class compression {
    public static String compress(String input) {
        StringBuilder compressed = new StringBuilder();

        char prevChar = input.charAt(0);
        int count = 1;

        for (int i = 1; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            if (currentChar == prevChar) {
                count++;
            } else {
                compressed.append(count).append(prevChar);
                prevChar = currentChar;
                count = 1;
            }
        }


        compressed.append(count).append(prevChar);

        return compressed.toString();
    }
}
