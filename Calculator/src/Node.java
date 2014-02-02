public class Node <ElementType> {
    ElementType _element;
    Node<ElementType> _next;

    public Node(ElementType element) {
	_element = element;
	_next = null;
    }
    public ElementType getElement() {
	return _element;
    }
    public Node<ElementType> getNext() {
	return _next;
    }
    public void setNext (Node<ElementType> aNode) {
	_next = aNode;
    }
}
