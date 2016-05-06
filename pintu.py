import RPi.GPIO as GPIO

GPIO.setmode(GPIO.BOARD)
GPIO.setwarnings(False)

pin_pintu = 13		#inisiasi pin GPIO untuk aktivasi door lock
pin_sensor = 15		#inisiasi pin GPIO untuk membaca data sensor pintu (reed switch), terhubung dengna GND dan pin GPIO
GPIO.setup(pin_pintu, GPIO.OUT)		#mengatur pin sebagai keluaran
GPIO.setup(pin_sensor, GPIO.IN, pull_up_down = GPIO.PUD_DOWN)		#mengatur pin sebagai input dengan memanfaatkan resisotr pull up/down internal Raspi

def pintu_buka(pin):		#fungsi untuk membuka pintu
	GPIO.output(pin, 0)

def pintu_kunci(pin):		#fungsi untuk mengunci pintu
	GPIO.output(pin, 1)



#Coded by Faisal Candrasyah H, CTO of IndisBuilding
