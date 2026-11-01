class Solution {
    public void duplicateZeros(int[] arr) {
        int possibleZeros = 0;
        int length = arr.length - 1;

        // Step 1: Count the zeros that will be duplicated within the array bounds
        for (int i = 0; i <= length - possibleZeros; i++) {
            if (arr[i] == 0) {
                // Edge case: if the zero is at the boundary and cannot be duplicated
                if (i == length - possibleZeros) {
                    arr[length] = 0; // copy it to the end without duplication
                    length--;
                    break;
                }
                possibleZeros++;
            }
        }

        // Step 2: Copy elements from back to front
        int last = length - possibleZeros;
        for (int i = last; i >= 0; i--) {
            if (arr[i] == 0) {
                arr[i + possibleZeros] = 0;
                possibleZeros--;
                arr[i + possibleZeros] = 0;
            } else {
                arr[i + possibleZeros] = arr[i];
            }
        }
    }
}
