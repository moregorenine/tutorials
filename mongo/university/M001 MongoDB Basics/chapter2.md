# Chapter 2: Importing, Exporting, and Querying Data
## Lecture: How does MongoDB store data?
- JSON
  - JavaScript Standard Object Notation
- JSON format
  - Start and end with curly braces {}
  - Separate each **key** and **value** with a colon :
  - Separate each **key**:**value** pair with a comma ,
  - **"keys"** must be surrounded by quotation marks ""
    - In MongoDB **"keys"** are called **"fiields"**
- BSON
  - Bridges the gap between binary representation and JSON format
  - Optimized for:
    - Spped
    - Space
    - Flexibility
  - High performance
  - General-purpose focus
  
|JSON|BSON|
|:---:|:---:|
|**Encoding**<br>UTF-8 String|**Encoding**<br>Binary|
|**Data Support**<br>String, Boolean, Number, Array|**Data Support**<br>String, Boolean, Number(Integer, Long, Float, ...), Array, Date, Raw Binary|
|**Readability**<br>Human and Machine|**Readability**<br>Machine only|

## Quiz: What is JSON?
**Problem**
>Which of the following documents is correct JSON?

**Answer**
>{"name" : "Devi", "age": 19, "major": "Computer Science"}
>- :heavy_check_mark: This is correct.
>- The document starts and ends with curly brackets, all field names are enclosed in quotes, all field:value pairs are separated by commas.

>["name" : "Devi", "age": 19, "major": "Computer Science"]
>- :x: This is incorrect.
>- This document is using square brackets instead of curly braces.

>{name : "Devi", age: 19, major: "Computer Science"}
>- :x: This is incorrect.
>- While some software may not throw an error, this is still not correct JSON because each field name should be in quotes.

## Quiz: JSON vs. BSON
**Problem**

>This exercise is case sensitive. Make sure that you are using all CAPS when entering your answer.
>
>Write BSON or JSON in the numbered blanks in the following sentences to make them true:

**Answer**
>MongoDB stores data in **BSON**, and you can then view it **JSON**.
>
>**BSON** is faster to parse and lighter to store than **JSON**.
>
>**JSON** supports fewer data types than **BSON**.

## Lecture: Importing and Exporting Data
|JSON|BSON|
|:---:|:---:|
|**mongoimport**<br>mongoimport --uri "\<Atlas Cluster URI\>"<br>--drop=\<filename\>.json|**mongorestore**<br>mongorestore --uri "\<Atlas Cluster URI\>"<br>--drop dump|
|**mongoexport**<br>mongoexport --uri "\<Atlas Cluster URI\>"<br>--collection=\<collection name\><br>--out=\<filename\>.json|**mongodump**<br>mongodump --uri "\<Atlas Cluster URI\>"|
### URI String
- Uniform Resource Identifier
- srv - establishes a **secure** connection
```
mongodb+srv://<user>:<password>@<clusterURI>.mongodb.net/<databasename>
```

## Quiz: Import and Export
**Problem**
>Which of the following commands will add a collection that is stored in animals.json to an Atlas cluster?

**Answer**
>mongoimport
>- :heavy_check_mark: This is correct.
>- mongoimport can import data from JSON, and other supported non BSON formats.

>mongodump
>- :x: This is incorrect.
>- mongodump exports data in its raw BSON form.

>mongorestore
>- :x: This is incorrect.
>- mongorestore imports data from a mongodump created BSON format.

>mongoexport
>- :x: This is incorrect.
>- mongoexport does work with JSON, but it would export it, thus making a copy of the data outside of the Atlas cluster, rather than adding a collection to the Atlas cluster.

## Lecture: Data Explorer

## Quiz: Data Explorer
**Problem**
>In the sample_training.trips collection a person with birth year 1961 took a trip that started at "Howard St & Centre St". What was the end station name for that trip?
>
>Copy and paste your answer from the Atlas UI to the response text box. The station name should be in a single set double quotes, exactly as it is in the Data Explorer.

**Answer**
>{"start station name" : "Howard St & Centre St", "birth year" : 1961}

## Lecture: Find Command
- Connect to the Atlas cluster
```
mongo "mongodb+srv://<username>:<password>@<cluster>.mongodb.net/admin"
```
```
show dbs

use sample_training

show collections

db.zips.find({"state": "NY"})
```
- it
  - Iterates through the **cursor**.
- cursor
  - A **pointer** to a result set of a query
- pointer
  - A direct address of the memory location
```
db.zips.find({"state": "NY"}).count()

db.zips.find({"state": "NY", "city": "ALBANY"})

db.zips.find({"state": "NY", "city": "ALBANY"}).pretty()
```
- Summary
  - Use "show dbs" and "show collections" for available namespaces
  - **find()** returns a cursor with documents that match the find query
  - **count()** returns the number of documents that match the find query
  - **pretty()** formats the documents in the cursor

## Quiz: Find Command
**Problem**
>What does it do in the mongo shell?

**Answer**
>Iterates through the cursor results
>- :heavy_check_mark: This is correct.
>- The rest of the options are silly.

## Quiz: The mongo shell
**Problem**
>Which of the following statements are true about the mongo shell?

**Answer**
>It is a fully functioning JavaScript interpreter.
>- :heavy_check_mark: This is correct.
>- mongo shell is a fully functioning JavaScript interpreter, which means that you can create things like JavaScript functions and variables in it.

>It allows you to interact with your MongoDB instance without using a Graphical User Interface.
>- :heavy_check_mark: This is correct.
>- There are other means of interacting with the database, such as through the Atlas UI, which is more visually supportive than the mongo shell.

>mongo shell automatically returns an ordered list of results
>- :x: This is incorrect.
>- The mongo shell does not automatically sort results nor does it return data in sorted order by default. However, you can get a sorted set of documents by using the **sort()** command which will be discussed later in this course.
