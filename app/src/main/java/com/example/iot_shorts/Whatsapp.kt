package com.example.iot_shorts

class Whatsapp {
    //Steps/commands:
    /*
    Step 1: pip3 install opencv-python
    Step 2: sudo apt-get install libcblas-dev
    Step 3: sudo apt-get install libhdf5-dev
    Step 4: sudo apt-get install libhdf5-serial-dev
    Step 5: sudo apt-get install libatlas-base-dev
    Step 6: sudo apt-get install libqt4-test
    Step 7: sudo apt-get install libqtgui4
    Step 8: sudo apt-get install libjasper-dev
    Step 9: pip3 install pyperclip
    Step 10: pip3 install pyautogui

    Step 11: connect LED with register on bread board
    Step 12: connect pin 39 and 40 on bread board

     */

    //whatsapp.py
    /*
import pyautogui as pygu
from time import sleep
import pyperclip
import webbrowser
import numpy.core.multiarray
import cv2
import RPi.GPIO as IO
import time

IO.setmode(IO.BOARD)
IO.setup(40, IO.OUT)

webbrowser.open_new('https://web.whatsapp.com/")

default_message = [
    "hi",
    "*turn_on_light*-_turns_on_led_"
    "*turn_off_light*-_Turns_off_led-"
                ]
turn_on_light = ["sure, your bulb is on"]

turn_off_light = ["led is off"]

def open_whatsapp():
    find_whatsapp_header=None
    while find_whatsapp_header is None:
        find_whatsapp_header = pygu.locateOnScreen("Whatsapp_header.JPG", confidence=.8)
        use_here_button_pos = pygu.locate0nScreen ("use_here_button.JPG", confidence=.8)
        if(use_here_button_pos):
            print("whatsapp is used somewhere")
            sleep(2)
            pygu.moveTo(use_here_button_pos[0], use_here_button_pos[1], duration=0.5)
            pygu.click()
        print(".")
        sleep (2)

    return 1

def new_chat_available():
    green_circle_pos = pygu.locateOnScreen("green_circle.JPG", confidence=.8)
    if(green_circle_pos):
        sleep (2)
        pygu.moveTo(green_circle_pos[0],green_circle_pos[1], duration=0.5)
        pygu.click()
        sleep (1)
        ok_button_pos=pygu.locate0nScreen("ok_button.JPG", confidence.8)
        if(ok_button_pos):
            pygu.moveTo(ok_button_pos[0],ok_button_pos[1], duration=0.5)
            pygu.click()
            return 1
        else:
            sleep(1)
            return(0)

def read_last_message():
    smily_paperclip_pos = pygu.locateOnScreen("smily_paperclip.JPG", confidence=.5)
    pygu.moveTo(smily_paperclip_pos[0], smily_paperclip_pos[1])
    pygu.moveTo(smily_paperclip_pos[0]+50, smily_paperclip_pos[1]-35, duration=0.5)
    sleep(1)
    pygu.tripleClick()
    print('in read_last')
    pygu.hotkey('ctrl', 'c')
    sleep(0.1)
    return(pyperclip.paste())

def get_response(incoming_message):
    if "CD_bot" in incoming_message:
        return default_message

    if "turn_on_light" in incoming_message:
        print('get_response')
        IO.output(40,1)
        return turn_on_light

    if "turn_off_light" in incoming_message:
        IO.output(40,0)
        return turn_off_light
    else:
        return ""

def new_message_availabe():
    current_mouse_pos = pygu.position()
    pointer_color = pygu.pixel(current_mouse_pos[0], current_mouse_pos[1])
    if (pointer_color == (255,255,255)):
        return 1
    else:
        return 0

if (open_whatsapp()):
    print("whatsapp page ready")
while(1):
    if(new_chat_available() or new_message_availabe()):
        print("new chat")
        incoming_message = read_last_message()
        message_content  = get_response(incoming_message)
        send_message(message_content)


     */
}