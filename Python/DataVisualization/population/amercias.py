import sys
import pygal.maps.world


def main(argv=None):
    if argv is None:
        argv = sys.argv
        pass


    world_map = pygal.maps.world.World()
    world_map.title = 'North, Central, and South America'

    world_map.add('North America', {'ca': 34126000, 'us': 309349000, 'mx': 113423000})
    world_map.add('Central America', ['bz', 'cr', 'gt', 'hn', 'ni', 'pa', 'sv'])
    world_map.add('South America', ['ar', 'bo', 'br', 'cl', 'co', 'ec', 'gf', 'gy', 'pe', 'py', 'sr', 'uy', 've'])

    world_map.render_to_file('americas.svg')


    return 0


if __name__ == '__main__':
    sys.exit(main())
