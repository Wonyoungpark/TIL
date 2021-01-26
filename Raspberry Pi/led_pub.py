import paho.mqtt.client as mqtt
import time
import json
import RPi.GPIO as GPIO
import datetime
import Adafruit_DHT as dht
from RPLCD.i2c import CharLCD

GPIO.setwarnings(False)
GPIO.setmode(GPIO.BCM)
GPIO.setup(16,GPIO.OUT)
GPIO.setup(20,GPIO.OUT)
GPIO.setup(21,GPIO.OUT)
GPIO.setup(13,GPIO.OUT)
GPIO.setup(19,GPIO.OUT)
GPIO.setup(26,GPIO.OUT)

GPIO.setup(12,GPIO.IN,pull_up_down=GPIO.PUD_UP) # BUTTON

lcd = CharLCD("PCF8574", 0x27)
intrusion_control=0

dht_type = 11
dht_pin = 23

# Define Variables
MQTT_HOST = "192.168.0.21"
MQTT_PORT = 1883
MQTT_KEEPALIVE_INTERVAL = 60
MQTT_TOPIC = "lcd/CCL"

def show_dht():
    humidity, temperature = dht.read_retry(dht_type, dht_pin)
    temp = round(temperature,1)
    now = datetime.datetime.now()
    nowtime = now.strftime('%H:%M:%S')
    print(temp,nowtime)
    lcd.write_string('TEMP ')
    lcd.write_string(str(temp))
    lcd.write_string('C ')
    lcd.crlf()
    lcd.write_string('Won Young Park')
    lcd.crlf()
    
# Define on_publish event function
def on_publish(client, userdata, mid):
    print ("Message Published...")

#자신의 pc ip
def on_connect ( client, userdata , flags, rc ):
    print("Connect with result code" + str (rc))
    client.subscribe("lcd/CCL")

def on_message(client, userdata, msg):
    print(msg.topic+" "+str(msg.payload.decode('utf-8')))
    if msg.payload.decode('utf-8') == "on":
        GPIO.output(16,False)
        GPIO.output(20,False)
        GPIO.output(21,False)
        GPIO.output(13,False)
        GPIO.output(19,False)
        GPIO.output(26,False)
        while True:
            button_state = GPIO.input(12)
            if button_state == False:
                print('button pressed')
                show_dht()
                break
            else:
                GPIO.output(16,True)
                GPIO.output(20,True)
                GPIO.output(21,True)
                GPIO.output(13,True)
                GPIO.output(19,True)
                GPIO.output(26,True)
    elif msg.payload.decode('utf-8') == "off":
        GPIO.output(16,False)
        GPIO.output(20,False)
        GPIO.output(21,False)
        GPIO.output(13,False)
        GPIO.output(19,False)
        GPIO.output(26,False)

# Initiate MQTT Client
client = mqtt.Client()

# Register publish callback function
client.on_publish = on_publish
client.on_connect = on_connect
client.on_message = on_message

# Connect with MQTT Broker
client.connect(MQTT_HOST, MQTT_PORT, MQTT_KEEPALIVE_INTERVAL)
client.loop_start()

   
try:
    while True:
        humidity, temperature = dht.read_retry(dht_type, dht_pin)
        if humidity is not None and temperature is not None:
            data = {'temperature':round(temperature, 1), 'name':'WonyoungPark'}
            client.publish(MQTT_TOPIC, str(data))
            print('Published. Sleeping ...')
        else:
            print('Failed to get reading. Skipping ...')
except KeyboardInterrupt:
    GPIO.cleanup()
finally:
    GPIO.cleanup()