class Solution {

        public static boolean areSentencesSimilar(String sentence1, String sentence2) {
            if (sentence1.equals(sentence2) || sentence1.isEmpty() || sentence2.isEmpty()) {
                return true;
            }

            String[] sentence1Words = sentence1.split(" ");
            String[] sentence2Words = sentence2.split(" ");

            // Find out who is smaller and make s1 smaller
            if (sentence1Words.length > sentence2Words.length) {
                return areSimilar(sentence2Words, sentence1Words);
            }else{
                return areSimilar(sentence1Words, sentence2Words);
            }
        }

        static boolean areSimilar(String[] small, String[] big) {
            int start = 0;
            while (start < small.length && small[start].equals(big[start])) {
                start++;
            }
            int end = small.length - 1;
            while (end >= 0 && small[end].equals(big[end+ big.length-small.length])) {
                end--;
            }

            return start > end;

    }

}