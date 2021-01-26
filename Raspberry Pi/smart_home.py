import picamera
import time
import datetime
import Adafruit_DHT
import RPi.GPIO as GPIO
from RPLCD.i2c import CharLCD

GPIO.setmode(GPIO.BCM)
GPIO.setup(21,GPIO.OUT) # LED B1
GPIO.setup(20,GPIO.OUT) # LED B2
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
dht_pin = 23

def show_dht():
    humidity, temperature = Adafruit_DHT.read_retry(dht_type, dht_pin)
    #humid = round(humidity,1)
    temp = round(temperature,1)
    now = datetime.datetime.now()
    nowtime = now.strftime('%H:%M:%S')
    #print(humid,temp)
    print(temp,nowtime)
    lcd.write_string('TEMP ')
    lcd.write_string(str(temp))
    lcd.write_string('C ')
    lcd.crlf()
    #lcd.write_string('HUMID ')
    #lcd.write_string(str(humid))
    #lcd.write_string('% ')
    lcd.write_string(nowtime)

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
        
def blink():
    GPIO.output(20,True)
    time.sleep(0.1)
    GPIO.output(20,False)
    time.sleep(0.1)
    GPIO.output(21,True)
    time.sleep(0.1)
    GPIO.output(21,False)
    time.sleep(0.1)

try:
    while True:
        if GPIO.input(24) == True:
            print("SENSOR ON!!")
            while True:
                buzz()
                blink()
                if intrusion_control == 0:
                    lcd.clear()
                    camera.capture("camera/smart_pic.jpg")
                    lcd.write_string('Won Young Park')
                    lcd.crlf()
                    lcd.write_string('201834714')
                    intrusion_control += 1
                if GPIO.input(12) == False:
                    print("button pressed")
                    lcd.clear()
                    GPIO.output(20,False)
                    GPIO.output(21,False)
                    intrusion_control = 0
                    show_dht()
                    
                    # dht 고장으로 인한 test message
                    #lcd.write_string('OFF')
                    
                    time.sleep(2)
                    break
                time.sleep(0.3)
        else:
            GPIO.output(25,False)
            GPIO.output(20,False)
            GPIO.output(21,False)
            
            if timer > 3:
                timer = 0
                lcd.clear()
                show_dht()
                
                # dht 고장으로 인한 test message
                #lcd.write_string('TEMP ')
                
            timer+=0.3
            time.sleep(0.3)
except KeyboardInterrupt:
    lcd.clear()
    GPIO.cleanup()
finally:
    GPIO.cleanup()

