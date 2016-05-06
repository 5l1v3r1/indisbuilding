import RPi.GPIO as GPIO
import lampu, buzzer
from time import sleep
from threading import Thread

GPIO.setmode(GPIO.BOARD)
GPIO.setwarnings(False)

global pin_lampu, pin_buzzer	#inisiasi variabel dari file lampu dan buzzer
pin_lampu = lampu.pin_lampu	#memanggil variabel pin_lampu supaya berjalan di sini
pin_buzzer = buzzer.pin_buzzer	#memanggil variabel pin_buzzer supaya berjalan di sini

pin_sensor = 15		#inisiasi pin GPIO untuk membaca data sensor pintu (reed switch), terhubung dengna GND dan pin GPIO
GPIO.setup(pin_sensor, GPIO.IN, pull_up_down = GPIO.PUD_DOWN)		#mengatur pin sebagai input dengan memanfaatkan resisotr pull up/down internal Raspi

"""def lampu():	#fungsi untuk lampu kedap-kedip
	lampu.lampu_on(pin_lampu)
	sleep(0.5)
	lampu.lampu_off(pin_lampu)
	sleep(0.5)
	return

def buzzer():	#fungsi untuk buzzer kedap-kedip
	buzzer.buzzer_on(pin_buzzer)
	sleep(0.2)
	buzzer.buzzer_off(pin_buzzer)
	sleep(0.2)
	return"""

try:
	#t1 = Thread(target = lampu)	#membuat fungsi lampu dan buzzer berjalan bersamaan dalam satu waktu
	#t2 = Thread(target = buzzer)	
	while True:
		if GPIO.input(pin_sensor) == False:	#jika pintu terbuka, sensor menjauh
			print "Warning! Pintu terbuka!"
			#t1.start()	#memulai thread lampu dan buzzer
			#t2.start()
			#t1.join()	#memastikan thread berjalan hingga selesai baru lanjut ke bagian program berikutnya
			#t2.join()
			import emailexample
			lampu.lampu_on(pin_lampu)
			buzzer.buzzer_on(pin_buzzer)
			sleep(0.25)
			lampu.lampu_off(pin_lampu)
			buzzer.buzzer_off(pin_buzzer)
			sleep(0.25)
		sleep(0.5)

finally:
	GPIO.cleanup()	



#Coded by Faisal Candrasyah H, CTO of IndisBuilding
