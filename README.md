# Managing Java Library with Artifact Registry

Artifact Regisry manages Java (Maven) artifacts like Sonatype Nexus or JFrog Artifactory.

## Description

## Demo

## Features

- feature:1
- feature:2

## Requirement

## Usage
### 1. Enable API
```shell
$ gcloud services enable artifactregistry.googleapis.com
```

### 2. Create Maven Repository
```shell
$ gcloud beta artifacts repositories create shinyay-maven-repo \
    --repository-format=maven \
    --location=us-central1 \
    --description="Maven Repository"
```

### 3. Configure Service Account for the client
Creating a service account
```shell
$ gcloud iam service-accounts create shinyay-artifact \
    --description "For Artifact Registry" \
    --display-name "Artifact Registry for Maven"
```

Grant the service account read and write access to your repository
```shell
$ gcloud artifacts repositories add-iam-policy-binding shinyay-maven-repo \
    --location=us-central1 \
    --member serviceAccount:shinyay-artifact@(gcloud config get-value project).iam.gserviceaccount.com \
    --role roles/artifactregistry.writer
```

### 4. Create Key file
```shell
$ gcloud iam service-accounts keys create shinyay-artifact.json --iam-account=shinyay-artifact@(gcloud config get-value project).iam.gserviceaccount.com
$ mv shinyay-artifact.json ~/.config/gcloud/
```

Set Environment Variable
```shell
$ set -x GOOGLE_APPLICATION_CREDENTIALS $HOME/.config/gcloud/application_default_credentials.json
```

### 5-maven. Configure Maven Project
Create Maven Project

> [Maven Archetype references](https://maven.apache.org/guides/introduction/introduction-to-archetypes.html)

```shell
$ mvn archetype:generate -DgroupId=com.google.shinyay.lib -DartifactId=shinyay-maven-lib-sample -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false
```

Display Maven Project Configuration
```shell
$ gcloud artifacts print-settings mvn --repository shinyay-maven-repo --location us-central1
```

Instert the settings printed into the POM

#### In the case of Spring Initilizr
Remove the following code block:
```xml
<build>
  <plugins>
    <plugin>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-maven-plugin</artifactId>
    </plugin>
  </plugins>
</build>
```

### 6-maven. Deploy artifact to Artifact Registry
```shell
$ ./mvnw clean deploy -DPROJECT_ID=(gcloud config get-value project)
```

### 5-gradle. Configure Gradle Project
Create Gradle Project

> [gradle init types references](https://docs.gradle.org/current/userguide/build_init_plugin.html)

```
$ mkdir shinyay-gradle-lib-sample
$ gradle init -p shinyay-gradle-lib-sample --type java-library --dsl groovy --test-framework junit-jupiter
```

Display Gradle Project Configuration
```shell
$ gcloud artifacts print-settings gradle --repository shinyay-maven-repo --location us-central1
```

Instert the settings printed into the POM

```
publishing {
    publications {
        mavenJava(MavenPublication) {
            from components.java
            versionMapping {
                usage('java-api') {
                    fromResolutionOf('runtimeClasspath')
                }
                usage('java-runtime') {
                    fromResolutionResult()
                }
            }
        }
    }
    repositories {
        maven {
            url "artifactregistry://us-central1-maven.pkg.dev/${PROJECT_ID}/shinyay-maven-repo"
        }
    }
}
```

#### In the case of Spring Initilizr
Add the following code block:
```groovy
bootJar {
  enabled = false
}

jar {
  enabled = true
}
```

### 6-gradle. Deploy artifact to Artifact Registry
```shell
$ ./gradlew clean publish -PPROJECT_ID=(gcloud config get-value project)
```

### 7. Verify the artifact on Artifact Registry

You can see the deoloyed artifacts:
- [Artifact Registry](http://console.cloud.google.com/artifacts)

## Installation

## References

## Licence

Released under the [MIT license](https://gist.githubusercontent.com/shinyay/56e54ee4c0e22db8211e05e70a63247e/raw/34c6fdd50d54aa8e23560c296424aeb61599aa71/LICENSE)

## Author

[shinyay](https://github.com/shinyay)
