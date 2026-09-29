# Double Input

A small Java command-line program that doubles a number.

## Quick start

**Requirements:** Java 17 or later and Maven.

Launch the development container from the repository root:

```sh
./launch_dev_container
```

This requires Docker and the `devcontainer` CLI to be installed and available on `PATH`.

Build the project:

```sh
mvn package
```

Run it with one numeric argument:

```sh
java -cp target/classes com.example.doubleinput.Main 3.5
```

```text
7.0
```

## Tests

Run the test suite with:

```sh
mvn test
```

## Project details

- Java 17
- Maven
- JUnit 5