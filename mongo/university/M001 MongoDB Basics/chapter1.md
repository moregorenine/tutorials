# Chapter 1: What is MongoDB?
## Lecture: What is the MongoDB Database?
- NoSQL Database
  - NoSQL documentDB
- Stored in collections
  - Documents are stored in collections of documents
## Quiz: What is MongoDB?
**Problem**
>Why is MongoDB a NoSQL database?

**Answer**
>Because it does not utilize tables, rows and columns to organize data.
>- :heavy_check_mark: This is correct.
>- NoSQL means that the database does not employ tables, rows and columns for data organization, which is true about MongoDB.

>Because it uses a structured way to store and access data
>- :heavy_check_mark: This is correct.
>- A database implies that there is a structured way to store and organize data.

## Lecture: What is a Document in MongoDB?
- document
  - A way to organize and store data as a set of field-value pairs.
- collection
  - An organized store of documents in MongoDB, usually with common fields between documents
  - A database would contain multiple collections.

## Quiz 1: What is the MongoDB Database?
**Problem**
>Select the statements that together help build the most complete definition of the MongoDB database:

**Answer**
>MongoDB database is an organized way to store and access data.
>- :heavy_check_mark: This is correct.
>- This is a general definition of a database and applies to the MongoDB database as well as to other databases out there.

>MongoDB is a NoSQL database that uses documents to store data in an organized way.
>- :heavy_check_mark: This is correct.
>- When we specify what kind of database MongoDB has, we can classify it as NoSQL because it does not employ related tables of data to store information, and it instead uses documents.

>MongoDB database organizes documents in rows and columns
>- :x: This is incorrect.
>- Documents are organized into collections.

>MongoDB's database uses tables of related data.
>- :x: This is incorrect.
>- Rows and columns are not part of the data organization in MongoDB.

## Quiz 2: What is a Document?
**Problem**
>In MongoDB how does a document relate to a collection?

**Answer**
>Collections consist of many documents.
>- :heavy_check_mark: This is correct.
>- A single collection in MongoDB consists of one or many documents.

>Documents are made up of collections.
>- :x: This is incorrect.
>- Documents are organized into collections, not the other way around.

>Collections are documents that are organized in rows and columns.
>- :x: This is incorrect.
>- Rows, columns and tables are not part of the data organization in MongoDB.

>Collections are tables of documents and other collections.
>- :x: This is incorrect.
>- Rows, columns and tables are not part of the data organization in MongoDB.

## Quiz 3: What is a Document?
**Problem**
>In a MongoDB Document what is the role of fields and values?

**Answer**
>A field is a unique identifier for a specific datapoint.
>- :heavy_check_mark: This is correct.
>- You can not have duplicate field names within the same level of a single document, which is why they are unique identifiers for a specific datapoint.

>Each field has a value associated with it.
>- :heavy_check_mark: This is correct.
>- Data is organized in field-value pairs, so each field has a value associated with it.

>Values do not have to be attached to fields, and can be stand alone data points.
>- :x: This is incorrect.
>- Data is organized in field-value pairs, so each field has to have a value associated with it. A value without a field has no meaning, and no way to be stored.

## Lecture: What is MongoDB Atlas?

## Quiz: What is Atlas?
**Problem**
>How is MongoDB Atlas related to MongoDB the Database?

**Answer**
>They are both MongoDB products.
>- :heavy_check_mark: This is correct.

>Atlas has many tools and services within it that are built specifically for the MongoDB Database.
>- :heavy_check_mark: This is correct.

>MongoDB Database has the same functionality as Atlas, but without the friendly user interface.
>- :x: This is incorrect.
>- Atlas features go beyond the functionality of organizing and storing data, examples are Charts, Realm, Security features and more.

>Atlas is a MongoDB service that can work with any database, but in this course it will be used with MongoDB.
>- :x: This is incorrect.
>- Atlas is built specifically for the MongoDB database, and can not be used in the same way with other databases.
