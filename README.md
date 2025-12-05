# Healenium-Appium Example

[![Docker Pulls](https://img.shields.io/docker/pulls/healenium/hlm-backend.svg?maxAge=25920)](https://hub.docker.com/u/healenium)
[![License](https://img.shields.io/badge/license-Apache-brightgreen.svg)](https://www.apache.org/licenses/LICENSE-2.0)
[![@healenium](https://img.shields.io/badge/Telegram-%40healenium-orange.svg)](https://t.me/healenium)

### Table of Contents

[Overall information](#overall-information)

[Compatibility with OSs](#compatibility-with-oss)

[Healenium Appium installation](#healenium-appium-installation)


### Overall information
Healenium-Appium example demonstrates a Java project to test the Plymouth Rock Assurance Android mobile app using Appium and Healenium for self-healing test automation.

### Compatibility with OSs

Support: Android native app testing (Plymouth Rock Assurance).

> This project is specifically designed to test the Plymouth Rock Assurance Android mobile application.

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

Install the Plymouth Rock Assurance app on your Android emulator.

The app package name is: `com.plymouthrock.mobile`

```sh
git clone https://github.com/jrvafiades-netizen/healenium-appium-java.git
cd healenium-appium-java
```

#### Running Tests Locally

1. Start Appium Server:
```sh
appium
```

2. Start your Android emulator with the Plymouth Rock Assurance app installed

3. Run the tests:
```sh
mvn clean test
```

The tests will interact with the Plymouth Rock Assurance app's login form and navigation elements.
