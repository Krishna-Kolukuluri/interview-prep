package designpatterns.behavioural;
/* https://www.journaldev.com/1617/chain-of-responsibility-design-pattern-in-java
The chain of responsibility pattern is used to achieve loose coupling in software design where a request from the client
is passed to a chain of objects to process them. Then the object in the chain will decide who will be processing the
request and whether the request is required to be sent to the next object in the chain or not.

We know that we can have multiple catch blocks in a try-catch block code. Here every catch block is kind of a processor
to process that particular exception. So when an exception occurs in the try block, it’s sent to the first catch block to
process. If the catch block is not able to process it, it forwards the request to the next object in chain i.e next catch
block. If even the last catch block is not able to process it, the exception is thrown outside of the chain to the calling program.

ATM dispense machine logic can be implemented using Chain of Responsibility Pattern, check out the linked post.
* */
public class ChainOfResponsibilityPattern {
}
