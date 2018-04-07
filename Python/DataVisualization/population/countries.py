import sys


def main(argv=None):
    if argv is None:
        argv = sys.argv
        pass

    for country_code in sorted(COUNTRIES.keys()):
        print(country_code, COUNTRIES[country_code])

    return 0


if __name__ == '__main__':
    sys.exit(main())
