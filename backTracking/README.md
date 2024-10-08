# Backtracking

## Overview
The **Backtracking** technique is used to explore all possible options by incrementally building solutions and abandoning them when they no longer lead to a valid solution. It is widely used in constraint-solving problems like combinations, permutations, and puzzles.

## When to Use:
- When solving problems that involve generating combinations, permutations, or subsets.
- When a problem requires trying out different possibilities and reverting changes if a solution doesn’t work.

## Effective Scenarios:
- Problems involving generating all possible combinations or permutations.
- Solving puzzles or constraint satisfaction problems like N-Queens.
- Exploring different possible paths or configurations.

## How to Recognize Problems that Use Backtracking:
- The problem asks for generating all possible outcomes, paths, combinations, or subsets.
- The problem involves constraints where you need to find all valid configurations.

---

## Basic Problem Types:
1. **Subsets**: Generating all possible subsets of a set.
2. **Permutations**: Generating all possible arrangements of a set of elements.
3. **Combination Sum**: Finding all combinations that sum up to a given target.

### Smart Hacks for Basic Problems:
- Use backtracking when you need to explore all possible subsets, combinations, or arrangements.
- Recursion and pruning are key elements in backtracking to avoid redundant computations.

---

## Advanced Problem Types:
1. **Palindrome Partitioning**: Partition a string such that every substring is a palindrome.
2. **Word Search**: Find if a word exists in a grid of letters.
3. **Sudoku Solver**: Solving a partially filled Sudoku board using backtracking.

### Smart Hacks for Advanced Problems:
- Backtracking is especially useful in constraint satisfaction problems like Sudoku or N-Queens, where you explore valid configurations.
- Problems involving complex paths (like word search) or partitioning often require recursion combined with backtracking to explore valid paths.
