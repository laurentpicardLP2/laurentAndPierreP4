# laurentAndPierreP4
Jeu puissance 4

## main
un objet Grid et un ensemble d’objets players
un HashMap dicoToken associant un symbole visualisable à chaque joueur
une boucle infinie dans laquelle le résultat d’un modulo (nbCoups%nbPlayer) invite chaque joueur à jouer à tour de rôle 
il est mis fin au programme lorsqu’un des joueurs a gagné ou s’il y a égalité

## grid
int[][] grid : représente la trame visuelle du jeu
int[] levelColumns  : image du taux de remplissage de chaque colonne (initialisé à nbRow puis est décrémenté à chaque ajout d’un jeton, colonne pleine si 0)
initGrid() : méthode initialisant à 0 tous les éléments de grid[][]
showGrid() : affiche la grille après chaque coup d’un joueur. Est appelé depuis la méthode Players[i].play()
addToken() : stocke l’id du player dans la cellule correspondant de grid[][] et fait décrémenter le compteur de la colonne correspondante de levelColumns 

## player
le constructeur procède aux appels des méthodes initialisant les informations relatives à chaque joueur (name, attribut d’un Player, et choix du symbole qui s’affichichera dans la grille. Cette infos n’est pas propre à un Player, mais est stocké dans la variable static dicoToken de Puissance4
play(Grid grid) : demande à un joueur de choisir une colonne (gestion des mauvaises saisies) et appelle 
isVictory(grid) qui indique si le joueur a gagné (condition d’arrêt du programme) ou sinon 
appelle grid.isFull(), pour voir si tous les éléments du tableau levelColumns[i] sont à 0, auquel cas il y égalité (condition d’arrêt du programme) ou sinon
renvoie false au main(Puissance 4) qui fait passer la main au joueur suivant

isVictory(Grid grid) : indique s’il y a ou non victoire selon l’une des quatre éventualités suivantes : 
4 pions alignés verticalement
4 pions alignés horizontalement
4 pions alignés en diagonale dans la direction bas-gauche vers haut-droit
4 pions alignés en diagonale dans la direction haut-gauche vers bas-droit

