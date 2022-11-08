package com.example.iot_shorts

class RFID {

    //commands
    /*
    sudo raspi-config
    sudo reboot
    Ismod | grep spi
    sudo apt-get update
    sudo apt-get upgrade
    sudo apt-get install python3-dev python3-pip
    sudo pip3 install spidev
    sudo pip3 install mfrc522
     */

    //connections
    /*
    SDA = pin 24
    SCK = pin 23
    MOSI = pin 19
    MISO = pin 21
    GND = pin 6
    RST = pin 22
    Vcc = pin 1
     */

    //write.py
    /*
    import RPi.GPIO as GPIO
    from mfrc522 import SimpleMFRC522

    reader = SimpleMFRC522()

    try:
        text = input('New Data:')
        print("Now place your tag to write")
        reader.write(text)
        print("written")
    finally:
        GPIO.cleanup()
     */

    //read.py
    /*
    import RPi.GPIO as GPIO
    from mfrc522 import SimpleMFRC522

    reader = SimpleMFRC522()

    try:
        id, text = reader.read()
        print(id)
        print(text)
    finally:
        GPIO.cleanup()
     */
}