from range import Range
import unittest

class RangeTest(unittest.TestCase):
    def setUp(self):
        self.r1 = Range()
        self.r2 = Range(2, 5)
        self.r3 = Range(2, 3)
        self.r4 = Range(6, 10)
        self.r5 = Range(2, 7)
        self.r6 = Range(-6, 6)

    def test_isvalid(self):
        self.assertTrue(self.r2.isvalid())

    def test_rstretch(self):
        self.assertEqual(self.r2.rstretch(), Range(2, 6))

    def test_lstrech(self):
        self.assertEqual(self.r2.lstretch(), Range(1, 5))

    def test_squeeze(self):
        self.assertEqual(self.r2.squeeze(), Range(3, 4))
        self.assertEqual(self.r3.squeeze(), self.r1)
    
    def test_shift(self):
        self.assertEqual(self.r3.shift(4), Range(6, 7))
    
    def test_length(self):
        self.assertEqual(self.r5.length(), 5)
    
    def test_disjoint(self):
        self.assertTrue(self.r2.disjoint(self.r4))
        self.assertFalse(self.r2.disjoint(self.r3))
    
    def test_contains(self):
        self.assertTrue(self.r6.contains(self.r1))
        self.assertFalse(self.r5.contains(self.r4))
    
    def test_overlaps(self):
        self.assertTrue(self.r6.overlaps(self.r1))
        self.assertFalse(self.r5.overlaps(self.r4))

if __name__ == '__main__': 
    unittest.main() 