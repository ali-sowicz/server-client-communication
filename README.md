# Server-client communication
The client program (C #) sends a GET request with the web
address as an argument. Web address is read from <code>client.txt</code> file.
The server (Java) returns the content of
the HTML document of the page address sent by the client. Client prints it out to <code>odp.txt</code>.
The server is multithreaded, it allows connection of up to 5 clients.

<code> </code>

# Testing
Make sure that correct path for <code>client.txt</code> and <code>odp.txt</code> is defined in Program.cs

Open cmd window and run server's code first
```
javac Server.java
java Server.java
```

Open another cmd window and run client's code
```
Client.exe
```

# Preview
Contents of <code>client.txt</code>

<img src= "https://user-images.githubusercontent.com/94705023/165735452-abd6dbb7-b6bf-4b1e-873a-ee5c8327cd1c.png" width="200">

Contents of <code>odp.txt</code>

<img src= "https://user-images.githubusercontent.com/94705023/165735272-d2326214-acac-48ad-a972-8db56b98916f.png" width="400">
