"""Simple queue to store the commands from the server"""
from queue import Queue


class Pool:
    """
    Creates a queue to store the actions

    Attributes
    -----------
    __queue: Queue
        simple FIFO queue
    """
    def __init__(self):
        self.__queue = Queue()

    def add(self, event):
        """Add action"""
        self.__queue.put(event)

    def get(self):
        """Remove action"""
        if not self.__queue.empty():
            return self.__queue.get()
        return None
