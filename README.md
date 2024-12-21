GIARDINELLI Léo  
JOLY Evan

Semaine 
Squelette de certaines classes


### Semaine du 28/10 au 3/10

- ajout squelette et doc pour les vehicles 
- ajout squelette et doc pour les Creators 
- ajout squelette et doc pour les VehicleVisitor
- ajout squelette et doc pour les Equipments


### Strategy de redistribution
Pour la stratégie de redistribution, nous avons défini deux types : une redistribution **aléatoire** et une autre **round-robin**. Ces stratégies s'appliquent uniquement lorsque des stations sont soit pleines, soit vides.

- **Redistribution aléatoire** :
    - Si une station est pleine, elle redistribue un nombre aléatoire de véhicules (entre 2 et 5 inclus) vers des stations sélectionnées aléatoirement parmi celles qui ne sont pas pleines.
    - À l'inverse, si une station est vide, elle reçoit un nombre aléatoire de véhicules (entre 2 et 5 inclus) prélevés parmi les stations qui ne sont pas vides.

- **Redistribution round-robin** :
    - Si une station est pleine, elle redistribue la moitié de sa capacité maximale, véhicule par véhicule, vers les stations les plus vides parmi les autres.
    - À l'inverse, si une station est vide, elle reçoit des véhicules, un par un, jusqu'à atteindre la moitié de sa capacité maximale, en provenance des stations les plus pleines.









