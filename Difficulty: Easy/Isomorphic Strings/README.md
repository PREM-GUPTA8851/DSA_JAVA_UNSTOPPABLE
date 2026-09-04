<h2><a href="https://www.geeksforgeeks.org/problems/isomorphic-strings-1587115620/1?utm=codolio">Isomorphic Strings</a></h2><h3>Difficulty Level : Difficulty: Easy</h3><hr><div class="problems_problem_content__Xm_eO" style="--text-color: var(--problem-text-color);"><p><span style="font-size: 18.6667px;">Given two strings <strong>s1</strong> and <strong>s2</strong> consisting only of lowercase English letters and having the same length, check whether they are isomorphic. </span><span style="font-size: 18.6667px;">Two strings are isomorphic if:</span></p>
<ul>
<li><span style="font-size: 18.6667px;">Each character in s1 must always map to the same character in s2.</span></li>
<li><span style="font-size: 18.6667px;">No two different characters in s1 can map to the same character in s2.</span></li>
<li><span style="font-size: 18.6667px;">A character may map to itself.</span></li>
</ul>
<p><span style="font-size: 18.6667px;">Return true if s1 and s2 are isomorphic, otherwise return false.</span></p>
<p><span style="font-size: 14pt;"><strong>Examples:</strong></span></p>
<pre><span style="font-size: 14pt;"><strong>Input: </strong>s1 = "aab", s2 = "xxy"
<strong>Output: </strong>true<strong>
Explanation: </strong>Each character in s1 can be consistently mapped to a unique character in s2 (a -&gt; x, b -&gt; y).
</span></pre>
<pre><span style="font-size: 14pt;"><strong>Input: </strong>s1 = "aab", s2 = "xyz"
<strong>Output: </strong>false<strong>
Explanation: </strong>S</span><span style="font-size: 18.6667px;">ame character 'a' in s1 maps to two different characters 'x' and 'y' in s2.</span></pre>
<pre><span style="font-size: 14pt;"><strong>Input: </strong>s1 = "abc", s2 = "xxz"
<strong>Output: </strong>false<strong>
Explanation: </strong>Two different characters 'a' and 'b' in s1 maps with same character 'x' in s2. </span></pre>
<p><span style="font-size: 14pt;"><strong>Constraints:</strong><br>1 ≤ s1.size() = s2.size() ≤ 10<sup>5</sup></span></p></div><p><span style=font-size:18px><strong>Company Tags : </strong><br><code>Google</code>&nbsp;<br><p><span style=font-size:18px><strong>Topic Tags : </strong><br><code>Strings</code>&nbsp;<code>Hash</code>&nbsp;