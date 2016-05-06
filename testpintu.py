from time import sleep

import RPi.GPIO as GPIO


GPIO.setmode(GPIO.BOARD)
GPIO.setup(15, GPIO.IN)
GPIO.setup(16, GPIO.OUT)

while True:
	GPIO.input(15)
	if (GPIO.input(15)=='1'):
		GPIO.output(16, True)
	elif (GPIO.input(15)=='0'):
		GPIO.output(16, False)
