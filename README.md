# Find my Drivers using Kotlin - Proof of Concept Driver REST API


## Brief Description Technology being use
### Kotlin
Kotlin develop by JetBrains, the maker of Great IDEs such as Intellij Idea and Android studio.
Kotlin has clearer syntax, and several feature that "fix" Java language but still maintain 100% compatibility with Java.
With kotlin we can easily swap Java Language, but still able to use it's ecosystem/framework.
This API use Java Frameworks/Library but there is no Java Code at all 

### Dagger
Dagger is DI Framework that uses pure code Generation. Dagger does not have complex lifecycle like Spring or Guice, so it startup is blazing fast compared to two other library

### Vert.x
Vert.x is a tool-kit to develop reactive application. Vert.x use Actor like concept called Verticle and use same Event-Loop as Node.js.
Vert.x has Nonblocking nature using callback
In this API, i use several Vert.x feature such as:
- Verticle. MainVerticle that handle HttpServer and Controller Handler. MainVerticle cannot be blocked, if thread is blocked more than 2 seconds, warning will occurred.
- Worker Verticle. Verticle that has it's own thread, handle long running process such as database operation, file operation etc. In this API WorkerVerticle consume message from EventBus.
- HazelCast Clustering. This API use HazelCast Cluster manager to handle Vert.x Cluster, so if we deploy multiple instance of Verticle Hazelcast will automatically join them.
- RxJava Integration. With Vert.x Nonblocking nature, it will hard to maintain code with to many callback. RxJava help us to handle concurrent operations.

### MongoDB
MongoDB is Document base Data Storage, with Geo Search Supports. This API use MongoDB with Morphia Object-Document Mapping library.
MongoDB is Flexible and Easy to use. I use MongoDB Geo Search support to Query Nearest Driver location.

### Gradle
I use gradle as build tools to build, test and package the application. I use gradle for it's easy custom task definition and task configuration.
I create custom task `docker` that build application into single combined `*.jar` and zip it with docker container definition.

### Docker
I use docker for easier deployment, application will be bundled into docker images then application is ready to deploy. 
I use docker-compose file for easier docker container definition. We can see docker related script inside `deployment` directory.
With docker we do not need to install many programs or data storage engine, only docker machine and docker-compose is needed.

### YoFramework
YoFramework, this framework contain a lot of library that help us to code easily using Kotlin Language. This framework initiate by Deny Prasetyo from Kotlin Indonesia.

## Prerequisite 
To Build Application
- Internet Connection
- Java SDK
- Docker Engine and Docker-Compose

To Deploy/Run application
- Docker Engine and Docker-Compose
- Internet Connection to pull required docker image layers

## Building and Deploying 
First we need to execute `./gradlew classes` to generate and compile source, execute `./gradle testClasses` to generate and compile test source.
If compilation is success generated source should be appear on above locations.
- To build app execute `./gradlew clean docker`, will produce `docker-kotlinAPI-drivers.zip` file inside `/build/dist` directory.
- Make sure docker engine and docker compose is installed on your unix system (your laptop, cloud or bare metal).
- To deploy on you local machine, copy `docker-kotlinAPI-drivers.zip` to other place (or you can use `/build/dist` directory, so skip this)
- To deploy on remote machine, upload `docker-kotlinAPI-drivers.zip` to your remote machine.
- Unzip `docker-kotlinAPI-drivers.zip`
- Execute `docker-compose build` to build docker images
- Execute `docker-compose up -d` to deploy container inside docker engine
- Docker will build and deploy 1 MongoDB instance, 1 API Instance and 2 Worker Instance. API and Worker instances will joined in single cluster by hazelcast.
- Docker Compose will read `docker-compose.yaml` file as Default, or you can use `-f` to use other `yml` file
- API can be accessed via `http://<docker_engine_ip>/`.
- Configuration for mongodb or API can be modified by editing `docker-compose.yaml`
Note: For simplification i only deploy 1 API instance that expose port 80, if you want to deploy more than one instance, you can use nginx as load balancer
just add nginx definition on `docker-compose.yaml` and configure it to forward request to API Instances.
MongoDB instance exposes it port (27017) to external, if you want to deploy on production, you should block port access from outside.
I intentionally expose MongoDB port so i can inspect MongoDB data from Application like Robomongo. 

## Test
- Before you run test, make sure you have mongodb engine running and reachable
- Modify `application-config-test.properties` make sure db connection is correct
- You can use gradle to run test, all the test should already self-contained
- Vert.x server will running in random available ports
- More information available on code documentation

## Result
In my Machine (Macbook Pro 13 end 2017) first request to API will take more time than next request.
- Endpoint PUT `/drivers/:id/location` will takes around 110ms in first request and around 0-5ms for next requests.
- Endpoint GEt `/drivers` (with 30.000 data) will takes around 400ms in first request and around 3-7ms for next requests. 






