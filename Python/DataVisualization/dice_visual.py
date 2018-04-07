import pygal
from die import Die


def main(argv=None):
    if argv is None:
        argv = None
        pass

    # create D6 and D10 dice
    die_1 = Die()
    die_2 = Die(10)

    # make some rolls, and store results in a list.
    results = []
    for roll_num in range(5000):
        result = die_1.roll() + die_2.roll()
        results.append(result)

    # Analyze the results.
    frequencies = []
    max_result = die_1.num_sides + die_2.num_sides

    for value in range(2, max_result+1):
        frequency = results.count(value)
        frequencies.append(frequency)

    # Visualize the results
    hist = pygal.Bar()

    hist.title = "Results of rolling two D6 dice 1000 times."
    hist.x_labels = list(range(2, max_result+1))
    hist.y_labels = list(range(0, 700, 100))
    hist.x_title = "Result"
    hist.y_title = "Frequency of Result"

    hist.add('D6 + D6', frequencies)
    hist.render_to_file('dice_visual.svg')

    return 0


if __name__ == '__main__':
    main()
