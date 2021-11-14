package ds.dstype.graphType;

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
public class EulerianPathCycle {
/*
In graph theory, an Eulerian trail (or Eulerian path) is a trail in a finite graph that visits every edge exactly once
(allowing for revisiting vertices).
Similarly, an Eulerian circuit or Eulerian cycle is an Eulerian trail that starts and ends on the same vertex.
* */

    // origin -> list of destinations
    HashMap<String, LinkedList<String>> flightMap = new HashMap<>();
    LinkedList<String> result = null;

    public List<String> findItinerary(List<List<String>> tickets) {
        // Step 1). build the graph first
        for(List<String> ticket : tickets) {
            String origin = ticket.get(0);
            String dest = ticket.get(1);
            if (this.flightMap.containsKey(origin)) {
                LinkedList<String> destList = this.flightMap.get(origin);
                destList.add(dest);
            } else {
                LinkedList<String> destList = new LinkedList<String>();
                destList.add(dest);
                this.flightMap.put(origin, destList);
            }
        }

        // Step 2). order the destinations
        this.flightMap.forEach((key, value) -> Collections.sort(value));

        this.result = new LinkedList<String>();
        // Step 3). post-order DFS
        this.DFS("JFK");
        return this.result;
    }

    //PostOrder Depth-First Search
    protected void DFS(String origin) {
        // Visit all the outgoing edges first.
        if (this.flightMap.containsKey(origin)) {
            LinkedList<String> destList = this.flightMap.get(origin);
            while (!destList.isEmpty()) {
                // while we visit the edge, we trim it off from graph.
                String dest = destList.pollFirst();
                DFS(dest);
            }
        }
        // add the airport to the head of the itinerary
        this.result.offerFirst(origin);
    }

    HashMap<String, PriorityQueue<String>> flightsMapGraph = new HashMap<>();
    List<String> itinerary = new ArrayList<>();
    public List<String> findItineraryPq(List<List<String>> tickets){
        //Step 1. Construct graph
        for(List<String> ticket: tickets){
            String origin = ticket.get(0);
            String destination = ticket.get(1);
            PriorityQueue<String> destinationsPq = flightsMapGraph.getOrDefault(origin, new PriorityQueue<>());
            destinationsPq.offer(destination);
            flightsMapGraph.put(origin, destinationsPq);
        }
        String startingFrom = "JFK";
        depthFirstSearch(startingFrom);

        return itinerary;
    }
    //Post-Order Depath First Search
    public void depthFirstSearch(String curAirport){
        PriorityQueue<String> destQueue = flightsMapGraph.get(curAirport);
        while(destQueue != null && !destQueue.isEmpty()){
            depthFirstSearch(destQueue.poll());
        }
        //Add CurrAirport code to start of list, previously added Aiport codes will be moved next indexes i.e. to 0 -> 1
        // 1 -> 2, 2 -> 3 respectively if yet all list contains values in those locations
        itinerary.add(0, curAirport);
    }
}
