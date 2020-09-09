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