tpNeuneu
========

Second TP of Object - The loft and the Neuneus -

Authors : Nicolas DAVID and Sébastien COHENDET

Majors functionnalities :

- food is at the bottom of each case wheras neuneu are at the top
- colors for each neuneu and food :
    * erratique are red
    * vorace are magenta
    * cannibale are black
    * rabbits are yellow
    * green and blue represents the foods (2 types of food/beverages) (not really implemented in the eating process)
- Graveyard of dead neuneu, on the right of the windows
- more than one neuneu can be on a single case (for all purpose : reproduction, eating each other)
- giving birth need a certain amount of energy and the baby has 50% of energy (called "niveau")
- when th enourriture is empty (level to 0), the box is empty

Caution : if the level needed to reproduce is low (20 for instance), as they are several neuneu at the same case, an infinite loop of new neuneu begins, since children born with level of 50.
So reproduce before dying !
