import sys
import csv
from datetime import datetime
from matplotlib import pyplot


def main(argv=None):
    if argv is None:
        argv = sys.argv
        pass


    # Get dates, high, and low temperatures from the film
    filename = 'sitka_weather_2014.csv'
    with open(filename) as f:
        reader = csv.reader(f)
        header_row = next(reader)

        for index, column_header in enumerate(header_row):
            print(index, column_header)

        dates, highs, lows = [], [], []
        for row in reader:
            try:
                date = datetime.strptime(row[0], "%Y-%m-%d")
                high = int(row[1])
                low = int(row[2])

            # if the data is ''
            except ValueError:
                print(current_date, 'missing data')

            else:
                dates.append(date)
                highs.append(high)
                lows.append(low)


    # Plot dates
    figure = pyplot.figure(dpi=128, figsize=(10, 6))
    pyplot.plot(dates, highs, c='red', alpha=0.5)
    pyplot.plot(dates, lows, c='blue', alpha=0.5)
    pyplot.fill_between(dates, highs, lows, facecolor='purple', alpha=0.1)


    # Format plot
    title = "Daily high and low temperatures, 2014"
    pyplot.title(title, fontsize=20)

    pyplot.xlabel("AKDT", fontsize=16)
    figure.autofmt_xdate()

    pyplot.ylabel("Temperature (F)", fontsize=16)
    pyplot.tick_params(axis='both', which='major', labelsize=16)


    pyplot.show()


    return 0


if __name__ == '__main__':
    sys.exit(main())
