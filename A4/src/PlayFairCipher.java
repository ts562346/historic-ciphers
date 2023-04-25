public class PlayFairCipher {
    public char [][] keyMatrix (String key){
        char[][] keyMatrix = new char [5][5];
        key = key.replace("J", "I"); // J is replaced by I, they are in same box

        char[] k = key.toCharArray();
        String alphabet = "ABCDEFGHI0KLMNOPQRSTUVWXYZ"; // don't have J

        // remove duplicate characters from the key and set key to first elements of the matrix
        int row = 0, column = 0;
        for (int i = 0; i < k.length; i++) {
            int j;
            for (j = 0; j < i; j++) {
                if (k[i] == k[j]) {
                    break;
                }
            }
            if (j == i) {
                keyMatrix[row][column++] = k[i];
                if(column == 5) {
                    row++; column = 0;
                }

                // remove from alphabet all the char already in matrix
                alphabet = alphabet.replace(k[i], '0');
            }
        }

        // fill rest of the matrix with other char in alpha
        char [] alpha = alphabet.toCharArray();
        int index = 0;

        for(int r = 0; r < keyMatrix.length; r++){
            for (int c = 0; c < keyMatrix[r].length; c++){
                if (keyMatrix[r][c]==0) {
                    if (alpha[index] != '0') {
                        keyMatrix[r][c] = alpha[index];
                    } else {
                        c--;
                    }
                    index++;
                }
            }
        }

        return keyMatrix;
    }

    public int [] getIndex (char target, char [][] keyMatrix){
        int [] index = new int[2];
        for (int i = 0; i < keyMatrix.length; i++) {
            for (int j = 0; j < keyMatrix[i].length; j++) {
                if (keyMatrix[i][j]==target) {
                    index[0] = i;
                    index[1] = j;
                    break;
                }
            }
        }
        return index;
    }

    public String encrypt(String plaintext, char[][] keyMatrix){
        plaintext = plaintext.replaceAll("\\s|[^a-zA-Z0-9]","");

        String ciphertext = "";

        // The following block of code inserts X where 2 consecutive characters are the same.
        int k = 0;
        int j = 1;

        String newElements = "";

        while (j < plaintext.length()) {
            if (plaintext.charAt(k) == plaintext.charAt(j)) {
                j++;
                newElements += plaintext.charAt(k);
                newElements += 'X';
            }

            else if (plaintext.charAt(j) != plaintext.charAt(k)
                    || j == plaintext.length() - 1) {
                newElements += plaintext.charAt(k);

                k = j;
                j++;
            }
        }

        newElements += plaintext.charAt(j - 1);
        if (newElements.length() % 2 != 0){
            newElements+='X';
        }
        plaintext = newElements;

        char [] pt = plaintext.toCharArray();

        for (int i  = 0; i < pt.length; i=i+2){
            int [] a = getIndex(pt[i], keyMatrix);
            int [] b = getIndex(pt[i+1], keyMatrix);

            // use modulus 5
            if (a[1] == b[1]){
                ciphertext += keyMatrix[(a[0]+1)%5][a[1]];
                ciphertext += keyMatrix[(b[0]+1)%5][b[1]];
            } else if (a[0] == b[0]){
                ciphertext += keyMatrix[a[0]][(a[1]+1)%5];
                ciphertext += keyMatrix[b[0]][(b[1]+1)%5];
            } else {
                ciphertext += keyMatrix[a[0]][b[1]];
                ciphertext += keyMatrix[b[0]][a[1]];
            }
        }
        return ciphertext;
    }

    public String decrypt(String ciphertext, char[][] keyMatrix){
        String plaintext = "";

        char [] ct = ciphertext.toCharArray();

        for (int i  = 0; i < ct.length; i=i+2){
            int [] a = getIndex(ct[i], keyMatrix);
            int [] b = getIndex(ct[i+1], keyMatrix);

            // use modulus 5
            if (a[1] == b[1]){
                plaintext += keyMatrix[((((a[0]-1)%5)+5)%5)][a[1]];
                plaintext += keyMatrix[((((b[0]-1)%5)+5)%5)][b[1]];
            } else if (a[0] == b[0]){
                plaintext += keyMatrix[a[0]][((((a[1]-1)%5)+5)%5)];
                plaintext += keyMatrix[b[0]][((((b[1]-1)%5)+5)%5)];
            } else {
                plaintext += keyMatrix[a[0]][b[1]];
                plaintext += keyMatrix[b[0]][a[1]];
            }
        }

        return plaintext;
    }
}