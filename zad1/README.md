## Usage

### Prerequistis

Docker

### How to run

We are building the app with sbt
`docker build --no-cache -t <name of image>`

Starting container with example outside ports
`docker run -d -p 8080:8080 --name <name of the container> <name of the image>`
