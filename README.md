# historic-ciphers

Write a program to simulate Playfair substitution cipher. Your program should have three methods/functions:

Method 1: Accepts a secret key (String of characters) as argument and generates and returns a key matrix (2D array). <br/>
Method 2: Accepts plaintext (String of characters) and the key matrix as arguments and generates and returns the ciphertext. <br/>
Method 3: Accepts ciphertext (String of characters) and the key matrix as arguments and generates and returns the plaintext. <br/>

You may assume that the plaintext, ciphertext and the key all consist of only upper-case letters. You can ignore spaces, punctuations and line breaks.

Use a driver program with a main method to test the above methods. First test your code using the examples from the lecture notes. Ensure that you test some of the special cases such as repeated characters in a pair, odd total number of characters, etc.

Next, run your program to encrypt the following text, using the secret key RAYQUAZA <br/>

POKEMON TOWER DEFENSE <br/>
YOUR MISSION IN THIS FUN STRATEGY TOWER DEFENSE GAME IS TO HELP PROFESSOR OAK TO STOP ATTACKS 
OF WILD RATTATA. SET OUT ON YOUR OWN POKEMON JOURNEY, TO CATCH AND TRAIN ALL POKEMON AND 
TRY TO SOLVE THE MYSTERY BEHIND THESE ATTACKS. YOU MUST PLACE POKEMON CHARACTERS 
STRATEGICALLY ON THE BATTLEFIELD SO THAT THEY STOP ALL WAVES OF ENEMY ATTACKER
DURING THE BATTLE YOU WILL LEVEL UP AND EVOLVE YOUR POKEMON. YOU CAN ALSO CAPTURE OTHER 
POKEMON DURING THE BATTLE AND ADD THEM TO YOUR TEAM. USE YOUR MOUSE TO PLAY THE GAME. 
GOOD LUCK

<br/> Note: Ignore spaces, punctuations, and line breaks. <br/>

Decrypt the ciphertext to get back the above plaintext (ignore about spaces, punctuations, and line breaks).
As an example, when you encrypt and decrypt, the text will appear as below:

![image](https://user-images.githubusercontent.com/64804214/234373967-5b47d86d-6bb6-4965-b838-b43655c5a341.png)

Write a program to simulate Matrix transposition cipher. Your program should have two methods: <br/>

Method 1: Accepts plaintext (String of characters) and a key (integer array representing the permutation of the columns) as arguments and generates and returns the ciphertext (String of characters). <br/>
Method 2: Accepts ciphertext (String of characters) and a key (integer array representing the permutation of the columns) as arguments and generates and returns the plaintext (String of characters). <br/>

Use a driver program with a main method to test the above methods. <br/>

You may assume that the plaintext and ciphertext consist of uppercase letters, lowercase letters, numbers, and spaces. You can represent the space by a % character. No other special characters are required.
