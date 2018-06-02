#base 64 include the import statement
import base64


#encode(encoding='UTF=8', errors='strict'), converts from ascii to string
var1 = "this is a basic string $(^"
res = base64.b64encode(var1.encode('utf-8'))
print "Encoded string: ", res
#decode(encoding='UTF-8', errors='strict'), converts from string to ascii
var1 =base64.b64decode(var1).decode('utf-8')
print "decoded string: ", res