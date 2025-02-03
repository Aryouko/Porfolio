import random
import time

################### Message de bienvenue et d'explication ##################

def message_bie():
    print("""
----------------------------------------------------------------------------
                        Règles du jeu de Marienbad
----------------------------------------------------------------------------
Règles : 1 - Deux joueurs s'affrontent à tour de rôle.
         2 - L'ordinateur commence.
         3 - Le joueur peut retirer un ou plusieurs bâtons, mais seulement dans une seule rangée.
         4 - Celui qui prend la dernière allumette gagne la partie.
----------------------------------------------------------------------------
                           Modes de jeu
----------------------------------------------------------------------------                        
1 - Humain contre Ordinateur
2 - Ordinateur contre Hasard
3 - Ordinateur contre Ordinateur
4 - Humain contre Humain
----------------------------------------------------------------------------
                           Apprentissage
----------------------------------------------------------------------------
Suivant qu'il gagne ou perd, l'ordinateur reçoit une récompense ou une punition.
----------------------------------------------------------------------------
""")

################### Affichage du plateau ##################

def affiche(plateau):
    print("\nPlateau actuel :")
    for i, rangee in enumerate(plateau):
        print(f"Rangée {i + 1}: {'| ' * rangee} ({rangee})")
    print()

################### Initialisation du jeu de Marienbad ##################

### Initialisation du plateau ###
def configurer_plateau():
    while True:
        try:
            nb_rangees = int(input("Entrez le nombre de rangées (2 ou plus) : "))
            if nb_rangees <= 1:
                print("Le nombre de rangées doit être supérieur à 1.")
            else:
                return [i * 2 - 1 for i in range(1, nb_rangees + 1)]
        except ValueError:
            print("Entrée invalide. Veuillez entrer un entier positif.")

### Fait un coup aléatoire ###
def coup_aleatoire(plateau_actuel):
    rangees_valides = [i for i, rangee in enumerate(plateau_actuel) if rangee > 0]
    rangee = random.choice(rangees_valides)
    allumettes = random.randint(1, plateau_actuel[rangee])
    return rangee, allumettes

### Crée un dictionnaire pour tous les coups possibles pour chaque état possible du plateau ###
def dicoProba(plateau_actuel):
    copie_plateau = [0 for _ in range(len(plateau_actuel))]
    dicoProba = {}
    
    while copie_plateau != plateau_actuel:
        copie_plateau[-1] += 1
        
        for i in range(len(copie_plateau), 0, -1):
            if copie_plateau[i] == plateau_actuel[i] + 1:
                copie_plateau[i] = 0
                copie_plateau[i - 1] += 1
        
            dicoProba[str(copie_plateau)] = {}
            for i in range(len(copie_plateau)):
                for j in range(copie_plateau[i]):
                    dicoProba[str(copie_plateau)][i,j+1] = 5
    
    return dicoProba
        
### Le coup de l'ordinateur ###
def ai_move(historique, l_jeu, dicoProba):
    coupOrdinateur = random.choices(list(dicoProba[str(l_jeu)].keys()),weights=dicoProba[str(l_jeu)].values())
    historique.append((dicoProba[str(l_jeu)], coupOrdinateur))
    return coupOrdinateur[0], coupOrdinateur[1]

### Calcule la probabilité de gagné ###
def calculate_probability(boulesjaunes, boulesrouges, board): # Calcul de la probabilité de gain 
    total_prob = 1.0 
    for i in range(len(board)): 
        if board[i] > 0: 
            prob_jaune = sum(boulesjaunes[i]) / (sum(boulesjaunes[i]) + sum(boulesrouges[i])) 
            prob_rouge = sum(boulesrouges[i]) / (sum(boulesjaunes[i]) + sum(boulesrouges[i])) 
            total_prob *= max(prob_jaune, prob_rouge) 
    return total_prob



################### Programme principal ##################

message_bie()
mode = 0

# Boucle pour le choix du mode de jeux
while mode not in [1, 2, 3, 4]:
    try:
        mode = int(input("\nChoisissez un mode de jeu (1, 2, 3 ou 4) : "))
        if mode not in [1, 2, 3, 4]:
            print("Mode invalide. Veuillez choisir entre 1, 2, 3 ou 4.")
    except ValueError:
        print("Entrée invalide. Veuillez saisir un nombre.")

if mode == 4:
    player1_name = input("Entrez le nom du premier joueur : ")
    player2_name = input("Entrez le nom du deuxième joueur : ")
    current_player = random.choice([player1_name, player2_name])
else:
    current_player = "CMP"

board = configure_board()

memoire_cmp = dicoProba(board)
memoire_cmp2 = dicoProba(board)

uneautrepartie = True
compteur_partie = 0 

# Boucle principal pour le dérouler d'une partie 
while uneautrepartie:
    player = current_player
    current_board = board[:]

    historique_cmp = []
    historique_cmp2 = []

    # Boucle pour le déroulé de la pa
    while sum(current_board) > 0:
        affiche(current_board)

        if player == 'CMP':  # Tour de l'ordinateur
            print("\nL'ordinateur choisit de jouer...")
            row, amount = ai_move(current_board)
            current_board[row] -= amount
            print(f"L'ordinateur enlève {amount} allumette(s) de la rangée {row + 1}.")

            if sum(current_board) == 0:
                winner = 'CMP'
            else:
                player = 'USER' if mode == 1 else 'RAND' if mode == 2 else 'CMP2'

        elif player == 'USER':  # Tour de l'utilisateur
            print("\n-- À vous de jouer ! --")
            valid_move = False

            while not valid_move:
                try:
                    row = int(input("Choisissez une rangée : ")) - 1
                    amount = int(input("Combien d'allumettes voulez-vous enlever ? "))

                    if row < 0 or row >= len(current_board) or current_board[row] < amount or amount <= 0:
                        print("Coup invalide. Recommencez.")
                    else:
                        valid_move = True
                except ValueError:
                    print("Entrée invalide. Recommencez.")

            current_board[row] -= amount
            print(f"Vous avez retiré {amount} allumette(s) de la rangée {row + 1}.")

            if sum(current_board) == 0:
                winner = 'USER'
            else:
                player = 'CMP'

        elif player == 'RAND':  # Tour d'un joueur aléatoire
            print("\nLe joueur au hasard choisit de jouer...")
            row, amount = random_move(current_board)
            current_board[row] -= amount
            print(f"Le joueur au hasard enlève {amount} allumette(s) de la rangée {row + 1}.")

            if sum(current_board) == 0:
                winner = 'RAND'
            else:
                player = 'CMP'

        elif player == 'CMP2':  # Deuxième IA dans le mode ordinateur contre ordinateur
            print("\nL'autre ordinateur choisit de jouer...")
            row, amount = ai_move(current_board)
            current_board[row] -= amount
            print(f"L'autre ordinateur enlève {amount} allumette(s) de la rangée {row + 1}.")

            if sum(current_board) == 0:
                winner = 'CMP2'
            else:
                player = 'CMP'

        elif player == player1_name:  # Tour du premier joueur humain dans le mode JvJ
            print(f"\n-- {player1_name}, à vous de jouer ! --")
            valid_move = False

            while not valid_move:
                try:
                    row = int(input("Choisissez une rangée : ")) - 1
                    amount = int(input("Combien d'allumettes voulez-vous enlever ? "))

                    if row < 0 or row >= len(current_board) or current_board[row] < amount or amount <= 0:
                        print("Coup invalide. Recommencez.")
                    else:
                        valid_move = True
                except ValueError:
                    print("Entrée invalide. Recommencez.")

            current_board[row] -= amount
            print(f"{player1_name} a retiré {amount} allumette(s) de la rangée {row + 1}.")

            if sum(current_board) == 0:
                winner = player1_name
            else:
                player = player2_name

        elif player == player2_name:  # Tour du deuxième joueur humain dans le mode JvJ
            print(f"\n-- {player2_name}, à vous de jouer ! --")
            valid_move = False

            while not valid_move:
                try:
                    row = int(input("Choisissez une rangée : ")) - 1
                    amount = int(input("Combien d'allumettes voulez-vous enlever ? "))

                    if row < 0 or row >= len(current_board) or current_board[row] < amount or amount <= 0:
                        print("Coup invalide. Recommencez.")
                    else:
                        valid_move = True
                except ValueError:
                    print("Entrée invalide. Recommencez.")

            current_board[row] -= amount
            print(f"{player2_name} a retiré {amount} allumette(s) de la rangée {row + 1}.")

            if sum(current_board) == 0:
                winner = player2_name
            else:
                player = player1_name

    compteur_partie += 1

    # Annonce des résultats
    if winner == 'CMP':
        print("\n----------------------------------------------------------------------------")
        print("L'ordinateur a gagné en ramassant la dernière allumette.")
        print("----------------------------------------------------------------------------\n")
    elif winner == 'USER':
        print("\n----------------------------------------------------------------------------")
        print("Bravo ! Vous avez gagné en ramassant la dernière allumette.")
        print("----------------------------------------------------------------------------\n")
    elif winner == 'RAND':
        print("\n----------------------------------------------------------------------------")
        print("Le joueur au hasard a gagné en ramassant la dernière allumette.")
        print("----------------------------------------------------------------------------\n")
    elif winner == 'CMP2':
        print("\n----------------------------------------------------------------------------")
        print("L'autre ordinateur a gagné en ramassant la dernière allumette.")
        print("----------------------------------------------------------------------------\n")
    elif winner == player1_name:
        print("\n----------------------------------------------------------------------------")
        print(f"{player1_name} a gagné en ramassant la dernière allumette.")
        print("----------------------------------------------------------------------------\n")
    elif winner == player2_name:
        print("\n----------------------------------------------------------------------------")
        print(f"{player2_name} a gagné en ramassant la dernière allumette.")
        print("----------------------------------------------------------------------------\n")

    # Récompense ou punition
    if winner == 'CMP':
        for coup in historique_cmp:
            memoire_cmp[coup[0]][coup[1]] += 3
        for coup in historique_cmp2:
            memoire_cmp2[coup[0]][coup[1]] -= 2
    else:
        for coup in historique_cmp2:
            memoire_cmp2[coup[0]][coup[1]] += 3
        for coup in historique_cmp:
            memoire_cmp[coup[0]][coup[1]] -= 2

    # Réinitialisation des verres vides
    for etat in memoire_cmp:
        for coup in memoire_cmp[etat]:
            if memoire_cmp[etat][coup] == 0:
                memoire_cmp[etat][coup] = 1

    # Affichage de l'état des verres
    print("État des verres - L'ordinateur : ")
    for i, row in enumerate(board):
        print(f"Rangée {i + 1} :")
        for j in range(row):
            print(f"  Position {j + 1}: {boulesjaunes_cmp[i][j]} jaunes, {boulesrouges_cmp[i][j]} rouges.")
    if mode == 3:
        print("État des verres - L'autre ordinateur : ")
        for i, row in enumerate(board):
            print(f"Rangée {i + 1} :")
            for j in range(row):
                print(f"  Position {j + 1}: {boulesjaunes_cmp2[i][j]} jaunes, {boulesrouges_cmp2[i][j]} rouges.")


    probability_cmp = calculate_probability(boulesjaunes_cmp, boulesrouges_cmp, current_board)
    probability_cmp2 = calculate_probability(boulesjaunes_cmp2, boulesrouges_cmp2, current_board)
    print("\n----------------------------------------------------------------------------")
    print("Vous avez joué "+ str(compteur_partie) +" parties.")
    print("----------------------------------------------------------------------------\n") 
    print("\n----------------------------------------------------------------------------") 
    print("La probabilité de gain de l'ordinateur à la prochaine partie si le joueur joue optimalement est de " + str(round(probability_cmp * 100, 2)) + "%") 
    print("----------------------------------------------------------------------------\n")
    if mode == 3:
        print("\n----------------------------------------------------------------------------") 
        print("La probabilité de gain de l'autre ordinateur à la prochaine partie si le joueur joue optimalement est de " + str(round(probability_cmp2 * 100, 2)) + "%") 
        print("----------------------------------------------------------------------------\n")

    # Continuer ou arrêter
    test = True
    while test:
        another_go = input("\nVoulez-vous rejouer ? [O/N]: ")
        if another_go in ("o", "O"):
            uneautrepartie = True
            test = False
        elif another_go in ("n", "N"):
            uneautrepartie = False
            test = False
        else:
            print("\nChoix invalide. Recommencez !")



