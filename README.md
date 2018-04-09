# Playfair-cipher-decryptor-simulated-annealing
A project with the focus of decrypting a playfair cipher using simulated annealing.

## Cryptography approach 

The field of cryptanalysis is concerned with the study of ciphers, having as its objective the
identification of weaknesses within a cryptographic system that may be exploited to convert
encrypted data (cipher-text) into unencrypted data (plain-text). Whether using symmetric or
asymmetric techniques, cryptanalysis assumes no knowledge of the correct cryptographic key
or even the cryptographic algorithm being used.

Assuming that the cryptographic algorithm is known, a common approach for breaking a cipher
is to generate a large number of keys, decrypt a cipher-text with each key and then examine the
resultant plain-text. If the text looks similar to English, then the chances are that the key is a
good one. The similarity of a given piece of text to English can be computed by breaking the
text into fixed-length substrings, called n-grams, and then comparing each substring to an
existing map of n-grams and their frequency. This process does not guarantee that the outputted
answer will be the correct plain-text, but can give a good approximation that may well be the
right answer.

## Playfair Cipher

The Playfair Cipher is a symmetric polygram substitution cipher invented by the Victorian
scientist Sir Charles Wheatstone in 1854 (of Wheatstone Bridge fame). The cipher is named
after his colleague Lord Playfair, who popularised and promoted the encryption system. Due to
its simplicity, the Playfair Cipher was used at a tactical level by both the British and US forces
during WWII and is also notable for its role in the rescue of the crew of PT-109 in the Pacific
in 1943.

Polygram substitution is a classical system of encryption in which a group of n plain-text letters
is replaced as a unit by n cipher-text letters. In the simplest case, where n = 2, the system is
called digraphic and each letter pair is replaced by a cipher digraph. The Playfair Cipher uses
digraphs to encrypt and decrypt from a 5x5 matrix constructed from a sequence key of 25
unique letters. Note that the letter J is not included.

For the purposes of this assignment, it is only necessary to implement the decrypt functionality
of the Playfair Cipher. It should be noted however, that the 5x5 matrix described below can be
augmented with auxiliary data structures to reduce access times to O(1). For example, the letter
‘A’ has a Unicode decimal value of 65. Thus, an int array called rowIndices could store the
matrix row of a char val at rowIndices[val – 65]. The same principle can be used for columns.

## Using the Playfair Cipher
### Step1:  Prime the Plain-Text

Convert the plaintext into either upper or lower-case and strip out any characters that are not
present in the matrix. A regular expression can be used for this purpose as follows:

String plainText = input.toUpperCase().replaceAll("[^A-Za-z0-9 ]", "");

Numbers and punctuation marks can be spelled out if necessary. Parse any double letters,
e.g. LETTERKENNY and replace the second occurrence with the letter X, i.e.
LETXERKENXY. If the plaintext has an odd number of characters, append the letter X to
make it even.

### Step 2: Break the Plain-Text in Diagraphs

Decompose the plaintext into a sequence of diagraphs and encrypt each pair of letters. The
key used below, THEQUICKBROWNFOXJUMPEDOVERTHELAZYDOGS, is written into
the 5x5 matrix as THEQUICKBROWNFXMPDVLAZYGS, as only the first 25 unique letters
are used to form a key. 

The plain-text sequence of characters, “ARTIFICIALINTELLIGENCE”, is broken into the diagraph set {AR, TI, FI, CI, AL, IN,
TE, LL, IG, EN, CE} and is encrypted into the cipher-text “SIIOOBKCSMKOHQSLBAKDKH” using the following rules:

#### Rule 1: Diagraph Letters in Different Rows and Columns

Create a “box” inside the matrix with each diagraph letter as a corner and read off the
letter at the opposite corner of the same row, e.g. AR→SI. 
This can also be expressed as cipher(B, P)={matrix[row(B)][col(P)], matrix[row(P)][col(B)]}. 
Reverse the process to decrypt a cypher-text diagraph.

#### Rule 2: Diagraph Letters in Same Row

Replace any letters that appear on the same row with the letters to their immediate
right, wrapping around the matrix if necessary. Decrypt by replacing cipher-text letters
the with letters on their immediate left.

#### Rule 3: Diagraph Letters in Same Column

Replace any letters that appear on the same column with the letters immediately below,
wrapping back around the top of the column if necessary. Decrypt by replacing ciphertext
letters the with letters immediately above.

### The Playfair Cipher suffers from three basic weaknesses

1. Repeated plain-text digrams will create repeated cipher-text digrams.

2. Digram frequency counts can reveal the most frequently occurring English digrams.

3. The most frequently occurring cipher-text letters are likely to be near the most frequent
English letters, i.e. E, T, A and O in the 5x5 square. This helps to reconstruct the 5x5
square.

### In this project we will be exploiting weakness (2)  

Note that these weaknesses rely on repetition and frequency counts and, in the absence of cribs, require enough cipher-text to reveal
patterns. In practice, this implies that at least 200 characters of cipher-text are available. 

## The Simulated Annealing Algorithm

Simulated annealing (SA) is an excellent approach for breaking a cipher using a randomly
generated key. Unlike conventional Hill Climbing algorithms, that are easily side-tracked by
local optima, SA uses randomization to avoid heuristic plateaux and attempt to find a global
maxima solution. The following pseudocode shows how simulated annealing can be used break
a Playfair Cipher. Note that the initial value of the variables temp and transitions can have a
major impact on the success of the SA algorithm. Both variables control the cooling schedule
of SA and should be experimented with for best results (see slide 20 of the lecture notes on
Heuristic Search).

The generation of a random 25-letter key on line 1 only requires that we shuffle a 25 letter
alphabet. A simple algorithm for achieving this was published in 1938 by Fisher and Yates.
The Fisher–Yates Shuffle generates a random permutation of a finite sequence, i.e. it randomly
shuffles an array key of n elements (indices 0..n-1) 


## Using n-Gram Statistics as a Heuristic Function

An n-gram (gram = word or letter) is a substring of a word(s) of length n and can be used to
measure how similar some decrypted text is to English. For example, the quadgrams (4-grams)
of the word “HAPPYDAYS” are “HAPP”, “APPY”, “PPYD”, “PYDA”, “YDAY” and
“DAYS”. A fitness measure or heuristic score can be computed from the frequency of
occurrence of a 4-gram, q, as follows: P(q) = count(q) / n, where n is the total number of 4-
grams from a large sample source. An overall probability of the phrase “HAPPYDAYS” can
be accomplished by multiplying the probability of each of its 4-grams:

P(HAPPYDAYS) = P(HAPP) × P(APPY) × P(PPYD) × P(PYDA) × P(YDAY)

One side effect of multiplying probabilities with very small floating point values is that
underflow can occur1 if the exponent becomes too low to be represented. For example, a Java
float is a 32-bit IEEE 754 type with a 1-bit sign, an 8-bit exponent and a 23-bit mantissa. The
64-bit IEEE 754 double has a 1-bit sign, a 11-bit exponent and a 52-bit mantissa. A simple way
of avoiding this is to get the log (usually base 10) of the probability and use the identity log(a
× b) = log(a) + log(b). Thus, the score, h(n), for “HAPPYDAYS” can be computed as a log
probability:

log10(P(HAPPYDAYS)) = log10(P(HAPP)) + log10(P(APPY)) + log10(P(PPYD)) +
log10(P(PYDA)) + log10(P(YDAY)


## Using this repository
git clone https://github.com/Damian404/Playfair-cipher-decryptor-simulated-annealing.git

Import clone into eclipse

Run CipherBreaker class

Alternativly, you can launch playfair.jar from the cmd.

To do this go to the directory with the playfair.jar and enter the following command:
java –cp ./playfair.jar ie.gmit.sw.ai.CipherBreaker

You can now enter the filename of which you want to decrypt.
*Note, you need to have the file in the directory where the project is launched from
