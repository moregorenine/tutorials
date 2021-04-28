# Chapter 3: Creating and Manipulating Documents
## Lecture: Inserting New Documents - ObjectId
M320 - Data Modeling, Later Chapters
- Summary
  - **"_id"** unique identifier for a document in a collection.
  - **"_id"** required in every MongoDB document. 
  - **ObjectId()** is the default value for the **"_id"** field unless otherwise specified.
  
## Quiz: ObjectId
**Problem**
>How does the value of _id get assigned to a document?

**Answer**
>It is automatically generated as an ObjectId type value.
>- :heavy_check_mark: This is correct.
>- When inserting a document via the Data Explorer in Atlas, the _id value is already generated as an ObjectID type, while the rest of the fields are not.

>You can select a non ObjectId type value when inserting a new document, as long as that value is unique to this document.
>- :heavy_check_mark: This is correct.
>- MongoDB generates a value, so that there is one just in case. You can definitely change the default value to a different value or data type, as long as they are unique to this document and not an array.

> When a document is inserted a random field is picked to serve as the _id field.
>- :x: This is incorrect.
>- MongoDB adds an _id field to any inserted document if it doesn't have one, and it does not utilize other fields for this purpose.

>_id field values are sequential integer values.
>- :x: This is incorrect.
>- You can assign the _id field values to be sequential integer values, but it is not the default behavior, nor is it best practice.

## Lecture: Inserting New Documents - insert() and errors
- Identical documents can exist in the same collection as long as their **_id** values are different.
- MongoDB has schema validation functionality allows you to enforce document structure.

## Quiz: Insert Errors
**Problem**
>Select all true statements from the following list:

**Answer**
>MongoDB can store duplicate documents in the same collection, as long as their _id values are different.
>- :heavy_check_mark:
>- The only value that is being checked for duplicates on insertion by default is the _id value, since it serves as a unique identifier for the document.

>If a document is inserted without a provided _id value, then that field and value will be automatically generated for the inserted document before insertion.
>- :heavy_check_mark:
>- MongoDB ensures that each inserted document has a unique _id value.

>MongoDB can always store duplicate documents in the same collection.
>- :x: This is false.
>- While documents that have duplicate content are allowed, they still have to have unique _id values.

>There is no way to ensure that duplicate records are not stored in MongoDB.
>- :x: This is false.
>- You can place additional rules on which documents can and cannot be inserted into a collection using MongoDB's schema validation functionality.

>If a document is inserted without a provided _id value, then that document will fail to be inserted and cause a write error.
>- :x: This is false.
>- MongoDB will automatically add an _id field and assign it an ObjectId type value when inserting such documents into a collection.

## Lecture: Inserting New Documents - insert() order
- Insert three test documents:
```
db.inspections.insert([ { "test": 1 }, { "test": 2 }, { "test": 3 } ])
```
- Insert three test documents but specify the _id values:
```
db.inspections.insert([{ "_id": 1, "test": 1 },{ "_id": 1, "test": 2 },
                       { "_id": 3, "test": 3 }])
```
- Find the documents with _id: 1
```
db.inspections.find({ "_id": 1 })
```
- Insert multiple documents specifying the _id values, and using the "ordered": false option.
```
db.inspections.insert([{ "_id": 1, "test": 1 },{ "_id": 1, "test": 2 },
                       { "_id": 3, "test": 3 }],{ "ordered": false })
```
- Insert multiple documents with _id: 1 with the default "ordered": true setting
```
db.inspection.insert([{ "_id": 1, "test": 1 },{ "_id": 3, "test": 3 }])
```
- View collections in the active db
```
show collections
```
- Switch the active db to training
```
use training
```
- View all available databases
```
show dbs
```

## Quiz: Insert Order
**Problem**
>Which of the following commands will successfully insert 3 new documents into an empty pets collection?

**Answer**
```
db.pets.insert([{ "pet": "cat" }, { "pet": "dog" }, { "pet": "fish" }])
```
>- :heavy_check_mark: This is correct.
>- The _id field is not specified in any of these documents, which means that it will be created for each automatically, and it will be unique.

```
db.pets.insert([{ "_id": 1, "pet": "cat" },
                { "_id": 1, "pet": "dog" },
                { "_id": 3, "pet": "fish" },
                { "_id": 4, "pet": "snake" }], { "ordered": true })
```
>- :x: This is incorrect.
>- There is a duplicate id issue between the "cat" and "dog" documents. While there are still 3 documents with unique _id values, the duplicate key error will appear on the second document in the array, and will prevent the operation from reaching the other documents. This will happen due to the ordered nature of this insert operation.

```
db.pets.insert([{ "_id": 1, "pet": "cat" },
                { "_id": 1, "pet": "dog" },
                { "_id": 3, "pet": "fish" },
                { "_id": 4, "pet": "snake" }], { "ordered": false })
```
>- :heavy_check_mark: This is correct.
>- This insert is unordered, which means that each document with a unique _id value will get inserted into the collection, which would make a total of 3 inserted documents.

```
db.pets.insert([{ "_id": 1, "pet": "cat" },
                { "_id": 2, "pet": "dog" },
                { "_id": 3, "pet": "fish" },
                { "_id": 3, "pet": "snake" })
```
>- :heavy_check_mark: This is correct.
>- While there is a duplicate key error between the "fish" and "snake" documents, it occurs at the very end of the insert operation, because this insert is ordered by default. As a result the first 3 documents will get inserted and the last one will create a duplicate key error.

## Lecture: Updating Documents - Data Explorer

## Quiz: Updating Documents

## Lecture: Updating Documents - mongo shell

## Quiz: Updating Documents in the shell

## Lecture: Deleting Documents and Collections

## Quiz 1: Deleting Documents

## Quiz 2: Deleting Documents
