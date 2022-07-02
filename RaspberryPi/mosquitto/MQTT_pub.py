import paho.mqtt.client as mqtt

mqtt = mqtt.Client("python_pub")
mqtt.connect("localhost", 1883)

mqtt.publish("IoT-P", "led on")
mqtt.publish("IoT-P", "led off")

mqtt.loop(2)
