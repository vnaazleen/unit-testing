class Odometer:
    DIGITS = '123456789'
    def __init__(self, size):
        self.START = int(Odometer.DIGITS[:size])
        self.LIMIT = int(Odometer.DIGITS[-size:])
        self.SIZE = size
        self.readings = []
        for n in range(10 ** (size - 1), 10 ** size):
            if self.is_ascending(n):
                self.readings.append(n) 

    def is_ascending(self, n : int) -> bool:
        return n == int(''.join(sorted(str(n))))


    def next_reading(self, n : int) -> int:
        if n == self.LIMIT:
            return self.START
        n += 1
        while self.is_ascending(n) == False:
            n += 1
        return n 


    def prev_reading(self, n : int) -> int:
        if n == self.START:
            return self.LIMIT
        n -= 1
        while self.is_ascending(n) == False:
            n -= 1
        return n


    def next_nthReading(self, n : int, step : int) -> int:
        for _ in range(step):
            n = self.next_reading(n)
        return n


    def prev_nthReading(self, n : int, step : int) -> int:
        for _ in range(step):
            n = self.prev_reading(n)
        return n


    def readings_in_range(self, start : int, limit : int) -> list:
        return self.readings[start : limit + 1]