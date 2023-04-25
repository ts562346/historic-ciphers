public class MatrixTranspositionCipher {
    public String encrypt(String plaintext, int [] key){
        String ciphertext = "";

        plaintext = plaintext.replace(" ", "%");
        int emptySpace = key.length - (plaintext.length())%(key.length);
        for (int i = 0; i < emptySpace; i++){
            plaintext += "%";
        }

        char[][] matrix = new char[plaintext.length()/key.length][key.length];
        int k = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = plaintext.charAt(k);
                k++;
            }
        }

        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                ciphertext += matrix[j][key[i]-1];
            }
        }
        return ciphertext;
    }

    public String decrypt(String ciphertext, int [] key){
        char[][] matrix = new char[ciphertext.length()/key.length][key.length];
        int k = 0;

        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[j][key[i]-1] = ciphertext.charAt(k);
                k++;
            }
        }

        String plaintext = "";
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                plaintext += matrix[i][j];
            }
        }
        return plaintext;
    }
}
