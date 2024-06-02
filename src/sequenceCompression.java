public class sequenceCompression {
    public static String compressSequence(String input) {
        StringBuilder compressed = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            if (Character.isDigit(input.charAt(i))) {
                int count = Character.getNumericValue(input.charAt(i));
                char character = input.charAt(i + 1);

                if (count == 1 && i + 2 < input.length() && Character.isDigit(input.charAt(i + 2))) {
                    int nextCount = Character.getNumericValue(input.charAt(i + 2));
                    char nextChar = input.charAt(i + 3);

                    if (nextCount == 1 && nextChar == character + 1) {
                        char startChar = character;
                        while (i + 2 < input.length() && Character.getNumericValue(input.charAt(i + 2)) == 1
                                && input.charAt(i + 3) == character + 1) {
                            character = input.charAt(i + 3);
                            i += 2;
                        }
                        compressed.append('#').append(startChar).append('-').append(character).append('#');
                    } else {
                        compressed.append(count).append(character);
                    }
                } else {
                    compressed.append(count).append(character);
                }
                i++;
            } else {
                compressed.append(input.charAt(i));
            }
        }

        return compressed.toString();
    }
}
