import java.util.Arrays;

public class SegmentTree {
    int oper = 0;
    int[] tree;
    int n;
    public SegmentTree(int[] array) {
        n = array.length;;
        tree = new int[4*n];
        build(array, 0,0, n-1);
    }


    public void build(int[] a, int ind, int left, int right) {
        if (left == right) {
            tree[ind] = a[left];
        } else {
            int mid = (left + right) / 2;
            build(a,ind * 2 + 1, left, mid);
            build(a, ind * 2 + 2, mid + 1, right);
            tree[ind] = tree[ind * 2 + 1] + tree[ind * 2 + 2];
        }
    }

    public void set(int index, int value) {
        set(index, value, 0, 0, n-1);
    }
    public void remove(int index) {
        set(index, 0);
    }
    public void set(int index, int value, int node, int left, int right) {
        oper+=1;
        if (left == right) {
            tree[node] = value;
        } else {
            int mid = (left + right) / 2;
            if (index <= mid) {
                set(index, value, node * 2 + 1, left, mid);
            } else {
                set(index,value, node* 2 + 2, mid+1,right);
            }
            tree[node] = tree[node * 2 + 1] + tree[node * 2 + 2];
        }
    }
    
    public int sum(int leftIndex, int rightIndex, int x, int xleft, int xright) {
        oper+=1;
        if (rightIndex < xleft || leftIndex > xright) return 0;
        if (xleft >= leftIndex && xright <= rightIndex) return tree[x];
        int xmid = (xleft + xright) / 2;
        return sum(leftIndex, rightIndex, 2 * x + 1, xleft, xmid) + sum(leftIndex, rightIndex, 2 * x + 2, xmid + 1, xright);
    }



    public void add(int[] arr, int value) {
        int[] newArray = Arrays.copyOf(arr, n+1);
        newArray[n] = value;
        n++;
        build(arr, 1, 0, n - 1);
    }


}
