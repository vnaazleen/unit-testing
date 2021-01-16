class Range:
    def __init__(self, start = 0, limit = 0):
        # range class
        self.start = start
        self.limit = limit

    def reset(self):
        self.start, self.limit = 0, 0

    def stretch(self, n = 1):
        self.start -= n
        self.limit += n

    def squeeze(self, n = 1):
        self.start += n
        self.limit -= n

        if self.start > self.limit:
            self.reset()
    
    def shift(self, n = 1):
        self.start += n
        self.limit += n

    def combine(self, r):
        self.start = min(self.start, r.start)
        self.limit = max(self.limit, r.limit)

    def contains(self, r):
        return self.start <= r.start and self.limit >= r.limit

    def isdisjoint(self, r):
        return self.start > r.limit or self.limit <= r.start
    
    def overlaps(self, r):
        return not self.isdisjoint(r)

    def touching(self, r):
        return self.start == r.start or self.start == r.limit or self.limit == r.limit or self.limit == r.start

    def equals(self, r):
        return self.start == r.start and self.limit == r.limit

    def length(self):
        return self.limit - self.start

    def lessthan(self, r):
        if self.start == r.start:
            return self.length() > r.length()

        return self.start < r.start
    
    def morethan(self, r):
        return not self.lessthan(r)

    def merge(self, r):
        if self.isdisjoint(r):
            return Range()
        
        new_start = min(self.start, r.start)
        new_limit = max(self.start, self.limit)

        return Range(new_start, new_limit)

    def to_string(self):
        return "[" + str(self.start) + ", " + str(self.limit) + ")"
