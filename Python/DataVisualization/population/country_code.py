import sys
from pygal_maps_world.i18n import COUNTRIES


def get_country_code(country_name):
    country_code = None

    for code, name in COUNTRIES.items():
        if name == country_name:
            country_code = code
            break

    return country_code


def main(argv=None):
    if argv is None:
        argv = sys.argv
        pass

    print(get_country_code('Andorra'))
    print(get_country_code('United Arab Emirates'))
    print(get_country_code('Afghanistan'))

    return 0


if __name__ == '__main__':
    sys.exit(main())
