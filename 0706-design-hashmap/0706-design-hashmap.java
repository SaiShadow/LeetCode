    class MyHashMap {

        private List<int[]> map;

        public MyHashMap() {
            map = new ArrayList<>();
        }

        public void put(int key, int value) {

            for (int[] arr : map) {
                if (arr[0] == key) {
                    arr[1] = value;
                    return;
                }
            }

            map.add(new int[] { key, value });
        }

        private int contains(int key) {

            int i = 0;

            for (int[] arr : map) {

                if (arr[0] == key) {
                    return i;
                }
                i++;
            }
            return -1;
        }

        public int get(int key) {

            for (int[] arr : map) {

                if (arr[0] == key) {
                    return arr[1];
                }
            }
            return -1;

        }

        public void remove(int key) {

            int index = contains(key);
            if (index != -1) {
                map.remove(index);
            }
        }
    }