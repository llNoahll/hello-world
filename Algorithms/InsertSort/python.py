def main(argv=None):
    if argv is None:
        argv = None
        pass


    l = input("Please input a list of numbers:\n").split()
    del_times = 0 # the times of delete string
    for i in range(0, len(l)):
        i -= del_times
        try:
            l[i] = int(l[i])
        except ValueError:
            del l[i]
            del_times += 1

        if i >= int(len(l)) - 1:
            break
    print("the init of list is %s" % (l))

    l_length = len(l)
    for i in range(1, l_length):    # We should compare numbers so that we need two numbers at least
        key = l[i]
        j = i - 1
        while l[j] > key and j >= 0:
            l[j + 1] = l[j]    # take away the bigger numbers, and insert the new and smaller number
            j -= 1
        l[j + 1] = key

    print("the final result is %s" % (l))


    return 0


if __name__ == '__main__':
    main()
