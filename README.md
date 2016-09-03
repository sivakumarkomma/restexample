How to start?

1. gradle build buildDocker
2. cd ./build/docker/
3. docker build .
4. docker start 485 (mysql server container id)
5. docker run --net="host" -t erkanerol/rest-api
