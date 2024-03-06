# NextRide SAAS!

L'application Uber-Like qui permet de réserver un Driver instantanément !

Un Rider peut réserver une course à tout moment pour n'importe quelle destination.
La réservation est confirmée une fois qu'un Driver libre est assigné par le système.

## Ride Booking Context

## Tarification :
### Structure de prix :

- Prix de base :
  - Paris -> Paris : 2 euros
  - Extérieur de Paris -> Paris : 0 euro
  - Paris -> Extérieur de Paris : 10 euros
  - Extérieur -> Extérieur : 50 euros
- Prix par kilomètre : 0.5 euro.
- Supplément UberX :
  +5 euros au total à partir de 3km mais offert le jour de l'anniversaire du Rider.
- Jour (ou soirée) de Noël : Double du montant total.
- Offre de bienvenue (1ère année) : 20 euros offerts.

### Conditions de Réservation :
#### Règles de Réservation :
- Si le Rider annule une course alors que le Driver est déjà en chemin, cela coûtera 5 euros de pénalité.
- Une course déjà annulée ne peut être annulée à nouveau
- Tant qu'un Driver n'est pas assigné à une réservation en cours, le Rider ne peut pas effectuer une autre réservation.
  Si le Rider souhaite faire une autre réservation, il doit d'abord annuler la précédente ou la planifier dans le futur.

## Driver Assignment Context

- Le système recherche un driver disponible dans un rayon de 5km autour du Rider.
- Un Driver ne peut être assigné qu'à une seule réservation à la fois.
- Si t'as un UberX et que c'est ton anniv, tu ne peux sélectionner qu'un Driver UberX qui a 5 étoiles de moyenne et 50 courses.

# User Story - Réserver une course

En tant que **Rider**,

Je souhaite **réserver une course** pouvant m'amener à ma destination

De sorte à assurer une alternative efficace aux transports en commun.

# User Story - Annuler une course

En tant que **Rider**,

Je souhaite **annuler ma course**

Car le **Driver** met trop de temps à venir.

# User Story - Lister toutes mes courses passées

En tant que **Rider**,

Je souhaite **lister tout l'historique de mes courses avec mention des Drivers respectifs**

De sorte à pouvoir me figurer la fréquence de mon utilisation.
