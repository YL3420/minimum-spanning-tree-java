# Instructions for local use



## GraalVM for JavaScript V8 support


#### JavaScript Engine allows for the use of Graphviz visualization 
#### without extra dependencies like dot 
https://www.graalvm.org/

<br>

#### Configure JDK in your IDE and set as GraalVM



## Maven build tool

#### In IDE:
#### Reload Maven projects
#### lifecycle: validate -> compile -> test -> install



## Execute

#### src/main/java/github/com/YL3420/mst_learn_/Main.java
#### execute main and check png in /visual

<br>

#### Modify graph in main and ensure it's a spanning tree and 
#### check result in the same image directory

# Expanding on this project

## 2-Approximation Algorithm / Christofides Algorithm (3/2 Approx) for Traveling Salesman Problem

#### These approxamation algorithms provide us with polynomial time algorithms that produce
#### close to optimal solutions.

<br>

#### Minimum Spanning Tree (MST) provides a lower bound on the optimality of our solution (OPT)
#### and is incorporated as part of the solution. The optimality of the solutions of these 
#### algorithms can be represented using α*OPT

## Applications: delivery with optimal route that completes a tournament back to the starting point.

#### Mathematically model a problem where we have a set of nodes presenting locations that need to be 
#### visited (delivery drop-off location) and a starting point (root). We also have edges (roads/routes)
#### that connect these points, creating a complete graph (note that a complete graph requires that any
#### two distinct vertices in the graph need to be connected by an edge).
#### We can compute a tour that requires us to visit all these vertices in the most cost-effective
#### way possible. The cost or weight on each edge can be determined by the distance, elevation change,
#### congestion at that instance, or construction status of the route. 
