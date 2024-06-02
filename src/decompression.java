public class decompression {
    public static String decompress(String compressed) {
        StringBuilder decompressed = new StringBuilder();
        for (int i = 0; i < compressed.length(); i++) {
            if (compressed.charAt(i) == '#') {
                // Extract the range
                char startChar = compressed.charAt(i + 1);
                char endChar = compressed.charAt(i + 3);
                for (char c = startChar; c <= endChar; c++) {
                    decompressed.append(c);
                }
                i += 4; // Skip over the range (e.g., #a-d#)
            } else if (Character.isDigit(compressed.charAt(i))) {
                // Handle multi-digit count
                StringBuilder countStr = new StringBuilder();
                while (i < compressed.length() && Character.isDigit(compressed.charAt(i))) {
                    countStr.append(compressed.charAt(i));
                    i++;
                }
                int count = Integer.parseInt(countStr.toString());
                char character = compressed.charAt(i);
                for (int j = 0; j < count; j++) {
                    decompressed.append(character);
                }
            } else {
                decompressed.append(compressed.charAt(i));
            }
        }

        return decompressed.toString();
    }
}
