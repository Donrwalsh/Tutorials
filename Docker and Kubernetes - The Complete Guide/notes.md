#Section 2: Manipulating Containers with the Docker Client

standard stuff about starting, stopping and killing containers.

Cleanup with `>docker system prune`

`>docker run redis`

To open a cli within the redis container: (winpty unique to my system, not in the course)

`>winpty docker exec -it <container id> redis-cli`

Communication channels, STDIN (standard in), STDOUT (standard out), STDERR (standard error). So the `-it` (which is the same as `-i -t`) plugs our cli into the STDIN channel of the container. The `-t` part makes it look pretty (simplification).

Get shell access inside the container: `>winpty docker exec -it <container id> sh` Ctrl+D or `>exit` if Ctrl+C isn't working. Do this twice, create a file in one and it will not be available in the other. Container isolation. Pretty standard.