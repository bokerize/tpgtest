# tpgtest
ip address regex validator, student info sorter, and method timing utility

## Getting Started

Download or checkout the project into preferred project folder

### Prerequisites

tested working on:

Maven: apache-maven-3.3.9
Java: version 1.8.0_131, vendor: Oracle Corporation

### Installing

A step by step series of examples that tell you have to get a development env running

clone or unzip to local drive

```
example:

C:\dev\TpgTest
```

run this if ip address file is provided:

```
> mvn compile exec:java -Dexec.args="c:\Temp\IpFile1.txt"

```

run this to use the default IP file:

```
> mvn compile exec:java

```



## Running the tests

to run the test suite

```
> mvn test

```
