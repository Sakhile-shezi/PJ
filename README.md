# Tic-Tac-Toe (Java Swing)

A classic two-player desktop Tic-Tac-Toe game built with Java Swing and AWT. Players alternate turns as **X** and **O** on a dark-themed 3×3 grid with automatic win/draw detection and instant round resets.

## Features

- **Two-Player Local Gameplay:** Alternates turns between Player `X` and Player `O` with live turn and result announcements.
- **Automated Win & Draw Detection:** Evaluates all rows, columns, and diagonals after every move and locks the board once a round ends.
- **Quick Reset Controls:** Includes a dedicated **Replay** button after each match as well as a top menu bar (`Options` → `Restart` / `Exit`).
- **Clean Desktop UI:** Built using `JFrame`, `GridLayout`, and `BorderLayout` with a custom dark cell theme.

## Project Structure

```text
PJ/
├── TictTacToe/
│   └── src/
│       └── tic1/
│           └── TicTacToe.java
└── README.md
```

## Prerequisites

- **Java Development Kit (JDK) 8 or higher** installed and added to your system `PATH`.

## Getting Started

### Option A: Run from Releases (No Compiling Required)
1. Go to the **[Releases](../../releases)** section of this repository.
2. Download the latest `TicTacToe.jar` file.
3. Double-click `TicTacToe.jar` to launch the game, or run:
   ```bash
   java -jar TicTacToe.jar
   ```

### Option B: Compile and Run from Source
1. Clone the repository:
   ```bash
   git clone [https://github.com/Sakhile-shezi/PJ.git](https://github.com/Sakhile-shezi/PJ.git)
   cd PJ/TictTacToe
   ```
2. Compile the source file:
   ```bash
   javac -d out src/tic1/TicTacToe.java
   ```
3. Run the application:
   ```bash
   java -cp out tic1.TicTacToe
   ```

## Author

- **Sakhile Shezi** — [@Sakhile-shezi](https://github.com/Sakhile-shezi)
