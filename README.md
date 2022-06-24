# MegaventoryApplication


## Summary

This is an application that uses Megaventory [API](https://api.megaventory.com/v2017a/documentation/index.html#!/SalesOrder) 
in order to insert several items.

## Inner-workings 

The application connects to the API endpoints over HTTP and inserts entities using the POST method.
Basically, the source code was stolen from [here](https://github.com/PanagiotisNtymenos/Megaventory-Mini-App)
and then heavily refactored because the original was terrible. The result is a working piece of code that is less 
terrible and builds on the original by using interfaces that help make the whole thing easily extendable.

To insert an entity using the API, an instance of `MegaventoryRestApiClient` is required, a utility class that contains the methods necessary to call the API.
The dedicated and redundant methods for adding entities have been replaced by a single `insertEntity` method that is part of the `MegaventoryRestApiClient` class.
The `insertEntity` method accepts an API endpoint in the form of a `String` and any object implementing the `JSONableEntity` interface. 
The `JSONableEntity` interface has one `toJSON` method that converts the object to JSON, a format accepted by the Megaventory API. 
The `MegaventoryRestApiClient` then makes a POST request and sends the prepared data to the specified endpoint. In case of failure, an exception is thrown.

#### Demonstration: 

```java
var apiClient = new MegaventoryRestApiClient();

var taxEndpoint = "Tax/TaxUpdate";
var tax = new Tax("VAT", "VAT GR", 24.0); // implements JSONableEntity

apiClient.insertEntity(taxEndpoint, tax);

```

## Potential improvements   

- Although the code was built to more or less meet the principles of SOLD, KISS, and DRY,
 some improvements can be made in this area. I believe that the amplitude of abstraction in 
 MegaventoryRestApiClient` is too large, a separate class to handle low-level HTTP requests would be useful.
- Some method names should have more descriptive names, although I couldn't think of better ones at the time of writing this. 
- Exception handling could be done better. It should at least have a dedicated Exception extension class. 
- Of course, the support for the other API endpoints is obvious. 


## Reference project

I've never worked on anything like this. 

## Authors

- [@Banogrono](https://github.com/Banogrono)

  
