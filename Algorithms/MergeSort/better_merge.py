import sys


def create_numerical_array(array=[]):
    del_times = 0 # the times of delete string
    for i in range(0, len(array)):
        i -= del_times
        try:
            array[i] = int(array[i])
        except ValueError:
            del array[i]
            del_times += 1

        if i >= int(len(array)) - 1:
            break

    return


def merge(a_left=[], a_right=[]):
    array = []

    # set the end of arraies
    left_length = len(a_left)
    right_length = len(a_right)

    # compare the two arraies, than combine them
    i = 0; j = 0
    while i < left_length and j < right_length:
        if a_left[i] < a_right[j]:
            array.append(a_left[i])
            i += 1
        else:
            array.append(a_right[j])
            j += 1

    if j == right_length:
        array.extend(a_left[i:])
    elif i == left_length:
        array.extend(a_right[j:])

    return array


def merge_sort(array=[], left=0, right=0):
    print("left = %d, right = %d, array = %s" % (left, right, array))

    if left < right - 1:
        middle = int((left + right) / 2 + 0.5)

        # sort left array
        left_array = merge_sort(array[:middle], 0, middle)
        # sort right array
        right_array = merge_sort(array[middle:], 0, right-middle)

        # combine two arraies
        array = merge(left_array, right_array)

    return array


def main(argv=None):
    if argv is None:
        argv = sys.argv
        pass

    l = input("Please input a list of numbers:\n").split()
    create_numerical_array(l)

    print("The init array = %s\n" % (l))

    length = len(l)
    l = merge_sort(l, 0, length)
    print("\nThe sorted array = %s" % (l))

    return 0


if __name__ == '__main__':
    sys.exit(main())
