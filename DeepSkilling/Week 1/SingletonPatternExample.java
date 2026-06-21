/*
Exercise 1: Implementing the Singleton Pattern
Scenario: 
You need to ensure that a logging utility class in your application has only one instance throughout the application lifecycle to ensure consistent logging.
Steps:
1.	Create a New Java Project:
    o	Create a new Java project named SingletonPatternExample.
2.	Define a Singleton Class:
    o	Create a class named Logger that has a private static instance of itself.
    o	Ensure the constructor of Logger is private.
    o	Provide a public static method to get the instance of the Logger class.
3.	Implement the Singleton Pattern:
    o	Write code to ensure that the Logger class follows the Singleton design pattern.
4.	Test the Singleton Implementation:
    o	Create a test class to verify that only one instance of Logger is created and used across the application.

*/

public class SingletonPatternExample{

    static class Logger {

        // Single instance of Logger
        private static Logger instance;

        // Private constructor
        private Logger() {
            System.out.println("Logger Instance Created");
        }

        // Returns the single Logger instance
        public static Logger getInstance() {
            if (instance == null) {
                instance = new Logger();
            }
            return instance;
        }

        public void log(String message) {
            System.out.println("[LOG] " + message);
        }
    }

    public static void main(String[] args) {

        // Getting Logger instances
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        logger1.log("Application Started");
        logger2.log("User Logged In");

        // Verifying Singleton behavior
        if (logger1 == logger2) {
            System.out.println("Only one Logger instance exists.");
        }

        System.out.println("Logger1 HashCode: " + logger1.hashCode());
        System.out.println("Logger2 HashCode: " + logger2.hashCode());
    }
}