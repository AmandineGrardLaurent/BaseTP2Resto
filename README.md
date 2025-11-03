# 🍽️ Resto - Application de commande en terminal

## 🧾 Description

**Resto** est une application Java simple simulant la prise de commande dans un restaurant via le **terminal**.  
Le programme permet à l'utilisateur de sélectionner les différents éléments d'un menu (entrées, plats, accompagnements, desserts, boissons), puis affiche un résumé de la commande.

Ce projet illustre :
- La manipulation des **collections Java** (`ArrayList`, `Map`, `LinkedHashMap`),
- La gestion de la **saisie utilisateur** avec `Scanner`,
- L’organisation du code avec des **méthodes réutilisables** et bien documentées.

---

## 🚀 Fonctionnalités

- Affichage dynamique du menu avec numérotation des choix.  
- Saisie utilisateur guidée pour chaque catégorie.  
- Vérification simple du numéro choisi.  
- Possibilité de passer plusieurs commandes successives.  
- Affichage d’un résumé propre des sélections.  

---

## 🧩 Structure du projet


### Principales méthodes :
| Méthode | Description |
|----------|-------------|
| `displayMenuOptions(String[] options, String categoryName)` | Affiche les options d’une catégorie (ex : entrées, plats, etc.) |
| `getCustomerSelection(int selectedIndex, String[] options)` | Retourne l’élément choisi selon le numéro saisi |
| `displayCustomerSelections(String[] customerSelections, int nbOrder)` | Affiche un résumé de la commande |
| `collectCustomerChoices(Map<String, String[]> menu, Scanner scan, String[] customerSelections)` | Collecte les choix du client pour toutes les catégories |
| `main(String[] args)` | Point d’entrée du programme – gère le déroulement complet des commandes |

---

## 🖥️ Exemple d’exécution

```yaml

Combien de menus souhaitez-vous ?

2

----------- Commande n°1 -----------
Choix entrées :
[1 - SALADE][2 - SOUPE][3 - QUICHE][4 - AUCUNE]
Que souhaitez-vous comme entrées ? [saisir le chiffre correspondant]

1
...
Résumé de la commande n°1 :
[salade, boeuf, frites, tiramisu, eau gazeuse]

----------- Commande n°2 -----------
...
Commande terminée. Bon appétit !!

```

---

## 🧠 Améliorations possibles

- ✅ Vérification avancée de la saisie (gestion d’erreurs, entrée non numérique).  
- 💾 Sauvegarde des commandes dans un fichier texte ou base de données.  

---

## 🛠️ Prérequis

- **Java 8** ou supérieur  
- Un terminal ou IDE Java (Eclipse, IntelliJ, VS Code, etc.)

---

## ▶️ Exécution

1. Compiler le programme :

   ```bash
   javac Resto.java
   ```
2. Lancer le programme : 

    ```bash
    java Resto
    ```