package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;


public class Base64encode {

	public static String encodeFileToBase64(String filePath) throws IOException {
        File file = new File(filePath);
        FileInputStream fileInputStream = new FileInputStream(file);

        byte[] fileBytes = new byte[(int) file.length()];
        fileInputStream.read(fileBytes);
        fileInputStream.close();

        return Base64.getEncoder().encodeToString(fileBytes);
    }
	
	 public static void decodeBase64ToFile(String base64String, String outputFilePath) {
	        try {
	            byte[] decodedBytes = Base64.getDecoder().decode(base64String);
	            try (FileOutputStream fos = new FileOutputStream(outputFilePath)) {
	                fos.write(decodedBytes);
	            }
	            System.out.println("PDF file saved to: " + outputFilePath);
	        } catch (IOException e) {
	            System.out.println("Error writing file: " + e.getMessage());
	        }
	    }
	 
	public static void main(String[] args) {
        try {
            String filePath = args[0]; // Change this to your PDF file path
            String base64String = encodeFileToBase64(filePath);

            System.out.println("Base64 Encoded String:");
            System.out.println(base64String);

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

}
