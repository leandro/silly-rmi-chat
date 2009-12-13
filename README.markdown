## This is a very simple RMI driven chat application built on Java.

### Points worth to be said about this project:

- It uses non-persistent message storage;
- It uses a very a bad OO design pattern: Chaos Design Pattern or yet, the Get Things Done Design Pattern;
- It's build over swing package;
- I'm far from being a experienced Java programmer (I started doing Java 2 days before creating this github project);
- I only did this because I wanted to take good grades on college;
- Anyone is wellcome to fork/refactor this project;
- I had a great experience and joy working on this, not to say the troubleshoot learning throughout the project development;

### Recommended stuff you should do on this project:

- Implement way better design patterns;
- Increase client application usability and accessbility, such as sending message when pressing Enter and putting user name on message box when double-clicking on it inside the user-list sidebar;

### Installation and usage

All you need to install are divided into steps (besides you need to have JVM on you machine):

1. Get this project via download or Git
2. Via download: wget http://github.com/leandro/silly-rmi-chat/archives/master (and extract the files)
3. Via Git: git clone git://github.com/leandro/silly-rmi-chat.git
4. Compile the project using the command: ./compile-project
5. Run ./generate-client-jar
6. Run ./generate-server-jar
7. Run "rmiregistry &" in the same directory repository (or extracted files) is
8. Run server interface provider: ./run-server &
9. Run client interface: ./run-client &

### License / Copying

This is free software; it is released under a BSD-style license that allows you to do as you wish with it as long as you don't attempt to claim it as your own work.
