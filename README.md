# SocketsWithJava

This project was developed for a Computer Networks course and demonstrates the implementation of TCP client-server communication using Java sockets.

## Overview

The project covers the following exercises:

1. Create a TCP server and client that exchange text messages through port **9001**.
2. Create a TCP server that intermediates text conversations between two or more clients through port **9002**.
3. Create a TCP server that receives binary image files and stores them locally. The client sends the images through port **9003**.
4. Create a TCP client that requests the home page of **http://www.aied.com.br** using raw TCP sockets.

---

## Technologies

- Java 21
- TCP Sockets
- Maven
- Multithreading
- Input/Output Streams
- Client-Server Architecture

---

# Exercise 1 - Basic TCP Messaging

## Description

A basic implementation of TCP communication between a client and a server.

### Server

- Listens for connections on port **9001**.
- Receives text messages from clients.
- Sends a response back to the client.

### Client

- Connects to the server.
- Sends a user-defined message.
- Displays the server response.

### Concepts Covered

- `ServerSocket`
- `Socket`
- `BufferedReader`
- `PrintWriter`
- TCP communication fundamentals

---

# Exercise 2 - Multithreaded TCP Server

## Description

A server capable of handling multiple clients simultaneously using Java threads.

### Server

- Listens on port **9002**.
- Creates a dedicated thread for each connected client.
- Allows multiple clients to communicate with the server concurrently.

### Special Commands

| Input | Response |
|---------|---------|
| Hello World! | But what a generic message... |
| teste | What exactly do you want to test? |
| SHUTDOWN | Shuts down the server |

### Concepts Covered

- Concurrent programming
- Threads
- `Runnable` interface
- Multi-client TCP communication
- Connection management

### Architecture

```text
Client 1 ──┐
           ├── Thread 1
Client 2 ──┤
           ├── Thread 2
Client 3 ──┘
```

---

# Exercise 3 - Binary Image Transfer

## Description

Implementation of binary file transfer over TCP.

### Client

The client:

- Reads an image file from disk.
- Sends:
  - File name
  - File size
  - Binary content

### Server

The server:

- Receives the image metadata.
- Reconstructs the file from the incoming bytes.
- Saves the image locally.

### Transmission Format

```text
[File Name]
[File Size]
[Image Bytes]
```

### Classes Used

- `File`
- `FileInputStream`
- `FileOutputStream`
- `DataInputStream`
- `DataOutputStream`

### Buffer Strategy

```java
byte[] buffer = new byte[4096];
```

The image is transmitted in chunks of 4096 bytes until the entire file has been sent.

### Concepts Covered

- Binary data transmission
- File handling
- Stream I/O
- TCP file transfer
- Custom application protocols

---

# Exercise 4 - HTTP Client Using Raw TCP Sockets

## Description

A simple HTTP client that manually communicates with a web server through a TCP socket, without using high-level HTTP libraries.

### Workflow

The client:

1. Resolves the DNS of `www.aied.com.br`.
2. Opens a TCP connection on port **80**.
3. Sends an HTTP GET request manually.
4. Receives and displays the HTTP response.

### Request Example

```http
GET / HTTP/1.1
Host: www.aied.com.br
Connection: close
```

### Concepts Covered

- DNS resolution
- HTTP protocol
- TCP communication
- Request/Response model
- Internet client-server communication

---

## Project Structure

```text
src
└── main
    ├── java
    │   └── edu
    │       └── gov
    │           └── fatec
    │               ├── exercicio1
    │               ├── exercicio2
    │               ├── exercicio3
    │               └── exercicio4
    │
    └── resources
        └── images
            └── test.png
```

---

## Running the Project

### Clone the Repository

```bash
git clone <repository-url>
```

### Compile

```bash
mvn compile
```

### Run

Execute the desired client or server class according to the exercise being tested.

Example:

```bash
java Client
```

or

```bash
java Server
```

---

## Networking Concepts Explored

This project demonstrates practical applications of:

- Client-Server Architecture
- TCP/IP
- DNS
- HTTP
- Java Sockets
- Multithreading
- File Transfer
- Stream-Based Communication
- Custom Application Protocols

---

## Author

**Gabriel de Oliveira Lima Silva**

Academic project developed for the Computer Networks course at FATEC.
