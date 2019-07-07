package com.topics.math;

public class Pow {
    public static void main(String[] args) {
        System.out.println(powRecursive(2, -3));
    }

    // iterative solution
    static double powIterative(int x, int n) {
        long N = n;
        double X = x;
        if (N < 0) {
            N = -N;
            X = 1/X;
        }

        double res = 1;
        double product = X;
        for (long i = N; i > 0; i /= 2) {
            if (i % 2 == 1) {
                res *= product;
            }
            product *= product;
        }
        return res;
    }

    // recursive solution
    static double powRecursive(int x, int n) {
        long N = n;
        double X = x;
        if (n < 0) {
            X = 1/X;
            N = -N;
        }
        return N == 0 ? 1 : iterativeHelper(X, N);
    }

    // static double powRecursiveHelper(double x, long n) {
    //     if (n == 0) {
    //         return 1;
    //     }
    //     double temp = powRecursiveHelper(x, n/2);
    //     if (n % 2 == 0) {
    //         return temp * temp;
    //     }
    //     return x * temp * temp;
    // }

    static double powRecursiveHelper2(double x, long n) {
        if (n == 1) {
            return x;
        }
        if (n % 2 == 0) {
            return powRecursiveHelper2(x*x, n/2);
        }
        return x * powRecursiveHelper2(x*x, n/2);
    }

    static double iterativeHelper(double x, long n) {
        double res = 1;
        for (long i = n; i > 0; i /= 2) {
            if (i % 2 == 1) {
                res *= x;
            }
            x *= x;
        }
        return res;
    }
}
