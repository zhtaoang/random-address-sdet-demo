# This is a SDET code challenge

### Description
This web service can return random address in JSON format.
* Request 
```html
GET /randomizer/address
```
* Response
```json
{
  "street" : "937 N Bayview Rd.",
  "house" : "Apt. 89",
  "city" : "Johnsonville",
  "county" : "El Dorado",
  "state" : "North Carolina",
  "state_code" : "MO",
  "country" : "Canada",
  "country_code" : "USA",
  "postal_code" : "84501",
  "address" : "937 N Bayview Rd., Apt. 89, Johnsonville, MO, 84501"
}
```

### Build Project
```shell script
./gradlew clean build
```

### Run Tests
```shell script
./gradlew test
```

### Start the App
```shell script
./gradlew bootRun
```

### Check the Result
```html
http://localhost:8080/randomizer/address
```