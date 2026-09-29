FROM almalinux:9

RUN dnf install -y \
        java-17-openjdk-devel \
        maven \
        git \
        unzip \
        openssh-clients \
        procps-ng \
    && dnf clean all \
    && rm -rf /var/cache/dnf

ARG USER_ID
ARG USER_GID

RUN groupadd --gid "$USER_GID" dev_group \
    && useradd --uid "$USER_ID" --gid dev_group --create-home --shell /bin/bash dev_user

WORKDIR /workspace
USER dev_user
