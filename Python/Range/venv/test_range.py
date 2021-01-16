from range import Range
import pytest

def test_reset():
    r = Range(3, 8)
    r.reset()
    assert r.start == 0 and r.limit == 0

def test_strech():
    r1 = Range(2, 4)
    r1.stretch()

    r2 = Range(2, 4)
    r2.stretch(2)

    assert r1.start == 1 and r1.limit == 5
    assert r2.start == 0 and r2.limit == 6

def test_squeeze():
    r1 = Range(2, 4)
    r1.squeeze()

    # reset condition
    r2 = Range(3, 3)
    r2.squeeze()

    r3 = Range(5, 10)
    r3.squeeze()

    # squeezing by certain value
    r4 = Range(2, 8)
    r4.squeeze(2)

    assert r1.start == 3 == r1.limit
    assert r2.start == 0 == r2.limit
    assert r3.start == 6 and r3.limit == 9
    assert r4.start == 4 and r4.limit == 6

def test_shift():
    r1 = Range(2, 4)
    r1.shift(3)

    assert r1.start == 5 and r1.limit == 7

def test_length():
    r1 = Range()
    r2 = Range(2, 5)
    r3 = Range(5, 5)

    assert r1.length() == 0
    assert r2.length() == 3
    assert r3.length() == 0

def test_combine():
    r1 = Range(2, 12)
    r2 = Range(5, 15)

    r1.combine(r2)

    assert r1.start == 2 and r1.limit == 15

def test_contains():
    r1 = Range(2, 12)
    r2 = Range(5, 15)
    r3 = Range(3, 9)

    result1 = r1.contains(r2)
    result2 = r1.contains(r3)

    assert result1 == False
    assert result2 == True

def test_isdisjoint():
    r1 = Range(2, 5)
    r2 = Range(6, 9)
    r3 = Range(3, 6)

    assert r1.isdisjoint(r2) == True
    assert r2.isdisjoint(r3) == False

def test_overlaps():
    r1 = Range(2, 5)
    r2 = Range(6, 9)
    r3 = Range(3, 6)

    assert r1.overlaps(r2) == False
    assert r2.overlaps(r3) == True 

def test_touching():
    r1 = Range(2, 3)
    r2 = Range(3, 5)
    r3 = Range(5, 15)

    assert r1.touching(r2) == True
    assert r1.touching(r3) == False
    assert r2.touching(r3) == True

def test_equals():
    r1 = Range(4, 8)
    r2 = Range(4, 8)

    assert r1.equals(r2)

def test_lessthan():
    r1 = Range(2, 5)
    r2 = Range(1, 5)
    r3 = Range(2, 3)

    assert r1.lessthan(r2) == True
    assert r2.lessthan(r3) == True
    assert r1.leesthan(r3) == False

def test_morethan():
    r1 = Range(2, 5)
    r2 = Range(1, 5)
    r3 = Range(2, 3)

    assert r1.lessthan(r2) == False
    assert r2.lessthan(r3) == False
    assert r1.leesthan(r3) == True

def test_merge():
    r1 = Range(2, 5)
    r2 = Range(1, 3)

    r1.merge(r2)

    assert r1.start == 1 and r2.start == 5