# Java Text Adventure

A command-line prison escape game written in Java. You wake up in a dark cell after a riot. Your cell door is open, but escaping the prison means exploring rooms, collecting items, and figuring out how to unlock the exit.

## Run the game

From the repository root, run:

```bash
bash run.sh
```

## How to play

Type `look` to inspect your starting room, then try `move north` to leave the cell. Read each room description for clues about exits and objects you can inspect. If you get stuck, type `hint` for a clue about your current room.

Some commands ask for a second line of input. For example, to inspect a table, type `look feature`, press Enter, then type `table` when prompted.

| Command | What it does |
| --- | --- |
| `look` | Describes your current room. |
| `move north`, `move east`, `move south`, `move west` | Moves in the chosen direction if the route is open. |
| `look feature` | Prompts for a feature in the room to inspect. |
| `look item` | Prompts for the name of an item to examine. |
| `take item` | Prompts for the name of an item to pick up. |
| `inventory` | Shows the items you’re carrying. |
| `map` | Shows the rooms you’ve explored. |
| `hint` | Gives a clue based on your current room. |
| `score` | Displays your current score. |
| `help` | Lists the basic commands. |
| `quit` | Exits the game. |

As you find items and clues, the game also accepts `use red and blue key`, `use crowbar`, and `enter password`. The last command prompts you to enter the four-digit code on a separate line.

