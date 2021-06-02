public class Rope {

  private final int LEAF_SIZE = 2;

  private int weight;
  private Rope left;
  private Rope right;
  private Rope root;
  private String data;

  public Rope(String data) {
    this.root = null;
    this.left = null;
    this.right = null;
    this.data = data;
    this.weight = data.length();

    if (this.weight > LEAF_SIZE) {
      this.left = new Rope(this.data.substring(0, LEAF_SIZE));
      this.right = new Rope(this.data.substring(LEAF_SIZE));
      this.left.root = this;
      this.right.root = this;
    }
  }

  // public Rope() {
  // this.root = this;
  // this.left = null;
  // this.right = null;
  // this.data = "";
  // this.length = 0;
  // }

  public char get(int index) {
    if (this.weight <= index && this.right != null) {
      return this.right.get(index - this.weight);
    }

    if (this.left != null) {
      return this.left.get(index);
    }

    return this.data.charAt(index);
  }

  // public boolean isBalanced(Rope other) {
  // if ((this.left != null && this.right != null) && (other.left != null &&
  // other.right != null))

  // return (this.left == other.left) && (this.right == other.left);

  // else if ((this.left != null && this.right != null) || (other.left != null &&
  // other.right != null))
  // return false;
  // else
  // return this.data.equals(other.data);
  // }

  // public Rope Concat(String txt) {
  // Rope other = new Rope(txt);
  // Rope tmp = new Rope();
  // tmp.left = this;
  // tmp.right = other;
  // tmp.length = this.length + other.length;
  // return tmp;
  // }

}
