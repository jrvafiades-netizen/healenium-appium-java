# Healenium-Appium Example

[![Docker Pulls](https://img.shields.io/docker/pulls/healenium/hlm-backend.svg?maxAge=25920)](https://hub.docker.com/u/healenium)
[![License](https://img.shields.io/badge/license-Apache-brightgreen.svg)](https://www.apache.org/licenses/LICENSE-2.0)
[![@healenium](https://img.shields.io/badge/Telegram-%40healenium-orange.svg)](https://t.me/healenium)

### Table of Contents

[Overall information](#overall-information)

[Compatibility with OSs](#compatibility-with-oss)

[Healenium Appium installation](#healenium-appium-installation)


### Overall information
Healenium-Appium example demos java project to test both web app and native apps using Appium.

### Compatibility with OSs

Support: Android Web, Android native app, IOS Web.

> Unfortunately, Healenium-Appium doesn't support IOS native apps at present.
> But we plan to release to support IOS apps in the near future.

### Prerequisites

- **Java 21 LTS** (or higher)
- Maven 3.9.x or higher
- Appium Server 2.x

This project has been upgraded to Java 21 LTS and requires Java 21 or higher to build and run.


### Healenium-Appium installation

#### Prerequisites
Ensure you have Java 21 LTS installed:
```sh
java -version
```

Clone Healenium repository:
```sh
git clone https://github.com/healenium/healenium.git
```

> Before running healenium you have to specify appium server host and port using appropriate environment variables of hlm-proxy container: APPIUM_SERVER_URL

Example setup hlm-proxy's env variables in case of local Appium server (specified by default):

```dockerfile
    - APPIUM_SERVER_URL=http://host.docker.internal:4723/wd/hub
```

Run Healenium with Appium only

```sh
docker-compose -f healenium/docker-compose-appium.yaml up -d
```

Run example tests

```sh
mvn clean test
```
