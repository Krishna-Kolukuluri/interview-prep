#_Problem Statement_

-     Design a software to control traffic lights at a junction where traffic are coming from four sides. It should follow
      basic traffic rules, allow a pedestrian to cross the road, and traffic to pass in reasonable time. How do you optimize 
      the waiting time with respect to high traffic from one direction e.g. during morning and evening rush hours?
    
-     Requirements Breakdown
    -     8 traffic lights + 8 Pedestrian signal lights needed
    -     4 ways of switching need necessary.
    -     U-turn can be accommodated with these 4 ways.
    -     Each way takes 40 secs before switching to another.
    -     switches works based on FIFO(queue) <-- regular traffic
    -     can increase interval for signal from 40 to 60 <-- more traffic sensed on the sensors.
    -     Pedestrian signals can be turned on/off on opposite to the vehicles signals.
    -     Interval should be dynamic as this can be changed if any blockage in the roads.
    -     Also, the order of the way (queue elements) should be configurable. This is necessary in case we need to give a way to the Ambulance/emergency vehicles. (Priority Queue can be used) assign equal priority at normal times.
-     to remove from queue (O(n)) and increase priority (O(lg n)) but as this is just a constant number. we can assume O(1) always.
-     Extension:
    -     If there are several junctions have id/name (unique) for junctions Map<id, TrafficControlSystem> might work. can dig deep if we want to have oops conversation.
    -     https://codepumpkin.com/mediator-design-pattern/