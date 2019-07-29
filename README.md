# statustest

HTTP Status Test Service


# Installation

`docker run -d -p 8080:8080 airhacks/statustest`

or

download the [latest WAR (4 kB)](https://github.com/AdamBien/statustest/releases) and deploy it on a Java EE 7 application server running on Java 8.

# Usage

The `status` header sets the expected HTTP status code and sends it back

`curl -i -H"status:205" http://localhost:8080/statustest/resources/statuses`

response:

`
HTTP/1.1 205 Reset Content
Server: Payara Micro #badassfish
Date: Sun, 27 Nov 2016 09:08:20 GMT
`

The requests body is sent back as response:

`curl -i -H"status:201" -XPOST -d'input' http://localhost:8080/statustest/resources/statuses`

response:

```
HTTP/1.1 201 Created
Server: Payara Micro #badassfish
Content-Type: text/plain
Date: Sun, 27 Nov 2016 09:11:38 GMT
Content-Length: 5

input

```


# Installing statustest "as-a-service" on openshift

Statustest is installed with [Payara Micro S2I](https://adambien.github.io/s2i-payara-micro/):

[![Statustest Build Pipeline](https://i.ytimg.com/vi/ImSuIoRcm-Y/mqdefault.jpg)](https://www.youtube.com/embed/ImSuIoRcm-Y?rel=0)

See you at [airhacks.com](http://airhacks.com)
