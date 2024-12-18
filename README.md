# GitHub User Activity Tracker

<a href="https://roadmap.sh/projects/github-user-activity">GitHub User Activity</a>

This project allows you to track the activity of a GitHub user, such as the repositories they have worked on, the commits they have pushed, and other events related to their GitHub account. The application interacts with the GitHub API to fetch recent events related to a specified GitHub user, processes the data, and prints key activities like pushing commits, opening issues, and starring repositories.

## Features

- **Fetch GitHub User Activity**: Get recent activities of a GitHub user, such as push events, issue creation, and starring repositories.
- **Display Key Events**: The program will display specific actions like:
  - **Push Event**: Shows the number of commits pushed to a repository.
  - **Issues Event**: Shows when a new issue is created in a repository.
  - **Watch Event**: Displays when a repository is starred.
- **Customizable**: You can modify the events you want to track based on the type of GitHub event.

## How It Works

1. The application prompts you to enter a GitHub username.
2. It sends a request to the GitHub API to fetch the user’s recent events.
3. The application processes the returned JSON data and maps it to Java objects.
4. Based on the type of event (push, issue, watch), it displays relevant information on the console.
5. The user can continue tracking other users or exit the program.

## Technologies Used

- **Java**: The core language used for implementing the application.
- **Jackson**: A JSON processing library to parse the data returned from the GitHub API.
- **OkHttp**: A library for making HTTP requests to the GitHub API.
- **GitHub API**: The application interacts with GitHub's public API to fetch user events.

## Setup and Installation

1. Clone this repository to your local machine:

    ```bash
    git clone https://github.com/your-username/github_user_activity.git
    ```

2. Navigate to the project folder:

    ```bash
    cd github_user_activity
    ```

3. Ensure that you have **Java 17** or later installed on your system. You can check your Java version by running:

    ```bash
    java -version
    ```

4. Compile and run the project:

    If you're using Maven or Gradle for dependency management, make sure to add the required dependencies for **Jackson** and **OkHttp** to your project.

    If you don't use a build tool, you can compile and run the program with `javac` and `java` commands.

    ```bash
    javac -cp ".:path_to_okhttp_jar:path_to_jackson_jar" com/github_user_activity/Main.java
    java -cp ".:path_to_okhttp_jar:path_to_jackson_jar" com.github_user_activity.Main
    ```

5. **Running the Application**: After running the program, it will prompt you to enter a GitHub username.

    Example prompt:

    ```
    ENTER A VALID GITHUB USERNAME (or type 'exit' to quit):
    ```

6. Type a GitHub username (e.g., `CarlosZaragozaBeato`) and the application will display the recent activities related to that user.

    Example output:

    ```
    Pushed 3 commits to CarlosZaragozaBeato/leetcode_prep
    Opened a new issue in CarlosZaragozaBeato/leetcode_prep
    Starred CarlosZaragozaBeato/leetcode_prep
    ```

## Sample Output

After entering a GitHub username, the program will show outputs like:

```
Pushed 3 commits to kamranahmedse/developer-roadmap
Opened a new issue in kamranahmedse/developer-roadmap
Starred kamranahmedse/developer-roadmap
```

The above output is an example of activities that might occur for the entered GitHub user.

## Error Handling

- If the provided username is invalid or the GitHub API is not accessible, the program will display an error message.
- If any field in the JSON response is missing or invalid, the program is designed to ignore unknown fields without crashing.

## Contributing

Feel free to fork this repository and submit pull requests. If you find any bugs or issues, please report them by opening an issue in the repository.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

### Customization

You can customize the types of GitHub events you wish to track. Currently, the application tracks the following events:

- **PushEvent**: Displays when the user pushes commits to a repository.
- **IssuesEvent**: Shows when a new issue is opened in a repository.
- **WatchEvent**: Indicates when a user stars a repository.

You can extend this list by adding more event types and their handling logic to the code.

---
