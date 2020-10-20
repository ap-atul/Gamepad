import os
from threading import Thread

import pyautogui as auto
from server.pool import Pool


class Config:
    def __init__(self):
        self.__filePath = "./server/keymap.txt"
        self.__mappings = None
        self.__pool = None

    def parseSettings(self):
        if not os.path.isfile(self.__filePath):
            raise FileNotFoundError("Key map file is missing")

        self.__mappings = dict()
        with open(self.__filePath, "r") as file:
            for line in file.readlines():
                line = line.split("=")
                if len(line) == 2:
                    self.__mappings[line[0]] = line[1].replace("\n", "")

    def getKeyMappings(self):
        try:
            self.parseSettings()
            return self.__mappings
        except FileNotFoundError:
            exit(1)


class Key:
    def __init__(self):
        self.__allKeys = auto.KEYBOARD_KEYS
        self.__config = Config()
        self.__pool = None
        self.mappings = self.__config.getKeyMappings()
        self.__UP = "up"
        self.__DOWN = "down"
        self.__RIGHT = "right"
        self.__LEFT = "left"
        self.__A = "a"
        self.__B = "b"
        self.__C = "c"
        self.__D = "d"

    def keyPress(self, key):
        print(f"Pressing key :: {key} --> {self.mappings[key]}")
        auto.keyDown(self.mappings[key])

    def keyRelease(self, key):
        print(f"Releasing key :: {key} --> {self.mappings[key]}")
        auto.keyUp(self.mappings[key])

    def setPool(self, pool: Pool):
        self.__pool = pool
        Thread(target=self.check, args=()).start()

    def check(self):
        while True:
            command = self.__pool.get()
            if command is not None:
                command = command.split(" ")
                if command[0] == "p":
                    self.keyPress(command[1])
                else:
                    self.keyRelease(command[1])
