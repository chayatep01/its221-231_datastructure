package lab8;


class Node<T>
{
	T  element;
	Node<T> next;
	Node(T element)
	{
        this.element=element;
        next=null;
     }
    Node(T element, Node<T> next)
    { this(element);
      this.next=next;
    }
}

