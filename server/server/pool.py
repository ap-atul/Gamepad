from queue import Queue


class Pool:
    def __init__(self):
        self.__queue = Queue()

    def add(self, event):
        self.__queue.put(event)

    def get(self):
        if not self.__queue.empty():
            return self.__queue.get()
        return None
