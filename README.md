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
```
$ gcloud services enable artifactregistry.googleapis.com
```

### 2. Create Maven Repository
```
$ gcloud beta artifacts repositories create shinyay-maven-repo \
    --repository-format=maven \
    --location=us-central1 \
    --description="Maven Repository"
```

### 3. Configure Service Account for the client
Creating a service account
```
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
```
$ gcloud iam service-accounts keys create shinyay-artifact.json --iam-account=shinyay-artifact@(gcloud config get-value project).iam.gserviceaccount.com
$ mv shinyay-artifact.json ~/.config/gcloud/
```

Set Environment Variable
```shell
$ set -x GOOGLE_APPLICATION_CREDENTIALS $HOME/.config/gcloud/application_default_credentials.json
```

### 5-a. Display Maven Project Configuration
Create Maven Project

> [Maven Archetype references](https://maven.apache.org/guides/introduction/introduction-to-archetypes.html)

```
$ mvn archetype:generate -DgroupId=com.google.shinyay.lib -DartifactId=shinyay-lib -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false
```

Display Maven Project Configuration
```shell
$ gcloud artifacts print-settings mvn --repository shinyay-maven-repo--location us-central1
```

### 5-b. Display Gradle Project Configuration
Create Gradle Project

> [gradle init types references](https://docs.gradle.org/current/userguide/build_init_plugin.html)

```
$ mkdir shinyay-gradle-lib
$ gradle init -p shinyay-gradle-lib --type java-library --dsl groovy --test-framework junit-jupiter
```

Display Gradle Project Configuration
```shell
$ gcloud artifacts print-settings gradle --repository shinyay-maven-repo--location us-central1
```


## Installation

## References

## Licence

Released under the [MIT license](https://gist.githubusercontent.com/shinyay/56e54ee4c0e22db8211e05e70a63247e/raw/34c6fdd50d54aa8e23560c296424aeb61599aa71/LICENSE)

## Author

[shinyay](https://github.com/shinyay)
