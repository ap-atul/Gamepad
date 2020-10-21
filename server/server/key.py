"""File to parse the keymap and make action to the system"""

import os
from threading import Thread

import pyautogui as auto
from server.pool import Pool


class Config:
    """
    Parses the key map file and creates a dictionary for all the
    key maps

    Attributes
    ----------
    __filePath: str
        path of the key map file, does not change
    __mappings: dict
        stores the key mapping of buttons on app to their values from txt
    """
    def __init__(self):
        self.__filePath = "./server/keymap.txt"
        self.__mappings = None

    def __parseSettings(self):
        """Parses the file and stores the dict in mappings"""
        if not os.path.isfile(self.__filePath):
            raise FileNotFoundError("Key map file is missing")

        self.__mappings = dict()
        with open(self.__filePath, "r") as file:
            for line in file.readlines():
                line = line.split("=")
                # checking for key map
                if len(line) == 2:
                    self.__mappings[line[0]] = line[1].replace("\n", "")

    def getKeyMappings(self):
        """Returns the parsed key map file"""
        try:
            self.__parseSettings()
            return self.__mappings
        except FileNotFoundError:
            exit(1)


class Key:
    """
    Performs the system actions for each key, the action depend on the
    command in the pool queue.

    Attributes
    ----------
    __allKeys: list
        list of all the keyboard keys available
    __config: Config
        object to retrieve the mapping
    __pool: Pool
        object to retrieve the command in the pool
    mappings: dict
        key mapping from the Config
    """
    def __init__(self):
        self.__allKeys = auto.KEYBOARD_KEYS
        self.__config = Config()
        self.__pool = None
        self.mappings = self.__config.getKeyMappings()

    def __keyPress(self, key):
        """Press action on the key"""
        print(f"Pressing key :: {key} --> {self.mappings[key]}")
        auto.keyDown(self.mappings[key])

    def __keyRelease(self, key):
        """Release action on the key"""
        print(f"Releasing key :: {key} --> {self.mappings[key]}")
        auto.keyUp(self.mappings[key])

    def setPool(self, pool: Pool):
        """Starting the thread and storing the Pool object"""
        self.__pool = pool
        Thread(target=self.__check, args=()).start()

    def __check(self):
        """Reading the action and performing based on the command"""
        while True:
            command = self.__pool.get()
            if command is not None:
                command = command.split(" ")
                # press
                if command[0] == "p":
                    self.__keyPress(command[1])
                # release
                else:
                    self.__keyRelease(command[1])
