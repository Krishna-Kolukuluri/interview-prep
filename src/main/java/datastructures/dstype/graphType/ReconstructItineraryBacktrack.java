package datastructures.dstype.graphType;

import java.util.*;

/*
Problem Statement.
You are given a list of airline tickets where tickets[i] = [fromi, toi] represent the departure and the arrival airports
of one flight. Reconstruct the itinerary in order and return it.

All of the tickets belong to a man who departs from "JFK", thus, the itinerary must begin with "JFK". If there are
multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string.

For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
You may assume all tickets form at least one valid itinerary. You must use all the tickets once and only once.
* */
public class ReconstructItineraryBacktrack {
    /*
    Typically, backtracking is used to enumerate all possible solutions for a problem, in a trial-fail-and-fallback strategy.

    A greedy algorithm is any algorithm that follows the problem-solving heuristic of making locally optimal choice at
    each step, with the intent of reaching the global optimum at the end.
    * */
    //Approach 1. Backtracking + Greedy methods(algorithms)
    HashMap<String, List<String>> flightMap = new HashMap<>();
    HashMap<String, boolean[]> airportVisitMap = new HashMap<>();
    int flights = 0;
    List<String> itinerary = null;
    public List<String> findItinerary(List<List<String>> tickets){
        //Build graph from tickets using priority queue will take care of destination airport names sorting by lexically(Greedy part of implementation)
        //We could use List to store destinations for each origin, but it requires extra step of sorting destinations for each origin post creating graph.
        for(List<String> ticket: tickets){
            String origin = ticket.get(0);
            String destination = ticket.get(1);
            if(flightMap.containsKey(origin)){
                flightMap.get(origin).add(destination);
            }else{
                List<String> destinationsList = new LinkedList<>();
                destinationsList.add(destination);
                flightMap.put(origin, destinationsList);
            }
        }
        //Initialize visited map with default value as false for all destinations from each origin
        for(Map.Entry<String, List<String>> entry:flightMap.entrySet()){
            Collections.sort(entry.getValue());
            airportVisitMap.put(entry.getKey(), new boolean[entry.getValue().size()]);
        }
        flights = tickets.size();
        LinkedList<String> route = new LinkedList<>();
        //Starting airport i.e. origin airport from the problem
        route.add("JFK");
        backtracking("JFK", route);
        return itinerary;
    }
    public boolean backtracking(String origin, LinkedList<String> route){
        //Base case for backtracking
        if(route.size() == flights + 1){
            itinerary =(List<String>) route.clone();
            return true;
        }
        if(!flightMap.containsKey(origin)){
            return false;
        }
        int index = 0;
        boolean[] visitedDestinationMap = airportVisitMap.get(origin);
        for (String destination: flightMap.get(origin)){
            if(!visitedDestinationMap[index]){
                visitedDestinationMap[index] = true;
                route.add(destination);
                boolean retValue = backtracking(destination, route);
                route.pollLast();
                visitedDestinationMap[index] = false;
                if(retValue){
                    return true;
                }
            }
            ++index;
        }
        return false;
    }
    /*
    Complexity
    Time Complexity: O(∣E∣^d) where ∣E∣ is the number of total flights and d is the maximum number of flights from an airport.

    Space Complexity: O(∣V∣+∣E∣) where ∣V∣ is the number of airports and ∣E∣ is the number of flights.
    * */


}
