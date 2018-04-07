def main(argv=None):
    if argv is None:
        argv = None
        pass

    l = input("Please input a list of numbers:\n").split()
    del_times = 0 # the times of delete string
    l_length = len(l)
    for i in range(0, l_length):
        i -= del_times
        try:
            l[i] = int(l[i])
        except ValueError:
            del l[i]
            del_times += 1

        if i >= int(len(l)) - 1:
            break

    print("The init of list is %s." % (l))

    l_length = len(l)
    for i in range(0, l_length-1):
        for j in range(i+1, l_length):
            if l[i] > l[j]:
                l[i] ^= l[j]
                l[j] ^= l[i]
                l[i] ^= l[j]

    print("The result is %s." % (l))


    return 0


if __name__ == '__main__':
    main()
