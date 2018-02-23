# DAG-All-Possible-Paths
You are given a DAG which may be disjointed (this represents courses in a university that must be taken in a particular order, but may represent different streams).

Identify all node with 0 in-degree.
For each such node, generate all possible paths that originate from that node

e.g., in the following graph assume that all edges point downward

        0     6.   4
       /  \ ./
       1    2
      / \ ./
      3 . 5

you should generate the following paths
0->1->3
0->1->5 
0->2->5
6->2->5
4

__________________________________________________________________________________________________________________________________
Steps to run the code:

-> To run the sample code, simple run the "DAGServiceTest"

-> To take user input, run "DAGService" and input the following 
      1. Total no. of nodes
      2. Total no. of edges
      3. For each edges, enter parent node and connected child node
      4. Run "DAGService"
