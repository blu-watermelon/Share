package test;

import java.io.FileOutputStream;
import java.util.Base64;

public class Base64decode {
	
	public static void decodeBase64ToFile(String base64String, String outputFilePath) {
        try {
            byte[] decodedBytes = Base64.getDecoder().decode(base64String);
            try (FileOutputStream fos = new FileOutputStream(outputFilePath)) {
                fos.write(decodedBytes);
            }
            System.out.println("PDF file saved to: " + outputFilePath);
        } catch (Exception e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }

    // Main method to test
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java Base64PdfConverter <base64string> <outputfile>");
            return;
        }
        decodeBase64ToFile(args[0], args[1]);
    }
}
