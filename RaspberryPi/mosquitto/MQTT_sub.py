import paho.mqtt.client as mqtt

#서버로부터 CONNTACK 응답을 받을 때 호출되는 콜백
def on_connect(client, userdata, flags, rc):
	print("Connected with result code "+str(rc))
	client.subscribe("IoT-P")

def on_message(client, userdata, msg):
	print(msg.topic+" "+str(msg.payload)) #토픽과 메세지를 출력한다.

client = mqtt.Client()
client.on_connect = on_connect
client.on_message = on_message

client.connect("localhost", 1883, 60)
client.loop_forever()
