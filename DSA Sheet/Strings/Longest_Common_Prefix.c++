#include <iostream>
#include <vector>
#include <string>

using namespace std;

class Solution {
public:
    string common(const string& s1, const string& s2) {
        int n = min(s1.length(), s2.length());
        string result;
        for (int i = 0; i < n; i++) {
            if (s1[i] == s2[i]) {
                result += s1[i];
            } else {
                break;
            }
        }
        return result;
    }

    string longestCommonPrefix(const vector<string>& strs) {
        if (strs.empty()) return "";
        string result = strs[0];
        for (int i = 1; i < strs.size(); i++) {
            result = common(result, strs[i]);
            if (result.empty()) break;
        }
        return result;
    }
};

int main() {
    Solution sol;

    vector<string> strs1 = {"flower", "flow", "flight"};
    vector<string> strs2 = {"dog", "racecar", "car"};
    vector<string> strs3 = {"interspecies", "interstellar", "interstate"};
    vector<string> strs4 = {};

    cout << "Longest Common Prefix (Test 1): " << sol.longestCommonPrefix(strs1) << endl; 
    cout << "Longest Common Prefix (Test 2): " << sol.longestCommonPrefix(strs2) << endl; 
    cout << "Longest Common Prefix (Test 3): " << sol.longestCommonPrefix(strs3) << endl; 

    return 0;
}
