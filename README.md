# Projet COO 2024

## GIARDINELLI Léo & JOLY Evan

### Introduction sur le sujet du projet

Le projet consiste à mettre en œuvre les différents design patterns vus en cours et à les appliquer dans un cadre concret. Il s'agit également de comprendre quelle solution implémenter dans chaque situation et de justifier son choix.

Pour ce projet, nous avons conçu un système de gestion de location de véhicules similaire à v'Lille. Dans ce projet, il y a 10 stations définies dans le `main`. Chaque station contient un nombre aléatoire maximum de véhicules, compris entre 10 et 20, répartis en différents types. Les utilisateurs peuvent louer ou déposer des véhicules dans une station, et ils peuvent choisir le type de véhicule qu'ils souhaitent louer.

---

### HowTo

Rubrique « HowTo » décrivant les étapes principales :
- Récupération des sources du projet depuis le dépôt.
- Génération de la documentation.
- Compilation et exécution des sources.
- Compilation et exécution des tests.
- Génération et exécution de l’archive (.jar) du projet.

---

### Éléments de code saillant

#### Éléments de conception intéressants/importants

- Gestion des interactions complexes entre stations, utilisateurs et visiteurs indésirables.
- Modularité et réutilisabilité des composants du projet.
- Respect des principes de programmation orientée objet pour une architecture évolutive.

#### Présentation des principes de conception mis en œuvre

- **Stratégie de redistribution** (deux méthodes, une aléatoire et l'autre round robin).
- **Un observeur** pour la notification des stations au controlCenter.
- **Un visitors** de station (les visiteurs tels que voleur) qui n'est pas vraiment un visiteur car agi toujours sur un même type de station.
- **Un ClientStation** qui est un peu comme un visiteur mais que n'a pas de méthode accept car visit uniquement le même type de station 
- **Un état de chaque station**.
- **Un décorateur de véhicule** (panier, etc...).
- **Un état des véhicules**.
- **Un builder** pour la création de véhicules notamment géré des id unique.
- **Un visitor de véhicule** (par exemple pour le réparateur).

##### Strategy de Redistribution

Pour équilibrer les véhicules entre stations, deux stratégies principales de redistribution ont été définies. Ces stratégies interviennent lorsque des stations deviennent pleines ou vides.

- **Redistribution Aléatoire** :
  - **Stations pleines** : Une station pleine redistribue un nombre aléatoire de véhicules, compris entre 2 et la capacité maximale du nombre de véhicules de la station, vers des stations choisies aléatoirement parmi celles qui ne sont pas pleines.
  - **Stations vides** : Une station vide reçoit un nombre aléatoire de véhicules, compris entre 2 et la capacité maximale du nombre de véhicules de la station, provenant des stations qui ne sont pas vides.

- **Redistribution Round-Robin** :
  - **Stations pleines** : Une station pleine redistribue la moitié de sa capacité maximale, véhicule par véhicule, vers les stations les plus vides parmi les autres.
  - **Stations vides** : Une station vide reçoit des véhicules un par un, jusqu'à atteindre la moitié de sa capacité maximale, en provenance des stations les plus pleines.


##### L'obersever

Afin de gérer les différentes notifications qu'une station peut envoyer au ControlCenter, comme un ajout, un véhicule qui est loué, lorsque qu'une station est pleine ou vide, et donc mettre à jour les différents attributs de notre Control Center.

##### Les visiteurs de station et de vehicle

Nous avons décidé de gérer séparément les différentes actions que l'on pourrait réaliser sur des stations et des véhicules grâce au visiteur. Dans l'implémentation, seul le VehicleVisitor est un vrai visiteur, car il peut agir différemment selon le type de véhicule qu'il va visiter. Dans le cas des stations, c'est juste une classe qui permet de gérer des événements sur des stations. Toutes ces actions sont ensuite gérées dans le ControlCenter, qui peut, grâce à des méthodes dédiées à chaque événement, lancer tout type d'événement sur les stations et sur les véhicules.
##### Client Station

Un point clé du projet était de gérer les différents véhicules dans la station : comment les retirer, avoir le type de véhicule que l'on veut, etc.

Pour réaliser cela, nous avions au départ pensé à ajouter un état dans Station qui gérerait quel type de véhicule on voulait renvoyer avec rentVehicle. Or, cela n'avait pas trop de sens de donner la responsabilité à la station de renvoyer tel type de véhicule.

C'est pour cela que nous avons décidé à la base de gérer cela comme un visiteur de Station, dont la méthode visit nous permettrait de renvoyer le véhicule du type souhaité selon le visiteur choisi. Or, ces deux visiteurs n'avaient rien à voir, car les deux ne devaient pas forcément implémenter les mêmes méthodes.

Au final, nous avons donc séparé ce visiteur et l'avons placé dans un package à part entière. Ce visiteur permet donc de retirer un véhicule du type que l'on veut et de le récupérer. Pour faire cela, nous utilisons une interface anonyme avec une méthode de test qui effectue un instanceof pour vérifier la présence d'un véhicule voulu dans une station.

Sachant que, comme pour le visiteur de station, ils n'ont de visiteur que le nom, car ils ne se comportent pas réellement de la même manière.


##### Etat station

Les etats des stations sont au nombre de 3, il nous permete gere le cas ou elle sont vide, pleine ou aucun des deux, et donc d'adapter les differente méthode de la classe en fonction de l'etat de la station comment savoir si on peut louer un vehicle ou si elle vide et donc que rien ne peut être loué.

##### Vehicle Equipement

Afin de géré les equipement dans le vehicle nous avons utiliser un decorateur, ce decorateura ajoute au fur et a mesure des eencapsulation différent equipement affiché dans une chaine de caractère 

---

### Points à mettre en avant pour valoriser le projet
