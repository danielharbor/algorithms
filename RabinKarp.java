public class RabinKarp {
    public static void main(String[] args) {
        System.out.println(contains("helloworld", "hello"));
    }

    static int getCharHash(char c) {
        return (c * 421); // using a random prime here
    }

    static int getHash(String str) {
        int hash = 0;
        for (char c : str.toCharArray()) {
            hash += getCharHash(c);
        }
        return hash;
    }

    static boolean compareChars(String str, String key, int start, int end) {
        for (int i=start, j=0; i < end; i++,j++) {
            if (str.charAt(i) != key.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    static boolean contains(String str, String key) {
        if (key.length() > str.length()) {
            return false;
        }
        int keyHash = getHash(key);
        int strHash = getHash(str.substring(0, key.length()));
        int firstCharIndex = 0;
        int lastCharIndex = key.length()-1;
        while (lastCharIndex < str.length()) {
            // found a hash match. now compare each character.
            if (keyHash == strHash) {
                if (compareChars(str, key, firstCharIndex, lastCharIndex+1)) {
                    return true;
                }
            }
            if (++lastCharIndex < str.length()) {
                strHash = strHash - getCharHash(str.charAt(firstCharIndex++)) + getCharHash(str.charAt(lastCharIndex));
            }
        }
        return false;
    }
}
