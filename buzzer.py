import RPi.GPIO as GPIO

GPIO.setmode(GPIO.BOARD)
GPIO.setwarnings(False)

pin_buzzer = 16
GPIO.setup(pin_buzzer, GPIO.OUT)

def buzzer_off(pin):
	GPIO.output(pin, 0)

def buzzer_on(pin):
	GPIO.output(pin, 1)

buzzer_off(pin_buzzer)

#Coded by Faisal Candrasyah H, CTO of IndisBuilding
