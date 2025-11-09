FROM ubuntu:24.04

RUN apt-get update && \
    apt-get install -y \
    openjdk-8-jdk \
    python3 \
    scala \
    vim \
    apt-transport-https curl gnupg -yqq \
    curl \
    gpg
RUN curl -sL "https://keyserver.ubuntu.com/pks/lookup?op=get&search=0x2EE0EA64E40A89B84B2DF73499E82A75642AC823" | gpg --dearmor > /etc/apt/trusted.gpg.d/sbt.gpg 
RUN echo "deb https://repo.scala-sbt.org/scalasbt/debian all main" | tee /etc/apt/sources.list.d/sbt.list
RUN apt-get update && apt-get install -y sbt


