import requests
import sys


def main(argv=None):
    if argv is None:
        argv = sys.argv
        pass


    # Make an API call and store the response.
    usl = 'https://api.github.com/search/repositories?q=language:python&sort=stars'
    r = requests.get(usl)
    print("Status code:", r.status_code)

    # Store API response in a variable.
    response_dict = r.json()
    print("Total responsitories:", response_dict['total_count'])

    # Explore information about the reponsitorities.
    repo_dicts = response_dict['items']
    print("Repositories returned:", len(repo_dicts))

    # Explore the first repository.
    repo_dict = repo_dicts[0]
    print("\nKeys:", len(repo_dict))
    for key in sorted(repo_dict.keys()):
        print(key)

    # # Process results.
    # print(response_dict.keys())


    return 0


if __name__ == '__main__':
    sys.exit(main())
