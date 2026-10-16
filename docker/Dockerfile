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

RUN dnf install -y dnf-plugins-core \
    && dnf config-manager --add-repo https://download.docker.com/linux/centos/docker-ce.repo \
    && dnf install -y \
        docker-ce \
        docker-ce-cli \
        containerd.io \
        docker-buildx-plugin \
        docker-compose-plugin \
    && dnf clean all \
    && rm -rf /var/cache/dnf

# Fix ssh connection with dind: sshd's PAM "account" phase was failing
RUN sed -i 's/^account.*include.*password-auth/account    required     pam_permit.so/' /etc/pam.d/sshd

ARG USER_ID
ARG USER_GID

RUN groupadd --gid "$USER_GID" dev_group \
    && useradd --uid "$USER_ID" --gid dev_group --create-home --shell /bin/bash dev_user \
    && (getent group docker >/dev/null || groupadd --system docker) \
    && usermod --append --groups docker dev_user \
    && install -d --mode 0700 --owner dev_user --group dev_group /home/dev_user/.ssh

COPY docker/devcontainer-entrypoint /usr/local/bin/devcontainer-entrypoint
RUN chmod 0755 /usr/local/bin/devcontainer-entrypoint

EXPOSE 22

WORKDIR /workspace
ENTRYPOINT ["/usr/local/bin/devcontainer-entrypoint"]
CMD ["sleep", "infinity"]
