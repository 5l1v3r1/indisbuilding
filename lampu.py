import RPi.GPIO as GPIO

GPIO.setmode(GPIO.BOARD)
GPIO.setwarnings(False)

pin_lampu = 11		#definisi pin GPIO yg terhubung ke relay lampu
GPIO.setup(pin_lampu, GPIO.OUT)

def lampu_off(pin):		#fungsi untuk menyalakan lampu
	GPIO.output(pin, 0)

def lampu_on(pin):		#fungsi untuk mematikan lampu
	GPIO.output(pin, 1)



#Coded by Faisal Candrasyah H, CTO of Indisbuilding
