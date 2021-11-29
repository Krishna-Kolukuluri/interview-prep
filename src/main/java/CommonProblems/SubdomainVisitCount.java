package CommonProblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
*
A website domain "discuss.leetcode.com" consists of various subdomains. At the top level, we have "com", at the next
* level, we have "leetcode.com" and at the lowest level, "discuss.leetcode.com". When we visit a domain like
* "discuss.leetcode.com", we will also visit the parent domains "leetcode.com" and "com" implicitly.

A count-paired domain is a domain that has one of the two formats "rep d1.d2.d3" or "rep d1.d2" where rep is the number
* of visits to the domain and d1.d2.d3 is the domain itself.

For example, "9001 discuss.leetcode.com" is a count-paired domain that indicates that discuss.leetcode.com was visited
* 9001 times.
Given an array of count-paired domains cpdomains, return an array of the count-paired domains of each subdomain in the
* input. You may return the answer in any order.
*
* */
public class SubdomainVisitCount {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> counts = new HashMap();
        for (String domain: cpdomains) {
            String[] cpinfo = domain.split("\\s+");
            String[] frags = cpinfo[1].split("\\.");
            int count = Integer.valueOf(cpinfo[0]);
            String cur = "";
            for (int i = frags.length - 1; i >= 0; --i) {
                cur = frags[i] + (i < frags.length - 1 ? "." : "") + cur;
                counts.put(cur, counts.getOrDefault(cur, 0) + count);
            }
        }

        List<String> ans = new ArrayList();
        for (String dom: counts.keySet())
            ans.add("" + counts.get(dom) + " " + dom);
        return ans;
    }
}
/*
*
Complexity Analysis

Time Complexity: O(N)O(N), where NN is the length of cpdomains, and assuming the length of cpdomains[i] is fixed.

Space Complexity: O(N)O(N), the space used in our count.
*
* */
