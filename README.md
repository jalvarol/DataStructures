This is a brief overview of Abstract Data and Structures using Java. Each DS folder contains a topic with examples and multiple files to demonstrate the topic at hand. All folders contain JUnit testing with VSCode, you can use Junit Jupiter while setting up to run the junit test files. 
To run these files, please select the individual data structure folders other wise there will be errors with JUnit testing. i.e. "Open Folder" -> "Select Graphs"

**<p align="center">Singly Linked Lists</p>** Linked lists are a data structure where data is chained together using a series of references. A list needs to keep track of data items and references to the next item. In order to do this, lists are made of special objects called NODES. Nodes hold both data and a reference to the next Node in the list. Additionally, Linked lists are sized dynamically compared to arrays which are static. Linked lists also allow for comparative ease of insertion and deletion. Unfortunately, they do not allow for random access - need to scroll through the list item-by-item to find the element we're looking for.  

Methods were tested thoroughly with JUnit classes. To run the tests, use the ListTest.java file.
BlockChain Application: This application uses the List class, storing Block objects to represnt the BlockChain. Please run the BlockChain.java file for this application.

**<p align="center">Doubly Linked Lists</p>** A doubly-linked list is similar to a linked list, the difference is that each node contains a reference to both the next node and the previous node in the List. 

CardApp Application: To demonstrate doubly-linked lists, we implement this by bubble sorting and shuffling a deck of cards. In both instances, we traverse the List of cards forward or backwards and update elements within the Card Lists.

**<p align="center">Queues</p>** Data is kept in the order in which it is added. Very similar to Linked Lists except only the data at the front of the Queue can be accessed (FIFO:First In First Out), and data can only be added at the back of the Queue. Adding an element -> Enqueuing the data. Removing an element -> Dequeuing the data. 

**<p align="center"> Stacks</p>** Data is also kept in the order in which it is added. Shares similarities to Queues and Linked Lists, however only the data at the end of the stack can be accessed (LIFO:Last In First Out). Adding an element -> Push. Removing an element -> Pop. We insert and remove elements at the "top" of the stack(At the end)

Queues and Stacks are demonstrated together with the PalindromeTest file. We use both a Queue and a Stack to determine if a word is a Palindrome. Since we can only access the front of a Queue, and the end of a Stack, we compare the front and end respectively, then we dequeue and pop to continue comparing elements.

 
**<p align="center"> Recursion </p>** 
Any method that calls itself is considered recursive until a condition is met. A recurisve method solves a problem by calling a copy of itself to work on a smaller problem. The method calls itself on a simpler version of the original problem,the recursive step, until it reaches its base case. It is a useful alternative to loops in iterative code.

We implement recursion within the methods; binary search, inSortedOrder, printInReverse, all within the List.java file. We also add linear search to see the differences between recursion and iterative code. Additionally, we add wrapper and helper methods to all three recursive methods and implement certain validation parameters within them.  

**Queue with 2 Stacks** We revisit the prior Queues and Stacks topic. In this section, we create a Queue using two stacks. As a result, we achieve a run time of O(n) within the Queues methods.  

**<p align="center" style = "bold">Tree ADT</p>** Tree ADTs are compromised of nodes. These nodes store data and pointers to other nodes in the tree. The most important node is known as the root, and the root is considered the **parent** node of its **child** nodes. Each node can have only one parent node but a node can have 0 or more child nodes. **Properties** A tree with n nodes will have exactly n-1 edges(links connecting to other nodes) because all nodes, except the root, will have exactly one incoming edge(links). The **depth** of a node in a tree is the number of edges from the **root** to the node. The **height** of a node is the number of edges in the longest path from the node down to a leaf(child) node. The height of any tree is the same as the height of its root. A **Binary Tree** is a tree where each node can have at most 2 children. Binary trees are considered to be **recursive structures**. The root node links to root nodes of its left and right **subtrees**. Each node in the tree will contain data as well as two references, one to the left child and one to the right. If a node doesnt have a right or left child, the values are set to Null. **Special Types of Binary Trees**: **Proper or strict** trees' nodes have either 0 or 2 children. A **Complete** binary tree is one where all levels are filled except the last, and all nodes are as far as left as possible. A **Perfect or Full** binary tree is one where all levels are completely filled. A **Balanced** binary tree is where the height of the left and right subtree is not greater than 1. 

**<p align="center"> BST </p>** A Binary Search Tree is a binary tree where every element in node n's left subtree is less than or equal to the element in n(root). And every element in n's right subtree is greater than the element in node n. BSTs are recursive structres because the BST properties just mentioned must hold true for all nodes in the tree and their subtrees. 

For the BST code within the **BST** folder, notice how we use wrapper and helper functions since the users of our BST class do not have direct access to any of the nodes nor their data or links. The purpose of the wrapper method is to provide a method that can be called outside the BST class. It will then call the helper. The helpers purpose is to implement the main purpose of its method recursively. When a BSTs are balanced, we can see the run-time analysis improve compared Linked Lists and Arrays. Considering 3 basic ADT operationrs (Search, Insertion, Deletion), instead of achieving O(n) for these operations, it is possible to achieve O(log<sub>2</sub>n) with balanced BSTs. 

**<p align="center"> Hash Tables</p>** A Hash Table is a data structure where values are mapped to an array index according to the rules of a **hashing algorithm**. This algorithm takes an input (a key) and returns the index of an array. This array index (a bucket) is the location where the value can be stored. The key can be the data itself or some portion of the data. Hash table operations such as search, insert, and delete can be performed in O(1) time. However, collisions can occur when more than one value is mapped to the same index in a hash table. To mitigate this, we can implement linear probing. If an element is hashed to an index that is already storing another value, the new element is inserted at the next open index. Unfortunately, linear probing would lead to less efficiency when performing insert and search operations, O(n). Another approach is separate chaining, in which we store a series of 0 or more linked elements at each index. This could also average a run time of O(n), but if we can lower the load factor, we can approach constant time. In order to do so, we need to choose an appropriate Table Size that will result in fewer collisions. Therefore, as the hash table continues to be filled with values, we must create a new table every time we exceed around 2/3 or 3/4 capacity.

The provided files in this section collectively implement a movie database application that demonstrates the use of hash tables with separate chaining to manage collisions and binary search trees for sorted data storage. The Movie class defines the structure of movie objects, while the Hash and List classes implement the hash table functionality. The MovieDatabase class integrates these components, providing a user interface for managing and querying the movie data, demonstrating the practical applications and efficiency of hash tables and binary search trees. 

**<p align="center"> Graphs </p>** A graph is a data structure used to model pairwise relations between objects. It consists of vertices (nodes) connected by edges (lines). Graphs can be directed or undirected, depending on whether the relationships have a direction. Common graph algorithms include Breadth-First Search (BFS) and Depth-First Search (DFS), which are used to traverse or search through graph data. Graphs are fundamental in computer science for representing and solving problems related to networks, such as social networks, communication networks, and transportation networks. The efficiency of graph operations depends on the representation used (adjacency list or adjacency matrix) and the algorithm applied. Properly implementing and utilizing graph algorithms can significantly optimize performance in various applications, from pathfinding in maps to analyzing connections in social media.

The provided files implement a social network application that demonstrates the use of graph data structures for managing relationships and connections. The Graph class defines the structure of the graph, including methods for adding vertices and edges, as well as performing graph traversals such as Breadth-First Search (BFS). The FriendNetwork class utilizes the Graph class to build a social network from user data, allowing users to add friends, find the shortest path between friends, and receive friend recommendations. This section illustrates the practical applications and efficiency of graph data structures in modeling and solving real-world problems related to social networks.
