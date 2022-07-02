import RPi.GPIO as GPIO
import time
GPIO.setmode(GPIO.BCM)
GPIO.setup(16,GPIO.OUT)
GPIO.setup(20,GPIO.OUT)
GPIO.setup(21,GPIO.OUT)

GPIO.setup(24,GPIO.IN)

GPIO.setup(12,GPIO.IN,pull_up_down=GPIO.PUD_UP)

GPIO.setup(25, GPIO.IN)
GPIO.setup(25, GPIO.OUT)

def pir(init):
    print("SENSOR ON!!")
    GPIO.output(16,True)
    while(init<10):
        GPIO.output(16,True)
        time.sleep(0.1)
        GPIO.output(16,False)
        time.sleep(0.1)
        init += 1

def done(pwm_led):
    GPIO.output(16,False)
    GPIO.output(20,False)
    GPIO.output(21,False)
    pwm_led.stop()
    GPIO.output(25,False)
    exist=0
    
def buzzer():
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

class Buzzer(object):
 def __init__(self):
  GPIO.setmode(GPIO.BCM)  
  self.buzzer_pin = 25
  GPIO.setup(self.buzzer_pin, GPIO.IN)
  GPIO.setup(self.buzzer_pin, GPIO.OUT)
  print("buzzer ready")

 def __del__(self):
  class_name = self.__class__.__name__
  print (class_name, "finished")

 def buzz(self,pitch, duration):
 
  if(pitch==0):
   time.sleep(duration)
   return
  period = 1.0 / pitch
  delay = period / 2
  cycles = int(duration * pitch)

  for i in range(cycles):
   GPIO.output(self.buzzer_pin, True)
   time.sleep(delay)
   GPIO.output(self.buzzer_pin, False)
   time.sleep(delay)

 def play(self, tune):
  GPIO.setmode(GPIO.BCM)
  GPIO.setup(self.buzzer_pin, GPIO.OUT)
  x=0

  print("Playing tune ",tune)
  if(tune==1):
    pitches=[262,294,330,349,392,440,494,523, 587, 659,698,784,880,988,1047]
    duration=0.1
    for p in pitches:
      self.buzz(p, duration)
      time.sleep(duration *0.5)
    for p in reversed(pitches):
      self.buzz(p, duration)
      time.sleep(duration *0.5)

  elif(tune==2):
    pitches=[262,330,392,523,1047]
    duration=[0.2,0.2,0.2,0.2,0.2,0,5]
    for p in pitches:
      self.buzz(p, duration[x])
      time.sleep(duration[x] *0.5)
      x+=1
  elif(tune==3):
    pitches=[392,294,0,392,294,0,392,0,392,392,392,0,1047,262]
    duration=[0.2,0.2,0.2,0.2,0.2,0.2,0.1,0.1,0.1,0.1,0.1,0.1,0.8,0.4]
    for p in pitches:
      self.buzz(p, duration[x])
      time.sleep(duration[x] *0.5)
      x+=1

  elif(tune==4):
    pitches=[1047, 988,659]
    duration=[0.1,0.1,0.2]
    for p in pitches:
      self.buzz(p, duration[x])
      time.sleep(duration[x] *0.5)
      x+=1

  elif(tune==5):
    pitches=[1047, 988,523]
    duration=[0.1,0.1,0.2]
    for p in pitches:
      self.buzz(p, duration[x])
      time.sleep(duration[x] *0.5)
      x+=1

  GPIO.setup(self.buzzer_pin, GPIO.IN)

pwm_led=GPIO.PWM(16,500)
pwm_led.start(0)

control = 0
init=0

try:
    while True:
        user_input=input("입력하세요:").upper()
        # LED
        if user_input == "R":
            print("RED ON!!")
            GPIO.output(16,True)
        if user_input == "G":
            print("GREEN ON!!")
            GPIO.output(20,True)
        if user_input == "B":
            print("BLUE ON!!")
            GPIO.output(21,True)
            
        if user_input =="M":
            for i in range(101):
                if(i==100):
                    i-0
                pwm_led.ChangeDutyCycle(i)
                time.sleep(0.02)
            
        if user_input =="X":
            while(init<10):
                GPIO.output(16,True)
                time.sleep(0.1)
                GPIO.output(16,False)
                time.sleep(0.1)
                GPIO.output(20,True)
                time.sleep(0.1)
                GPIO.output(20,False)
                time.sleep(0.1)
                GPIO.output(21,True)
                time.sleep(0.1)
                GPIO.output(21,False)
                time.sleep(0.1)
                init += 1
        # PIR
        if GPIO.input(24) == True:
             while (True):
                 pir(init)
        
                 if GPIO.input(24) == False:
                    print("SENSOR OFF!!")
                    GPIO.output(16,False)
                    break
        
        # Button Buzzer
        button_state = GPIO.input(12)
        exist=1
        if button_state==False:
            if(control==True):
                control=False
            else:
                control=True
        if control == True:
            while (GPIO.input(12)==False):
                buzzer()
                time.sleep(0.5)
                print("BUZZER ON!!")
            
            if button_state==False:
                print("BUZZER OFF!!")
                control = 0
                done(pwm_led)
                break
            time.sleep(0.3)
            
        # MUSIC
        if user_input == "S":
            if __name__ == "__main__":
              a = input("Enter Tune number 1-5:")
              buzzer = Buzzer()
              buzzer.play(int(a))

        if user_input =="O":
            done(pwm_led)
        time.sleep(0.5)

except KeyboardInterrupt:
    GPIO.cleanup()
finally:
    GPIO.cleanup()

