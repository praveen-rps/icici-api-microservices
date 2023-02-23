from cryptography.fernet import Fernet

# we will be encrypting the below string.

message = "hello geeks"

# generate a key for encryption and decryption
# You can use fernet to generate
# the key or use random key generator
# here I'm using fernet to generate key

key = Fernet.generate_key()

# Instance the Fernet class with the key

fernet = Fernet(key)

# then use the Fernet class instance
# to encrypt the string string must
# be encoded to byte string before encryption

encMessage = fernet.encrypt(message.encode())

print("original string: ", message)
print("encrypted string: ", encMessage)

arr = bytes('this is new text','utf-8')

altText = encMessage+arr
print(altText)

# decrypt the encrypted string with the
# Fernet instance of the key,
# that was used for encrypting the string
# encoded byte string is returned by decrypt method,
# so decode it to string with decode methods


decMessage = fernet.decrypt(encMessage).decode()

decMessage1 = fernet.decrypt(altText).decode()


print("decrypted string: ", decMessage)
print("decrypted string with alternation: ", decMessage1)


