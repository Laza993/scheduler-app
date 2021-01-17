# scheduler-app

## build ui docker image
docker build -t scheduler-app-image .

## run ui docker container

docker run --name scheduler-app-container -d -p 8888:80 scheduler-app-image


## build api docker image
docker build -t scheduler-app-api-image .

## run api docker container

docker run --name scheduler-app-api-container -d -p 8080:8080 scheduler-app-api-image
