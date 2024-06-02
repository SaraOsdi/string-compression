import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your input: ");
        String userInput = scanner.nextLine();

        // First level of compression
        String compressedString = compression.compress(userInput);
        System.out.println("Compressed String (before sequence compression): " + compressedString);

        // Second level of compression for sequences
        String finalCompressedString = sequenceCompression.compressSequence(compressedString);
        System.out.println("Compressed String (after sequence compression): " + finalCompressedString);

        // Decompression
        String decompressedString = decompression.decompress(finalCompressedString);
        System.out.println("Decompressed String: " + decompressedString);

        scanner.close();
    }
}
