## 01. Fractional Knapsack

The problem can be found at the following link: [Question Link](https://www.geeksforgeeks.org/problems/fractional-knapsack-1587115620/1?utm_source=chatgpt.com)

### Problem Description

**Task:** Given two arrays, val[] and wt[] , representing the values and weights of items, and an integer capacity representing the maximum weight a knapsack can hold, determine the maximum total value that can be achieved by putting items in the knapsack. You are allowed to break items into fractions if necessary.Return the maximum value as a double, rounded to 6 decimal places.Examples :Input: val[] = [60, 100, 120], wt[] = [10, 20, 30], capacity = 50

#### Examples

##### Example 1

- **Output:**
```text
240.000000
```
- **Explanation:** By taking items of weight 10 and 20 kg and 2/3 fraction of 30 kg. Hence total price will be 60+100+(2/3)(120) = 240

##### Example 2

- **Input:**
```text
val[] = [500], wt[] = [30], capacity = 10
```
- **Output:**
```text
166.670000
```
- **Explanation:** Since the item’s weight exceeds capacity, we take a fraction 10/30 of it, yielding value 166.670000.

### Time and Auxiliary Space Complexity

- **Expected Time Complexity:** O(n log n)
- **Expected Auxiliary Space Complexity:** O(n)

### Accepted Solutions (5)

#### Solution 1 (Java)

- **Submitted:** 2026-11-23 13:54:04
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
    public double fractionalKnapsack(int[] val, int[] wt, int capacity) {

        int n = val.length;
    /*
    val[] =
    [1, 5, 7, 2, 7, 10]
    wt[] =
    [4, 9, 6, 3, 7, 3]
    capacity =
    24
    */

        // Value aur weight ko ek saath store karenge
    double[][] items = new double[n][2];

    for (int i = 0; i < n; i++) {
            items[i][0] = val[i];  // value
            items[i][1] = wt[i];   // weight
    }

        /*
        Ab items array: --> RATIO --> val/ wgt
        items[val, wght]
        items[0] = [1, 4]  --> ratio = 1/4 -->0.25
        items[1] = [5, 9] --> ratio = 5/9 ->0.55
        items[2] = [7, 6] --> ratio = 1.16
        items[3] = [2, 3] --> ratio = 0.66
        items[4] = [7, 7] --> ratio = 1
        items[5] = [10,3] --> ratio = 3.33
        Ratio ka matlab: 1 kg lene par kitna profit milega?
        */

        // Highest ratio wala item pehle
        java.util.Arrays.sort(items, (a, b) ->
            Double.compare(b[0] / b[1], a[0] / a[1])
        );

        /*
        Sorting ke baad order:
        items[0] = [10,3] --> ratio = 3.33
        items[1] = [7, 6] --> ratio = 1.16
        items[2] = [7, 7] --> ratio = 1
        items[3] = [2, 3] --> ratio = 0.66
        items[4] = [5, 9] --> ratio = 5/9 ->0.55
        items[5] = [1, 4]  --> ratio = 1/4 -->0.25
        */

        double profit = 0.0;

        // Ek-ek item choose karenge
        for (int i = 0; i < n; i++) {

            if (capacity == 0) {
                break;
            }

            int value = (int) items[i][0]; 
            int weight = (int) items[i][1];
            // i --> 0
            // val = 10; wgt = 3
            // 3 <= 24
            
            // p = 10; c = 21
            // i = 1;
            // val = 7, wt = 6
            // p = 7 + 10 = 17
            // c = 21 - 6 = 15
            
            // i = 2
            // val = 7, wt = 7 
            // p = 17 + 7 = 24
            // c = 15 - 7 = 8
            
            // i = 3
            // val = 2, wt = 3
            // p = 24 + 2 = 26
            // c = 8 - 3 = 5
            
            // i = 4
            // val = 5; wt = 9 ; c = 5
            // 9 < 5
            // p = 5/9 * 5 = 25/9 = 28.777
            // yha p c == 0 honi chahiye bcz 
            // capacity already less than wht h isliye 
            // aapn n val/ wgt *c krke nikala h
            // aur fhr next iteration p capacity 0 hui return krwa do ans;
            
            // 
            if (weight <= capacity) {
                // to aapn ko uski value profit m add krni h
                profit += value;
                // profit = 0 + 10 = 10
                capacity -= weight;
                // capacity = 24 - 3 = 21 
            }
            else{
                profit += (double) value / weight * capacity;
                capacity = 0;
            }
        }

        // FINAL:
        // Total profit = 240.0
        // Remaining capacity = 0
        return profit;
    }
}
```

#### Solution 2 (Java)

- **Submitted:** 2026-11-23 13:53:55
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
    public double fractionalKnapsack(int[] val, int[] wt, int capacity) {

        int n = val.length;
    /*
    val[] =
    [1, 5, 7, 2, 7, 10]
    wt[] =
    [4, 9, 6, 3, 7, 3]
    capacity =
    24
    */

        // Value aur weight ko ek saath store karenge
    double[][] items = new double[n][2];

    for (int i = 0; i < n; i++) {
            items[i][0] = val[i];  // value
            items[i][1] = wt[i];   // weight
    }

        /*
        Ab items array: --> RATIO --> val/ wgt
        items[val, wght]
        items[0] = [1, 4]  --> ratio = 1/4 -->0.25
        items[1] = [5, 9] --> ratio = 5/9 ->0.55
        items[2] = [7, 6] --> ratio = 1.16
        items[3] = [2, 3] --> ratio = 0.66
        items[4] = [7, 7] --> ratio = 1
        items[5] = [10,3] --> ratio = 3.33
        Ratio ka matlab: 1 kg lene par kitna profit milega?
        */

        // Highest ratio wala item pehle
        java.util.Arrays.sort(items, (a, b) ->
            Double.compare(b[0] / b[1], a[0] / a[1])
        );

        /*
        Sorting ke baad order:
        items[0] = [10,3] --> ratio = 3.33
        items[1] = [7, 6] --> ratio = 1.16
        items[2] = [7, 7] --> ratio = 1
        items[3] = [2, 3] --> ratio = 0.66
        items[4] = [5, 9] --> ratio = 5/9 ->0.55
        items[5] = [1, 4]  --> ratio = 1/4 -->0.25
        */

        double profit = 0.0;

        // Ek-ek item choose karenge
        for (int i = 0; i < n; i++) {

            if (capacity == 0) {
                break;
            }

            int value = (int) items[i][0]; 
            int weight = (int) items[i][1];
            // i --> 0
            // val = 10; wgt = 3
            // 3 <= 24
            
            // p = 10; c = 21
            // i = 1;
            // val = 7, wt = 6
            // p = 7 + 10 = 17
            // c = 21 - 6 = 15
            
            // i = 2
            // val = 7, wt = 7 
            // p = 17 + 7 = 24
            // c = 15 - 7 = 8
            
            // i = 3
            // val = 2, wt = 3
            // p = 24 + 2 = 26
            // c = 8 - 3 = 5
            
            // i = 4
            // val = 5; wt = 9 ; c = 5
            // 9 < 5
            // p = 5/9 * 5 = 25/9 = 28.777
            // yha p c == 0 honi chahiye bcz 
            // capacity already less than wht h isliye 
            // aapn n val/ wgt *c krke nikala h
            // aur fhr next iteration p capacity 0 hui return krwa do ans;
            
            // 
            if (weight <= capacity) {
                // to aapn ko uski value profit m add krni h
                profit += value;
                // profit = 0 + 10 = 10
                capacity -= weight;
                // capacity = 24 - 3 = 21 
            }
            else{
                profit += (double) value / weight * capacity;
                capacity = 0;
            }
        }

        // FINAL:
        // Total profit = 240.0
        // Remaining capacity = 0
        return profit;
    }
}
```

#### Solution 3 (Java)

- **Submitted:** 2026-11-23 11:04:39
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
    public double fractionalKnapsack(int[] val, int[] wt, int capacity) {

        int n = val.length;
    /*
    val[] =
    [1, 5, 7, 2, 7, 10]
    wt[] =
    [4, 9, 6, 3, 7, 3]
    capacity =
    24
    */

        // Step 1: Value aur weight ko ek saath store karenge
    double[][] items = new double[n][2];

    for (int i = 0; i < n; i++) {
            items[i][0] = val[i];  // value
            items[i][1] = wt[i];   // weight
    }

        /*
        Ab items array: --> RATIO --> val/ wgt
        items[val, wght]
        items[0] = [1, 4]  --> ratio = 1/4 -->0.25
        items[1] = [5, 9] --> ratio = 5/9 ->0.55
        items[2] = [7, 6] --> ratio = 1.16
        items[3] = [2, 3] --> ratio = 0.66
        items[4] = [7, 7] --> ratio = 1
        items[5] = [10,3] --> ratio = 3.33
        Ratio ka matlab: 1 kg lene par kitna profit milega?
        */

        // Step 2: Highest ratio wala item pehle
        java.util.Arrays.sort(items, (a, b) ->
            Double.compare(b[0] / b[1], a[0] / a[1])
        );

        /*
        Sorting ke baad order:
        items[5] = [10,3] --> ratio = 3.33
        items[2] = [7, 6] --> ratio = 1.16
        items[4] = [7, 7] --> ratio = 1
        items[3] = [2, 3] --> ratio = 0.66
        items[1] = [5, 9] --> ratio = 5/9 ->0.55
        items[0] = [1, 4]  --> ratio = 1/4 -->0.25
        */

        double profit = 0.0;

        // Ek-ek item choose karenge
        for (int i = 0; i < n; i++) {

            if (capacity == 0) {
                break;
            }

            int value = (int) items[i][0];
            int weight = (int) items[i][1];

            if (weight <= capacity) {
                // to aapn ko uski value profit m add krni h
                profit += value;
                capacity -= weight;
            }
            else{
                profit += (double) value / weight * capacity;
                capacity = 0;
            }
        }

        // FINAL:
        // Total profit = 240.0
        // Remaining capacity = 0
        return profit;
    }
}
```

#### Solution 4 (Java)

- **Submitted:** 2026-11-22 22:47:40
- **Status:** Correct
- **Marks:** 0

```java
class Solution {
    public double fractionalKnapsack(int[] val, int[] wt, int capacity) {

        int n = val.length;

        // INPUT:
        // val = [60, 100, 120]
        // wt  = [10, 20, 30]
        // capacity = 50

        // Step 1: Value aur weight ko ek saath store karenge
        double[][] items = new double[n][2];

        for (int i = 0; i < n; i++) {
            items[i][0] = val[i];  // value
            items[i][1] = wt[i];   // weight
        }

        /*
        Ab items array:

        items[0] = [60, 10]  --> ratio = 60/10 = 6
        items[1] = [100, 20] --> ratio = 100/20 = 5
        items[2] = [120, 30] --> ratio = 120/30 = 4

        Ratio ka matlab: 1 kg lene par kitna profit milega?
        */

        // Step 2: Highest ratio wala item pehle
        java.util.Arrays.sort(items, (a, b) ->
            Double.compare(b[0] / b[1], a[0] / a[1])
        );

        /*
        Sorting ke baad order:
        [60, 10] --> ratio 6
        [100, 20] --> ratio 5
        [120, 30] --> ratio 4

        */

        double profit = 0.0;

        // Step 3: Ek-ek item choose karenge
        for (int i = 0; i < n; i++) {

            if (capacity == 0) {
                break;
            }

            int value = (int) items[i][0];
            int weight = (int) items[i][1];

            if (weight <= capacity) {

                // DRY RUN 1:
                // i = 0
                // value = 60, weight = 10
                // capacity = 50
                // 10 <= 50 --> poora item le sakte hain
                //
                // profit = 0 + 60 = 60
                // capacity = 50 - 10 = 40
                //
                // Ab profit = 60, capacity = 40

                // DRY RUN 2:
                // i = 1
                // value = 100, weight = 20
                // capacity = 40
                // 20 <= 40 --> poora item le sakte hain
                //
                // profit = 60 + 100 = 160
                // capacity = 40 - 20 = 20
                //
                // Ab profit = 160, capacity = 20

                profit += value;
                capacity -= weight;

            } else {

                // DRY RUN 3:
                // i = 2
                // value = 120, weight = 30
                // capacity = 20
                // 30 <= 20 --> FALSE
                //
                // Poora item nahi le sakte.
                // Sirf 20 kg ka fraction lenge.
                //
                // Profit = (120 / 30) * 20
                //        = 4 * 20
                //        = 80
                //
                // Total profit = 160 + 80 = 240
                // capacity = 0

                profit += (double) value / weight * capacity;
                capacity = 0;
            }
        }

        // FINAL:
        // Total profit = 240.0
        // Remaining capacity = 0
        return profit;
    }
}
```

#### Solution 5 (Java)

- **Submitted:** 2026-11-22 22:42:18
- **Status:** Correct
- **Marks:** 2

```java
class Solution {
    public double fractionalKnapsack(int[] val, int[] wt, int capacity) {

        int n = val.length;

        // Step 1: Highest value/weight ratio pehle
        double[][] items = new double[n][2];

        for (int i = 0; i < n; i++) {
            items[i][0] = val[i];
            items[i][1] = wt[i];
        }

        // Step 2: Descending order mein sort karo
        java.util.Arrays.sort(items, (a, b) ->
            Double.compare(b[0] / b[1], a[0] / a[1])
        );

        double profit = 0.0;

        // Step 3: Items choose karo
        for (int i = 0; i < n; i++) {

            if (capacity == 0) {
                break;
            }

            int value = (int) items[i][0];
            int weight = (int) items[i][1];

            if (weight <= capacity) {
                // Poora item le lo
                profit += value;
                capacity -= weight;
            } else {
                // Bacha hua fractional part lo
                profit += (double) value / weight * capacity;
                capacity = 0;
            }
        }

        return profit;
    }
}
```

*Generated on: 23/11/2026, 1:54:45 pm*