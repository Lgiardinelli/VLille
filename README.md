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
- **Deux visitors** de station (les visiteurs tels que voleur et les visiteurs du type de véhicule pour louer un type de véhicule souhaité).
- **Un état de chaque station**.
- **Un décorateur de véhicule** (panier, etc...).
- **Un état des véhicules**.
- **Un builder** pour la création de véhicules.
- **Un visitor de véhicule** (par exemple pour le réparateur).

##### Strategy de Redistribution

Pour équilibrer les véhicules entre stations, deux stratégies principales de redistribution ont été définies. Ces stratégies interviennent lorsque des stations deviennent pleines ou vides.

- **Redistribution Aléatoire** :
  - **Stations pleines** : Une station pleine redistribue un nombre aléatoire de véhicules, compris entre 2 et la capacité maximale du nombre de véhicules de la station, vers des stations choisies aléatoirement parmi celles qui ne sont pas pleines.
  - **Stations vides** : Une station vide reçoit un nombre aléatoire de véhicules, compris entre 2 et la capacité maximale du nombre de véhicules de la station, provenant des stations qui ne sont pas vides.

- **Redistribution Round-Robin** :
  - **Stations pleines** : Une station pleine redistribue la moitié de sa capacité maximale, véhicule par véhicule, vers les stations les plus vides parmi les autres.
  - **Stations vides** : Une station vide reçoit des véhicules un par un, jusqu'à atteindre la moitié de sa capacité maximale, en provenance des stations les plus pleines.


---

### Points à mettre en avant pour valoriser le projet
