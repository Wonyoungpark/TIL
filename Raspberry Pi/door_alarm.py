import RPi.GPIO as GPIO
import time
GPIO.setmode(GPIO.BCM)
GPIO.setup(16,GPIO.OUT)
GPIO.setup(20,GPIO.OUT)
GPIO.setup(21,GPIO.OUT)
GPIO.setup(24,GPIO.IN) #PIR
GPIO.setup(25, GPIO.IN) #Buzzer
GPIO.setup(25, GPIO.OUT)
GPIO.setup(12,GPIO.IN,pull_up_down=GPIO.PUD_UP) #Button

EMERGENCY=True


def buzz():
    pitch = 1000
    duration = 0.1
    period = 1.0 / pitch
    delay = period / 2
    cycles = int(duration * pitch)
    for i in range(cycles):
        GPIO.output(25,True)
        time.sleep(delay)
        GPIO.output(25,False)
        time.sleep(delay)

try:
    while EMERGENCY:
        if GPIO.input(24)==True:
            print("ON")
            buzz()
            GPIO.output(16,True)
            if GPIO.input(12) == True:
                print(GPIO.input(12))
                print("button")
                EMERGENCY=False
            if GPIO.input(12) == False:
                print("No button")
            time.sleep(10)
            print("10se")
            GPIO.output(20,True)
            GPIO.output(21,True)
            time.sleep(0.5)
            GPIO.output(20,False)
            GPIO.output(21,False)
except KeyboardInterrupt:
    GPIO.cleanup()
finally:
    GPIO.cleanup()
