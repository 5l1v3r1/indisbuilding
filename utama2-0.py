import paho.mqtt.client as mqtt		#import library mqtt
import lampu, buzzer, pintu		#memanggil file lampu.py dan buzzer.py
#import sensingpintu2			#memanggil file sensingpintu2.py untuk alert saat pintu dibuka paksa
from time import sleep
import pyjwt				#memanggil file pyjwt.py untuk token feedback raspi ke platform

topik = ["1","2","3"]	#list topik untuk mqtt
status = ["0","1"]			#list payload untuk mqtt

global pin_lampu, pin_buzzer, pin_pintu		#sinkronisasi variabel di program utama dengan program yg dipanggil (lampu, buzzer, dan pintu)
pin_lampu = lampu.pin_lampu
pin_buzzer = buzzer.pin_buzzer
pin_pintu = pintu.pin_pintu
#pin_sensor = sensingpintu2.pin_sensor

log = open('statuslampu.txt', 'r')              #membaca log status lampu
statuslampu = log.read()
print (statuslampu)
if statuslampu == "mati" :                      #sinkronisasi lampu dengan sta$
        lampu.lampu_on(pin_lampu)
elif statuslampu == "menyala" :
        lampu.lampu_off(pin_lampu)


# The callback for when the client receives a CONNACK response from the server.
def on_connect(client, userdata, rc):
        print ("Terhubung dengan kode hasil "+str(rc))
        # Subscribing in on_connect() means that if we lose the connection and
        # reconnect the subscriptions will be renewed.
        #client.subscribe("$SYS/#")
        for i in range(len(topik)) :		#menjadikan semua item di list topik menjadi topik subscribe
                client.subscribe(topik[i])

# The callback for when a PUBLISH message is received from the server.
def on_message(client, userdata, msg):
        print(msg.topic + " " + str(msg.payload))
        topic = msg.topic
        payload = msg.payload
	#check = 0	#untuk pembaca dibuka oleh aplikasi atau dibuka paksa, 1 oleh aplikasi


        if str(topic) == str(topik[1]) :			#kondisi topik dan payload yang diterima dari user (via HP atau Web platform kita)
                if str(payload) == str(status[0]) :	#lampu Normally Close
                        lampu.lampu_on(pin_lampu)
			file = open("statuslampu.txt", "w")
                        file.write("mati")
                        file.close()
                        print "Lampu MATI"
			pyjwt.token(topik[2], status[0])
                elif str(payload) == str(status[1]) :
                        lampu.lampu_off(pin_lampu)
			file = open("statuslampu.txt", "w")
                        file.write("menyala")
                        file.close()
                        print "Lampu MENYALA"
			pyjwt.token(topik[2], status[1])
        if str(topic) == topik[2] :
                if str(payload) == status[1] :
                        buzzer.buzzer_on(pin_buzzer)
                        print "Buzzer MENYALA"
			pyjwt.token(topik[1], status[1])
                elif str(payload) == status[0] :
                        buzzer.buzzer_off(pin_buzzer)
                        print "Buzzer MATI"
			pyjwt.token(topik[1], status[0])
        if str(topic) == topik[0] :
                if str(payload) == status[1] :
                        pintu.pintu_kunci(pin_pintu)
			file = open("statuspintu.txt", "w")
			file.write("terkunci")
			file.close()
                        print "Pintu TERKUNCI"
			#check = 0
			pyjwt.token(topik[0], status[1])
                elif str(payload) == status[0] :
                        pintu.pintu_buka(pin_pintu)
			file = open("statuspintu.txt", "w")
                        file.write("terbuka")
                        file.close()
                        print "Pintu TERBUKA"
			#check = 1
			pyjwt.token(topik[0], status[0])
	#if check == 0 and GPIO.input(pin_sensor) == False:
	#if check == 0 :
		#import simsenspint
	#else :
		#import sensingpintu


client = mqtt.Client()
client.username_pw_set("indisbuilding","indisbuilding-mqtt")
client.on_connect = on_connect
client.on_message = on_message

#client.connect("broker.mqttdashboard.com", 1883, 60)	#broker yang digunakan
#client.connect("iot.eclipse.org", 1883, 60)
client.connect("m11.cloudmqtt.com", 15291, 60)

# Blocking call that processes network traffic, dispatches callbacks and
# handles reconnecting.
# Other loop*() functions are available that give a threaded interface and a
# manual interface.
client.loop_forever()
