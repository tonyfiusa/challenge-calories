# challenge-calories
Calories consumed by employees

## How to use

### Requirements

* Docker
* JDK16
* Maven 3

### Setup

1. Compile and install with maven

``` mvn install ```

2. Add to your /etc/hosts the following entries

``` 127.0.0.1     user```

``` 127.0.0.1     web```

3. Run docker-compose

``` docker-compose up --build ```

4. Access [Web](http://web:8081) (It can take a couple of minutes to be available)
5. Use the following credentials

| Username | Password |
|----------|----------|
| test1    |   test   |
| test2    |   test   |

#### Customize Data

You can add the data you want in the db_scripts/data.sql and rerun

1. Stop docker-compose if running

``` docker-compose down ```

2. Relaunch docker-compose

``` docker-compose down up ```
