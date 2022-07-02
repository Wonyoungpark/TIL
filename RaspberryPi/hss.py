import picamera
import time
import Adafruit_DHT
import RPi.GPIO as GPIO
from RPLCD.i2c import CharLCD

GPIO.setmode(GPIO.BCM)
GPIO.setup(16,GPIO.OUT) # LED R
GPIO.setup(12,GPIO.IN,pull_up_down=GPIO.PUD_UP) # BUTTON
GPIO.setup(24,GPIO.IN) # PIR
GPIO.setup(25,GPIO.IN) # BUZZER
GPIO.setup(25,GPIO.OUT) # BUZZER

lcd = CharLCD("PCF8574", 0x27)
camera = picamera.PiCamera()
camera.resolution = (2592,1944)
intrusion_control=0
timer = 0
dht_type = 11
bcm_pin = 23

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
    while True:
        if GPIO.input(24) == True:
            print("SENSOR ON!!")
            while True:
                buzz()
                GPIO.output(16,True)
                if intrusion_control == 0:
                    lcd.clear()
                    camera.capture("camera/theif.jpg")
                    lcd.write_string('Intrusion')
                    lcd.crlf()
                    lcd.write_string('Detection')
                    intrusion_control += 1
                if GPIO.input(12) == False:
                    print("button pressed")
                    lcd.clear()
                    GPIO.output(16,False)
                    intrusion_control = 0
                    time.sleep(2)
                    break
                time.sleep(0.3)
        else:
            GPIO.output(25,False)
            GPIO.output(16,False)
            if timer > 3:
                timer = 0
                lcd.clear()
                humidity, temperature = Adafruit_DHT.read_retry(dht_type, bcm_pin)
                humid = round(humidity,1)
                temp = round(temperature,1)
                print(humid,temp)
                lcd.write_string('TEMP ')
                lcd.write_string(str(temp))
                lcd.write_string('C ')
                lcd.crlf()
                lcd.write_string('HUMID ')
                lcd.write_string(str(humid))
                lcd.write_string('% ')
            timer+=0.3
            time.sleep(0.3)
except KeyboardInterrupt:
    lcd.clear()
    GPIO.cleanup()
finally:
    GPIO.cleanup()
