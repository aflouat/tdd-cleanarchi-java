# UberTop SAAS!

L'application Uber-Like qui permet de réserver un Driver instantanément !

# User Story - Réserver une course

En tant que **Rider**,
Je souhaite **réserver une course** pouvant m'amener à ma destination
De sorte à assurer une alternative efficace aux transports en commun.

Un Rider peut réserver une course à tout moment pour n'importe quelle destination.
La réservation est confirmée une fois qu'un Driver libre est assigné par le système.

## Règles de Gestion de la Tarification

1. **Prix de Base** :
- De Paris à Paris : `2€`
- De l'extérieur de Paris à Paris : `20€`
- De Paris à l'extérieur de Paris : `10€`
- D'un point extérieur à un autre point extérieur : `50€`

2. **Prix par Kilomètre** : `0,5€` pour chaque kilomètre parcouru, quel que soit le trajet.


3. **Option UberX** :
- Disponible uniquement pour les trajets d'au moins `3km`.
- Ajoute un supplément de `5€` au total du trajet.
- Le supplément est offert le jour de l'anniversaire du Rider.


4. **Tarification Spéciale pour Noël** :
- Le montant total de la course est doublé pendant Noël.


5. **Offre de Bienvenue** :
- Une remise de `20€` est offerte aux Riders durant leur première année d'utilisation du service.


## Règles d'assignation d'un Driver

- Le système recherche un driver disponible dans un rayon de 5km autour du Rider.
- Un Driver ne peut être assigné qu'à une seule réservation à la fois.

# User Story - Lister toutes mes courses passées

En tant que **Rider**,
Je souhaite **lister tout l'historique de mes courses avec mention des Drivers respectifs**
De sorte à pouvoir me figurer la fréquence de mon utilisation.

