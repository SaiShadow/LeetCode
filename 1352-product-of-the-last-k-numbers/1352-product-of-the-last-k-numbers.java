class ProductOfNumbers {
    List<Integer> list;

    public ProductOfNumbers() {
        this.list = new ArrayList<>();
        list.add(1);
    }

    public void add(int num) {
        if (num == 0) {
            list.clear();
            list.add(1);
            return;
        }
        int last = list.get(list.size() - 1);
        list.add(last * num);
    }

    public int getProduct(int k) {
        if (k >= list.size()) {
            return 0;
        }
        int last = list.get(list.size() - 1);
        int kLast = list.get(list.size() - 1 - k);
        return last / kLast;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */