package editor.cn.设计跳表_1206;


/**
 * @author denglimin
 * @date 2021-07-20 12:16
 */
public class main {
  public static void main(String[] args) {
    Skiplist skiplist = new Skiplist();
    System.out.println(skiplist.add(16));
    System.out.println(skiplist.add(5));
    System.out.println(skiplist.add(14));
    System.out.println(skiplist.add(13));
    System.out.println(skiplist.add(0));
    System.out.println(skiplist.add(3));
    System.out.println(skiplist.add(12));
    System.out.println(skiplist.add(9));
    System.out.println(skiplist.add(12));
    System.out.println(skiplist.erase(3));
    System.out.println(skiplist.search(6));
    System.out.println(skiplist.add(7));
    System.out.println(skiplist.erase(0));
    System.out.println(skiplist.erase(1));
    System.out.println(skiplist.erase(10));
    System.out.println(skiplist.add(5));
    System.out.println(skiplist.search(12));
    System.out.println(skiplist.search(7));
    System.out.println(skiplist.search(16));
    System.out.println(skiplist.erase(7));
    System.out.println(skiplist.search(0));
    System.out.println(skiplist.add(9));
    System.out.println(skiplist.add(16));
    System.out.println(skiplist.add(3));
    System.out.println(skiplist.erase(2));
    System.out.println(skiplist.search(17));
    System.out.println(skiplist.add(2));
    System.out.println(skiplist.search(17));
    System.out.println(skiplist.erase(0));
    System.out.println(skiplist.search(9));
    System.out.println(skiplist.search(14));
    System.out.println(skiplist.erase(1));
    System.out.println(skiplist.erase(6));
    System.out.println(skiplist.add(1));
    System.out.println(skiplist.erase(16));
    System.out.println(skiplist.search(9));
    System.out.println(skiplist.erase(10));
    System.out.println(skiplist.erase(9));
    System.out.println(skiplist.search(2));
    System.out.println(skiplist.add(3));
    System.out.println(skiplist.add(16));
    System.out.println(skiplist.erase(15));
    System.out.println(skiplist.erase(12));
    System.out.println(skiplist.erase(7));
    System.out.println(skiplist.add(4));
    System.out.println(skiplist.erase(3));
    System.out.println(skiplist.add(2));
    System.out.println(skiplist.erase(1));
    System.out.println(skiplist.erase(14));
    System.out.println(skiplist.add(13));
    System.out.println(skiplist.add(12));
    System.out.println(skiplist.add(3));
    System.out.println(skiplist.search(6));
    System.out.println(skiplist.search(17));
    System.out.println(skiplist.add(2));
    System.out.println(skiplist.erase(3));
    System.out.println(skiplist.search(14));
    System.out.println(skiplist.add(11));
    System.out.println(skiplist.add(0));
    System.out.println(skiplist.search(13));
    System.out.println(skiplist.add(2));
    System.out.println(skiplist.search(1));
    System.out.println(skiplist.erase(10));
    System.out.println(skiplist.erase(17));
    System.out.println(skiplist.search(0));
    System.out.println(skiplist.search(5));
    System.out.println(skiplist.erase(8));
    System.out.println(skiplist.search(9));
    System.out.println(skiplist.add(8));
    System.out.println(skiplist.erase(11));
    System.out.println(skiplist.search(10));
    System.out.println(skiplist.erase(11));
    System.out.println(skiplist.search(10));
    System.out.println(skiplist.erase(9));
    System.out.println(skiplist.erase(8));
    System.out.println(skiplist.search(15));
    System.out.println(skiplist.search(14));
    System.out.println(skiplist.add(1));
    System.out.println(skiplist.add(6));
    System.out.println(skiplist.add(17));
    System.out.println(skiplist.add(16));
    System.out.println(skiplist.search(13));
    System.out.println(skiplist.search(4));
    System.out.println(skiplist.search(5));
    System.out.println(skiplist.search(4));
    System.out.println(skiplist.search(17));
    System.out.println(skiplist.search(16));
    System.out.println(skiplist.search(7));
    System.out.println(skiplist.search(14));
    System.out.println(skiplist.search(1));
  }
}
