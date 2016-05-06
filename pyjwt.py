import jwt
import hashlib

device_id = "1";
region_id = "1";
communication_id = "1";
device_type = "1";

encode1 = hashlib.sha1();
encode1.update(device_type);
keystring1 = encode1.hexdigest();

encode2 = hashlib.sha1();
encode2.update(communication_id + keystring1);
keystring2 = encode2.hexdigest();

encode3 = hashlib.sha1();
encode3.update(region_id + keystring2);
keystring3 = encode3.hexdigest();

key = hashlib.sha1();
key.update(device_id + keystring3);
keystring = key.hexdigest()

def token(topik, message):
	isi_encoded = {	"iss":"http://platform.indisbuilding.com", \
			"data": {"topic":topik, \
				 "value":message, \
				 "other_value":None } \
			} 
	encoded = jwt.encode(isi_encoded, keystring, algorithm='HS256')
	print encoded

#token("1","0")

#print "keystring = ", keystring

