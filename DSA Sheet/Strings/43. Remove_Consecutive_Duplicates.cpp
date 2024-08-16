#include <iostream>
#include <string>

using namespace std;

string removeConsecutiveDuplicates(const string& s) {
    string result;
    for (int i = 0; i < s.size(); i++) {
        if (i == 0 || s[i] != s[i - 1]) {
            result += s[i];
        }
    }
    return result;
}

int main() {
    string s = "aabbccdde";
    string result = removeConsecutiveDuplicates(s);
    cout << result << endl; 
    return 0;
}
