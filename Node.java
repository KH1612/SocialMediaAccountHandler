class Node {

	public User user;
	public Node leftChild;
	public Node rightChild;

	Node(User user) {
		this.user = user;
	}

	public String toString() {

	return "Name: " + user.account + '\n' + "Description: " + user.description + '\n';
	}
}