package com.example.iot_shorts

class PiCamera {

    //commands
    //sudo apt-get install python3-picamera
    //sudo pip install picamera
    //sudo raspi-config

    //cameraa.py
    /*
    import picamera
    from time import sleep

    camera = picamera.PiCamera()
    camera.resolution = (1280,720)
    camera.start_preview()
    sleep(2)
    camera,capture('/home/pi/Desktop/tst1.jpg')
    camera.stop_preview()
     */

    //camera1.py
    /*
    import picamera
    from time import sleep

    camera = picamera.PiCamera()
    sleep(2)
    camera.resolution = (1280,720)
    camera.vflip = True
    camera.contrast = 10
    camera.start_recording('home/pi/Desktop/v1.h264')
    camera.wait_recording(5)
    camera.stop_recording()
    print("done")
     */

}