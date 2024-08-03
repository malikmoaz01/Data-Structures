#include <bits/stdc++.h>
using namespace std;

int main() {
    int n;
    cin >> n;
    int p = n - 1;
    long long total = 0, sum1 = 0;

    for (int i = 0; i < p; i++) {
        cin >> total;
        sum1 += total;
    }

    long long sum = static_cast<long long>(n) * (n + 1) / 2;
    cout << sum - sum1 << endl;

    return 0;
}
