public class BinarySearchTree 
{
	public class Node 
	{
        public String data;
        public Node left;
        public Node right;

        public Node(String data) 
        {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    
    public Node root;

    public BinarySearchTree() 
    {
        this.root = null;
    }

    public void addNode(String newData) 
    {
        this.root = insert(root, newData);
    }

    public Node insert(Node root, String newData) 
    {
        if (root == null) 
        {
            root = new Node(newData);
            return root;
        }
        else if (root.data.compareTo(newData)<0) 
        {
            root.left = insert(root.left, newData);
        } 
        else 
        {
            root.right = insert(root.right, newData);
        }
        return root;
    }

    public boolean search(String data) 
    {
        return search(this.root, data);
    }

    private boolean search(Node root, String data) 
    {
        if (root == null) 
        {
            return false;
        } else if (root.data.compareTo(data)==0) 
        {
            return true;
        } else if (root.data.compareTo(data)<0) 
        {
            return search(root.left, data);
        }
        return search(root.right, data);
    }

    public void preorder() 
    {
        preorder(root);
        System.out.println();
    }

    public void preorder(Node root) 
    {
        if (root == null) 
        {
            return;
        }
        System.out.print(root.data + "\n");
        preorder(root.left);
        preorder(root.right);
    }
}
