package concepts;

public class CodeReviewPractices {
    /*
    *
    Java Code Review Checklist
Code reviews, or peer reviews, can sometimes feel like an unnecessary chore, especially when there is a backlog of
* features to work on, leaving very little time for these reviews. However, manual or automated reviews are essential
* to delivering quality code that provides a great customer experience.

This guide covers some of the most common items to check in a Java code review to ensure your code is reliable and easy
* to read, maintain and scale.

1. Ensure the Code Follows Standard Naming Conventions
Meaningful naming conventions help ensure the readability and maintainability of the application.

As such, ensure variable, method, and class names convey the subject:

addPerson()
Could be clarified to:

addEmployee()
Use all lower cases for package names and use reversed Internet domain naming conventions:

org/companyname/appname
Class names should start with Capitals:

Employee, Student,
Variable and method names should use CamelCase:

employeeList, studentName, displayEmployees()
2. Make Sure It Handles Constants Efficiently
Constants help improve memory as they are cached by the JVM. For values that are reused across multiple places, create a
* constant file that holds static values.

Favor database-driven values over dynamic values. Also, use ENUMs to group constants.

3. Java Code Reviews Should Check for Proper Clean Up
It is common during development to use procedures that help with your coding and debugging (hard coded variables, for example).
* It is good practice to remove these items and others such as:

Console print statements
Unnecessary comments
Use @deprecated on method/variable names that aren’t meant for future use
4. Does It Handle Strings Appropriately?
If you need to perform a lot of operations on a String, use StringBuilder or StringBuffer.

Strings are immutable, whereas StringBuilder and StringBuffer are mutable and can be changed. Additionally, a new String
* object is created for every concatenation operation.

Rather than creating multiple items, using a mutable object is preferred.

5. Is it Optimized to Use Switch-Case over Multiple If-Else Statements?
Rather than using multiple if-else conditions, use the cleaner and more readable switch-case.

Doing so makes the logic cleaner and optimizes the app's performance.

switch(expression) {

 case x:

// code block

   break;

case y:

  // code block

   break;

 default:

   // code block

}

6. Ensure the Code Follows Appropriate Error Handling Procedures
The NullPointerException is one of the most common and frustrating exceptions.

However, they can be avoided by performing a null check on a variable before operating on it.

The best practice is to use checked exceptions for recoverable operations and use runtime exceptions for programming errors.

Another area to evaluate during a Java code review is to ensure all exceptions are wrapped in custom exceptions.

In this way, the stack trace is preserved, making it easier to debug when things go wrong.

Also, it should declare specific checked exceptions that the method throws rather than generic ones. Doing so doesn’t
* give you the option to handle and debug the issue appropriately.

Avoid this:

public void hello() throws Exception { //Incorrect way

}

Try this instead:

public void hello() throws SpecificException1, SpecificException2 { //Correct way

}

Use the try-catch block for exceptions handling with appropriate actions taken in the catch block. Also, use a finally
* block to release resources, such as database connections, in the finally block. This allows you to close the resource gracefully.

7. Does the Code Have Unnecessary Comments?
Comments should not be used to explain code. If the logic is not intuitive, it should be rewritten. Use comments to
* answer a question that the code can’t. Another way to state it is that the comment should explain the “why” versus “what” it does.

8. Validate That the Code Follows Separation of Concerns
Ensure there is no duplication. Each class or method should be small and focus on one thing.

For example:

EmployeeDao.java - Data access logic

Employee.java - Domain Logic

EmployeerService.java - Business Logic

EmployeeValidator.java - Validating Input Fields

9. Does the Code Rely on Frameworks Rather Than Custom Logic When Possible?
When time is of the essence, reinventing the wheel is time wasted. There are plenty of proven frameworks and libraries
* available for the most common use cases you may need.

Examples include Apache Commons libraries, Spring libraries, and XML/JSON libraries.

10. Make Sure Variables Don’t Cause Memory Leaks
Creating a bunch of unnecessary variables can overwhelm the heap and lead to memory leaks and cause performance problems.
* This occurs when an object is present in the heap but is no longer used, and the garbage collection cannot remove it from memory.

Example:

Avoid This

boolean removed = myItems.remove(item); return removed;
Try This Instead

return myItems.remove(item);
    *
    * */
}
