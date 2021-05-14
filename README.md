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

## Installation

## References

## Licence

Released under the [MIT license](https://gist.githubusercontent.com/shinyay/56e54ee4c0e22db8211e05e70a63247e/raw/34c6fdd50d54aa8e23560c296424aeb61599aa71/LICENSE)

## Author

[shinyay](https://github.com/shinyay)
