# Word Ladder II

## Metadata
![Difficulty: Hard](https://img.shields.io/badge/Difficulty-Hard-red?style=flat-square)
[![Topic: Hash Table](https://img.shields.io/badge/Topic-Hash Table-blue?style=flat-square)](https://leetcode.com/tag/hash-table/) [![Topic: String](https://img.shields.io/badge/Topic-String-blue?style=flat-square)](https://leetcode.com/tag/string/) [![Topic: Backtracking](https://img.shields.io/badge/Topic-Backtracking-blue?style=flat-square)](https://leetcode.com/tag/backtracking/) [![Topic: Breadth-First Search](https://img.shields.io/badge/Topic-Breadth-First Search-blue?style=flat-square)](https://leetcode.com/tag/breadth-first-search/)

- **LeetCode Link**: [https://leetcode.com/problems/word-ladder-ii/](https://leetcode.com/problems/word-ladder-ii/)
- **Problem ID**: 126
- **Language**: Python3

## Solution Design

### Method Explanation
- *We solve this problem by leveraging standard data structures or algorithms suitable for the problem constraints.*
- *Make sure to update this section with notes on your implementation approaches.*

### Complexity Analysis
- **Time Complexity**: \(O(N)\) (where \(N\) is the number of elements)
- **Space Complexity**: \(O(1)\) auxiliary space

## Solution Code

```python
class Solution:
    def findLadders(self, beginWord: str, endWord: str, wordList: List[str]) -> List[List[str]]:
        depthMap = {}
        ans = []
        
        def dfs(word, seq):
            if word == beginWord:
                ans.append(seq[::-1])
                return
            
            steps = depthMap[word]
            for i in range(len(word)):
                original = word[i]
                for ch in 'abcdefghijklmnopqrstuvwxyz':
                    word = word[:i] + ch + word[i+1:]
                    if word in depthMap and depthMap[word] + 1 == steps:
                        seq.append(word)
                        dfs(word, seq)
                        seq.pop()
                word = word[:i] + original + word[i+1:]

        wordSet = set(wordList)
        q = deque([beginWord])
        depthMap[beginWord] = 1
        wordSet.discard(beginWord) 
        
        while q:
            word = q.popleft()
            steps = depthMap[word]
            if word == endWord:
                break
            for i in range(len(word)):
                original = word[i]
                for ch in 'abcdefghijklmnopqrstuvwxyz':
                    word = word[:i] + ch + word[i+1:]
                    if word in wordSet:
                        q.append(word)
                        wordSet.discard(word)
                        depthMap[word] = steps + 1  
                word = word[:i] + original + word[i+1:] 
        

        if endWord in depthMap:
            seq = [endWord]
            dfs(endWord, seq)
        
        return ans












```
