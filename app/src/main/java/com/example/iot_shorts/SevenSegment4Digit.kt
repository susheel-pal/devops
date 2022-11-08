package com.example.iot_shorts

class SevenSegment4Digit {

    //connection
    /*
     VCC on pin 2
     GND on pin 6
     DIO on pin 38
     CLK on pin 40
     */

    //clock.py
/*
from time import sleep
import tm1637

try:
    import thread
except ImportError:
    import thread as thread

Display = tm1637. TM1637 (CLK-21, DIO=20, brightness=1.0)

try:
    print ("Starting clock in the background (press CTRL+C to stop):")
    Display StartClock (military_time=False)
    print (Continue Python script and tweak Display!')
    sleep (5)
    Display.ShowDoublepoint (False)
    sleep (5)
    loops = 3
    while loops > 0:
        for i in range(0, 10):
            Display.SetBrightness (i/ 10.0)
            sleep(0.5)
        loops -= 1
        Display.StopClock()
        thread.interrupt_main()
except KeyboardInterrupt:
    print("properly closing the clock and open GPIO pins")
    Display.cleanup()
*/



    //tm1637.py
/*
import math
import RPi.GPIO as 10
import threading
from time import sleep, localtime

HexDigits = [0x3f, 0x06, 0x5b, 0x4f, 0x66, 0x6d, 0x7d,
    0x07, 0x7f, 0x61, 0x77, 0x7c, 0x39, 0x5e, 0x79, 0x71]
ADDR AUTO= 0x40
ADDR FIXED = 0x44
STARTADDR = 0xC0

class TM1637:

    doublePoint = False
    _Clkpin = 0
    _Datapin = 0
    _brightness = 1.0
    _currentData = [0, 0, 0, 0]

    def init_(self, CLK, DIO, brightness):
        self._Clkpin = CLK
        self._Datapin = DIO
        self._brightness = brightness
        IO.setup(self. Clkpin, IO.OUT)
        IO.setup(self. Datapin, IO.OUT)

    def cleanup(self):
        """Stop updating clock, turn off display, and cleanup GPIO"""
        self.StopClock()
        self.Clear()
        IO.cleanup()

    def Clear(self):
        b = self._brightness
        point = self._doublePoint
        self._brightness = 0
        self._doublePoint = False
        data = [0X7F, 0x7F, 0x7F, 0x7F]
        self.Show(data)
        self._brightness = b
        self._doublePoint = point

    def ShowInt(self, i):
        s = str(i)
        self.Clear()
        for i in range(0, len(s)):
            self.Show1 (i, int(s[i]))

    def Show(self, data):
        for i in range(0, 4):
            self._currentData[i] = data[i]

        self.start()
        self.writeByte (ADDR_AUTO)
        self.br()
        self.writeByte(STARTADDR)
        for i in range(0, 4):
            self.writeByte(self.coding (data[i]))
        self.br()
        self.writeByte(0x88 + int(self._brightness))
        self.stop()

    def Show1 (self, Digit Number, data):
        """show one Digit (number 0...3)"""
        if (DigitNumber or Digit Number> 3):
            return #error

        self._currentData[Digit Number] = data
        self.start()
        self.writeByte(ADDR_FIXED)
        self.br()
        self.writeByte(STARTADDR | Digit Number)
        self.writeByte(self.coding (data))
        self.br()
        self.writeByte(0x88 + int(self._brightness))
        self.stop()

    def SetBrightness (self, percent):
        """Accepts percent brightness from 0 - 1"""
        max brightness = 7.0 brightness = math.ceil(max_brightness * percent)
        if (brightness < 0):
            brightness = 0
        if(self. brightness != brightness):
        self._brightness = brightness
        self.Show(self._currentData)

    def ShowDoublepoint (self, on):
        """Show or hide double point divider"""
        if(self._doublePoint != on):
            self._doublePoint = on
            self.Show(self._currentData)

    def writeByte(self, data):
        for i in range(0, 8):
            IO.output(self._Clkpin, IO.LOW)
            if(data & 0x01):
                10.output(self._Datapin, IO. HIGH)
            else:
                10.output (self._Datapin, IO.LOW)
            data = data >> 1
            IO.output(self._Clkpin, 10.HIGH)

        IO.output(self._Clkpin, IO.LOW)
        IO.output(self._Datapin, IO.HIGH)
        IO.output (self._Clkpin, IO.HIGH)
        IO.setup(self._Datapin, IO.IN)

        while (IO.input(self._Datapin)):
            sleep(0.001)
            if(IO.input(self._Datapin)):
                IO.setup(self._Datapin, IO.OUT)
                IO.output(self._Datapin, IO.LOW)
                IO.setup(self._Datapin, IO.IN)

        IO.setup(self._Datapin, IO.OUT)

    def start(self):
        "send start signal to TM1637"""
        IO.output (self._Clkpin, 10.HIGH)
        IO.output (self._Datapin, IO.HIGH)
        IO.output(self._Datapin, 10.LOW)
        IO.output(self._Clkpin, IO.LOW)

    def stop(self):
        IO.output(self._Clkpin, IO.LOW)
        IO.output(self._ Datapin, IO.LOW)
        IO.output(self._Clkpin, IO.HIGH)
        IO.output(self._Datapin, IO.HIGH)

    def br(self):
        """terse break"""
        self.stop()
        self.start()

    def coding(self, data):
        if(self._doublePoint):
            pointData = 0x80
        else:
            pointData = 0
        if(data == 0x7F):
            data = 0
        else:
            data = HexDigits[data] + pointData

        return data

    def clock(self, military_time):
        """Clock script modified from: https://github.com/johnlr/raspberrypi-tm1637"""
        self.ShowDoublepoint (True)
        while (not self._stop_event.is_set());
            t = localtime()
            hour = t.tm_hour
            if not military_time:
                hour = 12 if (t.tm_hour % 12) == 0 else t.tm_hour % 12
                d0 = hour // 10 if hour // 10 else 0
                d1= hour % 10
                d2 = t.tm_min // 10
                d3 t.tm_min % 10
                digits = [d0, d1, d2, d3]
                self.Show(digits)

                # # Optional visual feedback of running alarm:
                # print digits
                # for i in tqdm(range (60 - t.tm_sec)):
                for i in range(60 - t.tm_sec):
                    if (not self._stop_event.is_set()):
                        sleep(1)

    def StartClock (self, military_time=True):
        #Stop event based on: http://stackoverflow.com/a/6524542/3219667
        self._stop_event = threading.Event()
        self._clock_thread = threading.Thread(target=self.clock, args=(military_time,))
        self._clock_thread.start()

    def StopClock(self):
        try:
            print('Attempting to stop live clock')
            self.__stop_event.set()
        except:
            print('No clock to close')

if __name__ = "__main__":
    """Confirm the display operation"""
    display = TM1637 (CLK=21, DIO=20, brightness=1.0)

    display.Clear()

    digits = [1, 2, 3, 4]
    display.Show(digits)
    print ("1234 - Working? (Press Key)
    scrap = raw_input()
    print ("Updating one digit at a time:")
    display.Clear()
    display.Show1(1, 3)
    sleep(0.5)
    display.Show1(1,3)
    sleep(0.5)
    display.Show1(2, 2)
    sleep(0.5)
    display.Show1(3, 1)
    sleep(0.5)
    display. Show1(0, 4)
    print ("4321 - (Press Key)")
    scrap = raw_input()

    print("Add double point\n")
    display.ShowDoublepoint(True)
    sleep(0.2)
    print("Brightness Off")
    display.SetBrightness(0)
    sleep(0.5)
    print("Full Brightness")
    display.SetBrightness(1)
    sleep(0.5)
    print("30% Brightness")
    display.SetBrightness(0.3)
    sleep(0.3)

     */
}