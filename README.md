# Gamepad
Make your smartphone device a gaming controller. Install the app on your android device. Run the python
server on the machine with the game, once connected start the game and play.

Change the ```keymap.txt``` file to configure keys as per the game

## Description
1. app : folder contains the android app which connects the python server running on the machine with 
the ip address 
2. server : folder contains the python server that is needed to be ran to connect the server and the mobile app

## Config
Change the values in the ```keymap.txt``` in the server folder as per your preference, the names of the keys on
the left hand are the app keys while right hand side needed to be changed.

## Execution steps
1.  Clone the repo
```console
$ git clone https://github.com/AP-Atul/Gamepad.git
```
2. Install all the requirements for the server
```console
$ pip install -r requirements.txt
```
3. Run the server
```console
$ python3 main.py
```
4. To run the app
```console
1. Import the app project in Android Studio
2. Run the AS on device
3. [I'll provide an apk soon.]
```