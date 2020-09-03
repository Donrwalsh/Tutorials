From Cracking the Coding Interview page 61: This is a list of absolute, must have knowledge:

| Data Structures       | Algorithms           | Concepts                |
|-----------------------|----------------------|-------------------------|
| Linked Lists          | Breadth-First Search | Bit Manipulation        |
| Trees, Tries & Graphs | Depth-First Search   | Memory (Stack vs. Heap) |
| Stacks & Queues       | Binary Search        | Recursion               |
| Heaps                 | Merge Sort           | Dynamic Programming     |
| Vectors / ArrayLists  | Quick Sort           | Big O Time & Space      |
| Hash Tables           |                      |                         |

# Section 1: Introduction

Data Structure

* Organizes and stores data
* Each has strengths and weaknesses

"The fact is, there aren't just two sides to any issue, there's almost always a reange of responses, and 'it depends' is almost always the right answer in any big question" ~ Linus Torvalds

Algorithm - Instructions on how to achieve a particular task

* There can be many algorithms that accomplish the same task
* There can be many implementations of the same algorithm

No surprises in this section.

# Section 2: Arrays and Big-O Notation

Basic introduction to Big-O Notation (worst-case) and space/time complexity. 

Arrays
* Cannot change the size of an array once it is instantiated.
* Indexes are 0-based.
* Contiguous block in memory. All of the elements in the array are stored together.
* Every element occupies the same amount of space in memory.
* If an array starts at memory address `x`, and the size of each element in the array is `y`, we can calculate the memory address of the `i`th element by using the following expression: `x + i * y`.
* Thus, if we know the index of an element, the time to retrieve the element will be the same, no matter where it is in the array. (which is to say, constant time)

| Operation                                         | Time Complexity |
|---------------------------------------------------|-----------------|
| Retrieve with index                               |       O(1)      |
| Retrieve without index                            |       O(n)      |
| Add an element to a full array                    |       O(n)      |
| Add an element to the end of an array (has space) |       O(1)      |
| Insert or update an element at a specific index   |       O(1)      |
| Delete an element by setting it to null           |       O(1)      |
| Delete an element by shifting elements            |       O(n)      |

