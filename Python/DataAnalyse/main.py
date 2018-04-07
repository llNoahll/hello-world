import sys
import numpy as np


def main(argv=None):
    if argv is None:
        argv = sys.argv
        pass


    data1 = [6, 7.5, 8, 0, 1]
    array1 = np.array(data1)
    print(array1)

    data2 = [[1, 2, 3, 4], [5, 6, 7, 8]]
    array2 = np.array(data2)
    print(array2)


    return 0


if __name__ == '__main__':
    sys.exit(main())
