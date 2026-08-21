<h2><a href="https://www.geeksforgeeks.org/problems/parenthesis-checker2744/1?utm=codolio">Parenthesis Checker</a></h2><h3>Difficulty Level : Difficulty: Easy</h3><hr><div class="problems_problem_content__Xm_eO" style="--text-color: var(--problem-text-color);"><p><span style="font-size: 14pt;">Given a string <strong>s</strong>, composed of different combinations of '(' , ')', '{', '}', '[', ']'. Determine whether the Expression is <strong>balanced </strong>or not.<br>An expression is balanced if:</span></p>
<ol>
<li><span style="font-size: 14pt;">Each opening bracket has a corresponding closing bracket of the same type.</span></li>
<li><span style="font-size: 14pt;">Opening brackets must be closed in the correct order.</span></li>
</ol>
<p><span style="font-size: 14pt;"><strong>Examples :</strong></span></p>
<pre><span style="font-size: 14pt;"><strong>Input: </strong>s = "[{()}]"
<strong>Output:</strong> true
<strong>Explanation: </strong>All the brackets are well-formed.</span></pre>
<pre><span style="font-size: 14pt;"><strong>Input: </strong>s = "[()()]{}"
<strong>Output:</strong> true
<strong>Explanation: </strong>All the brackets are well-formed.<br></span></pre>
<pre><span style="font-size: 14pt;"><strong>Input:</strong> s = "([]"<br><strong>Output: </strong>false<br><strong>Explanation: </strong>The expression is not balanced as there is a missing ')' at the end.<br></span></pre>
<pre><span style="font-size: 14pt;"><strong>Input:</strong> s = "([{]})"<br><strong>Output: </strong>false<br><strong>Explanation: </strong>The expression is not balanced as there is a closing ']' before the closing '}'.<br></span></pre>
<p><span style="font-size: 14pt;"><strong>Constraints:</strong><br>1 ≤ s.size() ≤ 10<sup>6<br></sup>s[i] ∈ {'{', '}', '(', ')', '[', ']'}</span></p></div><p><span style=font-size:18px><strong>Company Tags : </strong><br><code>Flipkart</code>&nbsp;<code>Amazon</code>&nbsp;<code>Microsoft</code>&nbsp;<code>OYO Rooms</code>&nbsp;<code>Snapdeal</code>&nbsp;<code>Oracle</code>&nbsp;<code>Walmart</code>&nbsp;<code>Adobe</code>&nbsp;<code>Google</code>&nbsp;<code>Yatra.com</code>&nbsp;<br><p><span style=font-size:18px><strong>Topic Tags : </strong><br><code>Strings</code>&nbsp;<code>Stack</code>&nbsp;<code>STL</code>&nbsp;