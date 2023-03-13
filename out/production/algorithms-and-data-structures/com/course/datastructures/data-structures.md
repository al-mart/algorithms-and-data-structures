# Linked List 

HEAD - First Element

Tail - Last element (points to null)

- Add new element (end) -                 `O(N)`

- Add new element (beginning) -           `O(1)`

- Finding element -                       `O(N)`

- Deleting first elem -                   `O(1)`

- Deleting from -                         `O(N)`



###LINKED LIST 

- Unlimited size 
- Don't need to know qnt of items up front 
- Size can grow dynamically
- Easy inserting . just move references
- Deleting is same
- Random access index(100). must traverser O(N)
- Additional space for pointers.
- No spatial locality(No caching) when accessing an element. 

####When to use 

- Large number of insert deletes 
- No idea about the quantity.

###Arrays

- Have to had qnt when declaring
- Cannot be increased in size 
- Inserting is hard. all elements to the right must be moved to make place.
- Deleting will end copying all elements to the right 
- Random access O(1)
- no extra space required.
- Can be accessed from cache.

####When to use

- Not lots of updates.
- Fast access is important.


#STACK

LIFO - Last in first out.

Top is the last element inserted.

- push, pop `O(1)`
- isEmpty, isFull `O(1)`


#QUEUE

FIFO - First In First out.

circularQueue
- enqueue, dequeue - `O(1)`
- isEmpty, isFull - `O(1)`


can also be implemented using two stacks.
