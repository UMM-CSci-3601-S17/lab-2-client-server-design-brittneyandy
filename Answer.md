1) What is the purpose of .gitignore?

Tells Git which files to ignore. (if file is already commited to git, it is unable to be ignored)

2) What is a route?

It is a path for traffic in a network. Like a path to our server.
 
3) What is the purpose of umm3601.Server class?
 
Creates routes to our users and todos. 
  
4) What is the purpose of the umn3601.UserController class?
  
The purpose of this class is to read the json file and filter the users. 
  
5) What does the url users do?

Brings us to the html file that contains a button. 

6) What does the url api/users do? 

Gives us all the users.

7) What does the url api/users?age=25 do?

It will give us all the users that are of age 25. 

8) What does the url api/users/588935f5de613130e931ffd5 do?

It will give us the specific user with the specific id. 

9) What happens when the user accesses the page "kittens"? Modify the server code so accessing the page "kittens" results in the text "Meow". Describe what you did and how it worked.

We get a 404 not found error. 

We made kittens.html under resources.public and made a header called meow!! 
We have also provided a href in the index.html file that pointed to the kittens.html file. 

10) What are the contents of the public folder?

images, css files, javascript files, and html files 

11) What is the purpose of the html files?

index.html: home page; 
about.html: a page for about information 
kittens.html: says "MEOW!"
users.html: has a button that prints out all users 

12) Describe what happens when you filter users by age in the client? What is read from the web page, and what request is sent to the server? What is received, and how/where is it displayed?

It is not implemented, therefore we are sent to users.html. (when using api/users?age=25, we get the filtered by age users)

If we use the api side, the filtered users by age is dumped in the spot that says json goes here. 

Otherwise there is no filtering option on the client side for users. 

13) Where is the client-side JavaScript defined?

It is resources.public.javascript.users.js

The script is called in users.html in the <head> section. 



