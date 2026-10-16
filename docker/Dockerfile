FROM almalinux:9

RUN dnf install -y \
        java-17-openjdk-devel \
        maven \
        git \
        unzip \
        openssh-server \
        openssh-clients \
        procps-ng \
    && dnf clean all \
    && rm -rf /var/cache/dnf

ARG USER_ID
ARG USER_GID

RUN groupadd --gid "$USER_GID" dev_group \
    && useradd --uid "$USER_ID" --gid dev_group --create-home --shell /bin/bash dev_user \
    && install -d --mode 0700 --owner dev_user --group dev_group /home/dev_user/.ssh

COPY docker/sshd-entrypoint /usr/local/bin/sshd-entrypoint
RUN chmod 0755 /usr/local/bin/sshd-entrypoint

EXPOSE 22

WORKDIR /workspace
ENTRYPOINT ["/usr/local/bin/sshd-entrypoint"]
CMD ["sleep", "infinity"]
