import RPi.GPIO as GPIO
import lampu, buzzer
import notifemail
from time import sleep
from os import system

GPIO.setmode(GPIO.BOARD)
GPIO.setwarnings(False)

pin_sensor = 15		#inisiasi pin GPIO untuk membaca data sensor pintu (reed switch), terhubung dengna GND dan pin GPIO
GPIO.setup(pin_sensor, GPIO.IN, pull_up_down = GPIO.PUD_DOWN)		#mengatur pin sebagai input dengan memanfaatkan resisotr pull up/down internal Raspi

global pin_lampu, pin_buzzer
pin_lampu = lampu.pin_lampu
pin_buzzer = buzzer.pin_buzzer

def alert():
	try:
		while True:
			file = open('statuspintu.txt', 'r')
			statuspintu = file.read()
			#print statuspintu
			if GPIO.input(pin_sensor) == False and statuspintu == "terkunci":	#jika pintu terbuka padahal dikunci, sensor menjauh
				#print "Warning! Pintu terbuka!"
				lampu.lampu_on(pin_lampu)
				buzzer.buzzer_on(pin_buzzer)
				sleep(0.2)
				lampu.lampu_off(pin_lampu)
				buzzer.buzzer_off(pin_buzzer)
				sleep(0.2)
				system("sudo start notifemail")
				system("sudo start camera")
				#print "Selesai mengunggah notif dan foto."
			
			elif GPIO.input(pin_sensor) == False and statuspintu == "terbuka":
				log = open('statuslampu.txt', 'r')        #membaca log status lampu
				statuslampu = log.read()
				#print (statuslampu)
				if statuslampu == "mati" :                #sinkronisasi lampu dengan sta$
        				lampu.lampu_on(pin_lampu)
				elif statuslampu == "menyala" :
        				lampu.lampu_off(pin_lampu)
			sleep(0.2)

	finally:
		GPIO.cleanup()
	

alert()

#Coded by Faisal Candrasyah H, CTO of IndisBuilding
