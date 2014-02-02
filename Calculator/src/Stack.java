public class Stack <ElementType> implements StackADT <ElementType>{
    private Node <ElementType> _top;

    public Stack () {
	_top = null;
    }
   
    public void push (ElementType element) {
		Node<ElementType> nodeToAdd = 
	       new Node<ElementType>(element);
		nodeToAdd.setNext(_top);
		_top = nodeToAdd;
	    }
   
    public ElementType pop () {
		if (this.isEmpty())
		    return null;
		else {
		    ElementType topElement = 
	            _top.getElement();
		    _top = _top.getNext();
		    return topElement;
		}
    }
   
    public boolean isEmpty() {
		return (_top == null);
	    }
}
