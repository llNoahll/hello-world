from country_code import get_country_code
import unittest
import sys


class TestGetCountryCode(unittest.TestCase):
    def setUp(self):
        self.country_name = 'China'
        self.country_code = get_country_code(self.country_name)

        return


    def test_get_country_mode(self):
        self.assertEqual('cn', self.country_code)

        return


    pass



def main(argv=None):
    if argv is None:
        argv = sys.argv
        pass

    unittest.main()

    return 0


if __name__ == '__main__':
    sys.exit(main())
