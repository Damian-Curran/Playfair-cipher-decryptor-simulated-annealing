# Playfair-cipher-decryptor-simulated-annealing
A project with the focus of decrypting a playfair cipher using simulated annealing.

##Cryptography approach 

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

##Playfair Cipher

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
