import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class main {
    public static String readFile (){
        String text = "";
        try {
            File myObj = new File("src/plaintext_input.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                text+=data;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return text;
    }

    public static void main(String[] args) {
        System.out.println("*** PLAYFAIR CIPHER ***");

        PlayFairCipher pfc = new PlayFairCipher();

        String plaintext = readFile();
        String key = "RAYQUAZA";

        char matrix [][]= pfc.keyMatrix(key);

        System.out.println("Key Matrix: ");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        String ciphertext = pfc.encrypt(plaintext, matrix);
        System.out.println("Encrypted: " + ciphertext);

        plaintext = pfc.decrypt(ciphertext, matrix);
        System.out.println("Decrypted: " + plaintext);

        System.out.println("*** MATRIX TRANSPOSITION CIPHER ***");

        MatrixTranspositionCipher mtc = new MatrixTranspositionCipher();

        String plaintext2 = readFile();
        int [] key2 = {9, 5, 6, 10, 4, 2, 1, 3, 7, 8};

        String ciphertext2 = mtc.encrypt(plaintext2, key2);
        System.out.println("Ciphertext: " + ciphertext2);

        plaintext2 = mtc.decrypt(ciphertext2, key2);
        System.out.println("Plaintext: " + plaintext2);
    }
}
