package com.example.iot_shorts

class Fingerprint {

    //connections
    /*
    GND on pin 6
    RX on pin 8
    TX on pin 10
    VCC on pin 17
     */

    //Command:
    /*
    sudo apt-get install git devscripts
    git clone https://github.com/bastianraschke/pyfingerprint.git
    cd ./pyfingerprint/src/
    dpkg-buildpackage  -uc  -us
    cd files
    cd pyfingerprint
    sudo apt-get -f install
    sudo usermod -a -G dialout pi
     */

    //finger.py
    /*
import time
from pyfingerprint.pyfingerprint import PyFingerprint

try:
    f = PyFingerprint('/dev/ttyUSB0', 57600, 0xFFFFFFFF, 0x00000000)
    print("hi")

    if (f.verifyPassword() == False ):
        raise ValueError('The given fingerprint sensor password is wrong!')
except Exception as e:
    print('The fingerprint sensor could not be initialized!')
    print('Exception message: + str(e))
    exit(1)


print('Currently used templates: + str(f.getTemplateCount())+'/'+ str(f.getStorageCapacity()))
try:
    print('Waiting for finger...')
    ## Wait that finger is read
    while(f.readImage() == False ):
        pass
    ## Converts read image to characteristics and stores it in charbuffer 1
    f.convertImage(0x01)

    ## Checks if finger is already enrolled
    result= f.searchTemplate()
    positionNumber = result[0]
    if(position Number>= 0):
        print('Template already exists at position #' + str(positionNumber))
        exit(0)

    print('Remove finger...')
    time.sleep(2)

    print('Waiting for same finger again...')
    while(f.readImage() == False ):
        pass.

    f.convertImage(0x02)
    if (f.compareCharacteristics() == 0 ):
        raise Exception('Fingers do not match')

    f.createTemplate()

    positionNumber = f.storeTemplate()
    print('Finger enrolled successfully!')
    print('New template position #' + str(position Number))

except Exception as e:
    print('Operation failed!')
    print('Exception message: + str(e))
    exit(1)
     */

}