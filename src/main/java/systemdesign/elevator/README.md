#_OOD - Design an Elevator_
- **Object-Oriented Design Principles**
  - Although there is no right answer, one should follow the SOLID principles to make the design. SOLID principles are a set of golden rules used by object-oriented developers. SOLID principles consist of (reference to educative.io):

    - S: Single-responsibility principle
    - O: Open-closed principle
    - L: Liskov substitution principle
    - I: Interface segregation principle
    - D: Dependency inversion principle


- **Design patterns**
  - One can also implement appropriate design patterns to enhance the functionality and code style. For this problem, I think these design pattern could be useful:
    - Observer Design Pattern
    - Composite Design Pattern
    - State Design Pattern
    - Singleton Design Pattern 
      
- **Analysis**
  - Alright, let me show you my implementation for this problem. I will try to keep it short and concise, so that it’s feasible to complete during the tech interview, which is about 45 to 60 minutes. I am sure that there are better solutions out there, but here is my approach.

  - First let’s identify the problem’s requirements. Usually, the basic requirements for this problem are:
    - The elevator can go up and down in a real-world fashion.
    - Users can send requests to the elevator from both outside and inside the elevator. 
      
  - The first requirement is a bit vague, so let me break it down. A real-world elevator has the following behaviours:
    - When elevator is going up or down, it will stop at all the floors that the users requested.
    - If the elevator received a request of going down while it is going up, the elevator will go to the highest floor 
      in the current requests, and then go down.
    - Users can send requests at anytime.

- **Assumptions**
  - Now, in real life, the elevator will finish all up requests before starting down requests. Let’s assume that going 
    up has more priority than going down, which means that when the elevator is in IDLE state, and has both up and down 
    requests, it will execute up requests first.

  - I used a max heap to store all down requests and sort them by their desired floor. Similarly, a min heap to store 
    all up requests and sort them by their desired floor.

  - When, the requester is outside the elevator, the elevator needs to stop at the currentFloor of the requester, 
    before going to the desiredFloor of the requester.

- **Time and Space Complexity**
  - The main structure that we use in this design is heap. It has a time complexity of O(nlogn). The space complexity is O(n).