# Department Top Three Salaries

## Metadata
![Difficulty: Hard](https://img.shields.io/badge/Difficulty-Hard-red?style=flat-square)
[![Topic: Database](https://img.shields.io/badge/Topic-Database-blue?style=flat-square)](https://leetcode.com/tag/database/)

- **LeetCode Link**: [https://leetcode.com/problems/department-top-three-salaries/](https://leetcode.com/problems/department-top-three-salaries/)
- **Problem ID**: 185
- **Language**: Mysql

## Solution Design

### Method Explanation
- *We solve this problem by leveraging standard data structures or algorithms suitable for the problem constraints.*
- *Make sure to update this section with notes on your implementation approaches.*

### Complexity Analysis
- **Time Complexity**: \(O(N)\) (where \(N\) is the number of elements)
- **Space Complexity**: \(O(1)\) auxiliary space

## Solution Code

```mysql
SELECT Department, Employee, Salary
FROM (
    SELECT 
        d.name AS Department,
        e.name AS Employee,
        e.salary AS Salary,
        DENSE_RANK() OVER (PARTITION BY d.name ORDER BY Salary DESC) AS rnk
    FROM Employee e
    JOIN Department d
    ON e.departmentId = d.id
) AS rnk_tbl
WHERE rnk <= 3;
```
