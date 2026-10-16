# Double Input

A small Java command-line program that doubles a number.

## Quick start

**Requirements:** Java 17 or later and Maven.

Launch the development container from the repository root:

```sh
./launch_dev_container
```

This requires Docker and the `devcontainer` CLI to be installed and available on `PATH`.
The launcher creates the `dev-net` network on first use, then attaches the container
to it. It assigns the first available hostname and container name: `devbox`, then
`devbox_2`, `devbox_3`, and so on. The selected name is shown in the launcher output.
The network name and subnet default to `dev-net` and `172.28.0.0/16`; set
`DEVCONTAINER_NETWORK` or `DEVCONTAINER_NETWORK_SUBNET` before running the launcher to
override them.

Before starting the container, the launcher creates an Ed25519 key pair at
`~/.ssh/dev_container` if it does not already exist and adds its public key to
`~/.ssh/authorized_keys` (without duplicate entries). The authorized keys file is
mounted read-only in the container; the SSH server starts automatically. Connect
from the host with `ssh -i ~/.ssh/dev_container -p 2201 dev_user@localhost`.
The launcher maps SSH to localhost on port `2201` for `devbox`, `2202` for
`devbox_2`, and so on.
The image entrypoint starts `sshd`; the Dev Container configuration preserves that
entrypoint instead of replacing it with the CLI's default keep-alive shell. After
changing the image or this configuration, rebuild and recreate the container:

```sh
./docker/build_dev_container_image
./launch_dev_container --remove-existing-container
```

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