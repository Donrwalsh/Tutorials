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

**Arrays**
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

# Section 3: Sort Algorithms

**Stable vs Unstable Sort Algorithms**

Suppose you have an array of integers such that more than one element have the same value. **Unstable** sort algorithms may result in the relative ordering of equivalent values not being preserved. It follows that **Stable** preserves the order of equivalent elements.

### Bubble Sort

Description:
1. Note the unsortedPartitionIndex (begins as the size of the array).
2. Traverse the array from i = 0 to the unsortedPartitionIndex.
3. Compare values two at a time, swapping positions if necessary to ensure the greater value is to the right.
4. Once the traversal finishes, the greatest value from the unsorted partition is now at the position of unsortedPartitionIndex.
5. Reduce unsortedPartitionIndex by 1 and then repeat steps 2-5. Exit when unsortedPartitionIndex = 0.

Details:
* In-place algorithm (The amount of extra memory being used does not increase as the size of the array increases).
* O(n²) time complexity (quadratic) - pretty bad.
* Stable sort algorithm. (In general this is true, however it would be easy to make it unstable by modifying the comparison to be inclusive of equality as well.)

### Selection Sort

Description:
1. Note the unsortedPartitionIndex (begins as the size of the array).
2. Traverse the array from i = 0 to the unsortedPartitionIndex.
3. While traversing, keep track of the index of the largest value encountered within the unsorted partition.
4. Swap the largest value with the element in the position of the unsortedPartitionIndex.
5. Reduce unsortedPArtitionIndex by 1 and then repeat steps 2-5. Exit when unsortedPartitionIndex = 0.

Details:
* In-place algorithm
* O(n²) time complexity - quadratic
* Doesn't require as much swapping as bubble sort
* Unstable sort algorithm

### Insertion Sort

Description:
1. Note the unsortedPartitionIndex (begins as 1, i.e. the first element (0) is already sorted)
2. Select the element at the unsortedPartitionIndex.
3. Traverse the sorted partition from the right. If an element in the sorted partition is greater than the selected element, shift it to the right.
4. Once a value that is less than the selected element or the sorted partition runs out, insert the selected element to the previous position.
5. Increment the unsortedPartitionIndex and repeat steps 2-5. Exit when unsortedPartitionIndex is greater than the length of the array.

Details:
* In-place algorithm
* O(n²) time complexity - quadratic
* Stable sort algorithm

### Shell Sort

Description:
1. Select a gap value that is greater than or equal to 1.
2. Perform a modified form of Insertion Sort where the comparison steps (3 & 4) are performed on elements that are the selected gap value distance apart rather than adjacent. (Shifting values will also use the gap value)
3. Decrement the gap value and perform another modified Insertion Sort with this new gap value.
4. Repeat steps 2-4 until the gap value reaches 1. At this point, we are performing Insertion Sort and the resulting array is sorted.

Details:
* Variation of Insertion Sort that starts with a large gap value and works down to an eventual gap value of 1 which is then identical to Insertion Sort. At this point, the array has been partially sorted so there is less shifting required which means it generally performs better than Insertion Sort.
* In-place algorithm.
* Time complexity depends on the gap selection method. Worst case is still O(n²) but can perform much better than that.
* Unstable algorithm. (gaps prevent order preservation)
* There are plenty of [ways](https://en.wikipedia.org/wiki/Shellsort#Gap_sequences) to determine the initial gap value, which will then influence the time complexity of Shell Sort. In our implementation, we're using a very simple approach of initializing the gap to `array.length/2`. On each iteration, we'll divide the gap value by 2 to get the next gap value and proceed until the gap value is 1.
* This gap-based approach could also be employed to improve the efficiency of Bubble Sort.

### Merge Sort

Description (Splitting Phase):
1. Begin with an unsorted array. Divide the array into two arrays, which are still unsorted.
2. Recursively perform step 1 on both arrays generated by step 1.
3. Repeat steps 1 and 2 until all the arrays have only one element each. Trivially, these arrays are sorted.

Description (Merging Phase):
1. Merge every left/right pair of sibling arrays into a sorted array.
2. Continue performing step 1 on each pair of arrays back up the chain that the Splitting Phase used to generate the arrays in the first place. The final result is the original array in sorted form.

Details:
* Divide and conquer algorithm; Recursive algorithm.
* Two phases: Splitting an Merging. Splitting phase leads to faster sorting during the Merging phase. Splitting is logical - we do not create new arrays.
* Not in-place. Uses temporary arrays.
* O(n*log*n) time complexity - We're repeatedly dividing the array in half during the splitting phase.
* Stable aglorithm.

### Quick Sort

Description:
1. Select an element from the array. This is called the *pivot*.
2. Reorder the array so that all elements with values less than the pivot come before the pivot and all elements with values greater than the pivot come after it.
3. The pivot is now in its correct sorted position. Next, recursively apply steps 1 and 2 to the sub-arrays on either side of the pivot. No action is required when the sub-arrays are of size 0 or 1.
4. The end result is that all elements have been the pivot value and thus the entire array is sorted.

Details:
* Divide and conquer algorithm; Recursive algorithm.
* In-place algorithm.
* O(n*log*n) time complexity - In the worst-case it is quadratic (choice of pivot always being the largest or smallest element in the sub-array produces a linear chain of n-1 nested calls)
* Unstable algorithm.

### Counting Sort

Description:
1. Generate a tracking array with one element for each value within the pre-determined range.
2. Iterate over the input array and for each element increment the appropriate element in the tracking array.
3. Using the tracking array, re-generate the input array in sorted order by relying on the tallies within the tracking array.

Details:
* Makes assumptions about the data and does not use comparisons. Counts the number of occurrences of each value.
* Only works with non-negative discrete values (no floats, strings, etc.) and these values must be within a specific range.
* NOT an in-place algorithm
* O(n) - can achieve this because we're making assumptions about the data we're sorting. Note that space complexity is based on the defined range.

Stable Version:
* Requires extra steps.
* Can calculate where values should be written back to the original array.
* Writing the values into the array in backwards order ensures stability.
* The trick is our tracking array should now hold the number of elements that have that value as well as the number that have less than that value. Then we iterate over our original values from right to left, and the tracking array informs us of the position that the value should hold in the array (in off-by-1 form, so decrement first), which is then decremented by 1 for the next upcoming value. This preserves the original order of the input array which makes this stable version perfect for use as part of Radix sort.
* Much easier to do this with linked-lists, but those haven't been covered yet at this point in the course.

### Radix Sort

Description:
1. Start by iterating over the input array examining the digit position with the least weight (such as the ones position in the decimal system).
2. Using a stable-sort-algorithm, sort these elements based on the examined digit.
3. Increment the digit position and repeat steps 1-2 on the next highest weight position.

Details:
* Makes assumptions about the data -> Data must have same radix and width. (Radix = number of possible digits in the system. Decimal system radix = 10, alphabet system = 26, binary system = 2, etc.) (Width = the number of these values being used to represent an element. Width of "Hello" = 5, width of "343" = 3, etc.)
* It is critically important that a stable sort algorithm is used. The retention of order is very important to not lose information when working up the weighted digits.
* Counting sort is often used as the sort algorithm for radix sort.
* O(n) - can achieve this because we're making assumptions about the data we're sorting. Even so, it often runs slower than O(n*log*n) algorithms because of the overhead involved.
* In-place depends on which sort algorithm you use.
* Stable algorithm (due to the requirement that the sub-sort must be stable)

# Section 4: Lists

[**Lists**](https://docs.oracle.com/javase/8/docs/api/java/util/List.html) are ordered sequences. In Java, they are an abstract data type.

Abstract Data Type:
* Doesn't dictate how the data is organized.
* Dictates the operations you can perform.
* Concrete data structure is usually a concrete class.
* Abstract data type is usually an interface.

[**ArrayList**](https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html)
* ArrayList being backed by an array means we can infer certain things about its performance.
* Note the difference between capacity and size of an ArrayList.

[**Vector**](https://docs.oracle.com/javase/8/docs/api/java/util/Vector.html) is a thread-safe ArrayList. It's been around since 1.0, and used to be the 'go-to' list class. If you use ArrayList with multiple threads that are only reading, then there's no issue but if those threads are also writing then you open yourself up to synchronization issues. Vectors use backing arrays just like ArrayList. . . unsurprisingly there are not a lot of differences between the two, but if you click through to the 'add' method of Vector you'll notice it has the `synchronized` keyword. Synchronization involves some baseline overhead that is best to avoid if you do not need thread-safety.

[**Linked Lists**](https://docs.oracle.com/javase/8/docs/api/java/util/LinkedList.html) are lists where items are aware of the next item in the list. Each item in the list is called a node. The first item in the linked list is called the 'head'.
* Inserting or deleting from the front of the list takes O(1) time because there is no shifting required as in arrays.
* Singly Linked Lists have associations going just one direction, from the head down the list to the tail which points to null.
* Double Linked List understandably has associations going both directions. A node will point to its successor and predecessor with nulls on either side. Working with a node on the front or the end is constant time. Obviously, working with inner elements is just as tricky as with Singly Linked Lists. Here are some examples of this:

To insert a node A between nodes B and C:
* Assign A's next field to B's next field
* Assign A's previous field to C's previous field
* Assign B's next field to A
* Assign C's previous field to A
* O(1) time complexity BUT we have to find the insertion position first, so this is actually O(n).

To remove node A from between B and C:
* Assign A to "removednode"
* Assign C's previous field to A's previous field
* Assign B's next field to A's next field
* Return A from the method
* O(1) time complexity BUT again we have to ind A first, so this is actually O(n)

(These same approaches can apply to Singly Linked Lists, just omit caring about previous nodes)

**Circular Linked List** is a variation of Singly Linked List where the tail does not point to null, but instead points to the head node. This enables you to traverse the entire list from any node.

# Section 5: Stacks

* Abstract data type. Dictates the operations we can perform on a set of data, but doesn't tell us how the data should be stored.
* LIFO - Last in, first out
* **push** - adds an item as the top item on the stack
* **pop** - removes the top item on the stack
* **peek** - gets the top item on the stack without popping it
* Ideal backing data structure: Singly Linked List. O(1) for push, pop, and peek. If you use an array, then push is O(n), because the array may have to be resized. Though if you know the maximum number of items that will ever be on the stack, an array can be a good choice. If memory is tight, an array might also be a good choice (no overhead for a LL's next field). Despite all this, Singly Linked Lists are still the ideal backing data structure.

Java has a [Stack](https://docs.oracle.com/javase/8/docs/api/java/util/Stack.html) class, but the docs themselves suggest to use a class that extends the Deque interface instead. Linked Lists implement this Deque interface.

# Section 6: Queues

* Abstract data type.
* FIFO - First in, first out
* **add** - also called enqueue - add an item to the end of the queue
* **remove** - also called dequeue - remove the item at the front of the queue
* **peek** - get the item at the front of the queue, but don't remove it

In the Queues project, we initially implemented the basic ArrayQueue that proceeds in one direction, resizing when `back` would exceed the size of the array. This is not optimal, as empty values may accumulate at the front of the array. An alternative implementation in the UpdatedArrayQueue project implements a 'Circular Queue' that avoids this issue.

[**Deque**](https://docs.oracle.com/javase/8/docs/api/java/util/Deque.html) is short for Double-Ended-Queue. . . pronounced 'deck'. This modified form of a queue allows you to add and remove from either end of the queue.

# Section 7: Hashtables

* Abstract data type.
* Provide access to data using keys, where the key doesn't have to be an integer. (though behind-the-scenes, those values are being converted into integers via hashing)
* Consists of key/value pairs where the data types of both do not need to match.
* Optimized for retrieval (when you know the key)
* Associative array is one type of hash table (This is a PHP thing).
* In Java, hashing is done by Object.hashCode().
* Collision may occur when more than one value has the same hashed value.
* **Load Factor** tells us how full a hash table is. It is equal to the size / capacity. Load factor is used to decide when to resize the array backing the hash table. 
* Don't want a load factor too low (lots of empty space) and don't want a load factor that is too high (will increase the likelihood of collisions). Load factor can play a role in determining the time complexity for retrieval.
* **Open Addressing** is a method for avoiding collision that modifies the hashed key if that key has already been occupied. **Linear Probing** is an approach that just increments the hashed key until we find an available key. LessSimpleHashtable.java shows us working to solve some of these collision issues with our simple array-backed hash table.
* Another strategy for dealing with collisions is called **Chaining**. Essentially each array position is a linked list which allows for many different elements to have the same hash value.

**Bucket Sort**

Description:
1. Distribute the items into buckets bsed on their hashed values (scattering phase)
2. Sort the items in each bucket
3. Merge the buckets - can just concatenate them (gathering phase)

Details
* Uses hasing
* Makes assumptions about the data, like radix and counting sort. Because of these assumptions, it can sort in O(n) time.
* Performs best when hashed values of items being sorted are evenly distributed, so there aren't many collisions.
* Generalization of counting sort.
* Requires that the values in bucket X must be greater than the values in bucket X - 1 and less than the values in bucket X + 1. This means that the hash function we use must meet this requirement.
* Not in-place
* Stability will depend on sort algorithm used to sort the buckets - ideally, you want a stable sort.
* To achieve O(n), must have only one item per bucket.
* Insertion sort is often used to sort the buckets, because it is fast when the number of items is small.

# Section 8: Search Algorithms

Finding values in a data structure.

**Linear Search Algorithm** - Iterate over the array and examine each element to see if it matches the value you're looking for. O(n) time complexity.

**Binary Search**
* Data must be sorted!
* Chooses the element in the middle of the array and compares it against the search value.
* If element is equal to the value, we're done. If element is greater than the value, search the left half of the array. If the element is less than the value, search the right half of the array. (Very similar to merge-sort)
* O(*log*n) - can be implemented recursively

# Section 9: Trees

**Trees** - General form
* Hierarchical data structure
* Nodes connected to children. Each node can have one and only one parent.
* Special node in each tree called the 'root' which does not have a parent. Each tree can have one and only one root.
* Example practical applications given are the Java class hierarchy and a windows file system.
* A leaf node has no children.
* Arrows of parents to children are known as 'edges'.
* A singleton tree has only one node - the root
* A sub-tree is if you start at any given node, it is that node (as the new root) and all of its descendents.
* A 'path' is the sequence of nodes required to go from one node to another. Cannot have a path that crosses a single node more than once. A 'root path' is a path going the other direction.
* The 'depth' of a node is the number of edges from the node to the root. The root will always have a depth of zero.
* The 'height' of a node is the number of edges on the longest path from a node to a leaf. (leaf nodes always have a height of zero). The height of the tree itself is the height of its root node.
* The 'ancestors' of a node are other nodes that are found in its path (i.e. nodes between it and the root).

**Binary Trees**
* Every node has 0, 1, or 2 children. (general trees have no such restriction)
* Children are referred to as left child and right child.
* A binary tree is complete if all levels (except the last level) is completely filled and on the last level, all nodes are as left-ward as possible.

**Binary Search Tree (BST)**
* Can perform insertions, deletions, and retrievals in O(*log*n) time.
* The left child always has a smaller value than its parent.
* The right child always has a larger value than its parent
* this means everything to the left of the root is less than the value of the root, and everything to the right of the root is greater than the value of the root. Because of this, we can very easily do a bineary search on this kind of tree.
* Find the min or max value by following the leftmost edges or the rightmost edges respectively.
* Spent some time watching a BST being built from an arbitrary array of integers. Note that the structure of that array heavily influences the resulting structure of the BST (consider how a sorted array produces a linked list). There are some more advanced forms of BSTs that self-arrange themselves when the BST structure is undesirable. Those are not covered in this course though.

**Traversal**
* Level - visit nodes on each level (not used often at all)
* Pre-order - visit the root of every subtree first (start at the top, go root-left-right, treating each child as a fresh root)
* Post-order - visit the root of every subtree last (start at the bottom left, go left-right-root)
* In-order - visit left child, then root, then right child (note that this results in traversing the data in sorted order, hence the name)

**Delete**
* Three possibilities when deleting a node: It is a leaf / it has one child / it has two children. First two are easy, 3rd is complex.
* Deleting a node with 2 children:
* Need to figure out what the replacement node will be.
* Want minimal disruption to the existing tree structure.
* Can take the replacement node from the deleted node's left subtree or right subtree.
* If taking it from the left subtree, we have to take the largest value in the left subtree
* If taking it from the right subtree, we have to take the smallest value in the right subtree.
* Choose one and stick to it.