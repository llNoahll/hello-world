import json
import sys
import pygal.maps.world
from pygal.style import RotateStyle
from country_code import get_country_code


def main(argv=None):
    if argv is None:
        argv = sys.argv
        pass


    filename = 'population_data.json'
    with open(filename) as file:
        pop_data = json.load(file)

    # Build a dictionary of population data
    cc_populations = {}
    for pop_dict in pop_data:
        if '2010' == pop_dict['Year']:
            country_name = pop_dict['Country Name']
            population = int(float(pop_dict['Value']) + 0.5)  # change the string such as '12345.6789' to float, and than change it to int
            code = get_country_code(country_name)

            if code:
                cc_populations[code] = population


    # Group the countries into three population levels.
    cc_pop_1, cc_pop_2, cc_pop_3 = {}, {}, {}
    for cc, pop in cc_populations.items():
        if pop < 1e7:
            cc_pop_1[cc] = pop
        elif pop < 1e9:
            cc_pop_2[cc] = pop
        else:
            cc_pop_3[cc] = pop


    world_map_style = RotateStyle('#336699')
    world_map = pygal.maps.world.World(style=world_map_style)
    world_map.title = "World Population in 2010, by Country"
    world_map.add('< 10^7', cc_pop_1)
    world_map.add('10^7 ~ 10^9', cc_pop_2)
    world_map.add('> 10^9', cc_pop_3)

    world_map.render_to_file('world_population.svg')


    return 0


if __name__ == '__main__':
    sys.exit(main())
